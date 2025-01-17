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


}
