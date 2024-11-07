package qlxemay;

public class ChiTietHoaDon {
	private XeMay xeMay;
    private int soluongmua;
 	private int masp;
 	private int soluongnhaphang;
 	private String tensp;
 	protected String loaisp;
 	private double tiennhaphang;
 	private double giasp;
	public ChiTietHoaDon() {
		this.xeMay = new XeMay();
	}
	
	public ChiTietHoaDon(XeMay xeMay, int soluongmua, int masp, int soluongnhaphang, String tensp, String loaisp, double tiennhaphang, double giasp) {
		super();
		this.xeMay = xeMay;
		this.soluongmua = soluongmua;
		this.masp = masp;
		this.soluongnhaphang = soluongnhaphang;
		this.tensp = tensp;
		this.loaisp = loaisp;
		this.tiennhaphang = tiennhaphang;
		this.giasp = giasp;
	}

	public XeMay getXeMay() {
		return xeMay;
	}
	public void setXeMay(XeMay xeMay) {
		this.xeMay = xeMay;
	}

	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
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

	@Override
    public String toString() {
        return xeMay.getMasp() + xeMay.getTensp() +
                "\n So luong san pham da mua: " + soluongmua;
	}
	public double tinhTien() {
	    if (this.xeMay != null) {
	        return this.xeMay.getGiasp() * this.soluongmua;
	    } else {
	        return 0.0;
	    }
	}

	
}
