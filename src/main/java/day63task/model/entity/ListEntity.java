package day63task.model.entity;

import day63task.model.dto.ListDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "list")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder
public class ListEntity extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lno;

    @Column(columnDefinition = "varchar(300)", nullable = false)
    private String lcontent;

    @Column
    private boolean lstatus;

    public ListDto toDto(){
        return ListDto.builder()
                .lno(this.lno)
                .lcontent(this.lcontent)
                .lstatus(this.lstatus)
                .build();
    }
}
