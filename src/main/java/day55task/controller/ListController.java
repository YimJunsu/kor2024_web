package day55task.controller;

import day55task.model.dao.ListDao;
import day55task.model.dto.ListDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ListController {

    private static ListController instance = new ListController();
    private ListController(){}
    public static ListController getInstance(){
        return instance;
    }

    // 쓰기
    @PostMapping("/upload")
    public boolean upload(@RequestBody ListDto listDto){
        System.out.println("ListController.upload");
        System.out.println("listDto = " + listDto);
        boolean result = ListDao.getInstance().upload(listDto);
        return result;
    }

    // 조회
    @GetMapping("/view")
    public ArrayList<ListDto> viewAll(){
        ArrayList<ListDto> result = ListDao.getInstance().viewAll();
        return result;
    }

    // 수정
    @PutMapping("/update")
    public boolean update(@RequestParam int bno){
        System.out.println("ListController.update");
        System.out.println("bno = " + bno);
        boolean result = ListDao.getInstance().update(bno);
        return result;
    }

    // 삭제
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int bno){
        System.out.println("ListController.delete");
        System.out.println("bno = " + bno);
        boolean result = ListDao.getInstance().delete(bno);
        return result;
    }
}
