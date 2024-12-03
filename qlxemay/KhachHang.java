/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlxemay;

import java.util.Scanner;

public class KhachHang implements INhap, IXuat {
    private int makh;
    private String age;  
    private String sdtkh;
    private String tenkh;
    private String diachikh;
    private String phai;

    public KhachHang() {

    }

    public KhachHang(int makh, String age, String sdtkh, String tenkh, String diachikh, String phai) {
        this.makh = makh;
        this.age = age;  
        this.sdtkh = sdtkh;
        this.tenkh = tenkh;
        this.diachikh = diachikh;
        this.phai = phai;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getAge() {  
        return age;
    }

    public void setAge(String age) {  
        this.age = age;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public void setSdtkh(String sdtkh) {
        this.sdtkh = sdtkh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachikh() {
        return diachikh;
    }

    public void setDiachikh(String diachikh) {
        this.diachikh = diachikh;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    @Override
    public void nhap() {
        Scanner in = new Scanner(System.in);
        String newsdt;
        while (true) { 
            System.out.print("Nhap so dien thoai: ");
            newsdt = in.nextLine();
            if (newsdt.matches("\\d{10}")) { 
                break;
            } else {
                System.out.println("So dien thoai khong hop le. Vui long nhap lai!");
            }
        }
        sdtkh = newsdt;
    
        String newage;
        while (true) { 
            System.out.print("Nhap ngay thang nam sinh: ");
            newage = in.nextLine();
            if (newage.matches("\\d{2}/\\d{2}/\\d{4}")) { 
                break;
            } else {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai!");
            }
        }
        age = newage;
    
        System.out.print("Nhap ho ten khach hang: ");
        tenkh = in.nextLine();
    
        String newgioitinh;
        while (true) { 
            System.out.print("Nhap gioi tinh: ");
            newgioitinh = in.nextLine();
            if (newgioitinh.matches("[a-zA-Z ]+")) { 
                break;
            } else {
                System.out.println("Gioi tinh khong hop le. Vui long nhap lai!");
            }
        }
        phai = newgioitinh;
        System.out.print("Nhap dia chi: ");
        diachikh = in.nextLine();
    }
    

    @Override
    public void xuat() {
        System.out.println("\tMa so khach hang: " + makh);
        System.out.println("\tHo va ten: " + tenkh);
        System.out.println("\tGioi tinh: " + phai);
        System.out.println("\tNgay thang nam sinh: " + age);  
        System.out.println("\tSo dien thoai: " + sdtkh);
        System.out.println("\tDia chi: " + diachikh);
        System.out.println("____________________________________________________________________");
    }

    @Override
    public String toString() {
        return "Ma so khach hang: " + makh +
                "\nHo va ten: " + tenkh +
                "\nGioi tinh: " + phai +
                "\nNgay sinh: " + age +  
                "\nSo dien thoai: " + sdtkh +
                "\nDia chi: " + diachikh;
    }

    public void sua() {
        Scanner s = new Scanner(System.in);

        String newtenkh;
        while (true) { 
            System.out.print("Nhap ten khach hang moi: ");
            newtenkh = s.nextLine();
            if (newtenkh.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Ten khach hang khong hop le. Vui long nhap lai!");
            }
        }
        this.setTenkh(newtenkh);
    
        String newage;
        while (true) { 
            System.out.print("Nhap ngay thang nam sinh: ");
            newage = s.nextLine();
            if (newage.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai!");
            }
        }
        this.setAge(newage);
        String newsdt;
        while (true) { 
            System.out.print("Nhap so dien thoai: ");
            newsdt = s.nextLine();
            if (newsdt.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("So dien thoai khong hop le. Vui long nhap lai!");
            }
        }
        this.setSdtkh(newsdt);
    
        String newgioitinh;
        while (true) { 
            System.out.print("Nhap gioi tinh: ");
            newgioitinh = s.nextLine();
            // Kiểm tra giới tính chỉ chứa chữ cái
            if (newgioitinh.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Gioi tinh khong hop le. Vui long nhap lai!");
            }
        }
        this.setPhai(newgioitinh);
        System.out.print("Nhap dia chi: ");
        this.setDiachikh(s.nextLine());
    }
    
}
