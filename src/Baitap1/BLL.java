/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baitap1;

import java.sql.ResultSet;

public class BLL {
    DAL dal = new DAL();
     public ResultSet listSP()
    {
        String sql = "select MaSP, TenSP, LoaiSanPham.TenLoaiSP from SanPham, LoaiSanPham where SanPham.MaLoaiSP=LoaiSanPham.MaLoaiSP";
        return dal.getResult(sql);
    }
     public int ThemLoaiSP(String MaLoaiSP, String TenLoaiSP)
    {       
            String sql="insert into LoaiSanPham values('"+MaLoaiSP+"',N'"+TenLoaiSP+"')";
            return dal.UpdateData(sql);
    }
}
