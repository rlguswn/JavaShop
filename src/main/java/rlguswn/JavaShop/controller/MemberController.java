package rlguswn.JavaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String signupPage() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberSignUpForm form, Model model) {
        try {
            Member member = memberService.signUp(form);
            model.addAttribute("message", "회원가입이 완료되었습니다.");
            return "member/login";
        } catch (RuntimeException e) {
            model.addAttribute("message", e.getMessage());
            return "member/signup";
        }
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value="error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("message", "로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인해주세요.");
        }
        return "member/login";
    }

    @GetMapping("/mypage")
    public String myPage(Model model) {
        Member member = memberService.getLoginMember();
        model.addAttribute("member", member);
        model.addAttribute("createdAt", member.formatCreatedAt());
        return "member/mypage";
    }
}
