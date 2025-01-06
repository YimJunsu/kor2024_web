package day55task.list.model.dto;

public class ListDto {
    //멤버변수
    private int bno;
    private String content;
    private boolean status;

    //생성자
    public ListDto() {}

    public ListDto(int bno, String content, boolean status) {
        this.bno = bno;
        this.content = content;
        this.status = status;
    }

    //getter,setter , toString
    public int getBno() {return bno;}
    public void setBno(int bno) {this.bno = bno;}
    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}
    public boolean isStatus() {return status;}
    public void setStatus(boolean status) {this.status = status;}

    @Override
    public String toString() {
        return "ListDto{" +
                "bno=" + bno +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}