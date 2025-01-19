package day65.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "board")
@Entity
@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno; // 게시물번호

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String btitle;

    @Column(columnDefinition = "longtext")
    private String bcontent;

    // 단방향
    @ManyToOne //Fk
    @JoinColumn(name = "mno") // FK 필드명
    private MemberEntity memberEntity;

    // entity ---> Dto
    public BoardDto toDto(){
        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent).build();
    }
}
