package day57task.model.dto;


import lombok.*;

@NoArgsConstructor  // 디폴트 생성자 주입
@AllArgsConstructor // 모든 매개변수 생성자 주입
@Getter @Setter @ToString // 메소드 Getter, Setter,
// toString 참조(주소)값 대신 멤버변수 호출 메서드
@Builder // 생성자 대신 인스턴스(객체)만드는 빌더 패턴

public class StudentDto {
    private int sno;
    private String sname;
    private int skor;
    private int smath;
    private int seng;
}
