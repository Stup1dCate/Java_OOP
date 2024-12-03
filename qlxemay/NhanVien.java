/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class NhanVien extends NhanSu implements INhap, IXuat {

   Scanner sc = new Scanner(System.in);
    private int SoSPban;
    private static int soluongnv = 0;
    private int TienThuongSP;

    public NhanVien() {

    }
    public static void Soluongnhanvien(){
        System.out.println("So luong nhan vien: "+soluongnv);
    }

    public NhanVien(int manv, String ten, String age, String sdt, String ChucVu, int salary, int SoSPban,int TienThuongSP) {
        super(manv, ten, age, sdt, ChucVu, salary);
        this.SoSPban = SoSPban;
        this.TienThuongSP=TienThuongSP;
         soluongnv++;
    }

    public int getSoSPban() {
        return SoSPban;
    }

    public static int getSoluongnv() {
        return soluongnv;
    }

    public static void setSoluongnv(int soluongnv) {
        NhanVien.soluongnv = soluongnv;
    }

    public void setSoSPban(int SoSPban) {
        this.SoSPban = SoSPban;
    }

    public int getTienThuongSP(){
        return TienThuongSP;
    }

    public void setTienThuongSP(int TienThuongSP){
        this.TienThuongSP=TienThuongSP;
    }

    @Override
    public void nhap() {
        Scanner s = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap so san pham ban duoc: ");
        while(true){
        if(s.hasNextInt()){
            SoSPban = s.nextInt();
            break;
        }System.out.println("Nhap so san pham la so!!");
        s.nextLine();
        }

        System.out.println("Nhap so tien thuong tren moi san pham ban duoc: (ngan dong)");
        
        while(true){
            if(s.hasNextInt()){
            TienThuongSP=s.nextInt();
                break;
        }System.out.println("Nhap so tien thuong la so!!");
        s.nextLine();
    }
        
        soluongnv++;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("So SP ban duoc: " + SoSPban);
        System.out.println("So tien thuong tren moi san pham ban duoc: "+TienThuongSP);
        System.out.println("Luong cuoi cung: " + finalsalary());
        System.out.println("____________________________________________________________________");
    }

    @Override
    public void Sua() {
        Scanner sc=new Scanner(System.in);
        super.Sua();
        System.out.println("Nhap so san pham ban duoc: ");
        SoSPban = sc.nextInt();
        System.out.println("Nhap tien thuong tren moi san pham ban duoc (ngan dong): ");
        TienThuongSP=sc.nextInt();
        System.out.println("Sua thanh cong!");
    }

    @Override
    public int finalsalary() {
        return getSalary() + TienThuongSP * SoSPban;
    }
}
