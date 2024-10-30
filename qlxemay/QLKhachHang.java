package qlxemay;

import java.util.Scanner;

class QLKhachHang {
	private DSKhachHang dskh;
    Scanner scanner = new Scanner(System.in);
    String fileName = "input_KhachHang.txt";
    public QLKhachHang() {
        dskh = new DSKhachHang();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("1. Thêm Khách hàng");
            System.out.println("2. Sửa thông tin Khách hàng");
            System.out.println("3. Xóa Khách hàng");
            System.out.println("4. Tìm kiếm Khách hàng");
            System.out.println("5. Xem thông tin trong danh sách Khách hàng");
            System.out.println("6. Tải danh sách Khách hàng từ file");
            System.out.println("7. Xuất danh sách Khách hàng ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
            	case 1:
	                dskh.them();
	                break;
                case 2:
                	dskh.sua();
                    break;
                case 3:
                	dskh.xoa();
                    break;
                case 4:
                	dskh.timKiem();
                    break;
                case 5:
                	dskh.xem();
                    break;
                case 6:
                    dskh.taiDanhSachTuFile(fileName);
                    break;
                case 7:            
                    dskh.xuatDanhSachRaFile(fileName);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }
}
