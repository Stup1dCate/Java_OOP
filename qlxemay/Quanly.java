/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

/**
 *
 * @author cuong
 */
public class Quanly extends NhanSu implements INhap,IXuat{
    private int bonus;
    
    public Quanly(){
        
    }

    public Quanly(int bonus, String ten, int age, String ChucVu, int salary) {
        super(ten, age, ChucVu, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhap thuong: ");
        bonus=sc.nextInt();
    }
    @Override 
    public void Xuat(){
        super.Xuat();
        System.out.println("Thuong: "+ bonus);
    }   
    @Override
     public int finalsalary(){
        return getSalary()+bonus;
    }
}
