package qlxemay;
import java.util.Scanner;

class QLHangSX {
    private DSHangSX dshsx;
    private Scanner s = new Scanner(System.in);
    private String fileName = "input_HangSX.txt"; 

    public QLHangSX() {
        dshsx = new DSHangSX();
    }

    public void menu() {
        int select;
        do {
            System.out.println("1. Them hang san xuat");
            System.out.println("2. Sua thong tin hang san xuat");
            System.out.println("3. Xoa hang san xuat");
            System.out.println("4. Tim kiem hang san xuat");
            System.out.println("5. Xem thong tin trong danh sach hang san xuat");
            System.out.println("6. Quay tro ve giao dien Menu chinh");
            System.out.print("Chon: ");

            select = s.nextInt();
            s.nextLine();
            
            switch (select) {
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
                    dshsx.timkiem();;
                    break;
                case 5:
                    dshsx.xem();
                case 6:
                    System.out.println("Luu thay doi va quay tro ve Menu chinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        } 
        while (select != 6);
    }
}
