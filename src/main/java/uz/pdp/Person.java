package uz.pdp;

import java.util.List;
import java.util.Map;

public class Person {
    private String fullName;
    private Integer age;
    private List<String> nickNames;
    private Map<Integer, String> jobs;

    public static Person getInstance(){
        return new Person();
    }

    private Person() {
    }

    public Person(String fullName, Integer age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNickNames(List<String> nickNames) {
        this.nickNames = nickNames;
    }

    public void setJobs(Map<Integer, String> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", nickNames=" + nickNames +
                ", jobs=" + jobs +
                '}';
    }

    private void init() {
        System.out.println("Person:::::: Person bean is initialized.");
    }

    private void destroy() {
        System.out.println("Person:::::: Person bean is destroyed.");
    }
}
