package rlguswn.JavaShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String signupPage() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody MemberSignUpForm form) {
        Member member = memberService.signUp(form);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }

    @GetMapping("/mypage")
    public String myPage(Model model) {
        Member member = memberService.getLoginMember();
        model.addAttribute("member", member);
        return "member/mypage";
    }
}
