package day52.boardService8mvc.model;

import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){}
    private static BoardDao instance = new BoardDao();
    public static BoardDao getInstance() {return instance;}

    // 모든 게시물들을 저장하는 리스트객체 선언
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    //1. 게시물 쓰기 처리 함수
    public boolean write(BoardDto boardDto){
        boardDB.add(boardDto);
        return true;
    }
    //2. 게시물 출력 처리 함수
    public ArrayList<BoardDto> findAll(){
        return boardDB;
    }
}
