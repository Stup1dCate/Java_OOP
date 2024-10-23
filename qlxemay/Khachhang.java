/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class Khachhang implements INhap, IXuat {

    private int makh;
    private int sotuoi;
    private long sdtkh;
    private String tenkh;
    private String diachikh;
    private String gioitinh;

    public Khachhang() {

    }

    public Khachhang(int makh, int sotuoi, long sdtkh, String tenkh, String diachikh, String phai) {
        this.makh = makh;
        this.sotuoi = sotuoi;
        this.sdtkh = sdtkh;
        this.tenkh = tenkh;
        this.diachikh = diachikh;
        this.gioitinh = phai;
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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public void Nhap() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập mã số khách hàng: ");
        makh = in.nextInt();
        System.out.println("Nhập số điện thoại khách hàng: ");
        sdtkh = in.nextLong();
        System.out.println("Nhập số tuổi khách hàng: ");
        sotuoi = in.nextInt();
        in.nextLine();
        System.out.println("Nhập Họ và tên khách hàng: ");
        tenkh = in.nextLine();
        System.out.println("Nhập giới tính khách hàng: ");
        gioitinh = in.nextLine();
        System.out.println("Nhập địa chỉ khách hàng: ");
        diachikh = in.nextLine();
    }

    @Override
    public void Xuat() {
        System.out.println("Mã số khách hàng: " + makh);
        System.out.println("Họ và tên khách hàng: " + tenkh);
        System.out.println("Giới tính khách hàng: " + gioitinh);
        System.out.println("Số tuổi: " + sotuoi);
        System.out.println("Số điện thoại khách hàng: " + sdtkh);
        System.out.println("Địa chỉ khách hàng: " + diachikh);
    }
}
