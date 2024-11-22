/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;
public abstract class NhanSu implements INhap,IXuat{
    private int manv;
    private String ten;
    private int age;
    private String sdt;
    protected String ChucVu;
    private int salary;
    public static int soluongnv=0;
    public NhanSu() {
        soluongnv++;
    }
    

    public NhanSu(int manv,String ten, int age,String sdt ,String ChucVu, int salary) {
        this.manv=manv;
        this.ten = ten;
        this.age = age;
        this.sdt=sdt;
        this.ChucVu = ChucVu;
        this.salary = salary;
        soluongnv++;
    }
    
    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }


    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public void nhap(){
        
        Scanner s=new Scanner(System.in);
        
        while(true){
        System.out.println("Nhap ho ten nhan vien: ");
        ten=s.nextLine();
        if (ten.matches("[a-zA-Z\\s]+")) {
            break;
        } else {
            System.out.println("Ten chi duoc chua chu cai. Vui long nhap lai!");
        }
    }
    while (true) {
        System.out.println("Nhap tuoi: ");
        if (s.hasNextInt()) {
            age = s.nextInt();
            // Kiểm tra tuổi trong khoảng từ 18 đến 99
            if (age >= 18 && age <= 99) {
                break;
            } else {
                System.out.println("Tuoi phai tren 18 va duoi 100. Vui long nhap lai!");
            }
        } else {
            System.out.println("Nhap tuoi la so!");
            s.next(); // Loại bỏ đầu vào không hợp lệ
        }
    }
    s.nextLine();
    while (true) {
        System.out.println("Nhap so dien thoai: ");
        sdt = s.nextLine().trim();  // Loại bỏ khoảng trắng thừa ở đầu và cuối chuỗi
        if (sdt.length() == 10 && sdt.matches("\\d{10}")) {
            break;
        } else {
            System.out.println("Nhap so dien thoai 10 so!");
        }
    }
    
    while (true) {
        System.out.println("Nhap luong: ");
        if (s.hasNextInt()) {
            salary = s.nextInt();
            // Kiểm tra salary là số nguyên và nhỏ hơn 999
            if (salary < 999) {
                break;
            } else {
                System.out.println("Luong phai nho hon 999 trieu. Vui long nhap lai!");
            }
        } else {
            System.out.println("Vui long nhap so nguyen hop le cho luong!");
            s.next(); // Loại bỏ đầu vào không hợp lệ
        }
    }
    
    }
    @Override
    public void xuat(){
        System.out.println("Ma nhan vien: "+manv);
        System.out.println("Ho ten: " +ten);
        System.out.println("Tuoi: " +age);
        System.out.println("So dien thoai: "+sdt);
        System.out.println("Chuc vu: "+ ChucVu);
        System.out.println("Luong co ban: " +salary);
     
    }
    public abstract int finalsalary();

    public static int getSoluongnv(){
        return soluongnv;
    }

    public void Sua(){
        Scanner s=new Scanner(System.in);
            System.out.println("Nhap ho ten nhan vien moi: ");
        ten=s.nextLine();
        System.out.println("Nhap tuoi: ");
        age=s.nextInt();
        System.out.println("Nhap so dien thoai: ");
        s.nextLine();
        sdt=s.nextLine();
        System.out.println("Nhap luong: ");
        salary=s.nextInt();
    }

}
