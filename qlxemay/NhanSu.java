/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;
public abstract class NhanSu implements INhap,IXuat{
    private int manv;
    private String ten;
    private String age;
    private String sdt;
    protected String ChucVu;
    private int salary;

    public NhanSu() {
    }
    

    public NhanSu(int manv,String ten, String age,String sdt ,String ChucVu, int salary) {
        this.manv=manv;
        this.ten = ten;
        this.age = age;
        this.sdt=sdt;
        this.ChucVu = ChucVu;
        this.salary = salary;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
        System.out.println("Nhap ngay thang nam sinh(dd/mm/yyyy): ");
            age = s.nextLine();
            if (age.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                break;
            } else {
                System.out.println("Ngay thang nam sinh phai theo dung dinh dang!");
            }
    }
  

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
        System.out.println("Nhap luong: (ngan dong)");
        if (s.hasNextInt()) {
            salary = s.nextInt();
            // Kiểm tra salary là số nguyên và nhỏ hơn 999
            if (salary < 999999) {
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
        System.out.println("Ngay thang nam sinh (dd/mm/yyyy): " +age);
        System.out.println("So dien thoai: "+sdt);
        System.out.println("Chuc vu: "+ ChucVu);
        System.out.println("Luong co ban: " +salary);
     
    }
    public abstract int finalsalary();

  
    public void Sua(){
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
        System.out.println("Nhap ngay thang nam sinh(dd/mm/yyyy): ");
            age = s.nextLine();
            if (age.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")) {
                break;
            } else {
                System.out.println("Ngay thang nam sinh phai theo dung dinh dang!");
            }
    }


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
        System.out.println("Nhap luong: (ngan dong)");
        if (s.hasNextInt()) {
            salary = s.nextInt();
            // Kiểm tra salary là số nguyên và nhỏ hơn 999
            if (salary < 999999) {
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
    
              
}
