package hello.hellospring.domain;

public class Member {

    private Long id;    // 우선 임의의 값, 시스템이 정한 id
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
