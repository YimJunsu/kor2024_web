package day55task.list.model.dao;

import day55task.list.model.dto.ListDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ListDao {

    // 싱글톤
    private static ListDao instance = new ListDao();
    // 연동 인터페이스
    private Connection conn;

    private ListDao() {// ==================== DB 연동 ====================
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "1234");
        } catch (Exception e) {System.out.println(e);}
    }
    public static ListDao getInstance() {return instance;}

    // 쓰기
    public boolean upload(ListDto listDto){
        try{
            String sql = "insert into todolist(content, status) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, listDto.getContent());
            ps.setBoolean(2, listDto.isStatus());
            int count = ps.executeUpdate();
            if(count == 1) {return true;}
        } catch (Exception e) {System.out.println(e);}
        return false;}

    // 조회
    public ArrayList<ListDto> viewAll(){
        ArrayList<ListDto> list = new ArrayList<>();
        try{
            String sql = "select * from todolist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ListDto listDto = new ListDto(
                        rs.getInt("bno"),
                        rs.getString("content"),
                        rs.getBoolean("status") );
                list.add(listDto);}
        } catch (Exception e){System.out.println(e);}return list;}


}
