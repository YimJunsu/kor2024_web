package day63task.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("")
    public String main() {return "/day63task/todolist.html";}

}
