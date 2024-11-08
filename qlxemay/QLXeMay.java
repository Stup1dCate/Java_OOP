package qlxemay;
import java.util.Scanner;

class QLXeMay {
	private DSXeMay dssp;
    Scanner s = new Scanner(System.in);
    String fileName = "input_XeMay.txt";
    String fileNameHangSanXuat = "input_HangSX.txt";
    DSHangSX dsHangSX;
    public QLXeMay() {
        dsHangSX = new DSHangSX();
        dsHangSX.taiDanhSachTuFile(fileNameHangSanXuat);
        dssp = new DSXeMay(); 
    }
    
    public void menu() {
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
            System.out.println("6. Tai danh sach xe may tu file");
            System.out.println("7. Cap nhat danh sach xe may vao file");            
            System.out.println("8. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");
            
            select = s.nextInt();
            s.nextLine(); 
            switch (select) {
            	case 1:
	                dssp.them();
	                break;
                case 2:
                	dssp.sua();
                    break;
                case 3:
                	dssp.xoa();
                    break;
                case 4:
                	dssp.timkiem();
                    break;
                case 5:
                	dssp.xem();
                    break;
                case 6:
                    dssp.taiDanhSachTuFile(fileName, dsHangSX);
                    break;
                case 7:            
                    dssp.xuatDanhSachRaFile(fileName);
                    break;
                case 8:
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai. \n");
                    continue;
            }
            // Hỏi người dùng có muốn tiếp tục chọn không
            if(select != 8){
                System.out.print("tiep tuc lua chon Menu (y/n)? ");
                String choice = s.nextLine().trim().toLowerCase();
                if (!choice.equals("y") && !choice.equals("yes") && !choice.equals("1")) {
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh. \n");
                    break;  
                }
            }
        } 
        while (true);
    }
}
