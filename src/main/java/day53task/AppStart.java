package day53task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

@RestController
class day53taskController{
    @PostMapping("/day53task")
    public String postMethod(){
        System.err.println("day53taskController");
        return "POST메소드 통신 성공";
    }
    @GetMapping("/day53task")
    public String GetMethod(){
        System.err.println("day53taskController.GetMethod");
        return "GET메소드 통신 성공";
    }
    @PutMapping("/day53task")
    public String PutMethod(){
        System.err.println("day53taskController.PutMethod");
        return "PUT메소드 통신성공";
    }
    @DeleteMapping("/day53task")
    public String DeleteMethod(){
        System.err.println("day53taskController.DeleteMethod");
        return "DELETE메소드 통신성공";
    }
}

