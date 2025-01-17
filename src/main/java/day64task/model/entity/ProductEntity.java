package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
public class ProductEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pno; // 제품번호

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String pname; // 제품명

    @Column(columnDefinition = "int", nullable = false)
    private int price; // 제품가격

    // 카테리고에서 온거 받기(단방향)
    @ManyToOne
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;

    // 오더로 보내는 양방향 만들기,
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    List<OrderEntity> orderEntityList = new ArrayList<>();


}
