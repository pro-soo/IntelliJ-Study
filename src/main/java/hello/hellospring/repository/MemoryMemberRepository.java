package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 문제 있지만, 예제이니 간단하게 HashMap 사용
    private static long sequence = 0L;  // key 값 생성

    @Override
    public Member save(Member member) {
         member.setId(++sequence);  // 시퀀스로 id setting
         store.put(member.getId(), member); // 회원가입 시 입력한 이름 값(매개변수)
         return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //  결과가 null이 반환될 가능성이 있기 때문에 Optional 사용
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream().filter(member -> member.getName().equals(
                name
        )).findAny();   // 루프를 돌면서 같은 경우에만 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore(){
        store.clear();
    }
}
