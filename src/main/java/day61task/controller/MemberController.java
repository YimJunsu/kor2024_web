package day61task.controller;

import day61task.model.Entity.MemberEntity;
import day61task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired // 스프링 컨테이너(메모리)에 등록된 빈(객체) 주입한다.
    private MemberService memberService;

    @PostMapping("/signup")
    public boolean signup(@RequestParam String id, @RequestParam String pwd) {
        boolean result = memberService.signup(id,pwd);
        return result;
    }

    @GetMapping("/findall")
    public List<MemberEntity> findall(){
        List<MemberEntity> list = memberService.findall();
        return list;
    }
}
