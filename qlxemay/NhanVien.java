/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;
import java.util.Scanner;


public class NhanVien extends NhanSu implements INhap,IXuat{
    Scanner sc =new Scanner(System.in);
    private int SoSPban;

    public NhanVien() {
    }

    public NhanVien(int manv,String ten, int age,long sdt, String ChucVu, int salary,int SoSPban) {
        super(manv, ten, age,sdt ,ChucVu, salary);
        this.SoSPban=SoSPban;
    }

    public int getSoSPban() {
        return SoSPban;
    }

    public void setSoSPban(int SoSPban) {
        this.SoSPban = SoSPban;
    }
    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhap so san pham ban duoc: ");
        SoSPban=sc.nextInt();
    }
    @Override 
    public void xuat(){
        super.xuat();
        System.out.println("So SP ban duoc: "+ SoSPban);
    }
    public int finalsalary(){
        return getSalary()+50*SoSPban;
    }
}