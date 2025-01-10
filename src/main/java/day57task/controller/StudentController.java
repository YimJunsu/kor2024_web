package day57task.controller;


import day57task.model.dao.StudentDao;
import day57task.model.dto.StudentDto;
import day57task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 객체(빈) 생성해서 메모리(Spring 컨테이너) 등록
// 이 클래스의 객체(빈)은 너가(Spring) 관리 해줘 : * IOC *
// = 싱글톤 필요가 없음.
public class StudentController {

    @PostMapping("/upload")
    public boolean upload(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.upload");
        System.out.println("studentDto = " + studentDto);
        return studentService.upload(studentDto);
    }

    @GetMapping("/viewall")
    public ArrayList<StudentDto> viewall(){
        System.out.println("StudentController.viewall");
        return studentService.viewall();
}
    @PutMapping("/update")
    public boolean update(@RequestBody StudentDto studentDto){
        System.out.println("StudentController.update");
        System.out.println("studentDto = " + studentDto);
        return studentService.update(studentDto);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int sno){
        System.out.println("StudentController._delete");
        System.out.println("sno = " + sno);
        return studentService.delete(sno);
    }

    @Autowired
    private StudentService studentService;
}
