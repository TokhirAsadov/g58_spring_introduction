package uz.pdp;


public class MyBean {

    public void hi(){
        System.out.println("===== MyBean hi method worked. =====");
    }

    private void init() {
        System.out.println("MyBean..... initialized.");
    }

    private void destroy() {
        System.out.println("MyBean..... destroyed.");
    }
}
