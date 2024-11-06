/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;
public abstract class NhanSu implements INhap,IXuat{
    Scanner sc =new Scanner(System.in);
    private int manv;
    private String ten;
    private int age;
    private long sdt;
    protected String ChucVu;
    private int salary;
    public static int soluongnv=0;
    public NhanSu() {
        soluongnv++;
    }
    

    public NhanSu(int manv,String ten, int age,long sdt ,String ChucVu, int salary) {
        this.manv=manv;
        this.ten = ten;
        this.age = age;
        this.sdt=sdt;
        this.ChucVu = ChucVu;
        this.salary = salary;
        soluongnv++;
    }

    
    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    public long getSDT() {
        return sdt;
    }

    public void setSDT(long sdt) {
        this.sdt = sdt;
    }


    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public void nhap(){
        System.out.println("Nhap ma nhan vien: ");
        manv=sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ho ten nhan vien: ");
        ten=sc.nextLine();
        System.out.println("Nhap tuoi: ");
        age=sc.nextInt();
        System.out.println("Nhap so dien thoai: ");
        sc.nextLine();
        sdt=sc.nextLong();
        System.out.println("Nhap chuc vu: ");
        ChucVu=sc.nextLine();
        System.out.println("Nhap luong: ");
        salary=sc.nextInt();
    }
    @Override
    public void xuat(){
        System.out.println("Ma nhan vien: "+manv);
        System.out.println("Ho ten: " +ten);
        System.out.println("Tuoi: " +age);
        System.out.println("So dien thoai: "+sdt);
        System.out.println("Chuc vu: "+ ChucVu);
        System.out.println("Luong: " +finalsalary());
    }
    public abstract int finalsalary();

    public static int getSoluongnv(){
        return soluongnv;
    }

    public void Sua(){
        nhap();
    }

}