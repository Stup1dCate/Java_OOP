package qlxemay;

import java.util.Scanner;

class QLNhanSu {
	private DSNhanSu dsns;
    Scanner scanner = new Scanner(System.in);
    String fileName1 = "input_NhanSu.txt";
    String fileName2 = "output_NhanSu.txt";
    public QLNhanVien() {
        dsns = new DSNhanSu();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("1. Thêm Nhân sự");
            System.out.println("2. Sửa thông tin Nhân sự");
            System.out.println("3. Xóa Nhân sự");
            System.out.println("4. Tìm kiếm Nhân sự");
            System.out.println("5. Xem thông tin trong danh sách Nhân sự");
            System.out.println("6. Tải danh sách Nhân viên từ file");
            System.out.println("7. Xuất danh sách Nhân viên ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
            	case 1:
	                dsns.them();
	                break;
                case 2:
                	dsns.sua();
                    break;
                case 3:
                	dsns.xoa();
                    break;
                case 4:
                	dsns.timKiem();
                    break;
                case 5:
                	dsns.xem();
                    break;
                case 6:
                    dsnv.taiDanhSachTuFile(fileName1);
                    break;
                case 7:            
                    dsnv.xuatDanhSachRaFile(fileName2);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }
}
