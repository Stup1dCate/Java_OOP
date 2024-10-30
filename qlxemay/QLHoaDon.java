package qlxemay;

import java.util.Scanner;

class QLHoaDon {
	private DSHoaDon dshd;
    Scanner scanner = new Scanner(System.in);
    String fileName = "input_HoaDon.txt";
    String fileNameKhachHang = "KhachHang.txt";
    String fileNameSanPham = "SanPham.txt";
    DSKhachHang dsKhachHang;
    DSXeMay dsXeMay;
    public QLHoaDon() {
        dsKhachHang = new DSKhachHang();
        dsKhachHang.taiDanhSachTuFile(fileNameKhachHang); // Tải danh sách khách hàng từ file
        dsXeMay = new DSXeMay();
        dshd = new DSHoaDon();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("1. Thêm Hóa đơn");
            System.out.println("2. Sửa thông tin Hóa đơn");
            System.out.println("3. Xóa Hóa đơn");
            System.out.println("4. Tìm kiếm Hóa đơn");
            System.out.println("5. Xem thông tin trong danh sách Hóa đơn");
            System.out.println("6. Tải danh sách Hóa đơn từ file");
            System.out.println("7. Xuất danh sách Hóa đơn ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
            	case 1:
	                dshd.them();
	                break;
                case 2:
                	dshd.sua();
                    break;
                case 3:
                	dshd.xoa();
                    break;
                case 4:
                	dshd.timKiem();
                    break;
                case 5:
                	dshd.xem();
                    break;
                case 6:
                    dshd.taiDanhSachTuFile(fileName, dsKhachHang, dsSanPham);
                    break;
                case 7:            
                    dshd.xuatDanhSachRaFile(fileName);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }
}
