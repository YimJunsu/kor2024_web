package day64task.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "porder")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @Builder
public class OrderEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ono; //주문번호

    @Column(columnDefinition = "int", nullable = false)
    private int pcount;




}
