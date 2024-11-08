package qlxemay;

import java.util.Scanner;

class QLHoaDon {
	private DSHoaDon dshd;
    Scanner s = new Scanner(System.in);
    String fileName = "input_HoaDon.txt";
    String fileName_KhachHang = "input_KhachHang.txt";
    String fileName_XeMay = "intput_XeMay.txt";
    String fileName_HangSX = "input_HangSX.txt";
    DSKhachHang dsKhachHang;
    DSXeMay dsXeMay;
    DSHangSX dsHangSX;

    public QLHoaDon() {
        dsKhachHang = new DSKhachHang();
        dsKhachHang.taiDanhSachTuFile(fileName_KhachHang); 
        dsXeMay = new DSXeMay();
        dshd = new DSHoaDon();
    }

    public void menu() {
        int select;
        do {
            System.out.println("[======================]");
			System.out.println("\tHOA DON");
			System.out.println("[======================]");
            System.out.println("1. Them Hoa Don");
            System.out.println("2. Sua thong tin hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Tim kiem hoa don");
            System.out.println("5. Xem thong tin chi tiet hoa don");
            System.out.println("6. Tai danh sach hoa don tu file");
            System.out.println("7. Xuat danh sach hoa don ra file");
            System.out.println("8. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");
            
            select = s.nextInt();
            s.nextLine();
            switch (select) {
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
                	dshd.timkiem();
                    break;
                case 5:
                	dshd.xem();
                    break;
                case 6:
                    dshd.taiDanhSachTuFile(fileName, dsKhachHang, dsXeMay);
                    break;
                case 7:            
                    dshd.xuatDanhSachRaFile(fileName);
                    break;
                case 8:
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh.\n");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
            // Hỏi người dùng có muốn tiếp tục chọn không
            System.out.print("tiep tuc lua chon Menu (y/n)? ");
            String choice = s.nextLine().trim().toLowerCase();
            if (!choice.equals("y") && !choice.equals("yes") && !choice.equals("1")) {
                System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                break;  
            }
        } 
        while (true);
    }
}
