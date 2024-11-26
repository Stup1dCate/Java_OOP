/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class XeDien extends XeMay {

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
    public void nhap(String filehxs) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap dung luong pin: ");
         while(true){
            if(sc.hasNextDouble()){
              dungluongpin = sc.nextDouble();
                  break;
            }
            System.out.println("Dung luong pin phai la so . Vui long nhap lai.");
            sc.nextLine();
        }
       
        super.nhap(filehxs);
    }

    @Override
    public void xuat() {
        System.out.println("\tThong tin san pham ");
        
        System.out.println("Dung luong pin: " + dungluongpin);
        super.xuat();
    }

    @Override
    public void sua() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap dung luong moi:");
         while(true){
            if(sc.hasNextDouble()){
              dungluongpin = sc.nextDouble();
                  break;
            }
            System.out.println("Dung luong pin phai la so . Vui long nhap lai.");
            sc.nextLine();
        }
        super.sua();
    }
}
