package day59.model.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder // 빌더 패턴 제공한다. -> day57lombok
public class MemberDto {
    private int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
}
