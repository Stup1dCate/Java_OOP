/*
  Demo các chức năng (cần có đầy đủ các chức năng xem, thêm, sửa, xóa, tìm kiếm)
Trả lời câu hỏi về đồ án của mình. Gõ lại code theo yêu cầu của GV
    Thang điểm:
  (1đ) Có ít nhất 3 lớp đối tượng chính --> lớp đối tượng là các loại xe máy (lớp cha: XeMay)
  (1đ) Các lớp phải có hàm thiết lập (constructor) -->
  (1đ) Có kế thừa hợp lý --> các kiểu liệu (giá, hãng, năm, ... )
  (1đ) Cài đặt và sử dụng đa hình
  (2đ) Lớp mảng các đối tượng (danh sách)
  (1đ) Đọc và ghi dữ liệu lên file (text) -->
  (1đ) Có thuộc tính static, phương thức static -->
  (1đ) Có lớp trừu tượng, hàm trừu tượng (abstract)
  (1đ) Có interface
Trừ điểm nếu không đủ chức năng, bị lỗi

yêu cầu trong terminal: 
1. Hiện danh sách các xe (mặc định hiện ra giống với input)
2. Sắp xếp danh sách theo giá tiền
3. Xem số lượng tồn kho 
4. Xem số lượng đã bán
5. Xem giá nhập
                                                    CHƯƠNG TRÌNH: QUẢN LÝ CỬA HÀNG BÁN XE MÁY
*/

package qlxemay;
import java.util.Scanner;

class QLXeMay {
	private DSXeMay dssp;
    Scanner scanner = new Scanner(System.in);
    String fileName = "input_XeMay.txt";
    String fileName2 = "XeMay_full.txt";
	public QLXeMay()
	{
		dssp = new DSXeMay();
	}	
    public void menu() {
        int choice;
        do {
        	System.out.println("1. Thêm Xe");
            System.out.println("2. Sửa thông tin Xe");
            System.out.println("3. Xóa Xe");
            System.out.println("4. Tìm kiếm Xe");
            System.out.println("5. Xem thông tin trong danh sách Xe");
            System.out.println("6. Tải danh sách Sản phẩm từ file");
            System.out.println("7. Xuất danh sách Sản phẩm ra file");
            System.out.println("8. Quay trở về giao diện chính");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc số

            switch (choice) {
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
                	dssp.timKiem();
                    break;
                case 5:
                	dssp.xem();
                    break;
                case 6:
                    dssp.taiDanhSachTuFile(fileName);
                    break;
                case 7:            
                    dssp.xuatDanhSachRaFile(fileName2);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 8);
    }
}
