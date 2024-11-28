package qlxemay;

import java.util.Scanner;

class QLHoaDon {
	private DSHoaDon dshd;
    Scanner s = new Scanner(System.in);
    String fileName = "input_HoaDon.txt";
    String fileName_XeMay = "input_XeMay.txt";
    String fileName_Khachhang="input_KhachHang.txt";
    public QLHoaDon() {
        dshd = new DSHoaDon();
    }

    public void menu() {
        dshd.taiDanhSachTuFile(fileName);
        int select;
        do {
            System.out.println("[======================]");
			System.out.println("\tHOA DON");
			System.out.println("[======================]");
            System.out.println("1. Them Hoa Don");
            System.out.println("2. Sua thong tin hoa don");
            System.out.println("3. Xoa hoa don");
            System.out.println("4. Tim kiem hoa don");
            System.out.println("5. Xem thong tin chi tiet danh sach hoa don");
            System.out.println("6. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");
            
            select = s.nextInt();
            s.nextLine();
            switch (select) {
            	case 1:
	                dshd.them(fileName_XeMay,fileName_Khachhang);
	                break;
                case 2:
                	dshd.sua(fileName_XeMay,fileName_Khachhang);
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
                    dshd.xuatDanhSachRaFile(fileName); 
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh.\n");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai. \n");
                    continue;
            }
            // Hỏi người dùng có muốn tiếp tục chọn không
            if(select != 6){
                System.out.print("tiep tuc lua chon Menu ? (y/n): ");
                String choice = s.nextLine().trim().toLowerCase();
                if (!choice.equals("y") && !choice.equals("yes") && !choice.equals("1")) {
                    dshd.xuatDanhSachRaFile(fileName); 
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                    break;  
                }
            }
        } 
        while (true);
    }
}
