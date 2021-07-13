package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration  // java로 빈 등록하기
public class SpringConfig {

    // 예전에는 xml에 빈을 등록했었는데, 요즘에는 java에 빈을 등록한다.

//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){   // spring container에 올린다.
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){ // AOP도 등록해서 쓰는 것을 추천 (특별하기 때문에)
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
//        return new JpaMemberRepository(em);

//    }
}
