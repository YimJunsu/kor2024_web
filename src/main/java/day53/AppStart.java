package day53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//[1] 스프링 서버를 실행하기 위한 클래스
@SpringBootApplication //  톰캣(웹) 서버를 세팅해주는 어노테이션
public class AppStart {
    public static void main(String[] args) {
        // 스프링 서버가 실행되면서 톰캣(웹) 서버를 세팅 해주는 어노테이션
        SpringApplication.run(AppStart.class);

    }
}

//[2] 외부로부터 HTTP 요청을 매핑(연결) 하기 위한 컨트롤러 클래스
@RestController  // 현재 클래스의 HTTP 컨트롤러 클래스임을 지정.
class day53Controller{
    @PostMapping("/day52")
    public String postMethod(){ //HTTP [POST] http://localhost.8080/day52주소 선언/만들기
        System.err.println("day53Controller.postMethod"); // soutm
        return "Server connect POST OK";
    }
    @GetMapping("/day52")
    public String getMethod(){ //HTTP [GET] http://localhost.8080/day52주소 선언/만들기
        System.err.println("day53Controller.getMethod");
        return "Server connect GET OK";
    }
    @PutMapping("/day52")
    public String putMethod(){ //HTTP [GET] http://localhost.8080/day52주소 선언/만들기
        System.err.println("day53Controller.putMethod");
        return "Server connect PUT OK";
    }
    @DeleteMapping("/day52")
    public String deleteMethod(){ //HTTP [GET] http://localhost.8080/day52주소 선언/만들기
        System.err.println("day53Controller.deleteMethod");
        return "Server connect DELETE OK";
    }
}
