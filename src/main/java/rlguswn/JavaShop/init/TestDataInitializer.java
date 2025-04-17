package rlguswn.JavaShop.init;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import rlguswn.JavaShop.dto.member.MemberSignUpForm;
import rlguswn.JavaShop.dto.product.ProductRegisterForm;
import rlguswn.JavaShop.enums.Role;
import rlguswn.JavaShop.service.MemberService;
import rlguswn.JavaShop.service.ProductService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@Component
public class TestDataInitializer implements ApplicationRunner {

    private final MemberService memberService;
    private final ProductService productService;
    private final ObjectMapper objectMapper;

    public TestDataInitializer(MemberService memberService, ProductService productService, ObjectMapper objectMapper) {
        this.memberService = memberService;
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        if (memberService.findAll().isEmpty() && productService.getAllProduct().isEmpty()) {
            loadTestData();
        }
    }

    private void loadTestData() throws IOException {
        ClassPathResource resource = new ClassPathResource("json/test-data.json");
        InputStream inputStream = resource.getInputStream();

        JsonNode jsonNode = objectMapper.readTree(inputStream);

        for (JsonNode node : jsonNode.get("admins")) {
            MemberSignUpForm form = new MemberSignUpForm();
            form.setEmail(node.get("email").asText());
            form.setPassword(node.get("password").asText());
            form.setUsername(node.get("username").asText());
            form.setAddress(node.get("address").asText());

            String roleStr = node.get("role").asText();
            form.setRole(Role.valueOf(roleStr));

            memberService.signUp(form);
        }

        for (JsonNode node : jsonNode.get("members")) {
            MemberSignUpForm form = new MemberSignUpForm();
            form.setEmail(node.get("email").asText());
            form.setPassword(node.get("password").asText());
            form.setUsername(node.get("username").asText());
            form.setAddress(node.get("address").asText());

            String roleStr = node.get("role").asText();
            form.setRole(Role.valueOf(roleStr));

            memberService.signUp(form);
        }

        for (JsonNode node : jsonNode.get("products")) {
            ProductRegisterForm form = new ProductRegisterForm();
            form.setName(node.get("name").asText());
            form.setDescription(node.get("description").asText());
            form.setPrice(node.get("price").decimalValue());
            form.setQuantity(node.get("quantity").longValue());

            if (node.has("image")) {
                String imagePath = node.get("image").asText();
                ClassPathResource imageResource = new ClassPathResource("static/images/" + imagePath);
                try (InputStream is = imageResource.getInputStream()) {
                    byte[] imageBytes = is.readAllBytes();
                    String contentType = Files.probeContentType(imageResource.getFile().toPath());

                    form.setImage(new MockMultipartFile(
                            "image",
                            imagePath,
                            contentType,
                            imageBytes
                    ));
                }
            }

            productService.registerProduct(form);
        }
    }
}
