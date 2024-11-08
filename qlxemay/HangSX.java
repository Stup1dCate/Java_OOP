package qlxemay;
import java.util.Scanner;

public class HangSX implements INhap,IXuat{
	private int mahsx;
	private String tenhsx;
	private String diachihsx;
	private String sdthsx;
	public HangSX() {
		
	}
	public HangSX(int mahsx, String tenhsx, String diachihsx, String sdthsx) {
		this.mahsx = mahsx;
		this.tenhsx = tenhsx;
		this.diachihsx = diachihsx;
		this.sdthsx = sdthsx;
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

	@Override
	public void nhap() {
		Scanner s = new Scanner(System.in);
		System.out.print("Ma so hang san xuat: ");
		mahsx = s.nextInt();
		System.out.print("Nhap so dien thoai hang san xuat: ");
		sdthsx = s.nextLine();
		s.nextLine();
		System.out.print("Ten hang san xuat: ");
		tenhsx = s.nextLine();
		System.out.print("Nhap dia chi hang san xuat: ");
		diachihsx = s.nextLine();
	}
	@Override
	public void xuat() {
		System.out.println("\tMa so hang san xuat: " + mahsx);
		System.out.println("\tTen hang: " + tenhsx);
		System.out.println("\tDia chi: " + diachihsx);
		System.out.println("\tSo dien thoai: " + sdthsx);
		System.out.println("____________________________________________________________________");
	}
    public void sua() { 
        Scanner s = new Scanner(System.in);
        System.out.println("\tCHINH SUA THONG TIN HANG SAN XUAT:  ");
        System.out.println("Nhap ma moi cua hang san xuat: ");
        this.setMahsx(s.nextInt());
        s.nextLine();
        System.out.println("Nhap ten moi cua hang san xuat: ");
        this.setTenhsx(s.nextLine());
        System.out.println("Nhap so dien thoai moi cua hang san xuat: ");
        this.setSdthsx(s.nextLine());
        System.out.println("Nhap dia chi moi cua hang san xuat: ");
        this.setDiachihsx(s.nextLine());
    }
}
