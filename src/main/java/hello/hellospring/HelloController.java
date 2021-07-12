package hello.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring!!");  // key-value 쌍으로 묶어서 보낸다.
        return "hello";     // hello.html로 연결
    }
}
