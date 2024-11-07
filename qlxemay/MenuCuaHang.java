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

public class MenuCuaHang {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int select;
		do {
			System.out.println("[======================]");
			System.out.println("\t  MENU");
			System.out.println("[======================]");
            System.out.println("1. Quan ly Xe May");
			System.out.println("2. Quan ly Hang San Xuat");
            System.out.println("3. Quan ly Nhan Su");
            System.out.println("4. Quan ly Khach Hang");
            System.out.println("5. Quan ly Hoa Don");
            System.out.println("6. Luu Thay doi va thoat chuong trinh");
            System.out.print("Chon: ");

            select = s.nextInt();
            s.nextLine();
			switch(select) {
			case 1:
				QLXeMay ql1 = new QLXeMay();
				ql1.menu();
				break;
			case 2:
				QLHangSX ql2 = new QLHangSX();
				ql2.menu();
				break;
			case 3:
				QLNhanSu ql3 = new QLNhanSu();
				ql3.menu();
				break;
			case 4:
				QLKhachHang ql4 = new QLKhachHang();
				ql4.menu();
				break;
			case 5:
				QLHoaDon ql5 = new QLHoaDon();
				ql5.menu();
				break;
			case 6:
				System.out.println("DA LUU THAY DOI VA THOAT CHUONG TRINH !\n");
				break;
			default:
	            System.out.println("Lua chon khong hop le. Vui long nhap lai \n");
			}
		} 
		while (select != 6);
		s.close();
	}
}
