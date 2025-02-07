package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder
public class CategoryEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno; // 카테고리번호

    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String cname; // 카테고리명

    // 카테 고리 -> 상품 , 양방향을 ProductList
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    List<ProductEntity> productEntityList = new ArrayList<>();
}
