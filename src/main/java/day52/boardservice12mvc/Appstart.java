package day52.boardservice12mvc;

import day52.boardService8mvc.view.BoardView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Appstart {
    public static void main(String[] args) {

        // 싱글톤 호출, 싱글톤 내부 함수 호출
        BoardView.getInstance().run();
    }
}
