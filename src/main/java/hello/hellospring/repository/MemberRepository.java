package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // java 8에 들어간 기능, 없으면 null로 반환되는데 그것을 optional로 감싸는 것
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
