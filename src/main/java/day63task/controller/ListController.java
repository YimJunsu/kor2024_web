package day63task.controller;

import day63task.model.dto.ListDto;
import day63task.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListController {

    @Autowired private ListService listService;

    @PostMapping("/upload")
    public boolean upload(@RequestBody ListDto listDto){
        return listService.upload(listDto);
    }
    @GetMapping("/view")
    public List<ListDto> view(){
        return listService.view();
    }
    @PutMapping("/change")
    public boolean change(@RequestBody ListDto listDto){
        return listService.change(listDto);
    }
    @DeleteMapping("/remove")
    public boolean remove(@RequestParam int lno){
        return listService.remove(lno);
    }
}
