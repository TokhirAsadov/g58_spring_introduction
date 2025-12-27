package uz.pdp;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Aspect
public class MySpringAOP {

    //@Before(value = "execution(* uz.pdp.Performance.perform())")
    public void silence(){
        System.out.println("Iltimos telefonlaringizni o`chiring.");
    }

    public void takeSeat(){
        System.out.println("Iltimos joyingizga o`tiring.");
    }

    public void qarsaklar(){
        System.out.println("👏👏👏👏👏👏👏👏");
    }

    public void xatolik(){
        System.out.println("⚠️⚠️⚠️⚠️⚠️⚠️⚠️⚠️");
    }
    public void sungiSuz(){
        System.out.println("⏱️⏱️⏱️⏱️⏱️⏱️⏱️⏱️");
    }
}
