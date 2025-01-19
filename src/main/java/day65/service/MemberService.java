package day65.service;

import day65.entity.BoardDto;
import day65.entity.BoardEntity;
import day65.entity.MemberEntity;
import day65.repository.BoardRepository;
import day65.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;
    // [1] 내가 쓴 글 전체 조회
    public List<BoardDto> myboardList(int mno){
        // 1. mno의 회원 엔티티르 찾는다.
            // Optional 클래스 : null 값을 포함 할 수 있는 객체
            // 특징 : 1. Null 을 안전하게 유무 판단
            // 주요메소드 :
                    // 1. isPresent() : 값여부 판단
                    // 2. get() : Optional 객체가 갖고 있는 값 반환 함수
                // 사용처 : JPA 의 findById() 함수가 반환 타입
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);
        if(optionalMember.isPresent()){ // 만약에 findById함수로 찾은 mno의 엔티티가 존재하면
           MemberEntity entity = optionalMember.get(); // Optional 갹채에서 엔티티를 꺼낸다.
            // 2. 찾은 엔티티에서 양방향으로 설정된 게시물 조회
            List<BoardEntity> boardEntityList = entity.getBoardEntityList();

            // 3. 모든 게시물 엔티티를 DTO로 변환
                // 방법 1
                /*
            List<BoardDto> list = new ArrayList<>();
            for(int index = 0; index <= boardEntityList.size() -1; index++ ){
                // 0부터 게시물 엔티티리스트의 마지막 인덱스 까지
                BoardEntity boardEntity = boardEntityList.get(index); // index 번째 엔티티 호출
                // 엔티티 dto 변환
                BoardDto boardDto = boardEntity.toDto();// 엔티티 dto로 변환
                list.add(boardDto); // dto를 리스트에 저장
            } */
                // 방법 2 forEach( 반복변수 -> { 실행문;} ), -> JAVA방법 / => JS방법
            /*
            List<BoardDto> list = new ArrayList<>();
            boardEntityList.forEach(boardEntity -> {list.add(boardEntity.toDto());
            } );
            */
                // 방법 3, .stream().map( 타입 :: 실행함수명 )
            List<BoardDto> list = boardEntityList.stream()
                    .map(BoardEntity :: toDto)
                    .collect(Collectors.toList());
            return list;
        } // if end
        return null;
    }

    @Autowired
    BoardRepository boardRepository;
     // [2] 게시물 작성, 양방향 관계 일 때
    @Transactional // 함수 안에서 insert, update, delete 쿼리문을 트랜잭션 으로 사용
    // 트랜잭션이란? 여러 작업들을 하나의 작업 단위로 묶어, 하나라도 작업이 실패하면 모두 실패/롤백/취소, 모두 성공해야 최종 성공
    public boolean myboardWrite(BoardDto boardDto){
        // * 현재 로그인된 회원이 게시물을 작성한다는 가정 :
        // 1. 현재 로그인된 회원번호를 세션에서 조회한다.
        int loginMno = 1; // (예시) 1번 회원이 로그인된 상태 가정
            // 1-2 현재 로그인된 회원번호의 회원엔티티 조회
        Optional<MemberEntity> optionalMember = memberRepository.findById(loginMno);
            //Optional : null 값을 저장/관리 할 수 있는 객체
        if(optionalMember.isPresent() == false){
            return false; //조회된 엔티티가 없으면 실패로 함수 반환 // 비로그인상태
        }
            // .get() : Optional 객체내 엔티티 꺼내기
        MemberEntity memberEntity = optionalMember.get(); // 엔티티 꺼내기
        // 2. 게시물 엔티티 생성한다. dto ---> 엔티티로 변환, 엔티티를 처음 생성할때는 영속성(DB테이블과 매핑) 없다.
        BoardEntity boardEntity = boardDto.toEntity();
        // 3. 게시물 엔티티에 회원엔티티 넣어주기 ex) 불러올땐 .set~으로
        boardEntity.setMemberEntity(memberEntity);
        // 4. 게시물 엔티티 저장하기
        BoardEntity saveEntity = boardRepository.save(boardEntity);
        // 5. .save(엔티티) : 엔티티 저장을 성공하면 성공한 엔티티 영속성 연결/매핑
        if(saveEntity.getBno() > 0){return true;} // 0보다 크다 : pk번호 는 1번부터 시작하므로
        return false;
    }
}
