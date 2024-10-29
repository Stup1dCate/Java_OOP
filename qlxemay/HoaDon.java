/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class HoaDon{

    private int mahd;
    private String ngaythanhtoan;
    //Thong tin khach hang
    private Khachhang khachhang;
    //masp : key de in ra chi tiet SP
    private int masp;
    // SoSPmua tin gia tien hoa don
    private int SoSPmua;

    public HoaDon() {

    }

    public HoaDon(int mahd, String ngaythanhtoan, Khachhang khachhang, int masp, int SoSPmua) {
        this.mahd = mahd;
        this.ngaythanhtoan = ngaythanhtoan;
        this.khachhang = khachhang;
        this.masp = masp;
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

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoSPmua() {
        return SoSPmua;
    }

    public void setSoSPmua(int SoSPmua) {
        this.SoSPmua = SoSPmua;
    }

    public void Nhap(DSXeMay dsxm) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don: ");
        mahd = sc.nextInt();
        System.out.println("Nhap ngay thanh toan: ");
        ngaythanhtoan = sc.nextLine();
        //Nhap thong tin khach hang
        khachhang.Nhap();
        //Nhap ten sp neu sp co ton tai thi in ra dssp co cung ten neu khong bat nguoi dung nhap lai ten sp
        System.out.println("Nhap ten san pham da mua: ");
        String tensp = sc.nextLine();
        int look = 0; // so sp co cung ten
        do {
            for (Xemay xm : dsxm.getDsXemays()) {
                if (xm.getTenSP().equals(tensp)) {
                    System.out.println("Thong tin san pham: ");
                    xm.Xuat();
                    look++;
                }
            }
            if (look == 0) {
                System.out.println("Khong ton tai san pham! Vui long nhap lai");
            }
        } while (look == 0);
        //Neu chi co 1 SP cung ten thi gan masp cho masp cua hoa don
        if (look == 1) {
            for (Xemay xm : dsxm.getDsXemays()) {
                if (xm.getTenSP().equals(tensp)) {
                    masp = xm.getMasp();
                }
            }
            System.out.println("Nhap so luong san pham mua: ");
            SoSPmua=sc.nextInt();
            return;
        }
        System.out.println("Nhap ma san pham: ");
        masp = sc.nextInt();
    }
    public void Xuat(DSXeMay dsxm){
        System.out.println("Ma hoa don: " + mahd);
        System.out.println("Ngay thanh toan: "+ ngaythanhtoan);
        khachhang.Xuat();
        Xemay xm= dsxm.timkiemtheomasp(masp);
         System.out.println("Ma san pham: " + xm.getMasp());
        System.out.println("Ten san pham: " + xm.getTenSP());
        System.out.println("Loai SP: " + xm.getTenSP());
        if(xm instanceof XeDien) System.out.println("Dung luong pin: "+ ((XeDien) xm).getDungluongpin());
        else  System.out.println("Dung luong pin: "+ ((XeXang)xm).getDungtich());
        xm.getHangsx().Xuat();
    }
}
