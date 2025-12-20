package uz.pdp;

public class MyBean2 {

    private final MyBean myBean;

    public MyBean2(MyBean myBean1){
        this.myBean = myBean1;
        System.out.println("MyBean2 .. dependency injection ........");
    }

    public MyBean getMyBean() {
        return myBean;
    }
}
