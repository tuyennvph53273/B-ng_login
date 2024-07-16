package View;

import Model.Model_sanPham;
import Repository.DB_conect;
import Repository.Repo_sanpham;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class sanPham extends javax.swing.JFrame {

    Repo_sanpham repo = new Repo_sanpham();
    DefaultTableModel model = new DefaultTableModel();
     DefaultTableModel modelCT = new DefaultTableModel();
    int i = 0;
    public sanPham() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) tbl_SP.getModel();
        modelCT = (DefaultTableModel) tbl_ctsp.getModel();
        loadToTableSp();
        loadToTableSpct();
          for (Model_sanPham de : repo.getAllSPCT()) {
            if (de.getIDLinhKien()!=null) {
                cbo_linhkien.addItem(de.getIDLinhKien());
            }
        }
          for (Model_sanPham de : repo.getAllSPCT()) {
            if (de.getIDLoai()!=null) {
                cbo_loai.addItem(de.getIDLoai());
            }
        }
          for (Model_sanPham de : repo.getAllSPCT()) {
            if (de.getIDMauSac()!=null) {
                cbo_mausac.addItem(de.getIDMauSac());
            }
        }
          for (Model_sanPham de : repo.getAllSPCT()) {
            if (de.getMaSP()!=null) {
                cbo_sanpham.addItem(de.getMaSP());
            }
        }
          for (Model_sanPham de : repo.getAllSPCT()) {
            if (de.getIDKhuyenmai()!=null) {
                cbo_Khuyenmai.addItem(de.getIDKhuyenmai());
            }
        }
    }

    public void loadToTableSp() {
        model.setRowCount(0);
        for (Model_sanPham sp : repo.getAllSP()) {
            model.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getTrangthai() ? "Còn hàng" : "hết hàng"
            });
        }
    }
    public void loadToTableSpct() {
        modelCT.setRowCount(0);
        for (Model_sanPham sp : repo.getAllSPCT()) {
            modelCT.addRow(new Object[]{
                sp.getMaSPCT(),
                sp.getIDLinhKien(),
                sp.getIDMauSac(),
                sp.getIDKhuyenmai(),
                sp.getMaSP(),
                sp.getIDLoai(),
                sp.getTrongLuong(),
                sp.getPhamvigio(),
                sp.getTocDo(),
                sp.getSoLuong(),
                sp.getHangSP(),
                sp.getGiaban(),
                sp.getTrangthai() ? "Còn hàng" : "hết hàng"
            });
        }
    }
     public void loadToTableSearchSp(String s) {
        model.setRowCount(0);
        for (Model_sanPham sp : repo.getSearchSP(s)) {
            model.addRow(new Object[]{
                sp.getMaSP(),
                sp.getTenSP(),
                sp.getTrangthai() ? "Còn hàng" : "hết hàng"
            });
        }
    }
    
   public void fillToTableSP(){
       i = tbl_SP.getSelectedRow();
       Model_sanPham a = repo.getAllSP().get(i);
       txt_maSearch.setText(a.getMaSP());
       txt_tenSP.setText(a.getTenSP());
       txt_maSP.setText(a.getMaSP());
       rbo_conSP.setSelected(a.getTrangthai()?true:false);
       rbo_hetSP.setSelected(!a.getTrangthai()?true:false);
   }
   public void fillToTableSPCT(){
       i = tbl_ctsp.getSelectedRow();
       Model_sanPham a = repo.getAllSPCT().get(i);
       txt_maspct.setText(a.getMaSPCT());
       cbo_linhkien.setSelectedItem(a.getIDLinhKien());
       cbo_mausac.setSelectedItem(a.getIDMauSac());
       cbo_Khuyenmai.setSelectedItem(a.getIDKhuyenmai());
       cbo_sanpham.setSelectedItem(a.getMaSP());
       cbo_loai.setSelectedItem(a.getIDLoai());
       txt_trongluong.setText(a.getTrongLuong());
       txt_phamvi.setText(a.getPhamvigio());
       txt_tocdo.setText(a.getTocDo());
       txt_soluong.setText(a.getSoLuong()+"");
       txt_hang.setText(a.getHangSP());
       txt_giaban.setText(a.getGiaban()+"");
       rdo_ConHangspct.setSelected(a.getTrangthai()?true:false);
       rdo_hetHangspct.setSelected(!a.getTrangthai()?true:false);
   }
    
    Model_sanPham addRecordSP(){
        Model_sanPham a = new Model_sanPham();
        a.setMaSP(txt_maSP.getText());
        a.setTenSP(txt_tenSP.getText());
        a.setTrangthai(rbo_conSP.isSelected());
        return a;             
    }
    
    Model_sanPham addRecordSPCT(){
        Model_sanPham a = new Model_sanPham();
        a.setMaSPCT(txt_maspct.getText());
        a.setIDLinhKien(cbo_linhkien.getSelectedItem()+"");
        a.setIDMauSac(cbo_mausac.getSelectedItem()+"");
        a.setIDKhuyenmai(cbo_Khuyenmai.getSelectedItem()+"");
        a.setMaSP(cbo_sanpham.getSelectedItem()+"");
        a.setIDLoai(cbo_loai.getSelectedItem()+"");
        a.setTrongLuong(txt_trongluong.getText());
        a.setTocDo(txt_tocdo.getText());
        a.setSoLuong(Integer.parseInt(txt_soluong.getText()));
        a.setHangSP(txt_hang.getText());
        a.setGiaban(Integer.parseInt(txt_giaban.getText()));
        a.setTrangthai(rdo_ConHangspct.isSelected());
        return a;             
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_maSearch = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_SP = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_delete2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txt_maSP = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_tenSP = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        rbo_conSP = new javax.swing.JRadioButton();
        rbo_hetSP = new javax.swing.JRadioButton();
        F5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_ctsp = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_trongluong = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_phamvi = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_tocdo = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txt_hang = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_giaban = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        rbo_conhang = new javax.swing.JRadioButton();
        rbo_hethang = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        cbo_linhkien = new javax.swing.JComboBox<>();
        cbo_mausac = new javax.swing.JComboBox<>();
        cbo_loai = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_maspct = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        cbo_Khuyenmai = new javax.swing.JComboBox<>();
        cbo_sanpham = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        rdo_ConHangspct = new javax.swing.JRadioButton();
        rdo_hetHangspct = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel7.setBackground(new java.awt.Color(216, 239, 239));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setText("Danh Sách Sản Phẩm");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sanpham1.png"))); // NOI18N

        txt_maSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maSearchActionPerformed(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search.png"))); // NOI18N
        btn_search.setText("Tìm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        tbl_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_SP);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Mã Sản Phẩm");

        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trasua.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute1.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute2.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute3.png"))); // NOI18N

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        btn_delete2.setText("Xóa");
        btn_delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete2ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel30.setText("Mã Sản Phẩm: ");

        txt_maSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maSPActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel31.setText("Tên Sản Phẩm: ");

        txt_tenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tenSPActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel32.setText("Trạng Thái");

        buttonGroup2.add(rbo_conSP);
        rbo_conSP.setText("Còn Hàng");

        buttonGroup2.add(rbo_hetSP);
        rbo_hetSP.setText("Hết Hàng");

        F5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        F5.setText("F5");
        F5.setMaximumSize(new java.awt.Dimension(84, 31));
        F5.setMinimumSize(new java.awt.Dimension(84, 31));
        F5.setPreferredSize(new java.awt.Dimension(84, 31));
        F5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                F5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btn_them)
                                .addGap(61, 61, 61)
                                .addComponent(btn_sua)
                                .addGap(55, 55, 55)
                                .addComponent(btn_delete2))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel31)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel32)
                                                .addGap(47, 47, 47)))
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(rbo_conSP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbo_hetSP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txt_tenSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel22))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(txt_maSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btn_search)
                        .addGap(35, 35, 35)
                        .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(185, 185, 185))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel22))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)))
                                .addGap(94, 94, 94)
                                .addComponent(jLabel7)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_maSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_search)
                                        .addComponent(jLabel21))
                                    .addComponent(F5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel32)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbo_conSP)
                                    .addComponent(rbo_hetSP))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sua)
                            .addComponent(btn_them)
                            .addComponent(btn_delete2))
                        .addGap(14, 14, 14))))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel7);

        jPanel8.setBackground(new java.awt.Color(216, 239, 239));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Chi Tiết Sản Phẩm");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sanpham1.png"))); // NOI18N

        tbl_ctsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm CT", "ID Linh Kiện", "ID Mầu sắc", "ID Khuyến mãi", "ID Sản Phẩm", "ID Loại", "Trọng Lượng", "Phạm Vi gió", "Tốc Độ Gió", "Số Lượng", "Hãng Sản Xuất", "Giá Bán", "Trạng Thái"
            }
        ));
        tbl_ctsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ctspMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_ctsp);

        jLabel1.setText("ID Sản Phẩm :");

        jLabel2.setText("ID Khuyến mãi :");

        jLabel3.setText("ID Linh Kiện :");

        jLabel4.setText("Mầu Sắc :");

        jLabel10.setText(" ID Loại :");

        jLabel11.setText("Trọng Lượng :");

        jLabel12.setText("Phạm Vi Gió :");

        jLabel25.setText("Tốc Độ Gió :");

        jLabel26.setText("Số Lượng :");

        jLabel27.setText("Hẵng Sản Xuất :");

        jLabel28.setText("Giá Bán :");

        jLabel29.setText("Trạng Thái :");

        buttonGroup1.add(rbo_conhang);
        rbo_conhang.setText("Còn hàng");
        rbo_conhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbo_conhangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbo_hethang);
        rbo_hethang.setText("Hết Hàng");
        rbo_hethang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbo_hethangActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Sua.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        jButton3.setText("Mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Xoa.png"))); // NOI18N
        jButton9.setText("Xóa");

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cute4.png"))); // NOI18N

        jLabel18.setText("Mã Sản Phẩm CT :");

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cộng.png"))); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_ConHangspct);
        rdo_ConHangspct.setText("Còn Hàng");

        buttonGroup1.add(rdo_hetHangspct);
        rdo_hetHangspct.setText("Hết Hàng");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(269, 269, 269))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(336, 336, 336)))
                .addComponent(jLabel14)
                .addGap(49, 49, 49))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 123, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(cbo_Khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbo_linhkien, 0, 122, Short.MAX_VALUE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbo_mausac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_trongluong, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jButton2)
                        .addGap(57, 57, 57)
                        .addComponent(jButton9)
                        .addGap(60, 60, 60)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addGap(46, 46, 46))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_maspct, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(rdo_ConHangspct, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdo_hetHangspct, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addGap(73, 73, 73)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(rbo_conhang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbo_hethang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_phamvi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_tocdo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_hang, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(68, 68, 68))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel16)))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_trongluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbo_conhang)
                            .addComponent(rbo_hethang)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txt_maspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(cbo_linhkien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txt_phamvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txt_tocdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_hang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel28)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(cbo_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(cbo_Khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdo_ConHangspct)
                                .addComponent(rdo_hetHangspct)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(cbo_sanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton9))
                        .addGap(12, 12, 12))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Sản Phẩm Chi Tiết", jPanel8);

        jPanel6.setBackground(new java.awt.Color(216, 239, 239));

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Left.png"))); // NOI18N
        jButton8.setText("Thoát");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_maSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maSearchActionPerformed

    private void rbo_conhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbo_conhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbo_conhangActionPerformed

    private void rbo_hethangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbo_hethangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbo_hethangActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
           Model_sanPham nv  = addRecordSP();
        try {
            if (repo.editInfoSP(nv) != null) {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
            loadToTableSp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        new QLThuocTinh().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.dispose();
        new QLThuocTinh().setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new TrangChu().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        Model_sanPham nv  = addRecordSP();
        try {
            if (repo.addInfoSP(nv) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
            loadToTableSp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete2ActionPerformed
        // TODO add your handling code here:
           Model_sanPham nv  = addRecordSP();
        try {
            if (repo.deleteInfoSP(nv) != null) {
                JOptionPane.showMessageDialog(this, "Xóa  thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
            loadToTableSp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_delete2ActionPerformed

    private void tbl_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPMouseClicked
        // TODO add your handling code here:
        fillToTableSP();
    }//GEN-LAST:event_tbl_SPMouseClicked

    private void txt_maSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maSPActionPerformed

    private void txt_tenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tenSPActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
         String tuKhoa = txt_maSearch.getText();
        loadToTableSearchSp(tuKhoa);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void F5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_F5ActionPerformed
        // TODO add your handling code here:
        loadToTableSp();
    }//GEN-LAST:event_F5ActionPerformed

    private void tbl_ctspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ctspMouseClicked
        // TODO add your handling code here:
        fillToTableSPCT();
    }//GEN-LAST:event_tbl_ctspMouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txt_maspct.setText("");
        txt_trongluong.setText("");
        txt_phamvi.setText("");
        txt_tocdo.setText("");
        txt_soluong.setText("");
        txt_hang.setText("");
        txt_giaban.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Model_sanPham nv  = addRecordSPCT();
        try {
            if (repo.addInfoSPCT(nv) != null) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
            loadToTableSpct();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton F5;
    private javax.swing.JButton btn_delete2;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbo_Khuyenmai;
    private javax.swing.JComboBox<String> cbo_linhkien;
    private javax.swing.JComboBox<String> cbo_loai;
    private javax.swing.JComboBox<String> cbo_mausac;
    private javax.swing.JComboBox<String> cbo_sanpham;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbo_conSP;
    private javax.swing.JRadioButton rbo_conhang;
    private javax.swing.JRadioButton rbo_hetSP;
    private javax.swing.JRadioButton rbo_hethang;
    private javax.swing.JRadioButton rdo_ConHangspct;
    private javax.swing.JRadioButton rdo_hetHangspct;
    private javax.swing.JTable tbl_SP;
    private javax.swing.JTable tbl_ctsp;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_hang;
    private javax.swing.JTextField txt_maSP;
    private javax.swing.JTextField txt_maSearch;
    private javax.swing.JTextField txt_maspct;
    private javax.swing.JTextField txt_phamvi;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_tenSP;
    private javax.swing.JTextField txt_tocdo;
    private javax.swing.JTextField txt_trongluong;
    // End of variables declaration//GEN-END:variables
}
