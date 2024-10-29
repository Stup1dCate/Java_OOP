package qlxemay;

import java.util.Scanner;

public class MenuCuaHang {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int choice1;
        do{
            System.out.println("1. Quản lý Sản phẩm");
            System.out.println("2. Quản lý Khách Hàng");
            System.out.println("3. Quản lý Nhân sự");
            System.out.println("4. Quản lý Hãng Sản Xuất");
            System.out.println("5. Quản lý Hóa Đơn");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice1 = reader.nextInt();
            reader.nextLine();
            switch (choice1) {
                case 1:
                    int choice2;
                    System.out.println("bạn đã vào mục Quản lý Sản Phẩm. Ở đây chúng tôi có Xe máy và Xe Xăng");
                    System.out.println("1. Quản lý Xe Xăng");
                    System.out.println("2. Quản lý Xe Điện");
                    System.out.print("lựa chọn của bạn: ");
                    choice2 = reader.nextInt();
                    reader.nextLine();
                    switch(choice2)
                    {
                        case 1:
                            QLXeXang ql1 = new QLXeXang();
                            ql1.menu();
                            break;
                        case 2:
                            QLXeDien ql2 = new QLXeDien();
                            ql2.menu();
                            break;
                    }
                    break;
            
                case 2:
                    QLKhachHang ql3 = new QLKhachHang();
                    ql3.menu();
                    break;

                case 3: 
                    int choice3;
                    System.out.println("bạn đã vào mục Quản lý Nhân sự. Ở đây chúng tôi có Nhân viên và Quản lý");
                    System.out.println("1. Quản lý Nhân Viên");
                    System.out.println("2. Quản lý Quản lý");
                    System.out.print("lựa chọn của bạn: ");
                    choice3 = reader.nextInt();
                    reader.nextLine();
                    switch(choice3)
                    {
                        case 1:
                            QLNhanVien ql4 = new QLNhanVien();
                            ql4.menu();
                            break;
                        case 2:
                            QLQuanLy ql5 = new QLQuanLy();
                            ql5.menu();
                            break;
                    }
                    break;
                
                case 4:
                    QLHangSX ql6 = new QLHangSX();
                    ql6.menu();
                    break;

                case 5:
                    QLHoaDon ql7 = new QLHoaDon();
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
