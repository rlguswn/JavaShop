package rlguswn.JavaShop.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rlguswn.JavaShop.Security.CustomUserDetailService;

import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/test-login")
public class TestLoginController {

    private final CustomUserDetailService customUserDetailService;
    private final ObjectMapper objectMapper;

    public TestLoginController(CustomUserDetailService customUserDetailService, ObjectMapper objectMapper) {
        this.customUserDetailService = customUserDetailService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/admin")
    public String adminLogin(HttpServletRequest request) throws IOException {
        ClassPathResource resource = new ClassPathResource("json/test-data.json");
        InputStream inputStream = resource.getInputStream();

        JsonNode jsonNode = objectMapper.readTree(inputStream);

        String email = jsonNode.get("admins").get(0).get("email").asText();
        UserDetails userDetails = customUserDetailService.loadUserByUsername(email);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails.getAuthorities()
        );

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

        return "redirect:/";
    }

    @GetMapping("/member")
    public String memberLogin(HttpServletRequest request) throws IOException {
        ClassPathResource resource = new ClassPathResource("json/test-data.json");
        InputStream inputStream = resource.getInputStream();

        JsonNode jsonNode = objectMapper.readTree(inputStream);

        String email = jsonNode.get("members").get(0).get("email").asText();
        UserDetails userDetails = customUserDetailService.loadUserByUsername(email);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails, userDetails.getPassword(), userDetails.getAuthorities()
        );

        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);

        return "redirect:/";
    }
}
