package uz.pdp;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MySpringAOP {

    @Before("execution(* uz.pdp.Performance.perform(..))")
    public void silence(){
        System.out.println("Iltimos telefonlaringizni o`chiring.");
    }

    @Before("execution(* uz.pdp.Performance.perform(..))")
    public void takeSeat(){
        System.out.println("Iltimos joyingizga o`tiring.");
    }

    @AfterReturning("execution(* uz.pdp.Performance.perform(..))")
    public void qarsaklar(){
        System.out.println("👏👏👏👏👏👏👏👏");
    }

    @AfterThrowing("execution(* uz.pdp.Performance.perform(..))")
    public void xatolik(){
        System.out.println("⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️");
    }

    @After("execution(* uz.pdp.Performance.perform(..))")
    public void sungiSuz(){
        System.out.println("⏱️⏱️⏱️⏱️⏱️⏱️⏱️⏱️");
    }
}
