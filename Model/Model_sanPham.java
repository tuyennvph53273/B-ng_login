package Model;


public class Model_sanPham {
    private String maSPCT; 
    private String IDLinhKien ; 
    private String IDMauSac ; 
    private String IDKhuyenmai ; 
    private String TenSP ; 
    private String maSP ; 
    private String IDLoai ; 
    private String TrongLuong ; 
    private String Phamvigio ; 
    private String TocDo ; 
    private String hangSP ; 
    private Integer soLuong ; 
    private Integer giaban ; 
    private Boolean trangthai ; 

    public Model_sanPham() {
    }

    public Model_sanPham(String maSPCT, String IDLinhKien, String IDMauSac, String IDKhuyenmai, String TenSP, String maSP, String IDLoai, String TrongLuong, String Phamvigio, String TocDo, String hangSP, Integer soLuong, Integer giaban, Boolean trangthai) {
        this.maSPCT = maSPCT;
        this.IDLinhKien = IDLinhKien;
        this.IDMauSac = IDMauSac;
        this.IDKhuyenmai = IDKhuyenmai;
        this.TenSP = TenSP;
        this.maSP = maSP;
        this.IDLoai = IDLoai;
        this.TrongLuong = TrongLuong;
        this.Phamvigio = Phamvigio;
        this.TocDo = TocDo;
        this.hangSP = hangSP;
        this.soLuong = soLuong;
        this.giaban = giaban;
        this.trangthai = trangthai;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getIDLinhKien() {
        return IDLinhKien;
    }

    public void setIDLinhKien(String IDLinhKien) {
        this.IDLinhKien = IDLinhKien;
    }

    public String getIDMauSac() {
        return IDMauSac;
    }

    public void setIDMauSac(String IDMauSac) {
        this.IDMauSac = IDMauSac;
    }

    public String getIDKhuyenmai() {
        return IDKhuyenmai;
    }

    public void setIDKhuyenmai(String IDKhuyenmai) {
        this.IDKhuyenmai = IDKhuyenmai;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getIDLoai() {
        return IDLoai;
    }

    public void setIDLoai(String IDLoai) {
        this.IDLoai = IDLoai;
    }

    public String getTrongLuong() {
        return TrongLuong;
    }

    public void setTrongLuong(String TrongLuong) {
        this.TrongLuong = TrongLuong;
    }

    public String getPhamvigio() {
        return Phamvigio;
    }

    public void setPhamvigio(String Phamvigio) {
        this.Phamvigio = Phamvigio;
    }

    public String getTocDo() {
        return TocDo;
    }

    public void setTocDo(String TocDo) {
        this.TocDo = TocDo;
    }

    public String getHangSP() {
        return hangSP;
    }

    public void setHangSP(String hangSP) {
        this.hangSP = hangSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGiaban() {
        return giaban;
    }

    public void setGiaban(Integer giaban) {
        this.giaban = giaban;
    }

    public Boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Boolean trangthai) {
        this.trangthai = trangthai;
    }

    

   
}
