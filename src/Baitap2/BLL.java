
package Baitap2;

import java.sql.ResultSet;


public class BLL {
    DAL dal = new DAL();
    public ResultSet listSP2()
    {
        String sql = "select * from SANPHAM";
        return dal.getResult(sql);
    }
     public ResultSet listHD()
    {
        String sql = "select * from CHITIETHOADON";
        return dal.getResult(sql);
    }
      public int ThemSP(String MaSP, String TenSP, String DonViTinh, int Gia)
    {       
            String sql="insert into SANPHAM values('"+MaSP+"',N'"+TenSP+"',N'"+TenSP+"',"+Gia+")";
            return dal.UpdateData(sql);
    }
        public int SuaSP(String MaSP, String TenSP, String DonViTinh, int Gia)
    {       
            String sql="update SANPHAM set TENSP=N'"+TenSP+"',DONVITINH=N'"+DonViTinh+"',GIA="+Gia+" where MASP='"+MaSP+"'";
            return dal.UpdateData(sql);
    }
            public int Xoa(String MaSP)
    {       
            String sql="delete from SANPHAM where MaSP='"+MaSP+"'";
            return dal.UpdateData(sql);
    }
}
