package day52.boardService8mvc.view;

import day52.boardService8mvc.controller.BoardController;
import day52.boardService8mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    // 싱글톤 ( 3단계 ), 싱글톤이란? 프로그램내 1개만 존재 가능한 객체 디자인 패턴
    private BoardView(){}
    private static BoardView instance = new BoardView();
    public static BoardView getInstance(){return instance;}

    private Scanner scan = new Scanner(System.in);

    // 0. 메인 페이지
    public void run(){
        while (true){
            System.out.println("1.등록 2.출력 :");
            int choose = scan.nextInt();
            if(choose == 1) {write();}
            else if (choose ==2) {findAll();}
        }
    }

    // 1. 게시물 쓰기, 출력 페이지
    public void write() {
        System.out.println("[게시물 쓰기 페이지]");
        scan.nextLine();
        System.out.print("title : ");
        String title = scan.next();
        System.out.print("content : ");
        String content = scan.next();
        System.out.print("password : ");
        int pwd = scan.nextInt();
        BoardDto boardDto = new BoardDto(title, content, pwd);
        boolean result = BoardController.getInstance().write(boardDto);
        if (result) {System.out.println("write success");} else {System.out.println("write fail");}
    }

    public void findAll(){
        System.out.println("[게시물 출력 페이지]");
        ArrayList<BoardDto> result = BoardController.getInstance().findAll();
        for(int index = 0; index <= result.size() -1; index++){
            System.out.print("제목 : " + result.get(index));
            System.out.print("내용 : " + result.get(index));
            System.out.println();
        }
    }
}
