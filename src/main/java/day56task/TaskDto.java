package day56task;

public class TaskDto {
    private String id;
    private String pwd;
    private String phn;
    private String email;

    public TaskDto(){}
    public TaskDto(String id, String pwd, String phn, String email) {
        this.id = id;
        this.pwd = pwd;
        this.phn = phn;
        this.email = email;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getPwd() {return pwd;}
    public void setPwd(String pwd) {this.pwd = pwd;}
    public String getPhn() {return phn;}
    public void setPhn(String phn) {this.phn = phn;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() {
        return "TaskDto{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phn='" + phn + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
