package rlguswn.JavaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.dto.member.MemberSignUpForm;
import rlguswn.JavaShop.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/signup")
    public ResponseEntity<String> signupPage() {
        String message = "회원가입 페이지";
        return ResponseEntity.ok(message);
    }

    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@RequestBody MemberSignUpForm form) {
        Member member = memberService.signUp(form);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginPage() {
        String message = "로그인 페이지";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/mypage")
    public ResponseEntity<Member> myPage() {
        Member member = memberService.getLoginMember();
        return ResponseEntity.ok(member);
    }
}
