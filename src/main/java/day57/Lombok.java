package day57;

public class Lombok {
    public static void main(String[] args) {

        //1. 디폴트 생성자로 객체 생성
        // - @NoArgsConstructor 어노테이션이 디폴트 생성자를 주입/만들어준다.
        MemberDto m1 = new MemberDto();

        // 2. 모든매개변수 생성자로 객체 생성
        // - @AllArgsConstructor 어노테이션이 모든 매개변수 생성자를 주입
        MemberDto m2 = new MemberDto("qwe1", "유재석");

        //

        // 3. setter 메소드 사용
        m1.setId("as01");
        // - @Setter 어노테이션이 멤버변수의 setter메소드를 주입

    }
}