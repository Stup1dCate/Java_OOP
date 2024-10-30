package qlxemay;

import java.util.Scanner;

class QLKhachHang {
	private DSKhachHang dskh;
    Scanner s = new Scanner(System.in);
    String fileName = "input_KhachHang.txt";
    public QLKhachHang() {
        dskh = new DSKhachHang();
    }

    public void menu() {
        int select;
        do {
            System.out.println("1. Them khach hang");
            System.out.println("2. Sua thong tin khach hang");
            System.out.println("3. Xoa khach hang");
            System.out.println("4. Tim kiem khach hang");
            System.out.println("5. Xem thong tin danh sach khach hang");
            System.out.println("6. Tai danh sach khach hang tu file");
            System.out.println("7. Xuat danh sach khach hang vao file");
            System.out.println("8. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");

            select = s.nextInt();
            s.nextLine(); 

            switch (select) {
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
                    System.out.println("Luu thay doi va quay tro ve Menu chinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        } while (select != 8);
    }
}
