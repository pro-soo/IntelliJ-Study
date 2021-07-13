package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // aop로 쓰기 위한 설정
@Component
public class TimeTraceAop {

    // 어디에 적용할지 적어준다. (패키지명)
    @Around("execution(* hello.hellospring..*(..))")

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: "+joinPoint.toString());
        try {
            return joinPoint.proceed(); // 프록시(가짜)를 먼저 실행하고 joinPoint.proceed() 실행 후 진짜가 실행된다.
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toString() + " "+ timeMs+ "ms");

        }
    }
}
