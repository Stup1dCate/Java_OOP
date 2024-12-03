/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class KhachHang implements INhap, IXuat {
    private int makh;
    private String age;  
    private String sdtkh;
    private String tenkh;
    private String diachikh;
    private String phai;

    public KhachHang() {

    }

    public KhachHang(int makh, String age, String sdtkh, String tenkh, String diachikh, String phai) {
        this.makh = makh;
        this.age = age;  
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

    public String getAge() {  
        return age;
    }

    public void setAge(String age) {  
        this.age = age;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public void setSdtkh(String sdtkh) {
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
        System.out.print("Nhap so dien thoai: ");
        sdtkh = in.nextLine();
        System.out.print("Nhap ngay thang nam sinh: ");
        age = in.nextLine();  
        System.out.print("Nhap ho ten khach hang: ");
        tenkh = in.nextLine();
        System.out.print("Nhap gioi tinh: ");
        phai = in.nextLine();
        System.out.print("Nhap dia chi: ");
        diachikh = in.nextLine();
    }

    @Override
    public void xuat() {
        System.out.println("\tMa so khach hang: " + makh);
        System.out.println("\tHo va ten: " + tenkh);
        System.out.println("\tGioi tinh: " + phai);
        System.out.println("\tNgay thang nam sinh: " + age);  
        System.out.println("\tSo dien thoai: " + sdtkh);
        System.out.println("\tDia chi: " + diachikh);
        System.out.println("____________________________________________________________________");
    }

    @Override
    public String toString() {
        return "Ma so khach hang: " + makh +
                "\nHo va ten: " + tenkh +
                "\nGioi tinh: " + phai +
                "\nNgay sinh: " + age +  
                "\nSo dien thoai: " + sdtkh +
                "\nDia chi: " + diachikh;
    }

    public void sua() {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap ten khach hang moi: ");
        this.setTenkh(s.nextLine());
        System.out.print("Nhap ngay thang nam sinh: ");
        this.setAge(s.nextLine());  
        System.out.print("Nhap so dien thoai: ");
        this.setSdtkh(s.nextLine());
        System.out.print("Nhap gioi tinh: ");
        this.setPhai(s.nextLine());
        System.out.print("Nhap dia chi: ");
        this.setDiachikh(s.nextLine());
    }
}
