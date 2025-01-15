package day62.service;

import day62.model.entity.BoardEntity;
import day62.model.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//MVC 컴포넌트 공통 : 컴포넌트 스캔을 통해 자동으로 스프링 컨테이너에 빈(인스턴스) 생성
// 1. Spring mvc 패턴에서 추가된 레이어/구역 으로 자바의 비즈니스 로직 담당
public class BoardService {
    // 비즈니스 로직이란? 기능에 실질적인 코드
        // 예) 회원가입에서 타입변환, 유효성검사, 자료 가공) 아닌 저장에 필요한 코드
    @Autowired BoardRepository boardRepository;
    // 서비스는 무조건 리포지토리를 이용하여 엔티티를 조작하고 요청과 응답을 받는다.
        // 규칙 : 서비스에서 컨트롤러 객체를 사용하면 안된다.
    // C : 게시물 쓰기
    public boolean write(BoardEntity boardEntity){
        boardRepository.save(boardEntity);
        //insert SQL 문을 작성하지 않아도 된다. 왜? 자동으로 쿼리가 생성된다.
        return true;
    }
    // R : 게시물 전체 조회
    public List<BoardEntity> printAll(){
        // select SQL 문을 작성하지 않고 자동으로 쿼리가 생성된다.
        List<BoardEntity> list = boardRepository.findAll();
        return list;
    }
    // R : 게시물 개별 조회
    public BoardEntity print(int bno){
        // select SQL 문을 작성하지 않고 자동으로 쿼리가 생성된다.
        BoardEntity entity = boardRepository.findById(bno).get();
        return entity;
    }
    // U : 게시물 수정
    @Transactional // 수정처리 트랙젠션 필수
    public boolean update(BoardEntity boardEntity){
        // update SQL 문을 작성하지 않고 자동으로 쿼리가 생성된다.
        // 1. 수정할 게시물 번호를 이용하여 수정할 엔티티를 찾는다.
       BoardEntity updateEntity = boardRepository.findById(boardEntity.getBno()).get();
        // 2. 수정할 엔티티의 값을 setter 이용하여 수정한다.
        updateEntity.setBtitle(boardEntity.getBtitle());
        updateEntity.setBcontent(boardEntity.getBcontent());
            // (영속성) - 엔티티/인스턴스를 수정하면 자동으로 DB도 같이 수정된다.
        return true;
    }
    // D : 게시물 삭제
    public boolean delete(int bno){
        // delete SQL 문을 작성하지 않고 자동으로 쿼리가 생성된다.
        boardRepository.deleteById(bno);
        return true;
    }
}
