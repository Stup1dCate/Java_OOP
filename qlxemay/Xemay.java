/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class Xemay implements INhap, IXuat {

    private int masp;
    private int soluong;
    private String tenSP;
    protected String loaiSP;
    private double gianhap;
    private double giaban;
    private HangSX hangsx;

    private String tenhang;
    private String sdthang;
    private String diachi;

    public Xemay() {
        hangsx = new HangSX();
    }

    public Xemay(int masp, int soluong, String tenSP, String loaiSP, double gianhap, double giaban, HangSX hangsx) {
        this.masp = masp;
        this.soluong = soluong;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.hangsx = hangsx;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public double getGianhap() {
        return gianhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public HangSX getHangsx() {
        return hangsx;
    }

    public void setHangsx(HangSX hangsx) {
        this.hangsx = hangsx;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getSdthang() {
        return sdthang;
    }

    public void setSdthang(String sdthang) {
        this.sdthang = sdthang;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham: ");
        masp = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ten san pham: ");
        tenSP = sc.nextLine();
        System.out.println("Nhap so luong: ");
        soluong = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap loai SP");
        loaiSP = sc.nextLine();
        System.out.println("Nhap gia nhap: ");
        gianhap = sc.nextDouble();
        System.out.println("Nhap gia ban: ");
        giaban = sc.nextDouble();

        hangsx.Nhap();
    }

    @Override
    public void Xuat() {
        System.out.println("Ma san pham: " + masp);
        System.out.println("Ten san pham: " + tenSP);
        System.out.println("So luong: " + soluong);
        System.out.println("Loai SP: " + loaiSP);
        System.out.println("Gia nhap: " + gianhap);
        System.out.println("Gia ban: " + giaban);
        hangsx.Xuat();
    }

}
