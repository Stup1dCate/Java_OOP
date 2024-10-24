/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;
// fsfsef
import java.util.Scanner;

public class HangSX implements INhap, IXuat {

    private String tenhang;
    private String sdthang;
    private String diachi;

    public HangSX() {

    }

    public HangSX(String tenhang, String sdthang, String diachi) {
        this.tenhang = tenhang;
        this.sdthang = sdthang;
        this.diachi = diachi;
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
        System.out.println("Nhap ten hang: ");
        tenhang = sc.nextLine();
        System.out.println("Nhap so dien thoai hang: ");
        sdthang = sc.nextLine();
        System.out.println("Nhap dia chi hang: ");
        diachi = sc.nextLine();
    }

    @Override
    public void Xuat() {
        System.out.println("Ten hang: " + tenhang);
        System.out.println("So dien thoai hang: " + sdthang);
        System.out.println("Dia chi hang: " + diachi);
    }

    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten hang san xuat moi: ");
        tenhang=sc.nextLine();
        System.out.println("Nhap so dien thoai: ");
        sdthang=sc.nextLine();
        System.out.println("Nhap dia chi hang: ");
        diachi = sc.nextLine();
        
    }
}
