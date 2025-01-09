package rlguswn.JavaShop.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rlguswn.JavaShop.domain.Member;
import rlguswn.JavaShop.repository.MemberRepository;

import java.util.Optional;

@Service
@Primary
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private final MemberRepository memberRepository;

    public CustomUserDetailService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("멤버를 찾을 수 없습니다."));
        return new CustomUserDetails(member);
    }
}
