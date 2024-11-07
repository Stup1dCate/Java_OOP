/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class HoaDon implements INhap,IXuat{
	private int mahd;
	private String ngaythanhtoan;
	private KhachHang khachHang;
	private XeMay xeMay;
	private ChiTietHoaDon cthd;
	// Thêm các thuộc tính từ KhachHang
	private int makh;
	private int sotuoi;
	private long sdtkh;
	private String tenkh;
	private String diachikh;
	private String phai;
	// Thêm các thuộc tính từ SanPham
	private int masp;
	private int soluongnhaphang;
	private String tensp;
	protected String loaisp;
	private double tiennhaphang;
	private double giasp;
	// Thêm các thuộc tính từ ChiTietHoaDon
    private int SoSPmua;
	
	public HoaDon() {
		this.khachHang = new KhachHang();
		this.xeMay = new XeMay();
		this.cthd = new ChiTietHoaDon();
	}
	public HoaDon(int mahd, String ngaythanhtoan, KhachHang khachHang, XeMay xeMay, int SoSPmua) {
		this.mahd = mahd;
		this.ngaythanhtoan = ngaythanhtoan;
		this.khachHang = khachHang;
		this.xeMay = xeMay;
		this.SoSPmua = SoSPmua;
	}
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public String getNgaythanhtoan() {
		return ngaythanhtoan;
	}
	public void setNgaythanhtoan(String ngaythanhtoan) {
		this.ngaythanhtoan = ngaythanhtoan;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}

	public int getSotuoi() {
		return sotuoi;
	}
	public void setSotuoi(int sotuoi) {
		this.sotuoi = sotuoi;
	}

	public long getSdtkh() {
		return sdtkh;
	}
	public void setSdtkh(long sdtkh) {
		this.sdtkh = sdtkh;
	}

	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDiachikh() {
		return diachikh;
	}
	public void setDiachikh(String diachikh) {
		this.diachikh = diachikh;
	}

	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	
	public XeMay getXeMay() {
		return xeMay;
	}
	public void setXeMay(XeMay xeMay) {
		this.xeMay = xeMay;
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

	public double getGiasp() {
		return giasp;
	}
	public void setGiasp(double giasp) {
		this.giasp = giasp;
	}
	
	public ChiTietHoaDon getChiTietHoaDon() {
		return cthd;
	}
	public void setChiTietHoaDon(ChiTietHoaDon cthd) {
		this.cthd = cthd;
	}

	public int getSoSPmua() {
		return SoSPmua;
	}
	public void setSoSPmua(int SoSPmua) {
		this.SoSPmua = SoSPmua;
	}

	public void xuat() {
		System.out.println("Ma hoa don: " + mahd);
		System.out.println("Ngay thanh toan: " + ngaythanhtoan);
	}

	public void nhap() {
		Scanner s = new Scanner(System.in);
		System.out.println("Nhap ma hoa don: ");
		mahd = s.nextInt();
		s.nextLine();
		System.out.println("Nhap ngay thanh toan: ");
		ngaythanhtoan = s.nextLine();
	}

	public String toString() {
		return "Ma hoa don: " + mahd + "\nNgay lap hoa don: " + ngaythanhtoan;
	}

    public void sua() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhap ma so hoa don moi: ");
        this.setMahd(s.nextInt());
        s.nextLine();
        System.out.println("Nhap ngay thanh toan hoa don moi: ");
        this.setNgaythanhtoan(s.nextLine());
        
        // sửa thông tin khách hàng nếu cần thiết 
        khachHang.sua();
    }

	public void nhapKhachHang() {
        KhachHang kh = new KhachHang();
        kh.nhap();
        
        setMakh(kh.getMakh());
        setTenkh(kh.getTenkh());
        setSotuoi(kh.getSotuoi());
        setPhai(kh.getPhai());
        setSdtkh(kh.getSdtkh());
        setDiachikh(kh.getDiachikh());
	}
}