package uz.pdp;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
//
//        Callable<String> task = () -> {
//            Thread.sleep(1000);
//            return "Task completed";
//        };
//
//        Thread.startVirtualThread(() -> {
//            try {
//                String result = task.call();
//                System.out.println(result);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//
//        Future<String> future = executorService.submit(task);

    }
}