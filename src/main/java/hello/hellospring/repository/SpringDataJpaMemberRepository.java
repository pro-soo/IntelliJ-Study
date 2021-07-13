package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
        // extends JpaRepository 하면 인터페이스에 대한 구현체를 알아서 만들고 bean 등록 해준다.

    // SPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);   // 단순 쿼리문은 인터페이스 만으로 끝낼 수 있다.
}
