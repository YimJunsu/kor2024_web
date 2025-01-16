package day64.JPA연관관계.model.dto;

import lombok.*;

@AllArgsConstructor@NoArgsConstructor
@Getter@Setter@Builder@ToString
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String memail;
    private String cdate;
    private String udate;
}
