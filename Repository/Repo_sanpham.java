package Repository;

import Model.Model_sanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Repo_sanpham {

    public ArrayList<Model_sanPham> getAllSP() {
        ArrayList<Model_sanPham> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from SanPham");
            while (rs.next()) {
                Model_sanPham ms = new Model_sanPham();
                ms.setMaSP(rs.getString(1));
                ms.setTenSP(rs.getString(2));
                ms.setTrangthai(rs.getBoolean(3));
                list.add(ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repo_sanpham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    public ArrayList<Model_sanPham> getAllSPCT() {
        ArrayList<Model_sanPham> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from SanPhamChiTiet");
            while (rs.next()) {
                Model_sanPham ms = new Model_sanPham();
                ms.setMaSPCT(rs.getString(1));
                ms.setIDLinhKien(rs.getString(2));
                ms.setIDMauSac(rs.getString(3));
                ms.setIDKhuyenmai(rs.getString(4));
                ms.setMaSP(rs.getString(5));
                ms.setIDLoai(rs.getString(6));
                ms.setTrongLuong(rs.getString(7));
                ms.setPhamvigio(rs.getString(8));
                ms.setTocDo(rs.getString(9));
                ms.setSoLuong(rs.getInt(10));
                ms.setHangSP(rs.getString(11));
                ms.setGiaban(rs.getInt(12));
                ms.setTrangthai(rs.getBoolean(13));
                list.add(ms);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repo_sanpham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public Integer addInfoSP(Model_sanPham nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                     INSERT INTO SanPham
                     VALUES 
                     	(?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaSP());
            ptsm.setString(2, nv.getTenSP());
            ptsm.setBoolean(3, nv.getTrangthai());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }

    public Integer editInfoSP(Model_sanPham nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "Update SanPham \n"
                + "Set TenSanpham = ?, TrangThai = ?\n"
                + "Where IDSanpham = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(3, nv.getMaSP());
            ptsm.setString(1, nv.getTenSP());
            ptsm.setBoolean(2, nv.getTrangthai());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer deleteInfoSP(Model_sanPham nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = "Delete from SanPham\n"
                + "where IDSanPham = ?";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaSP());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {

        }
        return row;
    }
    public Integer addInfoSPCT(Model_sanPham nv) throws SQLException {
        Integer row = null;
        Connection cn = DB_conect.getConnection();
        String sql = """
                    INSERT INTO SanPhamChiTiet
                        VALUES 
                        (?,?,?,?,?,?,?,?,?,?,?,?,?)""";
        try {
            PreparedStatement ptsm = cn.prepareStatement(sql);
            ptsm.setString(1, nv.getMaSPCT());
            ptsm.setString(2, nv.getIDLinhKien());
            ptsm.setString(3, nv.getIDMauSac());
            ptsm.setString(4, nv.getIDKhuyenmai());
            ptsm.setString(5, nv.getMaSP());
            ptsm.setString(6, nv.getIDLoai());
            ptsm.setString(7, nv.getTrongLuong());
            ptsm.setString(8, nv.getPhamvigio());
            ptsm.setString(9, nv.getTocDo());
            ptsm.setInt(10, nv.getSoLuong());
            ptsm.setString(11, nv.getHangSP());
            ptsm.setInt(12, nv.getGiaban());
            ptsm.setBoolean(13, nv.getTrangthai());
            row = ptsm.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
        }
        return row;
    }
      public ArrayList<Model_sanPham> getSearchSP(String tuKhoa) {
        ArrayList<Model_sanPham> list = new ArrayList<>();
        try {
            ResultSet rs = DB_conect.getConnection().createStatement().executeQuery("select * from SanPham\n" +
                                                                                    "where IDSanpham like '%"+tuKhoa+"%'");
            while (rs.next()) {
                Model_sanPham ms = new Model_sanPham();
                ms.setMaSP(rs.getString(1));
                ms.setTenSP(rs.getString(2));
                ms.setTrangthai(rs.getBoolean(3));
                list.add(ms);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }
      
}
