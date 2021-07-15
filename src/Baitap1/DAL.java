/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baitap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DAL {
    static ResultSet rs = null;
    static Statement st = null;
    static Connection conn=null;
    static void getConnect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = (Connection)DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SPham;Username=sa;Password = 123456");
        } catch (Exception e) {
            System.out.println("Không kết nối được");
        }
    }
    //Phương thức dùng để truy vẫn cơ sở dữ liệu
    public ResultSet getResult(String sql) {
        try {
            getConnect();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //Phương thức hiển thị Thêm, sửa, xóa dữ liệu: insert into, update set, delete
    public int UpdateData(String sql){
        int kq = 0;
        try {
            getConnect();
            st = conn.createStatement();
            kq = st.executeUpdate(sql);
            closeConnect();
        } catch (SQLException e) {
              e.printStackTrace();
        }
        return kq;
    }
    
    
    public void closeConnect() throws SQLException
    {
        if(this.rs!=null&&!this.rs.isClosed())
        try{
            this.rs.close();
            this.rs=null;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Loi dong ket qua");
        }
        if(this.st!=null&&!this.st.isClosed())
        try{
            this.st.close();
            this.st=null;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Loi dong lenh thuc thi");
        }
        
        if(this.conn!=null&&!this.conn.isClosed())
        try{
            this.conn.close();
            this.conn=null;
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Loi dong ket noi");
        }
   } 
}
