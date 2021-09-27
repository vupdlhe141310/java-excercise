/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecbillmanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class QuanLyBienLai {

    public static void main(String[] args) {
        List<BienLai> listBL = new ArrayList<>();
        List<KhachHang> listKH = new ArrayList<>();
        QuanLy q = new QuanLy();
        while (true) {
            System.out.println("===================================\n"
                    + "1 Thêm mới Khách hàng.\n"
                    + "2 Thêm mới Biên lai hàng.\n"
                    + "3 Hiện thị Ds Khách\n"
                    + "4 Hiện thị Ds Biên Lai\n"
                    + "5 Hiện thị Ds Biên Lai theo Khách\n"
                    + "6 Sửa thông tin KH\n"
                    + "7 Thoát khỏi chương trình.");
            System.out.print("Chọn chức năng: ");
            int choice = Validation.inputIntLimit(1, 6);
            switch (choice) {
                case 1:
                    //lay thong tin
                    System.out.print("Họ tên Chủ hộ: ");
                    String hoTen = Validation.inputString();
                    System.out.print("Số nhà: ");
                    String soNha = Validation.inputString();
                    System.out.print("Mã Công tơ: ");
                    int maCT = Validation.inputIntLimit(0, Integer.MAX_VALUE);
                    //them kh
                    listKH = q.themKhachHang(listKH, hoTen, soNha, maCT);
                    break;
                case 2:
                    //tim kh 
                    System.out.print("Mã Công tơ: ");
                    maCT = Validation.inputIntLimit(0, Integer.MAX_VALUE);
                    int index = q.timKhachHangBangMaCT(listKH, maCT);
                    //tim duoc khach hang
                    if (index != -1) {
                        //lay thong tin cong to
                        KhachHang khach = listKH.get(index);
                        System.out.print("Chỉ số điện cũ: ");
                        int csCu = Validation.inputIntLimit(0, Integer.MAX_VALUE);
                        System.out.print("Chỉ số điện mới: ");
                        int csMoi = Validation.inputIntLimit(0, Integer.MAX_VALUE);

                        //them bien lai
                        listBL = q.themBienLai(listBL, csCu, csMoi, khach);
                    } else {
                        System.out.println("\nKhông tìm thấy Khách hàng có mã công tơ '" + maCT + "' !\n");
                    }
                    break;
                case 3:
                    System.out.println("---------------------------------");
                    int count = 0;
                    for (KhachHang khach : listKH) {
                        System.out.println(khach);
                        System.out.println("---------------------------------");
                        count++;
                    }
                    if (count == 0) {
                        System.out.println("Không có Khách hàng nào !");
                        System.out.println("---------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("---------------------------------");
                    count = 0;
                    for (BienLai bienlai : listBL) {
                        System.out.println(bienlai);
                        System.out.println("---------------------------------");
                        count++;
                    }
                    if (count == 0) {
                        System.out.println("Không có Biên lai nào !");
                        System.out.println("---------------------------------");
                    }
                    break;
                case 5:
                    System.out.print("Mã Công tơ: ");
                    maCT = Validation.inputIntLimit(0, Integer.MAX_VALUE);
                    count = 0;
                    System.out.println("---------------------------------");
                    for (BienLai bienlai : listBL) {
                        if (bienlai.getKhach().getMaCT() == maCT) {
                            System.out.println(bienlai);
                            System.out.println("---------------------------------");
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Không tìm thấy biên lai nào của nhà có mã công tơ '" + maCT + " !");
                        System.out.println("---------------------------------");
                    }
                    break;
                case 6:
                    System.out.print("Mã Công tơ: ");
                    int maCTcu = Validation.inputIntLimit(0, Integer.MAX_VALUE);
                    index = q.timKhachHangBangMaCT(listKH, maCTcu);
                    //tim duoc khach hang
                    if (index != -1) {
                        System.out.print("Họ tên Chủ hộ: ");
                        hoTen = Validation.inputString();
                        System.out.print("Số nhà: ");
                        soNha = Validation.inputString();
                        System.out.print("Mã Công tơ: ");
                        int maCTmoi = Validation.inputIntLimit(0, Integer.MAX_VALUE);
                        q.suaKhach(listKH, listBL, maCTcu, hoTen, soNha, maCTmoi);
                    } else {
                        System.out.println("\nKhông tìm thấy Khách hàng có mã công tơ '" + maCTcu + "' !\n");
                    }
                    break;
                case 7:
                    return;

            }
        }
    }
}
