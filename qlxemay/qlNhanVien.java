package qlxemay;

import java.util.Scanner;

class QLNhanVien {
	private DSNhanSu dsnv;
    Scanner scanner = new Scanner(System.in);
    String fileName1 = "input_NhanVien.txt";
    String fileName2 = "output_NhanVien.txt";
    public QLNhanVien() {
        dsnv = new DSNhanSu();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("1. Thêm Nhân viên");
            System.out.println("2. Sửa thông tin Nhân viên");
            System.out.println("3. Xóa Nhân viên");
            System.out.println("4. Tìm kiếm Nhân viên");
            System.out.println("5. Xem thông tin trong danh sách Nhân viên");
            System.out.println("6. Tải danh sách Nhân viên từ file");
            System.out.println("7. Xuất danh sách Nhân viên ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
            	case 1:
	                dsnv.them();
	                break;
                case 2:
                	dsnv.sua();
                    break;
                case 3:
                	dsnv.xoa();
                    break;
                case 4:
                	dsnv.timKiem();
                    break;
                case 5:
                	dsnv.xem();
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
