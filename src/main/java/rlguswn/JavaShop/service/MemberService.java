package rlguswn.JavaShop.service;

import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.Cart;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.dto.member.MemberSignUpForm;
import rlguswn.JavaShop.enums.Role;
import rlguswn.JavaShop.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final CartService cartService;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, CartService cartService, BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.cartService = cartService;
        this.passwordEncoder = passwordEncoder;
    }

    public Member signUp(MemberSignUpForm form) {
        if (memberRepository.findByEmail(form.getEmail()).isPresent()) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(form.getPassword());

        Member member = new Member(
                form.getEmail(),
                encodedPassword,
                form.getUsername(),
                form.getAddress(),
                form.getRole()
        );
        Member savedMember = memberRepository.save(member);

        Cart cart = new Cart(savedMember);
        cartService.createCart(cart);

        return savedMember;
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member getLoginMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("멤버를 찾을 수 없습니다."));
    }
}
