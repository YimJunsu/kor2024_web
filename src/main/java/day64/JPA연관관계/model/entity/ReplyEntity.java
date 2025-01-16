package day64.JPA연관관계.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reply")
@Getter@Setter@ToString@Builder
@NoArgsConstructor@AllArgsConstructor
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno; // 댓글번호
    @Column(columnDefinition = "varchar(250)", nullable = false)
    private String rcontent; // 댓글내용

    // 단방향 FK : 게시물번호(PK) --> 댓글[FK]
    @ManyToOne
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity; // 보드 엔티티를 참조한다.

    // 단방향 FK : 회원번호(PK) --> 댓글(FK)
    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;
}
