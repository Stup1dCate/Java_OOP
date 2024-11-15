package qlxemay;

import java.util.Scanner;

public class XeMay implements IXuat {

    private int masp;
    private int soluongnhaphang;
    private String tensp;
    protected String loaisp;
    private double tiennhaphang;
    private double giasp;
    private HangSX hangSX;

    // Thêm các thuộc tính từ NhaCungCap
    private int mahsx;
    private String tenhsx;
    private String diachihsx;
    private String sdthsx;

    // Constructor không tham số
    public XeMay() {
        this.hangSX = new HangSX();
    }

    // Constructor có tham số
    public XeMay(int masp, int soluongnhaphang, String tensp, String loaisp, double tiennhaphang, double giasp, HangSX hangSX) {
        this.masp = masp;
        this.soluongnhaphang = soluongnhaphang;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.tiennhaphang = tiennhaphang;
        this.giasp = giasp;
        this.hangSX = hangSX;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluongnhaphang() {
        return soluongnhaphang;
    }

    public void setSoluongnhaphang(int soluongnhaphang) {
        this.soluongnhaphang = soluongnhaphang;
    }

    public double getGiasp() {
        return giasp;
    }

    public void setGiasp(double giasp) {
        this.giasp = giasp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public double getTiennhaphang() {
        return tiennhaphang;
    }

    public void setTiennhaphang(double tiennhaphang) {
        this.tiennhaphang = tiennhaphang;
    }

    public HangSX getHangSX() {
        return hangSX;
    }

    public void setHangSX(HangSX hangSX) {
        this.hangSX = hangSX;
    }

    public int getMahsx() {
        return mahsx;
    }

    public void setMahsx(int mahsx) {
        this.mahsx = mahsx;
    }

    public String getTenhsx() {
        return tenhsx;
    }

    public void setTenhsx(String tenhsx) {
        this.tenhsx = tenhsx;
    }

    public String getDiachihsx() {
        return diachihsx;
    }

    public void setDiachihsx(String diachihsx) {
        this.diachihsx = diachihsx;
    }

    public String getSdthsx() {
        return sdthsx;
    }

    public void setSdthsx(String sdthsx) {
        this.sdthsx = sdthsx;
    }

    public void nhap(String filehsx) {
        Scanner in = new Scanner(System.in);
        System.out.print("So luong hang nhap: ");
        soluongnhaphang = in.nextInt();
        System.out.print("So tien nhap hang (1 san pham): ");
        tiennhaphang = in.nextDouble();
        System.out.print("Gia ban san pham (1 san pham): ");
        giasp = in.nextDouble();
        in.nextLine();
        System.out.print("Ten san pham: ");
        tensp = in.nextLine();
        // Nhập thông tin hang san xuat
        System.out.println("\tNHAP THONG TIN HANG SAN XUAT TUONG UNG:");
        System.out.println("Nhap ma so hang san xuat");
        int ma = in.nextInt();
        DSHangSX dshsx = new DSHangSX();
        dshsx.taiDanhSachTuFile(filehsx);
        for(HangSX hang:dshsx.getDshsx()){
            if(ma==hang.getMahsx()){
                hangSX=hang;
                return;
            }
        }
        hangSX.setMahsx(ma);
        hangSX.nhap();
        System.out.println("\n===== DA LUU DU LIEU SAN PHAM THANH CONG ! =====\n");

    }

    @Override
    public void xuat() {
  
        System.out.println("\tMa san pham: " + masp);
        System.out.println("\tSo luong nhap: " + soluongnhaphang);
        System.out.println("\tGia ban: " + giasp);
        System.out.println("\tTen san pham: " + tensp);
        System.out.println("\tLoai san pham: " + loaisp);
        System.out.println("\tGia nhap: " + tiennhaphang);
        // Hiển thị thông tin nhà cung cấp
        hangSX.xuat();
    }

    @Override
    public String toString() {
        return "SanPham [masp:" + masp + ", soluongnhaphang:" + soluongnhaphang + ", tensp:" + tensp + ", loaisp:" + loaisp + ", tiennhaphang:" + tiennhaphang + ", giasp:" + giasp + ", HangSX:" + hangSX + ", mahsx:" + mahsx + ", tenhsx:" + tenhsx + ", diachihsx:" + diachihsx + ", sdthsx:" + sdthsx + "]";
    }

    public void sua() {
        // Sửa thông tin mã sản phẩm, tên sản phẩm, loại sản phẩm, số lượng nhập hàng, giá tiền, và thông tin nhà cung cấp
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ten san pham moi: ");
        this.setTensp(in.nextLine());
        System.out.println("Nhap so luong hang nhap moi: ");
        this.setSoluongnhaphang(in.nextInt());
        System.out.println("Nhap so tien nhap moi: ");
        this.setTiennhaphang(in.nextDouble());
        System.out.println("Nhap so tien ban moi: ");
        this.setGiasp(in.nextDouble());
          System.out.println("Nhap ma so hang san xuat:");
        int ma = in.nextInt();
        hangSX.setMahsx(ma);
        // Sửa thông tin nhà cung cấp
        hangSX.sua();
    }

    public void nhapHangSX() {
        // Tạo đối tượng NhaCungCap và gọi phương thức nhap() của nó
        HangSX hsx = new HangSX();
        hsx.nhap();

        // Gán thông tin nhà cung cấp cho sản phẩm
        setMahsx(hsx.getMahsx());
        setTenhsx(hsx.getTenhsx());
        setDiachihsx(hsx.getDiachihsx());
        setSdthsx(hsx.getSdthsx());
    }
}
