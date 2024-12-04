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
    private XeMay xm;
    // SoSPmua tin gia tien hoa don
    private int SoSPmua;
    private KhachHang khachhang;

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public HoaDon(int mahd, String ngaythanhtoan, XeMay xm, int SoSPmua, KhachHang khachhang) {
        this.mahd = mahd;
        this.ngaythanhtoan = ngaythanhtoan;
        this.xm = xm;
        this.SoSPmua = SoSPmua;
        this.khachhang = khachhang;
    }

    public HoaDon() {
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

    public void Nhap(String filedsxm,String filedskh) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma xe may: ");
        DSXeMay dsxm = new DSXeMay();
        dsxm.taiDanhSachTuFile(filedsxm);
        int ma;
        do {
        	while(!sc.hasNextInt()) {
        		System.out.println("Du lieu nhap vao can la so nguyen");
        		System.out.print("Vui long nhap lai: ");
        		sc.next();
        	}
            ma = sc.nextInt();
            if (ma == 0) {
                return;
            }
            if (dsxm.timKiemXeMayTheoMa(ma) != null) {
                xm = dsxm.timKiemXeMayTheoMa(ma);
                      if(xm.getSoluongnhaphang()==0) {
                      System.out.println("San pham da het hang");
                        return;
                  }
              
            } else {
                System.out.println("Khong tim thay ma xe!");
                System.out.print("Vui long nhap lai hoac nhap 0 de thoat: ");
            }
        } while (dsxm.timKiemXeMayTheoMa(ma) == null);
        sc.nextLine();
        while (true) { 
            System.out.print("Nhap ngay thanh toan: ");
            ngaythanhtoan = sc.nextLine();
            if (ngaythanhtoan.matches("\\d{2}/\\d{2}/\\d{4}")) { 
                break;
            } else {
                System.out.print("Ngay thanh toan khong hop le. Vui long nhap lai: ");
            }
        }
        System.out.print("Nhap so luong xe mua: ");
        boolean test = false;
        do{
             SoSPmua = sc.nextInt();
             if(SoSPmua==0){
                 xm=null;
                 return;
             }
        for(XeMay xeMay:dsxm.getDsXemay()){
            if(xm.getMasp()==xeMay.getMasp()){
                if(SoSPmua>xeMay.getSoluongnhaphang()) {
                    test=false;
                    System.out.print("So luong mua vuot qua so luong ton kho. Vui long nhap lai hoac nhap 0 de thoat: ");
                }
                else {
                    xeMay.setSoluongnhaphang(xeMay.getSoluongnhaphang()-SoSPmua);
                        test=true;
                }
            }
        }
                dsxm.xuatDanhSachRaFile(filedsxm);
        } while(test==false);
        System.out.println("NHAP THONG TIN KHACH HANG");
        DSKhachHang dskh=new DSKhachHang();
        dskh.taiDanhSachTuFile(filedskh);
        int choice;
       do{
            System.out.println("1.Khach hang cu");
            System.out.println("2.Khach hang moi");
            System.out.print("Chon: ");
        
        while(true){
            if(sc.hasNextInt()){
                choice=sc.nextInt();
                break;
            }
            sc.nextLine();
            System.out.println("Khong hop le! Vui long nhap lai: ");
        }
        sc.nextLine();
        switch (choice) {
            case 0:
                xm=null;
                return;
            case 1:
                System.out.print("Nhap ma so khach hang: ");
                int mkh;
                while (true) {                    
                    if(sc.hasNextInt()){
                        mkh=sc.nextInt();
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Ma khach hang phai la so. Vui long nhap lai: ");
                }
                for(KhachHang kh:dskh.getdsKhachHang()){
                    if(kh.getMakh()==mkh){
                        khachhang=kh;
                        System.out.println("DA LUU THONG TIN KHACH HANG");
                        return;
                    }
                }
                System.out.println("Khong tim thay ma khach hang!");
                return;
            case 2:
                dskh.them();
                dskh.xuatDanhSachRaFile(filedskh);
                 for(KhachHang kh:dskh.getdsKhachHang()){
                        khachhang=kh;               
                }
                   System.out.println("DA LUU THONG TIN KHACH HANG");
                        return;    
            default:
                System.out.print("Khong hop le! Vui long nhap lai hoac nhap 0 de thoat: ");
                
                
        }
       } while(true);
    }

    public void xuat() {
        System.out.println("=========THONG TIN HOA DON===========");
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ngay thanh toan: " + ngaythanhtoan);
        System.out.println("CHI TIET THONG TIN KHACH HANG");
        System.out.println("Ho va ten: " + khachhang.getTenkh());
		System.out.println("Gioi tinh: " + khachhang.getPhai());
		System.out.println("Ngay sinh: " + khachhang.getAge());
		System.out.println("So dien thoai: " +khachhang.getSdtkh());
		System.out.println("Dia chi: " + khachhang.getDiachikh());	
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

    public void sua(String filedsxm,String filedskh) {
        Scanner sc = new Scanner(System.in);
         DSXeMay dsxm = new DSXeMay();
        dsxm.taiDanhSachTuFile(filedsxm);
        for(XeMay xeMay:dsxm.getDsXemay()){
            if(xm.getMasp()==xeMay.getMasp()) xeMay.setSoluongnhaphang(xeMay.getSoluongnhaphang()+SoSPmua);
        }
          System.out.print("Nhap ma xe may moi: ");
        int ma;
        do {
            ma = sc.nextInt();
            if (ma == 0) {
                System.out.println("Khong hop le!");
                return;
            }
            if (dsxm.timKiemXeMayTheoMa(ma) != null) {
                xm = dsxm.timKiemXeMayTheoMa(ma);
                  if(xm.getSoluongnhaphang()==0) {
                      System.out.println("San pham da het hang");
                                      return;

                  }
            } else {
                System.out.println("Khong tim thay ma xe!");
                System.out.print("Vui long nhap lai hoac nhap 0 de thoat: ");
            }
        } while (dsxm.timKiemXeMayTheoMa(ma) == null);
        sc.nextLine();
        while (true) { 
            System.out.print("Nhap ngay thanh toan: ");
            ngaythanhtoan = sc.nextLine();
            if (ngaythanhtoan.matches("\\d{2}/\\d{2}/\\d{4}")) { 
                break;
            } else {
                System.out.print("Ngay thanh toan khong hop le. Vui long nhap lai: ");
            }
        }
         System.out.print("Nhap so luong xe mua: ");
        boolean test = false;
        do{
             SoSPmua = sc.nextInt();
        for(XeMay xeMay:dsxm.getDsXemay()){
            if(xm.getMasp()==xeMay.getMasp()){
                if(SoSPmua>xeMay.getSoluongnhaphang()) {
                    test=false;
                    System.out.print("So luong mua vuot qua so luong ton kho. Vui long nhap lai: ");
                }
                else {
                    xeMay.setSoluongnhaphang(xeMay.getSoluongnhaphang()-SoSPmua);
                        test=true;
                }
            }
        }
        } while(test==false);
        dsxm.xuatDanhSachRaFile(filedsxm);
        System.out.print("Nhap phim 0 de sua thong tin khach hang hoac nhap phim bat ky de ket thuc: ");
        sc.nextLine();
        String continu=sc.nextLine();
        if(!continu.equals("0")) {
            return ;
        }
        khachhang.sua();
        System.out.print("Ban co muon luu thong tin khach hang vua sua vao danh sach khach hang khong (y/n): ");
        do{
              String choice=sc.nextLine();
        switch (choice) {
            case "y":
                DSKhachHang dskh=new DSKhachHang();
                dskh.taiDanhSachTuFile(filedskh);
                for (int i = 0; i < dskh.getdsKhachHang().size(); i++) { 
                    KhachHang kh = dskh.getdsKhachHang().get(i);
                    if (kh.getMakh() == khachhang.getMakh()) {
                        dskh.getdsKhachHang().set(i, khachhang); 
                        dskh.xuatDanhSachRaFile(filedskh);
                        return;
                    }
                }
                dskh.getdsKhachHang().add(khachhang);
                dskh.xuatDanhSachRaFile(filedskh);
                return;
            case "n":
                return;
            default:
                System.out.print("Khong hop le! Vui long nhap lai: ");
        }
        } while (true);
      
    }
}
