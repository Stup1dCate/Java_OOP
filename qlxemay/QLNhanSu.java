package qlxemay;

import java.util.Scanner;

class QLNhanSu {
	private DSNhanSu dsns;
    Scanner scanner = new Scanner(System.in);
    String fileName = "input_NhanSu.txt";
    public QLNhanSu() {
        dsns = new DSNhanSu();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("[======================]");
			System.out.println("\tNHAN SU");
			System.out.println("[======================]");
            System.out.println("1. Them nhan su");
            System.out.println("2. Sua thong tin nhan su");
            System.out.println("3. Xoa nhan su");
            System.out.println("4. Tim kiem nhan su");
            System.out.println("5. Xem thong tin danh sach nhan su");
            System.out.println("6. Tai danh sach nhan su tu file");
            System.out.println("7. Xuat danh sach nhan su ra file");
            System.out.println("8. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
            	case 1:
	                dsns.Them();
	                break;
                case 2:
                	dsns.Sua();
                    break;
                case 3:
                	dsns.Xoa();
                    break;
                case 4:
                	dsns.TimKiem();
                    break;
                case 5:
                	dsns.Xem();
                    break;
                case 6:
                    dsns.taiDanhSachTuFile(fileName);
                    break;
                case 7:            
                    dsns.xuatDanhSachRaFile(fileName);
                    break;
                case 8:
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh.\n");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai \n");
            }
        } while (choice != 8);
    }
}