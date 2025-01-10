package day57task.service;


import day57task.model.dao.StudentDao;
import day57task.model.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service // 객체(빈) 생성해서 메모리(Spring 컨테이너) 등록
// 이 클래스의 객체(빈)은 너가(Spring) 관리 해줘 : IOC
// = 싱글톤 필요가 없음.
public class StudentService {
    // 너(Spring)가 만든 빈(객체/인스턴스)를 주세요. @Autowired -> DI
    @Autowired
    private StudentDao studentDao;

    public boolean upload(StudentDto studentDto){
        System.out.println("StudentService.upload");
        System.out.println("studentDto = " + studentDto);
        return studentDao.upload(studentDto);
    }
    public ArrayList<StudentDto> viewall(){
        System.out.println("StudentService.viewall");
        return studentDao.viewall();
    }
    public boolean update(StudentDto studentDto){
        System.out.println("StudentService.update");
        System.out.println("studentDto = " + studentDto);
        return studentDao.update(studentDto);
    }
    public boolean delete(int sno){
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);
        return studentDao.delete(sno);
    }
}
