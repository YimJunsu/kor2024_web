package day63.model.entity;

import day63.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity // 현재 클래스를 데이터베이스의 테이블과 매핑 정의
@Table(name = "member") // 테이블 이름 정의
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder
public class MemberEntity extends BaseTime {
// =========== 테이블 필드/속성 설계 day59 회원테이블과 비교 =========
    @Id // primary key 제약조건
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int mno;    // 회원번호

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String mid;     // 회원 아이디(not null, unique 제약조건)

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String mpwd;    // 회원 비밀번호(not null 제약조건)

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String mname;   // 회원 닉네임

    @Column(columnDefinition = "varchar(13)", nullable = false, unique = true)
    private String mphone; // 회원 전화번호(not null, unique 제약조건)

    // Entity --> DTO {룸북에서 제공 하지 않음}
    public MemberDto toDto(){
        // 빌터패턴 이용한 인스턴스 생성
        // 클래스명.builder().멤버변수명(새로운값).build();
        return MemberDto.builder() //.builder() 빌더패턴의 시작점
                .mno(this.mno)
                .mid(this.mid)
                // 패스워드는 보안상 생략
                .mname(this.mname)
                .mphone(this.mphone)
                .build(); // .build() 빌더 패턴의 끝마침.
    }
}
