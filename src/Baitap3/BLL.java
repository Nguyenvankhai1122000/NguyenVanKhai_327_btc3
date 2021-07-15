
package Baitap3;
import java.sql.ResultSet;
public class BLL {
     DAL dal = new DAL();
    public ResultSet listSach()
    {
        String sql = "select * from TBLSACH";
        return dal.getResult(sql);
    }
    public ResultSet listSachTim(String MaSach)
    {
        String sql = "select * from TBLSACH where MASACH=N'"+MaSach+"'";
        return dal.getResult(sql);
    }
}
