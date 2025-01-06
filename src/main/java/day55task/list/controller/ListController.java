package day55task.list.controller;

import day55task.list.model.dao.ListDao;
import day55task.list.model.dto.ListDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public boolean upload(ListDto listDto){
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
}
