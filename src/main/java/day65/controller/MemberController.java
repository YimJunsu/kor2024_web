package day65.controller;

import day65.entity.BoardDto;
import day65.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired private MemberService memberService;

    @GetMapping("/info/board/findall")
    public List<BoardDto> myboardList(@RequestParam int mno){
        return memberService.myboardList(mno);
    }

    @PostMapping("/info/board/write")
    public boolean myboardWrite(@RequestBody BoardDto boardDto){
        return memberService.myboardWrite(boardDto);
    }
}
