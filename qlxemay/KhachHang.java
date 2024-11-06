/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class KhachHang implements INhap,IXuat{
	private int makh;
	private int sotuoi;
	private long sdtkh;
	private String tenkh;
	private String diachikh;
	private String phai;
	public KhachHang() {
		
	}
	public KhachHang(int makh, int sotuoi, long sdtkh, String tenkh, String diachikh, String phai) {
		this.makh = makh;
		this.sotuoi = sotuoi;
		this.sdtkh = sdtkh;
		this.tenkh = tenkh;
		this.diachikh = diachikh;
		this.phai = phai;
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
	@Override
	public void nhap() {
		Scanner in = new Scanner(System.in);
		System.out.println("nhap ma so khach hang: ");
		makh = in.nextInt();
		System.out.println("Nhap so dien thoai khach hang: ");
		sdtkh = in.nextLong();
		System.out.println("Nhap so tuoi khach hang: ");
		sotuoi = in.nextInt();
		in.nextLine();
		System.out.println("Nhap ho ten khach hang: ");
		tenkh = in.nextLine();
		System.out.println("Nhap gioi tinh khach hang: ");
		phai = in.nextLine();
		System.out.println("Nhap dia chi khach hang: ");
		diachikh = in.nextLine();
	}
	@Override
	public void xuat() {
		System.out.println("Ma so khach hang: " + makh);
		System.out.println("Ho va ten: " + tenkh);
		System.out.println("Gioi tinh: " + phai);
		System.out.println("So tuoi: " + sotuoi);
		System.out.println("So dien thoai: " +sdtkh);
		System.out.println("Dia chi: " + diachikh);		
	}
	@Override
	public String toString() {
		return "Ma so khach hang: " + makh +
	            "\nHo va ten: " + tenkh +
	            "\nGioi tinh: " + phai +
	            "\nSo tuoi: " + sotuoi +
	            "\nSo dien thoai: " + sdtkh +
	            "\nDia chi: " + diachikh;
	}
	public void sua() { // ------
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma so khach hang moi: ");
        this.setMakh(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhap ten khach hang: ");
        this.setTenkh(scanner.nextLine());
        System.out.println("Nhap so tuoi cua khach hang: ");
        this.setSotuoi(scanner.nextInt());
        System.out.println("Nhap so dien thoai: ");
        this.setSdtkh(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Nhap gioi tinh: ");
        this.setPhai(scanner.nextLine());
        System.out.println("Nhap dia chi: ");
        this.setDiachikh(scanner.nextLine());
    }
}
