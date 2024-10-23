/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;
import qlxemay.INhap;
import qlxemay.IXuat;


public class NhanVien extends NhanSu implements INhap,IXuat{
    Scanner sc =new Scanner(System.in);
    private int SoSPban;

    public NhanVien() {
    }

    public NhanVien(String ten, int age, String ChucVu, int salary,int SoSPban) {
        super(ten, age, ChucVu, salary);
        this.SoSPban=SoSPban;
    }

    public int getSoSPban() {
        return SoSPban;
    }

    public void setSoSPban(int SoSPban) {
        this.SoSPban = SoSPban;
    }
    @Override
    public void Nhap(){
        super.Nhap();
        System.out.println("Nhap so san pham ban duoc: ");
        SoSPban=sc.nextInt();
    }
    @Override 
    public void Xuat(){
        super.Xuat();
        System.out.println("So SP ban duoc: "+ SoSPban);
    }
    public int finalsalary(){
        return getSalary()+50*SoSPban;
    }
}
