package hello.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","spring!!");  // key-value 쌍으로 묶어서 보낸다.
        return "hello";     // hello.html로 연결
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){ // 기본으로 파라미터를 넘겨 줘야 한다.
        model.addAttribute("name",name);
        return "hello-template";    // template engine
    }

    @GetMapping("hello-string")
    @ResponseBody   // http의 body부분에 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;  // "hello 요청한 문자"가 뷰 없이 그대로 출력 (뷰 리졸브 동작)
    }

    @GetMapping("hello-api")    // api 방식을 사용하는 이유 -> json {key : value}
    @ResponseBody   // 객체가 오면 json 방식으로 data를 만들어서 http 응답에 반환하겠다! (HttpMessageConverter 동작)
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        
        public String getName() {   // getter/setter - java bean 표준 방식
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
