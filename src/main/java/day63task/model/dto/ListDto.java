package day63task.model.dto;

import day63task.model.entity.ListEntity;
import lombok.*;

@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@ToString@Builder
public class ListDto {

    private int lno;
    private String lcontent;
    private boolean lstatus;
    private String cdate;
    private String udate;

    public ListEntity toEntity(){

        return ListEntity.builder()
                .lno(this.lno)
                .lcontent(this.lcontent)
                .lstatus(this.lstatus)
                .build();
    }
}
