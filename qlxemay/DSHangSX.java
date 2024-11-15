package qlxemay;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DSHangSX {

    private ArrayList<HangSX> dshsx;
    private static int mahsx;

    public DSHangSX() {
        dshsx = new ArrayList<>();
    }

    public static int getMahsx() {
        return mahsx;
    }

    public static void setMahsx(int mahsx) {
        DSHangSX.mahsx = mahsx;
    }

    public ArrayList<HangSX> getDshsx() {
        return dshsx;
    }

    public void setDshsx(ArrayList<HangSX> dshsx) {
        this.dshsx = dshsx;
    }

    public void xem() {
        if (dshsx != null && !dshsx.isEmpty()) {
            System.out.println("\nTHONG TIN DANH SACH HANG SAN XUAT: ");
            for (HangSX hsx : dshsx) {
                hsx.xuat();
                System.out.println("____________________________________________________________________");
            }
            System.out.println("\n");
        } else {
            System.out.println("Danh sach trong.\n");
        }
    }

    public void them() {
        Scanner s = new Scanner(System.in);
        System.out.print("\t NHAP THONG TIN HANG SAN XUAT CAN THEM: \n");
        HangSX hsx = null;
        hsx = new HangSX();
        if (hsx != null) {
            System.out.println("Nhap ma hang san xuat: ");
            int count;
            do {
                count = 0;
                int masp = s.nextInt();
                if (masp == 0) {
                    return;
                }
                for (HangSX hang : dshsx) {
                    if (hang.getMahsx() == masp) {
                        count++;
                    }
                    if (count == 1) {
                        System.out.println("Ma hang san xuat da ton tai!");
                        System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                        break;
                    }
                }
                if (count == 0) {
                    hsx.setMahsx(masp);
                }
            } while (count == 1);
            hsx.nhap();
            dshsx.add(hsx);
        }
        System.out.println("\n===== DA LUU DU LIEU HANG SAN XUAT THANH CONG ! =====\n");
    }

    public void sua() {
        ArrayList<HangSX> dstam = new ArrayList<>();
        System.out.println("Nhap ten hang san xuat can sua: ");
        Scanner sc = new Scanner(System.in);
        String tensua;
        int look = 0;
        tensua = sc.nextLine();
        for (HangSX hang : dshsx) {
            if (hang.getTenhsx().equals(tensua)) {
                System.out.println("Thong tin hang san xuat " + tensua);
                dstam.add(hang);
                hang.xuat();
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay hang SX!");
            return;
        }
        if (look == 1) {
            for (HangSX hang : dshsx) {
                if (hang.getTenhsx().equals(tensua)) {
                    int ma = hang.getMahsx();
                    System.out.println("Nhap ma moi cua hang san xuat: ");
                    int count;
                    do {
                        count = 0;
                        int masp = sc.nextInt();
                        if (masp == 0) {
                            return;
                        }
                        for (HangSX hsx : dshsx) {
                            if (hsx.getMahsx() == masp) {
                                count++;
                            }
                            if (ma == masp) {
                                count = 0;
                            }
                            if (count == 1) {
                                System.out.println("Ma hang san xuat da ton tai!");
                                System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                                break;
                            }
                        }
                        if (count == 0) {
                            hang.setMahsx(masp);
                        }
                    } while (count == 1);
                    hang.sua();
                    System.out.println("Sua thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Nhap ma hang san xuat muon sua: ");
        // Kiem tra xem ma hang san xuat moi co trung voi ma hang san xuat co trong danh sach khong
        int ma = sc.nextInt();
        for (HangSX hang : dstam) {
            if (hang.getMahsx() == ma) {
                System.out.println("Nhap ma moi cua hang san xuat: ");
                int count;
                do {
                    count = 0;
                    int masp = sc.nextInt();
                    if (masp == 0) {
                        return;
                    }
                    for (HangSX hsx : dshsx) {
                        if (hsx.getMahsx() == masp) {
                            count++;
                        }
                        if (count == 1) {
                            System.out.println("Ma hang san xuat da ton tai!");
                            System.out.println(" Vui long nhap lai ma moi hoac nhap 0 de thoat.");
                            break;
                        }
                    }
                    if (count == 0) {
                        hang.setMahsx(masp);
                    }
                } while (count == 1);
                hang.sua();
                return;
            }
        }
        System.out.printf("Khong ton tai hang san xuat %s co ma: %d\n", tensua, ma);
    }

    public void xoa() {
        Scanner sc = new Scanner(System.in);
        ArrayList<HangSX> dstam = new ArrayList<>();
        System.out.println("Nhap ten hang san xuat can xoa: ");
        String tenxoa;
        int look = 0;
        tenxoa = sc.nextLine();
        for (HangSX hang : dshsx) {
            if (hang.getTenhsx().equals(tenxoa)) {
                System.out.println("Thong tin hang san xuat " + tenxoa);
                hang.xuat();
                dstam.add(hang);
                look++;
            }
        }
        if (look == 0) {
            System.out.println("Khong tim thay hang SX!");
            return;
        }
        if (look == 1) {
            for (HangSX hang : dshsx) {
                if (hang.getTenhsx().equals(tenxoa)) {
                    dshsx.remove(hang);
                    System.out.println("Xoa thanh cong!");
                    return;
                }
            }
        }
        System.out.println("Nhap ma hang san xuat muon xoa: ");
        int ma = sc.nextInt();
        for (HangSX hang : dstam) {
            if (hang.getMahsx() == ma) {
                dshsx.remove(hang);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.printf("Khong ton tai hang san xuat %s co ma: %d\n", tenxoa, ma);
    }

    public void timkiem() {
        Scanner s = new Scanner(System.in);
        System.out.print("Nhap ten hang san xuat can tim kiem: ");
        String find = s.nextLine();
        boolean found = false;
        for (HangSX hsx : dshsx) {
            if (hsx.getTenhsx().contains(find)) {
                hsx.xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co hang san xuat can tim kiem !");
        }
    }

    public void taiDanhSachTuFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Chuyển dòng văn bản thành đối tượng HangSX và thêm vào danh sách
                HangSX hsx = parseLineToHangSX(line);
                if (hsx != null) {

                    dshsx.add(hsx);
                }
            }
            System.out.println("Da tai danh sach tu tep tin: " + fileName + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay tep tin: " + fileName + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDanhSachRaFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (HangSX hsx : dshsx) {
                // Ghi đối tượng HangSX thành dòng văn bản và xuống dòng
                writer.write(parseHangSXToLine(hsx));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm chuyển dòng văn bản thành đối tượng HangSX
    private HangSX parseLineToHangSX(String line) {
        String[] parts = line.split(";"); // Giả sử dữ liệu được phân tách bằng dấu chấm phẩy
        if (parts.length == 4) {
            int mahsx = Integer.parseInt(parts[0]);
            String sdthsx = parts[1];
            String tenhsx = parts[2];
            String diachihsx = parts[3];
            return new HangSX(mahsx, tenhsx, diachihsx, sdthsx);
        }
        return null;
    }

    // Hàm chuyển đối tượng HangSX thành dòng văn bản
    private String parseHangSXToLine(HangSX hsx) {
        return hsx.getMahsx() + ";" + hsx.getSdthsx() + ";" + hsx.getTenhsx() + ";" + hsx.getDiachihsx();
    }
}
