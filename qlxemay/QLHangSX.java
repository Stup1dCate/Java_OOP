package qlxemay;
import java.util.Scanner;

public class QLHangSX {
    private DSHangSX dshsx;
    Scanner scanner = new Scanner(System.in);
    String fileName = "input_HangSX"; 
	public QLHangSX()
	{
		dshsx = new DSHangSX();
	}	
    public void menu() {
        int choice;
        do {
        	System.out.println("1. Thêm Hãng Sản xuất");
            System.out.println("2. Sửa thông tin Hãng Sản xuất");
            System.out.println("3. Xóa Hãng Sản xuất");
            System.out.println("4. Tìm kiếm Hãng Sản xuất");
            System.out.println("5. Xem thông tin trong danh sách Hãng Sản xuất");
            System.out.println("6. Tải danh sách Sản phẩm từ file");
            System.out.println("7. Xuất danh sách Sản phẩm ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
            	case 1:
	                dshsx.them();
	                break;
                case 2:
                	dshsx.sua();
                    break;
                case 3:
                	dshsx.xoa();
                    break;
                case 4:
                	dshsx.timKiem();
                    break;
                case 5:
                	dshsx.xem();
                    break;
                case 6:
                    dshsx.taiDanhSachTuFile(fileName);
                    break;
                case 7:            
                    dshsx.xuatDanhSachRaFile(fileName);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }
}
