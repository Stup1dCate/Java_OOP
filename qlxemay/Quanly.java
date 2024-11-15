/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class Quanly extends NhanSu implements INhap, IXuat {

    Scanner sc = new Scanner(System.in);
    private int bonus;

    public Quanly() {
    }

    public Quanly(int manv, String ten, int age, String sdt, String ChucVu, int salary, int bonus) {
        super(manv, ten, age, sdt, ChucVu, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void nhap() {
        Scanner s = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap so tien thuong cua quan ly: ");
        bonus = s.nextInt();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("So tien thuong cua quan ly la: " + bonus);
        System.out.println("Luong cuoi cung: " + finalsalary());
        System.out.println("____________________________________________________________________");
    }

    @Override
    public void Sua() {
        Scanner sc = new Scanner(System.in);
        super.Sua();
        System.out.println("Nhap so tien thuong cua quan ly: ");
        bonus = sc.nextInt();
        System.out.println("Sua thanh cong!");
    }

    public int finalsalary() {
        return getSalary() + bonus;
    }
}
