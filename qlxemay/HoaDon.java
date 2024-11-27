/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;
import java.util.ArrayList;

public class HoaDon implements IXuat {

    private int mahd;
    private String ngaythanhtoan;
    //masp : key de in ra chi tiet SP
    private XeMay xm;
    // SoSPmua tin gia tien hoa don
    private int SoSPmua;

    public HoaDon() {
    }
    public HoaDon(HoaDon hoaDon){
        this.mahd=hoaDon.mahd;
        this.SoSPmua=hoaDon.SoSPmua;
        this.ngaythanhtoan=hoaDon.ngaythanhtoan;
        this.xm=hoaDon.xm;
    }
    public HoaDon(int mahd, String ngaythanhtoan, XeMay dsxm, int SoSPmua) {
        this.mahd = mahd;
        this.ngaythanhtoan = ngaythanhtoan;
        this.xm = dsxm;
        this.SoSPmua = SoSPmua;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public String getNgaythanhtoan() {
        return ngaythanhtoan;
    }

    public void setNgaythanhtoan(String ngaythanhtoan) {
        this.ngaythanhtoan = ngaythanhtoan;
    }

    public XeMay getXm() {
        return xm;
    }

    public void setXm(XeMay xm) {
        this.xm = xm;
    }

    public int getSoSPmua() {
        return SoSPmua;
    }

    public void setSoSPmua(int SoSPmua) {
        this.SoSPmua = SoSPmua;
    }

    private int Tong() {
        return xm.getGiasp() * SoSPmua;
    }

    public void Nhap(String filedsxm) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma xe may: ");
        DSXeMay dsxm = new DSXeMay();
        dsxm.taiDanhSachTuFile(filedsxm);
        int ma;
        do {
            ma = sc.nextInt();
            if (ma == 0) {
                System.out.println("Khong hop le!");
                return;
            }
            if (dsxm.timKiemXeMayTheoMa(ma) != null) {
                xm = dsxm.timKiemXeMayTheoMa(ma);
                   if(xm.getSoluongnhaphang()==0){
                       System.out.printn("San pham da het hang");
                return;
                   }
            } else {
                System.out.println("Khong tim thay ma xe!");
                System.out.println("Vui long nhap lai hoac nhap 0 de thoat");
            }
        } while (dsxm.timKiemXeMayTheoMa(ma) == null);
        sc.nextLine();
        System.out.println("Nhap ngay thanh toan");
        ngaythanhtoan = sc.nextLine();
        System.out.println("Nhap so luong xe mua: ");
        boolean test = false;
        do{
             SoSPmua = sc.nextInt();
        for(XeMay xeMay:dsxm.getDsXemay()){
            if(xm.getMasp()==xeMay.getMasp()){
                if(SoSPmua>xeMay.getSoluongnhaphang()) {
                    test=false;
                    System.out.println("So luong mua vuot qua so luong ton kho. Vui long nhap lai");
                }
                else {
                    xeMay.setSoluongnhaphang(xeMay.getSoluongnhaphang()-SoSPmua);
                        test=true;
                }
            }
        }
        } while(test==false);
       dsxm.xuatDanhSachRaFile(filedsxm);
    }

    public void xuat() {
        System.out.println("=========THONG TIN HOA DON===========");
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ngay thanh toan: " + ngaythanhtoan);
        System.out.println("\tCHI TIET SAN PHAM MUA");
        System.out.println("Ma san pham: " + xm.getMasp());
        System.out.println("Ten san pham: " + xm.getTensp());
        System.out.println("Gia ban: " + xm.getGiasp());
        System.out.println("Loai san pham: " + xm.getLoaisp());
        if (xm.getLoaisp().equals("Xe dien")) {
            System.out.println("Dung luong: " + ((XeDien) xm).getDungluongpin());
        } else {
            System.out.println("Dung tich: " + ((XeXang) xm).getDungtich());
        }
        xm.getHangSX().xuat();
        System.out.println("Tong tien: "+ Tong());
    }

    public void sua(String filedsxm) {
        Scanner sc = new Scanner(System.in);
         DSXeMay dsxm = new DSXeMay();
        dsxm.taiDanhSachTuFile(filedsxm);
        for(XeMay xeMay:dsxm.getDsXemay()){
            if(xm.getMasp()==xeMay.getMasp()) xeMay.setSoluongnhaphang(xeMay.getSoluongnhaphang()+SoSPmua);
        }
          System.out.println("Nhap ma xe may moi: ");
        int ma;
        do {
            ma = sc.nextInt();
            if (ma == 0) {
                System.out.println("Khong hop le!");
                return;
            }
            if (dsxm.timKiemXeMayTheoMa(ma) != null) {
                xm = dsxm.timKiemXeMayTheoMa(ma);
   if(xm.getSoluongnhaphang()==0){
                       System.out.printn("San pham da het hang");
                return;
                   }
            } else {
                System.out.println("Khong tim thay ma xe!");
                System.out.println("Vui long nhap lai hoac nhap 0 de thoat");
            }
        } while (dsxm.timKiemXeMayTheoMa(ma) == null);
        sc.nextLine();
        System.out.println("Nhap ngay thanh toan:");
        ngaythanhtoan=sc.nextLine();
         System.out.println("Nhap so luong xe mua: ");
        boolean test = false;
        do{
             SoSPmua = sc.nextInt();
        for(XeMay xeMay:dsxm.getDsXemay()){
            if(xm.getMasp()==xeMay.getMasp()){
                if(SoSPmua>xeMay.getSoluongnhaphang()) {
                    test=false;
                    System.out.println("So luong mua vuot qua so luong ton kho. Vui long nhap lai");
                }
                else {
                    xeMay.setSoluongnhaphang(xeMay.getSoluongnhaphang()-SoSPmua);
                        test=true;
                }
            }
        }
        } while(test==false);
        dsxm.xuatDanhSachRaFile(filedsxm);
    }
}
