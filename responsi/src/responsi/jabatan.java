/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;
import java.awt.Color;
//import lat6.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import responsi.gambar.setimage;

/**
 *
 * @author al
 */
public class jabatan extends javax.swing.JFrame {
 login konek= new login();
     Connection Con =konek.getConnection();
    DefaultTableModel tablemodel;
    Statement Stm;
    //Connection Con;
    ResultSet RsUser;
    koneksi dbsetting;
    String driver, database, user, pass, userlogin;
    //String data[] = new String[5];
    
     double hdr=0, tj=0,lmbr=0;
     double miu_hdr=0,miu_hdr2=0,miu_tj=0,miu_lmbr=0,miu_lmbr2=0,miu_hdr3=0;
     String m_hdr="",m_hdr2="",m_tj="",m_lmbr="",m_lmbr2="";
     double z=0,output=0, output2=0,outputA=0,outputB=0,outputC=0,outputD=0,f=0,output3=0;
     String out="dikit",out2="jekpot";
    /**
     * Creates new form jabatan
     */
    public jabatan() {
       initComponents();
        setLocationRelativeTo(null);
        setTitle("");
        setResizable(false);
        //getDB();   
        
    }

    private void nopeg(){

    cmbpegjab.removeAllItems();
    try{
    Connection Con =konek.getConnection();
    Statement Stm=Con.createStatement();
    String sql="select no_peg from data_peg";
    ResultSet r=Stm.executeQuery(sql);
    cmbpegjab.addItem("--- Pilih No Pegawai ---");
    while(r.next()){
        String p=r.getString("no_peg");
        cmbpegjab.addItem(p);
    }
    r.close();
    Stm.close();
    cmbpegjab.setSelectedIndex(0);
}catch (SQLException e){
            System.out.println(e);
}
    }
    private void gajipokok(){
        txtgajipokokhit.removeAll();
    try{
    Connection Con =konek.getConnection();
    Statement Stm=Con.createStatement();
    String sql="select gaji_pokok,no_peg_jab from jabatan where no_jab ='"+txtjabhit.getText()+"'";
    ResultSet r=Stm.executeQuery(sql);
    while(r.next()){
        String p=r.getString("gaji_pokok");
        txtgajipokokhit.setText(""+p);
        String q=r.getString("no_peg_jab");
        txtpeghit.setText(""+q);

    }
    r.close();
    Stm.close();
    
}catch (SQLException e){
            System.out.println(e);
}
    }
     private void nopeghit(){

    

    }
//            private void getDB(){
//        dbsetting=new koneksi();
//        driver=dbsetting.SettingPanel("DBDriver");
//        database=dbsetting.SettingPanel("DBDatabase");
//        user=dbsetting.SettingPanel("DBUsername");
//        pass=dbsetting.SettingPanel("DBPassword");
//        
//        try {
//            Class.forName(driver);
//            Con=DriverManager.getConnection(database,user,pass);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver not Found");
//        } catch (SQLException e){
//            System.out.println(e);
//        }
//    }
    private void tampil(){
    Object row []={
        "NO PEGAWAI","NAMA","JENIS KELAMIN","UMUR","STATUS","ALAMAT"};
    tablemodel = new DefaultTableModel(null,row);
    tblpeg.setModel(tablemodel);
        try {
            String query ="select * from data_peg";
            Stm=(Statement)Con.createStatement();
            RsUser=Stm.executeQuery(query);
            tablemodel.setRowCount(0);
            while(RsUser.next()){
                tablemodel.addRow(new Object[]{
                    RsUser.getString(1),
                    RsUser.getString(2),
                    RsUser.getString(3),
                    RsUser.getString(4),
                    RsUser.getString(5),
                    RsUser.getString(6)
                });
                
            }
            Stm.close();
            RsUser.close();
        } catch (SQLException e) {
            System.out.println("Gagal tampil data"+e.toString());
        }
    }
    
    
    public void simpan(){
          String jk;
        if (rbpria.isSelected()){
            jk="L";
        }else{jk="P";}
        
        try{
            String query="insert into data_peg"+"(no_peg,nama,jk,umur,status,alamat)"+"values('"+txtnopeg.getText()+"','"+txtnama.getText()+"','"+jk+"','"+Integer.parseInt(txtumur.getText())+"',"
                    + "'"+txtstatus.getText()+"','"+txtalamat.getText()+"')";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil disimpan");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal simpan data"+ex.toString());
        }
    }             
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlmenu = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pnlpeg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnopeg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rbpria = new javax.swing.JRadioButton();
        rbwanita = new javax.swing.JRadioButton();
        txtumur = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        btntampil = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpeg = new javax.swing.JTable();
        pnljab = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtnojabatan = new javax.swing.JTextField();
        cmbjabatan = new javax.swing.JComboBox();
        txtgajipokok = new javax.swing.JTextField();
        btntampiljab = new javax.swing.JButton();
        btnsimpanjab = new javax.swing.JButton();
        btneditjab = new javax.swing.JButton();
        btnhapusjab = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbljab = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtcarijabatan = new javax.swing.JTextField();
        btncarijab = new javax.swing.JButton();
        cmbpegjab = new javax.swing.JComboBox();
        pnlhitgaji = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btntampilhit = new javax.swing.JButton();
        btnsimpanhit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhit = new javax.swing.JTable();
        btnedithit = new javax.swing.JButton();
        btnhapushit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtcarihit = new javax.swing.JTextField();
        btncarihit = new javax.swing.JButton();
        txtnogaji = new javax.swing.JTextField();
        txtgajipokokhit = new javax.swing.JTextField();
        txttj = new javax.swing.JTextField();
        txtjumhadir = new javax.swing.JTextField();
        txtjumlembur = new javax.swing.JTextField();
        txttotalgaji = new javax.swing.JTextField();
        btnhitung = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtjabhit = new javax.swing.JTextField();
        txtpeghit = new javax.swing.JTextField();
        pnllaporan = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jLabel23.setBackground(new java.awt.Color(0, 0, 204));
        jLabel23.setFont(new java.awt.Font("DejaVu Serif", 1, 48)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("PT. CAN JADI");
        jLabel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.white, java.awt.Color.white, java.awt.Color.black));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButton1.setText("Data Pegawai");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hitung Gaji");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Jabatan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.CardLayout());

        pnlmenu.setBackground(new java.awt.Color(102, 102, 255));
        pnlmenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel20.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("SISTEM PENGGAJIAN");
        jLabel20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("P E G A W A I");
        jLabel22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnlmenuLayout = new javax.swing.GroupLayout(pnlmenu);
        pnlmenu.setLayout(pnlmenuLayout);
        pnlmenuLayout.setHorizontalGroup(
            pnlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmenuLayout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(pnlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlmenuLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(88, 88, 88))
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(168, 168, 168))
        );
        pnlmenuLayout.setVerticalGroup(
            pnlmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmenuLayout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jPanel2.add(pnlmenu, "card5");

        pnlpeg.setBackground(new java.awt.Color(102, 102, 255));
        pnlpeg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlpeg.setPreferredSize(new java.awt.Dimension(800, 494));

        jLabel2.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DATA PEGAWAI");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No_Pegawai");

        txtnopeg.setText("jTextField1");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama");

        txtnama.setText("jTextField2");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jenis Kelamin");

        rbpria.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup1.add(rbpria);
        rbpria.setForeground(new java.awt.Color(255, 255, 255));
        rbpria.setText("L");

        rbwanita.setBackground(new java.awt.Color(102, 102, 255));
        buttonGroup1.add(rbwanita);
        rbwanita.setForeground(new java.awt.Color(255, 255, 255));
        rbwanita.setText("P");
        rbwanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbwanitaActionPerformed(evt);
            }
        });

        txtumur.setText("jTextField4");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Umur");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");

        txtstatus.setText("jTextField5");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Alamat");

        txtalamat.setText("jTextField6");

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search"));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("No/Nama Peg");

        txtcari.setText("jTextField7");

        btncari.setText("Search");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(35, 35, 35)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btncari)
                        .addGap(92, 92, 92))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncari)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btntampil.setText("Tampil");
        btntampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntampilActionPerformed(evt);
            }
        });

        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        tblpeg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblpeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpegMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblpeg);

        javax.swing.GroupLayout pnlpegLayout = new javax.swing.GroupLayout(pnlpeg);
        pnlpeg.setLayout(pnlpegLayout);
        pnlpegLayout.setHorizontalGroup(
            pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlpegLayout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(249, 249, 249))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlpegLayout.createSequentialGroup()
                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlpegLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(89, 89, 89)
                        .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlpegLayout.createSequentialGroup()
                                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlpegLayout.createSequentialGroup()
                                        .addComponent(rbpria)
                                        .addGap(21, 21, 21)
                                        .addComponent(rbwanita))
                                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnopeg, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlpegLayout.createSequentialGroup()
                                        .addComponent(btntampil)
                                        .addGap(38, 38, 38)
                                        .addComponent(btnsimpan)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnedit)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnhapus)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlpegLayout.createSequentialGroup()
                                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtumur, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlpegLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGap(22, 22, 22))
        );
        pnlpegLayout.setVerticalGroup(
            pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlpegLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnopeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbpria)
                    .addComponent(rbwanita))
                .addGap(23, 23, 23)
                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlpegLayout.createSequentialGroup()
                        .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtumur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnlpegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(btnedit)
                    .addComponent(btnhapus)
                    .addComponent(btntampil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.add(pnlpeg, "card2");

        pnljab.setBackground(new java.awt.Color(102, 102, 255));
        pnljab.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnljab.setPreferredSize(new java.awt.Dimension(800, 494));

        jLabel24.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("JABATAN PEGAWAI");
        jLabel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("No Jabatan");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("No Pegawai");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Nama Jabatan");

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Gaji Pokok");

        txtnojabatan.setText("jTextField16");

        cmbjabatan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Pillih Jabatan ---", "Manager", "Marketing", "Karyawan", "Bagian Gudang" }));
        cmbjabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbjabatanMousePressed(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbjabatanMouseClicked(evt);
            }
        });
        cmbjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbjabatanActionPerformed(evt);
            }
        });

        txtgajipokok.setText("jTextField19");

        btntampiljab.setText("Tampil");
        btntampiljab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntampiljabActionPerformed(evt);
            }
        });

        btnsimpanjab.setText("Simpan");
        btnsimpanjab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanjabActionPerformed(evt);
            }
        });

        btneditjab.setText("Edit");
        btneditjab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditjabActionPerformed(evt);
            }
        });

        btnhapusjab.setText("Hapus");
        btnhapusjab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusjabActionPerformed(evt);
            }
        });

        tbljab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbljab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbljabMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbljab);

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search"));

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("No Jabatan");

        txtcarijabatan.setText("jTextField20");

        btncarijab.setText("Search");
        btncarijab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarijabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcarijabatan))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(btncarijab)
                .addGap(54, 54, 54))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtcarijabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncarijab)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        cmbpegjab.setMaximumRowCount(100);

        javax.swing.GroupLayout pnljabLayout = new javax.swing.GroupLayout(pnljab);
        pnljab.setLayout(pnljabLayout);
        pnljabLayout.setHorizontalGroup(
            pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnljabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(245, 245, 245))
            .addGroup(pnljabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnljabLayout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(btntampiljab)
                        .addGap(18, 18, 18)
                        .addComponent(btnsimpanjab)
                        .addGap(18, 18, 18)
                        .addComponent(btneditjab)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapusjab)
                        .addContainerGap(132, Short.MAX_VALUE))
                    .addGroup(pnljabLayout.createSequentialGroup()
                        .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnljabLayout.createSequentialGroup()
                                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26))
                                .addGap(101, 101, 101)
                                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnojabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbpegjab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnljabLayout.createSequentialGroup()
                                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addGroup(pnljabLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel29)))
                                .addGap(86, 86, 86)
                                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtgajipokok, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(pnljabLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnljabLayout.setVerticalGroup(
            pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnljabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(32, 32, 32)
                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnojabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(25, 25, 25)
                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbpegjab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(6, 6, 6)
                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnljabLayout.createSequentialGroup()
                        .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(34, 34, 34)
                        .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgajipokok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(pnljabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntampiljab)
                    .addComponent(btnsimpanjab)
                    .addComponent(btneditjab)
                    .addComponent(btnhapusjab))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2.add(pnljab, "card3");

        pnlhitgaji.setBackground(new java.awt.Color(102, 102, 255));
        pnlhitgaji.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        pnlhitgaji.setPreferredSize(new java.awt.Dimension(800, 494));

        jLabel12.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("HITUNG GAJI PEGAWAI");
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("No_Gaji");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("No_Pegawai");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gaji Pokok");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Taggung Jawab (max 100)");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Jum hadir (max 26 HARI)");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Jum Jam Lembur (max 160 JAM)");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Total Gaji");

        btntampilhit.setText("Tampil");
        btntampilhit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntampilhitActionPerformed(evt);
            }
        });

        btnsimpanhit.setText("Simpan");
        btnsimpanhit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanhitActionPerformed(evt);
            }
        });

        tblhit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblhit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhitMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhit);

        btnedithit.setText("Edit");
        btnedithit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedithitActionPerformed(evt);
            }
        });

        btnhapushit.setText("Hapus");
        btnhapushit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapushitActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Search"));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("No Gaji");

        txtcarihit.setText("jTextField1");

        btncarihit.setText("Search");
        btncarihit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncarihitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(txtcarihit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btncarihit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtcarihit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncarihit)
                .addContainerGap())
        );

        txtnogaji.setText("jTextField9");

        txtgajipokokhit.setEditable(false);
        txtgajipokokhit.setText("jTextField11");

        txttj.setText("jTextField12");

        txtjumhadir.setText("jTextField13");

        txtjumlembur.setText("jTextField14");

        txttotalgaji.setEditable(false);
        txttotalgaji.setText("jTextField15");

        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("No Jabatan");

        txtjabhit.setText("jTextField1");

        txtpeghit.setEditable(false);
        txtpeghit.setText("jTextField1");
        txtpeghit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpeghitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlhitgajiLayout = new javax.swing.GroupLayout(pnlhitgaji);
        pnlhitgaji.setLayout(pnlhitgajiLayout);
        pnlhitgajiLayout.setHorizontalGroup(
            pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlhitgajiLayout.createSequentialGroup()
                .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlhitgajiLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnhitung)
                        .addGap(18, 18, 18)
                        .addComponent(btntampilhit)
                        .addGap(18, 18, 18)
                        .addComponent(btnsimpanhit)
                        .addGap(18, 18, 18)
                        .addComponent(btnedithit)
                        .addGap(18, 18, 18)
                        .addComponent(btnhapushit))
                    .addGroup(pnlhitgajiLayout.createSequentialGroup()
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlhitgajiLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel19))
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlhitgajiLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtjabhit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpeghit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnogaji, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtjumhadir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtjumlembur, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txttotalgaji, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgajipokokhit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlhitgajiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(236, 236, 236))
            .addGroup(pnlhitgajiLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        pnlhitgajiLayout.setVerticalGroup(
            pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlhitgajiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlhitgajiLayout.createSequentialGroup()
                        .addGap(20, 201, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(pnlhitgajiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnogaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjabhit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(16, 16, 16)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpeghit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjumhadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(17, 17, 17)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjumlembur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgajipokokhit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotalgaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlhitgajiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnhitung)
                    .addComponent(btntampilhit)
                    .addComponent(btnsimpanhit)
                    .addComponent(btnedithit)
                    .addComponent(btnhapushit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel2.add(pnlhitgaji, "card4");

        pnllaporan.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout pnllaporanLayout = new javax.swing.GroupLayout(pnllaporan);
        pnllaporan.setLayout(pnllaporanLayout);
        pnllaporanLayout.setHorizontalGroup(
            pnllaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 725, Short.MAX_VALUE)
        );
        pnllaporanLayout.setVerticalGroup(
            pnllaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jPanel2.add(pnllaporan, "card6");

        jButton22.setText("Exit");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton5.setText("Laporan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(28, 28, 28)
                .addComponent(jButton5)
                .addGap(36, 36, 36)
                .addComponent(jButton22)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton22)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         
         pnlpeg.setVisible(false);
        pnljab.setVisible(true);
        pnlhitgaji.setVisible(false);
        pnlmenu.setVisible(false);
        pnllaporan.setVisible(false);
        nopeg(); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pnlpeg.setVisible(true);
        pnljab.setVisible(false);
        pnlhitgaji.setVisible(false);
        pnlmenu.setVisible(false);
        pnllaporan.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         pnlpeg.setVisible(false);
        pnljab.setVisible(false);
        pnlhitgaji.setVisible(true);
        pnlmenu.setVisible(false);
        pnllaporan.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rbwanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbwanitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbwanitaActionPerformed

    private void btntampilhitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntampilhitActionPerformed
        // TODO add your handling code here:
        Object row []={
        "NO GAJI","NO PEGAWAI","NO JABATAN","GAJI POKOK","T. JAWAB","JML HADIR","JML JAM LEMBUR","GAJI TOTAL"};
    tablemodel = new DefaultTableModel(null,row);
    tblhit.setModel(tablemodel);
        try {
            String query ="SELECT * FROM hit_gaji ";
            Stm=(Statement)Con.createStatement();
            RsUser=Stm.executeQuery(query);
            tablemodel.setRowCount(0);
            while(RsUser.next()){
                tablemodel.addRow(new Object[]{
                    RsUser.getString(1),
                    RsUser.getString(2),
                    RsUser.getString(3),
                    RsUser.getString(4),
                    RsUser.getString(5),
                    RsUser.getString(6),
                    RsUser.getString(7),
                    RsUser.getString(8),
                  
                });
                
            }
            Stm.close();
            RsUser.close();
        } catch (SQLException e) {
            System.out.println("Gagal tampil data"+e.toString());
        }
        bersihhit();
        btnsimpanhit.setEnabled(true);
        txtnogaji.setEnabled(true);
        txtnogaji.setEditable(true);
    }//GEN-LAST:event_btntampilhitActionPerformed

    private void btnhapushitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapushitActionPerformed
        // TODO add your handling code here:
         try{
            String query="delete from hit_gaji where no_gaji = '"+txtnogaji.getText()+"'";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil di delete");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal di delete data"+ex.toString());
        }
        bersihhit();
         btnsimpanhit.setEnabled(true);
        txtnogaji.setEnabled(true);
        txtnogaji.setEditable(true);
    }//GEN-LAST:event_btnhapushitActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         pnlpeg.setVisible(false);
        pnljab.setVisible(false);
        pnlhitgaji.setVisible(false);
        pnlmenu.setVisible(true);
        pnllaporan.setVisible(false);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
       simpan();
       bersih();
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btntampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntampilActionPerformed
        // TODO add your handling code here:
        tampil();
        bersih();
    }//GEN-LAST:event_btntampilActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
         String jk;
        if (rbpria.isSelected()){
            jk="L";
        }else{jk="P";}
        
        try{
            String query="update data_peg set nama ='"+txtnama.getText()+"',"+"jk ='"+jk+"',umur ='"+Integer.parseInt(txtumur.getText())+"',"
                    + "status='"+txtstatus.getText()+"',alamat ='"+txtalamat.getText()+"' where no_peg ='"+txtnopeg.getText()+"'";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil di ubah");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal di ubah data"+ex.toString());
        }
        
        bersih();
         btnsimpan.setEnabled(true);
        txtnopeg.setEnabled(true);
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        String jk;
        if (rbpria.isSelected()){
            jk="L";
        }else{jk="P";}
        
        try{
            String query="delete from data_peg where no_peg = '"+txtnopeg.getText()+"'";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil di delete");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal di delete data"+ex.toString());
        }
        
        bersih();
         btnsimpan.setEnabled(true);
        txtnopeg.setEnabled(true);
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tblpegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpegMouseClicked
        // TODO add your handling code here:
         int row=tblpeg.getSelectedRow();
        txtnopeg.setText(tblpeg.getValueAt(row, 0).toString());
        txtnama.setText(tblpeg.getValueAt(row, 1).toString());
        txtumur.setText(tblpeg.getValueAt(row, 3).toString());
        txtstatus.setText(tblpeg.getValueAt(row, 4).toString());
        txtalamat.setText(tblpeg.getValueAt(row, 5).toString());
        if(rbpria.equals(tblpeg.getValueAt(row, 2).toString())){
            rbpria.setSelected(true);
        }else{
            rbwanita.setSelected(true);
        }
        //btntampil.setEnabled(false);
        btnsimpan.setEnabled(false);
        txtnopeg.setEnabled(false);
        btnhapus.setEnabled(true);
        btnedit.setEnabled(true);
        //btncari.setEnabled(false);
      //  txtcari.setEnabled(false);
        
        
    }//GEN-LAST:event_tblpegMouseClicked

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
          String parameter;
          Object row []={
        "NO PEGAWAI","NAMA","JENIS KELAMIN","UMUR","STATUS","ALAMAT"};
    tablemodel = new DefaultTableModel(null,row);
    tblpeg.setModel(tablemodel);
        try {
            String query ="Select * from data_peg where no_peg like '%" + txtcari.getText() + "%'" +
            "or nama like '%" + txtcari.getText() + "%'";;
            Stm=(Statement)Con.createStatement();
            RsUser=Stm.executeQuery(query);
            tablemodel.setRowCount(0);
            while(RsUser.next()){
                tablemodel.addRow(new Object[]{
                    RsUser.getString(1),
                    RsUser.getString(2),
                    RsUser.getString(3),
                    RsUser.getString(4),
                    RsUser.getString(5),
                    RsUser.getString(6)
                   
                });
                
            }
            Stm.close();
            RsUser.close();
        } catch (SQLException e) {
            System.out.println("Gagal search  data"+e.toString());
        }
        
        bersih();
    }//GEN-LAST:event_btncariActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        txtnopeg.setText(null);
        txtnama.setText(null);
        txtumur.setText(null);
        txtstatus.setText(null);
        txtalamat.setText(null);
        rbpria.setSelected(true);
        txtcari.setText(null);
        txtnojabatan.setText(null);
        //txtnopegjab.setText(null);
       //cmbpegjab.setSelectedIndex(0);
        txtgajipokok.setText(null);
        cmbjabatan.setSelectedIndex(0);
        txtcarijabatan.setText(null);
        txtnogaji.setText(null);
        txttj.setText(null);
        txtjumhadir.setText(null);
        txtjumlembur.setText(null);
        txttotalgaji.setText(null);
        txtgajipokokhit.setText(null);
        txtcarihit.setText(null);
        txtpeghit.setText(null);
        txtjabhit.setText(null);
    }//GEN-LAST:event_formWindowActivated

    private void btntampiljabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntampiljabActionPerformed
        // TODO add your handling code here:
        tampiljab();
        txtgajipokok.setEditable(false);
        bersihjab();
        txtnojabatan.setEditable(true);
    }//GEN-LAST:event_btntampiljabActionPerformed

    private void btnsimpanjabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanjabActionPerformed
        // TODO add your handling code here:
          String jabatan;
          String gaji;
        if (cmbjabatan.getSelectedIndex()==0){
            jabatan="Manager";
            gaji="5000000";
            System.out.println("hhhhhhhh");
             txtgajipokok.setText(gaji);
        }else if("Marketing".equals(cmbjabatan.getSelectedItem())){
            jabatan="Marketing";
            gaji="2000000";
        }else if ("Karyawan".equals(cmbjabatan.getSelectedItem())){
            jabatan="Karyawan";
            gaji="2500000";
        }else{jabatan="Bagian Gudang"; gaji="1500000";}
       
        String nopeg;
        
        
        try{
            String query="insert into jabatan"+"(no_jab,no_peg_jab,nama_jab,gaji_pokok)"+"values('"+txtnojabatan.getText()+"','"+cmbpegjab.getSelectedItem()+"',  '"+jabatan+"','"+Integer.parseInt(gaji)+"')";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil disimpan");
            tampiljab();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal simpan data"+ex.toString());
        }
      bersihjab();      
    }//GEN-LAST:event_btnsimpanjabActionPerformed

    private void cmbjabatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbjabatanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbjabatanMouseClicked

    private void cmbjabatanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbjabatanMousePressed
        // TODO add your handling code here:     
    }//GEN-LAST:event_cmbjabatanMousePressed
    public String jabatan="";
        public  int gaji=0;
    public void jbtn(){
         
        if("Marketing".equals(cmbjabatan.getSelectedItem())){
             jabatan="Marketing";
             gaji=2000000;
            txtgajipokok.setText(""+gaji);
        }
        else if("Manager".equals(cmbjabatan.getSelectedItem())){
             jabatan="Manager";
             gaji=5000000;
            txtgajipokok.setText(""+gaji);
        }
         else if ("Karyawan".equals(cmbjabatan.getSelectedItem())){
            jabatan="Karyawan";
            gaji=2500000;
            txtgajipokok.setText(""+gaji);

        }else if ("Bagian Gudang".equals(cmbjabatan.getSelectedItem())) {      
        jabatan="Bagian Gudang"; 
        gaji=1500000;
        txtgajipokok.setText(""+gaji);
         }
        
    }    
    
    
    private void cmbjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbjabatanActionPerformed
        // TODO add your handling code here:
        jbtn();
        
    }//GEN-LAST:event_cmbjabatanActionPerformed

    private void btneditjabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditjabActionPerformed
        // TODO add your handling code here:
        
        
        try{
            String query="update jabatan set no_peg_jab='"+cmbpegjab.getSelectedItem()+"',nama_jab ='"+cmbjabatan.getSelectedItem()+"',gaji_pokok='"+txtgajipokok.getText()+"' "
                    + "where no_jab ='"+txtnojabatan.getText()+"'";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil di ubah");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal di ubah data"+ex.toString());
        }
        
        bersihjab();
         btnsimpanjab.setEnabled(true);
        txtnojabatan.setEnabled(true);
        txtnojabatan.setEditable(true);
    }//GEN-LAST:event_btneditjabActionPerformed

    private void tbljabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbljabMouseClicked
        // TODO add your handling code here:
        jbtn();
         int row=tbljab.getSelectedRow();
        String no_peg=tbljab.getValueAt(row, 1).toString();
        txtnojabatan.setText(tbljab.getValueAt(row, 0).toString());
        String jab=tbljab.getValueAt(row, 2
        ).toString();
        
        for(int i=1;i<cmbjabatan.getItemCount() ;i++){
            String ip=cmbjabatan.getItemAt(i).toString();
            if (ip.equals(jab)){
                cmbjabatan.setSelectedIndex(i);
                break;
            }
        }
        for(int i=0;i<cmbpegjab.getItemCount() ;i++){
            String ip=cmbpegjab.getItemAt(i).toString();
            if (ip.equals(no_peg)){
                cmbpegjab.setSelectedIndex(i);
                break;
            }
        }
        txtgajipokok.setText(tbljab.getValueAt(row, 3).toString());
        //btntampil.setEnabled(false);
        btnsimpanjab.setEnabled(false);
        txtnojabatan.setEnabled(false);
        btnhapusjab.setEnabled(true);
        btneditjab.setEnabled(true);
        //btncari.setEnabled(false);
      //  txtcari.setEnabled(false);
        
    }//GEN-LAST:event_tbljabMouseClicked

    private void btnhapusjabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusjabActionPerformed
        // TODO add your handling code here:
        try{
            String query="delete from jabatan where no_jab = '"+txtnojabatan.getText()+"'";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil di delete");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal di delete data"+ex.toString());
        }
        
        bersihjab();
         btnsimpan.setEnabled(true);
        txtnopeg.setEnabled(true);
        txtnojabatan.setEditable(true);

    }//GEN-LAST:event_btnhapusjabActionPerformed

    private void btncarijabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarijabActionPerformed
        // TODO add your handling code here:
        String parameter;
          Object row []={
        "NO JABATAN","NO PEGAWAI","JABATAN","GAJI POKOK"};
    tablemodel = new DefaultTableModel(null,row);
    tbljab.setModel(tablemodel);
        try {
            String query ="Select * from jabatan where no_jab like '%" + txtcarijabatan.getText() + "%'" +
            "or no_peg_jab like '%" + txtcarijabatan.getText() + "%'";;
            Stm=(Statement)Con.createStatement();
            RsUser=Stm.executeQuery(query);
            tablemodel.setRowCount(0);
            while(RsUser.next()){
                tablemodel.addRow(new Object[]{
                    RsUser.getString(1),
                    RsUser.getString(2),
                    RsUser.getString(3),
                    RsUser.getString(4)
                   
                });
                
            }
            Stm.close();
            RsUser.close();
        } catch (SQLException e) {
            System.out.println("Gagal search  data"+e.toString());
        }
        
        bersihjab();
    }//GEN-LAST:event_btncarijabActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
        hdr=Integer.parseInt(txtjumhadir.getText());
        tj=Integer.parseInt(txttj.getText());
        lmbr=Integer.parseInt(txtjumlembur.getText());
        gajipokok();
        fuzzy();
        System.out.println(" bonus" +bonus);
        double tot= bonus + Double.parseDouble(txtgajipokokhit.getText());
        txttotalgaji.setText(""+tot);
        
        
        
    }//GEN-LAST:event_btnhitungActionPerformed

    private void txtpeghitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpeghitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpeghitActionPerformed

    private void btnsimpanhitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanhitActionPerformed
        // TODO add your handling code here:
         try{
            String query="insert into hit_gaji"+"(no_gaji,no_peg,no_jab,gaji_pokok,tj,lama_kerja,jum_jam_lmbr,total_gaji)"+"values('"+txtnogaji.getText()+"','"+txtpeghit.getText()+"',"
                    + "'"+txtjabhit.getText()+"','"+Integer.parseInt(txtgajipokokhit.getText()) +"',"
                    + "'"+Integer.parseInt(txttj.getText())+"','"+Integer.parseInt(txtjumhadir.getText())+"','"+Integer.parseInt(txtjumlembur.getText())+"','"+Double.parseDouble(txttotalgaji.getText())+"')";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil disimpan");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal simpan data"+ex);
        }
         bersihhit();
    }//GEN-LAST:event_btnsimpanhitActionPerformed

    private void btnedithitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedithitActionPerformed
        // TODO add your handling code here:
        try{
            String query="update hit_gaji set no_peg='"+txtpeghit.getText()+"',no_jab ='"+txtjabhit.getText()+"',"
                    + "gaji_pokok='"+txtgajipokokhit.getText()+"',tj='"+txttj.getText()+"',lama_kerja='"+txtjumhadir.getText()+"',"
                    + "jum_jam_lmbr='"+txtjumlembur.getText()+"',total_gaji='"+txttotalgaji.getText()+"' "
                    + "where no_gaji ='"+txtnogaji.getText()+"'";
            Statement Stm=Con.createStatement();
            Stm.executeUpdate(query);
            Stm.close();
            JOptionPane.showMessageDialog(null,"berhasil di ubah");
            tampil();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Gagal di ubah data"+ex.toString());
        }
        
        bersihhit();
        btnsimpanhit.setEnabled(true);
        txtnogaji.setEnabled(true);
        txtnogaji.setEditable(true);
    }//GEN-LAST:event_btnedithitActionPerformed

    private void tblhitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhitMouseClicked
        // TODO add your handling code here:
        
         int row=tblhit.getSelectedRow();
        txtnogaji.setText(tblhit.getValueAt(row, 0).toString());
        txtpeghit.setText(tblhit.getValueAt(row, 1).toString());
        txtjabhit.setText(tblhit.getValueAt(row, 2).toString());
        txtgajipokokhit.setText(tblhit.getValueAt(row, 3).toString());
        txttj.setText(tblhit.getValueAt(row,4).toString());
        txtjumhadir.setText(tblhit.getValueAt(row, 5).toString());
        txtjumlembur.setText(tblhit.getValueAt(row, 6).toString());
        txttotalgaji.setText(tblhit.getValueAt(row, 7).toString());
        //btntampil.setEnabled(false);
        btnsimpanhit.setEnabled(false);
        txtnogaji.setEnabled(false);
        btnhapushit.setEnabled(true);
        btnedithit.setEnabled(true);
        //btncari.setEnabled(false);
      //  txtcari.setEnabled(false);
    }//GEN-LAST:event_tblhitMouseClicked

    private void btncarihitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncarihitActionPerformed
        // TODO add your handling code here:
        Object row []={
        "NO GAJI","NO PEGAWAI","NO JABATAN","GAJI POKOK","TANGGUNG JAWAB","JUMLAH HADIR","JUMLAH JAM LEMBUR","GAJI TOTAL"};
    tablemodel = new DefaultTableModel(null,row);
    tblhit.setModel(tablemodel);
        try {
            String query ="Select * from hit_gaji where no_gaji like '%" + txtcarihit.getText() + "%'" ;;
            Stm=(Statement)Con.createStatement();
            RsUser=Stm.executeQuery(query);
            tablemodel.setRowCount(0);
            while(RsUser.next()){
                tablemodel.addRow(new Object[]{
                    RsUser.getString(1),
                    RsUser.getString(2),
                    RsUser.getString(3),
                    RsUser.getString(4),
                    RsUser.getString(5),
                    RsUser.getString(6),
                    RsUser.getString(7),
                    RsUser.getString(8)
                   
                });
                
            }
            Stm.close();
            RsUser.close();
        } catch (SQLException e) {
            System.out.println("Gagal search  data"+e.toString());
        }
        
        
    }//GEN-LAST:event_btncarihitActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         try{
            Connection Con =konek.getConnection();
            String report = "/home/al/NetBeansProjects/responsi/src/responsi/report_gaji.jrxml";
            JasperReport JASP_REP = JasperCompileManager.compileReport(report);
            JasperPrint JASP_PRNT = JasperFillManager.fillReport(JASP_REP, null, Con);
            JasperViewer.viewReport(JASP_PRNT);
        }catch(Exception X)
        {
            JOptionPane.showMessageDialog(null, X.toString());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton22ActionPerformed
    
    double miu_lmbr3=0,miu_hdr4=0,miu_lmbr4=0,bonus=0,outputE=0;
   String m_lmbr3="",m_hdr3="",out3="",m_hdr4="",m_lmbr4="";
    
    public void fuzzy(){
        
        //HADIR
        if(hdr<=10){
        miu_hdr=1;
        m_hdr="sedikit";
                System.out.println("hadir "+miu_hdr+ "  "+m_hdr);

    }else if (hdr>=20 && hdr<=26 ){
        miu_hdr2=1;
        m_hdr2="banyak";
                System.out.println("hadir "+miu_hdr2+ "  "+m_hdr2);

    }else if (hdr>10 && hdr <20){
        miu_hdr3=-((hdr-20)/(20-10));
        m_hdr3="sedikit";
        miu_hdr4=((hdr-10)/(20-10));
        m_hdr4="banyak";
         System.out.println("hadir "+miu_hdr3+ "  "+m_hdr3);
        System.out.println("hadir "+miu_hdr4+ "  "+m_hdr4);
        
    }else{
        JOptionPane.showMessageDialog(null, " Maaf ,nilai diluar rentang...");
    }
       
        //TANGGUNG JAWAB
        if(tj>=50 && tj<=100){
            miu_tj= ((tj-50)/(100-50));
            m_tj="lumayan";
        }
        else{
            JOptionPane.showMessageDialog(null, "maaff, nilai diluar rentang....");
        }
        System.out.println("tanggung jawab "+miu_tj+ "  "+m_tj);
        
        //LEMBUR
        if(lmbr<=60 && lmbr >=0){
        miu_lmbr=1;
        m_lmbr="kecil";
                System.out.println(" lembur "+miu_lmbr+ "  "+m_lmbr); 

    }else if (lmbr>= 80 && lmbr<=160 ){
        miu_lmbr2=1;
        m_lmbr2="besar";
                System.out.println(" lembur "+miu_lmbr2+ "  "+m_lmbr2);

    }else if (lmbr>60 && lmbr <80){
        miu_lmbr3=-((lmbr-80)/(80-60));
        m_lmbr3="kecil";
        miu_lmbr4=((lmbr-60)/(80-60));
        m_lmbr4="besar";
        
         System.out.println(" lembur "+miu_lmbr3+ "  "+m_lmbr3);
         System.out.println(" lembur "+miu_lmbr4+ "  "+m_lmbr4);
       
    }else{
        JOptionPane.showMessageDialog(null, " Maaf ,nilai diluar rentang...");
    }
        
        if(miu_hdr==1  && miu_lmbr==1  ){
           output=miu_tj;
           out="dikit";
        } else if(miu_hdr2==1   && miu_lmbr2==1 ){
           output2=miu_tj;
           out2="jekcpott";
        }
        else if (miu_hdr2==1 && miu_lmbr==1){
            output=miu_tj;
            out="dikit";
        }
        else if (miu_hdr==1 && miu_lmbr2==1){
            output=miu_tj;
            out="dikit";
        }
        else if (miu_hdr3<1 && miu_hdr4<1 && miu_lmbr3<1 && miu_lmbr4<1 && miu_tj<1  ){
           double status=0 ;
           status=(miu_hdr3<=miu_hdr4 && miu_hdr3<=miu_lmbr3 && miu_hdr3<=miu_tj && miu_hdr3<=miu_lmbr4)?miu_hdr3:status;
           status=(miu_hdr4<=miu_hdr3 && miu_hdr4<=miu_lmbr3 && miu_hdr4<=miu_tj && miu_hdr4<=miu_lmbr4)?miu_hdr4:status;
           status=(miu_lmbr3<=miu_hdr3 && miu_lmbr3<=miu_hdr4 && miu_lmbr3<=miu_tj && miu_lmbr3<=miu_lmbr4)?miu_lmbr3:status;
           status=(miu_lmbr4<=miu_hdr3 && miu_lmbr4<=miu_hdr4 && miu_lmbr4<=miu_tj && miu_lmbr4<=miu_lmbr3)?miu_lmbr4:status;
           status=(miu_tj<=miu_hdr3 && miu_tj<=miu_hdr4 && miu_tj<=miu_lmbr3 && miu_tj<=miu_lmbr4)?miu_tj:status;
           outputA=status;
           out="dikit";
        }else if (miu_hdr3<1 && miu_hdr4<1 && miu_lmbr2==1 && miu_tj<1  ){
            double status=0 ;
           status=(miu_hdr3<=miu_hdr4 && miu_hdr3<=miu_lmbr2 && miu_hdr3<=miu_tj)?miu_hdr3:status;
           status=(miu_hdr4<=miu_hdr3 && miu_hdr4<=miu_lmbr2 && miu_hdr4<=miu_tj)?miu_hdr4:status;
           status=(miu_lmbr2<=miu_hdr3 && miu_lmbr2<=miu_hdr4 && miu_lmbr2<=miu_tj)?miu_lmbr2:status;
           outputB=status;
           out="dikit";
        }
        else if (miu_hdr3<1 && miu_hdr4<1 && miu_lmbr==1 && miu_tj<1){
            double status=0 ;
           status=(miu_hdr3<=miu_hdr4 && miu_hdr3<=miu_lmbr && miu_hdr3<=miu_tj)?miu_hdr3:status;
           status=(miu_hdr4<=miu_hdr3 && miu_hdr4<=miu_lmbr && miu_hdr4<=miu_tj)?miu_hdr4:status;
           status=(miu_lmbr<=miu_hdr3 && miu_lmbr<=miu_hdr4 && miu_lmbr<=miu_tj)?miu_lmbr:status;
           outputC=status;
           out="dikit";
        }else if (miu_hdr2==1 && miu_lmbr3<1 && miu_lmbr4<1 && miu_tj<1 ){
            double status=0 ;
           status=(miu_hdr2<=miu_lmbr3 && miu_hdr2<=miu_lmbr4 && miu_hdr2<=miu_tj)?miu_hdr2:status;
           status=(miu_lmbr3<=miu_hdr2 && miu_lmbr3<=miu_lmbr4 && miu_lmbr3<=miu_tj)?miu_lmbr3:status;
           status=(miu_lmbr4<=miu_hdr2 && miu_lmbr<=miu_lmbr3 && miu_lmbr4<=miu_tj)?miu_lmbr4:status;
           outputD=status;
           out="dikit";
        }
        else if (miu_hdr==1 && miu_lmbr3<1 && miu_lmbr4<1 && miu_tj<1 ){
            double status=0 ;
           status=(miu_hdr<=miu_lmbr3 && miu_hdr<=miu_lmbr4 && miu_hdr<=miu_tj)?miu_hdr:status;
           status=(miu_lmbr3<=miu_hdr && miu_lmbr3<=miu_lmbr4 && miu_lmbr3<=miu_tj)?miu_lmbr3:status;
           status=(miu_lmbr4<=miu_hdr && miu_lmbr<=miu_lmbr3 && miu_lmbr4<=miu_tj)?miu_lmbr4:status;
           outputE=status;
           out="dikit";
        }
        else {
            JOptionPane.showMessageDialog(null, "Maaf, ada kesalahan.. perhitungan");
        }
        
         double st=0 ;
           st=(outputA<=outputB && outputA<=outputC  && outputA>=outputD && outputA>=outputE)?outputA:st;
           st=(outputB<=outputA && outputB<=outputC  && outputB>=outputD && outputB>=outputE)?outputB:st;
           st=(outputC<=outputA && outputC<=outputB  && outputC>=outputD && outputC>=outputE)?outputC:st;
           st=(outputD<=outputA && outputD<=outputB  && outputA>=outputC && outputD>=outputE)?outputD:st;
           st=(outputE<=outputA && outputE<=outputB  && outputA>=outputC && outputE>=outputD)?outputE:st;
           f=st;
           out="dikit";
        
        if (output>=f){
            output3=output;
        }else{
            output3=f;
        }
        System.out.println(""+out+" ==>>"+output3+"" );
        System.out.println(""+out2+" ==>>"+output2+"");
        
        
        z=(((10+20)*output3)+((40+50)*output2)+(30*0.5)/((2*output3)+(2*output2)+0.5));
        System.out.println("z = "+z);
        bonus=(z/100)*2000000;
    }
    
    
    
    
    
    private void tampiljab(){
    Object row []={
        "NO JABATAN","NO PEGAWAI","JABATAN","GAJI POKOK"};
    tablemodel = new DefaultTableModel(null,row);
    tbljab.setModel(tablemodel);
        try {
            String query ="SELECT * FROM jabatan ";
            Stm=(Statement)Con.createStatement();
            RsUser=Stm.executeQuery(query);
            tablemodel.setRowCount(0);
            while(RsUser.next()){
                tablemodel.addRow(new Object[]{
                    RsUser.getString(1),
                    RsUser.getString(2),
                    RsUser.getString(3),
                    RsUser.getString(4),
                  
                });
                
            }
            Stm.close();
            RsUser.close();
        } catch (SQLException e) {
            System.out.println("Gagal tampil data"+e.toString());
        }
    }
  private void bersih(){
       txtnopeg.setText("");
        txtnama.setText("");
        txtumur.setText("");
        txtstatus.setText("");
        txtalamat.setText("");
        rbpria.setSelected(true);
        txtcari.setText("");
  }
  private void bersihjab(){
       cmbpegjab.setSelectedIndex(0);
        txtnojabatan.setText("");
        txtgajipokok.setText("");
      cmbjabatan.setSelectedIndex(0);
      btnsimpanjab.setEnabled(true);
  }
  
  private void bersihhit(){
      txtnogaji.setText(null);
        txttj.setText(null);
        txtjumhadir.setText(null);
        txtjumlembur.setText(null);
        txttotalgaji.setText(null);
        txtgajipokokhit.setText(null);
        txtcarihit.setText(null);
        txtjabhit.setText(null);
        txtpeghit.setText(null);
  }
  
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
            java.util.logging.Logger.getLogger(jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jabatan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jabatan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btncarihit;
    private javax.swing.JButton btncarijab;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnedithit;
    private javax.swing.JButton btneditjab;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhapushit;
    private javax.swing.JButton btnhapusjab;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnsimpanhit;
    private javax.swing.JButton btnsimpanjab;
    private javax.swing.JButton btntampil;
    private javax.swing.JButton btntampilhit;
    private javax.swing.JButton btntampiljab;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbjabatan;
    private javax.swing.JComboBox cmbpegjab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlhitgaji;
    private javax.swing.JPanel pnljab;
    private javax.swing.JPanel pnllaporan;
    private javax.swing.JPanel pnlmenu;
    private javax.swing.JPanel pnlpeg;
    private javax.swing.JRadioButton rbpria;
    private javax.swing.JRadioButton rbwanita;
    private javax.swing.JTable tblhit;
    private javax.swing.JTable tbljab;
    private javax.swing.JTable tblpeg;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtcarihit;
    private javax.swing.JTextField txtcarijabatan;
    private javax.swing.JTextField txtgajipokok;
    private javax.swing.JTextField txtgajipokokhit;
    private javax.swing.JTextField txtjabhit;
    private javax.swing.JTextField txtjumhadir;
    private javax.swing.JTextField txtjumlembur;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnogaji;
    private javax.swing.JTextField txtnojabatan;
    private javax.swing.JTextField txtnopeg;
    private javax.swing.JTextField txtpeghit;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txttj;
    private javax.swing.JTextField txttotalgaji;
    private javax.swing.JTextField txtumur;
    // End of variables declaration//GEN-END:variables
}
