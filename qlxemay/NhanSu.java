/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;
public abstract class NhanSu implements INhap,IXuat{
    Scanner sc =new Scanner(System.in);
    private String ten;
    private int age;
    protected String ChucVu;
    private int salary;
    public NhanSu() {
    }
    

    public NhanSu(String ten, int age, String ChucVu, int salary) {
        this.ten = ten;
        this.age = age;
        this.ChucVu = ChucVu;
        this.salary = salary;
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
    public void Nhap(){
        System.out.println("Nhap ho ten nhan vien: ");
        ten=sc.nextLine();
        System.out.println("Nhap tuoi: ");
        age=sc.nextInt();
//        System.out.println("Nhap chuc vu: ");
//        sc.nextLine();
//        ChucVu=sc.nextLine();
        System.out.println("Nhap luong: ");
        salary=sc.nextInt();
    }
    @Override
    public void Xuat(){
        System.out.println("Ho ten: " +ten);
        System.out.println("Tuoi: " +age);
        System.out.println("Chuc vu: "+ ChucVu);
        System.out.println("Luong: " +finalsalary());
    }
    public abstract int finalsalary();
    public void sua(){
        System.out.println("Nhap ten nhan vien moi: ");
        ten=sc.nextLine();
        System.out.println("Nhap tuoi: ");
        age=sc.nextInt();
//        System.out.println("Nhap chuc vu: ");
//        sc.nextLine();
//        ChucVu=sc.nextLine();
        System.out.println("Nhap luong: ");
        salary=sc.nextInt();
    }
}
