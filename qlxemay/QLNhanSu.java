package qlxemay;

import java.util.Scanner;

class QLNhanSu {
    private DSNhanSu dsns;
    private Scanner s = new Scanner(System.in);
    private String fileName = "input_NhanSu.txt";

    public QLNhanSu() {
        dsns = new DSNhanSu();
    }

    public void menu() {
        dsns.taiDanhSachTuFile(fileName);
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
            System.out.println("6. Xem so luong nhan su");
            System.out.println("7. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");

            // Kiểm tra đầu vào có phải số không
            while (!s.hasNextInt()) {
                System.out.print("Nhap sai dinh dang! Vui long nhap so tu 1 den 7: ");
                s.nextLine(); // Loại bỏ giá trị không hợp lệ
            }
            select = s.nextInt();
            s.nextLine(); // Loại bỏ dòng thừa sau khi nhập số

            switch (select) {
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
                    Quanly.SoLuongQuanLy();
                    NhanVien.Soluongnhanvien();
                    break;
                case 7:
                    dsns.xuatDanhSachRaFile(fileName);
                    System.out.println("Da luu thay doi va quay tro ve Menu chinh.\n");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.\n");
            }

            // Hỏi người dùng có muốn tiếp tục chọn không
            System.out.print("Tiep tuc lua chon Menu? (y/n): ");
            String choice = s.nextLine().trim().toLowerCase();
            if (!choice.equals("y") && !choice.equals("yes") && !choice.equals("1")) {
                dsns.xuatDanhSachRaFile(fileName);
                System.out.println("Da luu thay doi va quay tro ve Menu chinh.\n");
                break;
            }
        } while (true);
    }
}
