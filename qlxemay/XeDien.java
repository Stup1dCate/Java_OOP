/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;
public class XeDien extends Xemay{
    private double dungluongpin;

    public XeDien() {
    }
    
    public XeDien(double dungluongpin, int masp, int soluong, String tenSP, String loaiSP, double gianhap, double giaban, HangSX hangsx) {
        super(masp, soluong, tenSP, loaiSP, gianhap, giaban, hangsx);
        this.dungluongpin = dungluongpin;
    }

    public double getDungluongpin() {
        return dungluongpin;
    }

    public void setDungluongpin(double dungluongpin) {
        this.dungluongpin = dungluongpin;
    }
    @Override
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        super.Nhap();
        System.out.println("Nhap dung luong pin: ");
        dungluongpin=sc.nextDouble();
    }
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Dung luong pin: " + dungluongpin);
    }
    
}
