package day54.boardservice13.controller;

import day54.boardservice13.model.dao.BoardDao;
import day54.boardservice13.model.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

//public class BoardController {

//    // 싱글톤
//    private static BoardController instance = new BoardController();
//    private BoardController(){}
//    public  static BoardController getInstance(){
//        return instance;
//    }

// ==================== HTTP 웹 ====================
@RestController // 현재 클래스에 rest api 가 가능한 클래스임을 주입한다.
// [1] 클래스 위에 @RestController
public class BoardController {
    // 1. 게시물 쓰기    [ CRUD 중 C, HTTP METHOD 중 POST ]
    // [2] 함수위에 @XXXXMapping("/주소만들기")
    // [TEST] Talend Api Tester : [POST] http://localhost:8080/write
    //                            [Headers] Content-Type : application/json
    //                            [body] { "btitle" : "테스트제목" ,"bcontent" : "테스트내용" ,"bwriter" : "유재석" ,"bpwd" : "1234"}
    @PostMapping("/write")
    public boolean write(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.write"); // soutm : 메소드명 출력함수 자동완성
        System.out.println("boardDto = " + boardDto); // soutp : 메소드 매개변수 출력함수 자동완성
        boolean result = BoardDao.getInstance().write(boardDto);
        return result;
    }

    // 2. 게시물 전체 조회 [ CRUD 중 R, HTTP METHOD 중 GET }
    @GetMapping("/findall")
    public ArrayList<BoardDto> findAll1(){
        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
        return result;
    }

    // 3. 게시물 개별 조회 [ CRUD 중 R, HTTP METHOD 중 GET }
    @GetMapping("/findid")
    // [TEST] Talend Api Tester : [GET] http://localhost:8080/findid?bno=조회할번호
    public BoardDto findid(int bno){
        System.out.println("BoardController.findid");
        System.out.println("bno = " + bno);
        BoardDto result = BoardDao.getInstance().findid(bno);
        return result;
    }

    // 4. 게시물 수정 [ U ]


    // 5. 게시물 삭제
}
