package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller // spring container에 MemberController 객체가 생성된다.
public class MemberController {
    //@Autowired    1.필드주입
    private MemberService memberService;

//    @Autowired    2.setter 주입
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    @Autowired  // spring container에 등록된 Service Annotation을 주입해준다. (== DI, 의존성주입)
    // spring container에 올라가 있어야만 Autowired가 실행된다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }   // 3.생성자주입을 권장: 생성하는 시점에만 쓰고 변경못하게 하기때문

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")    // get은 조회할 때 주로 사용하고 폼을 넘겨줄때는 post 사용
    public String create(MemberForm form){
        Member member = new Member();
        member.setName((form.getName()));

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
