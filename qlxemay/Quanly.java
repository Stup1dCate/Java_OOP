/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;
import java.util.Scanner;

public class Quanly extends NhanSu implements INhap,IXuat{
    Scanner sc =new Scanner(System.in);
    private int bonus;

    public Quanly() {
    }

    public Quanly(int manv,String ten, int age, long sdt,String ChucVu, int salary,int bonus) {
        super(manv,ten, age,sdt ,ChucVu, salary);
        this.bonus=bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhap so tien thuong cua quan ly: ");
        bonus=sc.nextInt();
    }
    @Override 
    public void xuat(){
        super.xuat();
        System.out.println("So tien thuong cua quan ly la: "+ bonus);
    }
    public int finalsalary(){
        return getSalary()+bonus;
    }
}