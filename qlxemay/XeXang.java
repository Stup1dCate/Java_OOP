/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class XeXang extends XeMay {

    private double dungtich;

    public XeXang() {
    }

    public XeXang(double dungtich, int masp, int soluong, String tenSP, String loaiSP, int gianhap, int giaban, HangSX hangsx) {
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
    public void nhap(String filehsx) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap dung tich: ");
         while(true){
            if(sc.hasNextDouble()){
            dungtich = sc.nextDouble();
                  break;
            }
            System.out.println("Dung ltich phai la so . Vui long nhap lai.");
            sc.nextLine();
        }
        
        super.nhap(filehsx);

    }

    @Override
    public void xuat() {
        System.out.println("\tThong tin san pham ");
        System.out.println("Dung tich: " + dungtich);
        super.xuat();

    }

    @Override
    public void sua(String filehsx) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap dung tich moi:");
         while(true){
            if(sc.hasNextDouble()){
              dungtich = sc.nextDouble();
                  break;
            }
            System.out.println("Dung luong pin phai la so . Vui long nhap lai.");
            sc.nextLine();
        }
       
        super.sua(filehsx);
    }
}
