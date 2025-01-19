package day65.entity;

import lombok.*;

@Getter@Setter@Builder@ToString
@NoArgsConstructor@AllArgsConstructor
public class BoardDto {
    private int bno;
    private String btitle;
    private String bcontent;

    // Dto ---> entity
    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bno(this.bno)
                .build();
    }
}
