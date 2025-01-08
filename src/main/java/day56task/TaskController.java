package day56task;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("day56task/rest4")
public class TaskController {

    @PostMapping("/join")
    public boolean signUp(@RequestBody TaskDto taskDto){
        System.out.println("TaskController.signUp");
        System.out.println("taskDto = " + taskDto);
        return true;
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String id, @RequestParam String pwd){
        System.out.println("TaskController.login");
        System.out.println("id = " + id + ", pwd = " + pwd);
        return true;
    }

    @GetMapping("")
    public String[] viewAll(){
        return new String[] {"가입 인원 출력"};
    }

    @PutMapping("")
    public boolean update(@RequestBody TaskDto taskDto){
        System.out.println("TaskController.update");
        System.out.println("taskDto = " + taskDto);
        return true;
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam String id, @RequestParam String pwd){
        System.out.println("TaskController.delete");
        System.out.println("id = " + id + ", pwd = " + pwd);
        return true;
    }
}
