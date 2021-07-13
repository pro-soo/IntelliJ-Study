package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // java로 빈 등록하기
public class SpringConfig {

    // 예전에는 xml에 빈을 등록했었는데, 요즘에는 java에 빈을 등록한다.

    @Bean
    public MemberService memberService(){   // spring container에 올린다.
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
