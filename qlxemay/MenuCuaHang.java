package qlxemay;

import java.util.Scanner;

public class MenuCuaHang {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int choice;
        do{
            System.out.println("1. Quản lý Sản phẩm");
            System.out.println("2. Quản lý Khách Hàng");
            System.out.println("3. Quản lý Nhân sự");
            System.out.println("4. Quản lý Hãng Sản Xuất");
            System.out.println("5. Quản lý Hóa Đơn");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = reader.nextInt();
            reader.nextLine();
            switch (choice) {
                case 1:
                    QLXeMay ql1 = new QLXeMay();
                    ql1.menu();
                    break;
            
                case 2:
                    QLKhachHang ql3 = new QLKhachHang();
                    ql3.menu();
                    break;

                case 3: 
                    QLNhanSu ql4 = new QLNhanSu();
                    ql4.menu();
                    break;
                
                case 4:
                    QLHangSX ql5 = new QLHangSX();
                    ql6.menu();
                    break;

                case 5:
                    QLHoaDon ql6 = new QLHoaDon();
                    ql7.menu();
                    break;

                case 6:
                    System.out.println("Bạn đã thoát khỏi chương trình!");
                    break;
                default:
                    System.err.println("lựa chọn bạn nhập không hợp lệ. Vui lòng nhập lại");
                    break;
            }
        }
        while(choice1!=6);
    }
}
