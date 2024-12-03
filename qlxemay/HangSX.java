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
		while (true) {
			System.out.print("Nhap so dien thoai hang san xuat: ");
			sdthsx = s.nextLine().trim();
			if (!sdthsx.isEmpty() && sdthsx.matches("\\d+")) {
				break; 
			}
			System.out.println("So dien thoai phai la cac chu so va khong duoc de trong. Vui long nhap lai!");
		}
		while (true) {
			System.out.print("Ten hang san xuat: ");
			tenhsx = s.nextLine().trim();
			if (!tenhsx.isEmpty()) {
				break; 
			}
			System.out.println("Ten hang san xuat khong duoc de trong. Vui long nhap lai!");
		}
		while (true) {
			System.out.print("Nhap dia chi hang san xuat: ");
			diachihsx = s.nextLine().trim(); 
			if (!diachihsx.isEmpty()) {
				break; 
			}
			System.out.println("Dia chi hang san xuat khong duoc de trong. Vui long nhap lai!");
		}
	}
	
	@Override
	public void xuat() {
		System.out.println("\tMa so hang san xuat: " + mahsx);
		System.out.println("\tTen hang: " + tenhsx);
		System.out.println("\tDia chi: " + diachihsx);
		System.out.println("\tSo dien thoai: " + sdthsx);

	}
        
        
    public void sua() {
		Scanner s = new Scanner(System.in);
		System.out.print("Nhap ten moi cua hang san xuat: ");
		this.setTenhsx(s.nextLine());
		
		String newsdt;
		while (true) { 
			System.out.print("Nhap so dien thoai moi cua hang san xuat: ");
			newsdt = s.nextLine();
			if (newsdt.matches("\\d{10}")) { 
				break; 
			} else {
				System.out.println("So dien thoai khong hop le. Vui long nhap lai!");
			}
		}
		this.setSdthsx(newsdt);
		System.out.print("Nhap dia chi moi cua hang san xuat: ");
		this.setDiachihsx(s.nextLine());
	}
	
}
