package qlxemay;

import java.util.Scanner;

class QLNhanSu {
	private DSNhanSu dsns;
    Scanner s = new Scanner(System.in);
    String fileName = "input_NhanSu.txt";
    public QLNhanSu() {
        dsns = new DSNhanSu();
    }

    public void menu() {
        int select;
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
            select = s.nextInt();
            s.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (select) {
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
                	dsns.timkiem();
                    break;
                case 5:
                	dsns.xem();
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
            // Hỏi người dùng có muốn tiếp tục chọn không
            System.out.print("tiep tuc lua chon Menu (y/n)? ");
            String choice = s.nextLine().trim().toLowerCase();
            if (!choice.equals("y") && !choice.equals("yes") && !choice.equals("1")) {
                System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                break;  
            }
        } while (true);
    }
}