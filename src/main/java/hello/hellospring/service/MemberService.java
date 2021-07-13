package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {   // 생성자 주입 (DI)
        this.memberRepository = memberRepository;
    }

    /*
         회원가입
        */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원 X

        //long start = System.currentTimeMillis();    // 메소드 시간 측정 로직 (공통 관심 사항), 유지보수 어렵다.
       // try {
            validateDuplicateMember(member);    // 중복회원 검증 메서드, 핵심 관심 사항
            memberRepository.save(member);  // 통과 시 저장
            return member.getId();
        //}finally {
        //    long finish = System.currentTimeMillis();
        //    long timeMs = finish - start;
       //     System.out.println("join = "+timeMs+"ms");
       // }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
