package qlxemay;
import java.util.Scanner;

class QLXeMay {
	private DSXeMay dssp;

    String fileName = "input_XeMay.txt";
    String fileNameHangSanXuat = "input_HangSX.txt";
    DSHangSX dsHangSX;
    public QLXeMay() {
        dsHangSX = new DSHangSX();
        dsHangSX.taiDanhSachTuFile(fileNameHangSanXuat);
        dssp = new DSXeMay(); 
    }
    
    public void menu() {
            Scanner s = new Scanner(System.in);
        dssp.taiDanhSachTuFile(fileName);
        int select;
        do {
            System.out.println("[======================]");
			System.out.println("\t XE MAY");
			System.out.println("[======================]");
        	System.out.println("1. Them xe may");
            System.out.println("2. Sua thong tin xe may");
            System.out.println("3. Xoa mot xe may");
            System.out.println("4. Tim kiem xe may (theo masp)");
            System.out.println("5. Xem thong tin chi tiet danh sach xe may");         
            System.out.println("6. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");
            
              while (true) {
                            if (s.hasNextInt()) {
                                select= s.nextInt();
                                break;
                            }
                            System.out.println("Khong hop le! . Vui long nhap lai.");
                            s.nextLine();
                        }
            s.nextLine(); 
            switch (select) {
            	case 1:
	                dssp.them(fileNameHangSanXuat);
	                break;
                case 2:
                	dssp.sua(fileNameHangSanXuat);
                    break;
                case 3:
                	dssp.xoa();
                    break;
                case 4:
                	dssp.timKiem();
                    break;
                case 5:
                	dssp.xem();
                    break;
                case 6:
                    dssp.xuatDanhSachRaFile(fileName);
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
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
                      dssp.xuatDanhSachRaFile(fileName);
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                    break;  
                }
            }
        } 
        while (true);
    }
}
