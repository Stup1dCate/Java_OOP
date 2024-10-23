/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class XeXang extends Xemay {

    private double dungtich;

    public XeXang() {
    }

    public XeXang(double dungtich, int masp, int soluong, String tenSP, String loaiSP, double gianhap, double giaban, HangSX hangsx) {
        super(masp, soluong, tenSP, loaiSP, gianhap, giaban, hangsx);
        this.dungtich = dungtich;
    }

    public double getDungtich() {
        return dungtich;
    }

    public void setDungtich(double dungtich) {
        this.dungtich = dungtich;
    }

    @Override
    public void Nhap() {
        Scanner sc = new Scanner(System.in);
        super.Nhap();
        System.out.println("Nhap dung tich: ");
        dungtich=sc.nextDouble();
    }
    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Dung tich: "+ dungtich);
    }

}
