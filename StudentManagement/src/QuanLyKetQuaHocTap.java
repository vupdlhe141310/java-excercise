
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell
 */
public class QuanLyKetQuaHocTap {

    public static void main(String[] args) {
        List<Object> listSV = new ArrayList<>();
        List<Khoa> listKhoa = new ArrayList<>();
        listKhoa.add(new Khoa("Kế toán"));
        listKhoa.add(new Khoa("Công nghệ thông tin"));
        listKhoa.add(new Khoa("Quản trị kinh doanh"));
        listKhoa.add(new Khoa("Ngôn ngữ"));
        QuanLy q = new QuanLy();
        while (true) {
            System.out.println("===================================\n"
                    + "1 Thêm mới Khoa\n"
                    + "2 Thêm mới Sinh Viên\n"
                    + "3 Thêm Kết quả học tập của sinh viên\n"
                    + "4 Lấy Kết quả 1 kỳ học tập của 1 sinh viên\n"
                    + "5 Tổng số SV Chính Quy của 1 Khoa\n"
                    + "6 Các SV thủ Khoa\n"
                    + "7 Tìm các SV Tại Chức\n"
                    + "8 Danh Sách SV có Điểm TB kỳ gần nhất >= 8.0\n"
                    + "9 Các SV Có điểm TB kỳ Cao nhất\n"
                    + "10 Danh Sách SV theo Khoa\n"
                    + "11 Thống kê SV theo năm\n"
                    + "12 Thoát.");
            System.out.print("Chọn chức năng: ");
            int choice = Validation.inputIntLimit(1, 12);
            switch (choice) {
                //Thêm mới Khoa
                case 1:
                    System.out.print("Nhập tên Khoa: ");
                    String tenKhoa = Validation.inputString();
                    listKhoa.add(new Khoa(tenKhoa));
                    System.out.println("\n Đã thêm Khoa '" + tenKhoa + " !\n");
                    break;
                //Thêm mới Sinh Viên
                case 2:
                    int viTriKhoa = q.chonKhoa(listKhoa);
                    if (viTriKhoa == -1) {
                        System.out.println("\nVui lòng thêm các Khoa !\n");
                        break;
                    } else {
                        System.out.println("---------------\n"
                                + "1 Sinh viên chính quy\n"
                                + "2 Sinh viên tại chức");
                        System.out.print("Loại Sinh viên: ");
                        int loai = Validation.inputIntLimit(1, 2);
                        System.out.print("Mã sinh viên: ");
                        String maSV = Validation.inputString();
                        System.out.print("Tên sinh viên: ");
                        String hoTen = Validation.inputString();
                        System.out.print("Ngày sinh: ");
                        Date ngaySinh = Validation.inputDate();
                        System.out.print("Năm nhập học: ");
                        int namNhapHoc = Validation.inputIntLimit(1990, 2021);
                        System.out.print("Điểm đầu vào: ");
                        double diemDauVao = Validation.inputDouble();

                        switch (loai) {
                            case 1:
                                q.nhapSV(listSV, maSV, hoTen, ngaySinh, namNhapHoc, diemDauVao, "", listKhoa.get(viTriKhoa));
                                break;
                            case 2:
                                System.out.print("Nơi liên kết đào tạo: ");
                                String noiLK = Validation.inputString();
                                q.nhapSV(listSV, maSV, hoTen, ngaySinh, namNhapHoc, diemDauVao, noiLK, listKhoa.get(viTriKhoa));
                                break;
                        }
                    }
                    break;
                //Thêm Kết quả học tập của sinh viên
                case 3:
                    viTriKhoa = q.chonKhoa(listKhoa);
                    if (viTriKhoa == -1) {
                        System.out.println("\nVui lòng thêm các Khoa !\n");
                        break;
                    } else {
                        System.out.print("Mã sinh viên: ");
                        String maSV = Validation.inputString();
                        System.out.print("Học kỳ: ");
                        String hocKy = Validation.inputString();
                        System.out.print("Điểm TB: ");
                        double diemTB = Validation.inputDouble();
                        if (listKhoa.get(viTriKhoa).themKQHocTap(maSV, new KetQuaHocTap(hocKy, diemTB))) {
                            System.out.println("\nĐã thêm kq cho SV " + maSV + " !\n");
                        }
                    }
                    break;
                //Lấy Kết quả 1 kỳ học tập của 1 sinh viên
                case 4:
                    viTriKhoa = q.chonKhoa(listKhoa);
                    if (viTriKhoa == -1) {
                        System.out.println("\nVui lòng thêm các Khoa !\n");
                        break;
                    } else {
                        System.out.print("Mã sinh viên: ");
                        String maSV = Validation.inputString();
                        System.out.print("Học kỳ: ");
                        String hocKy = Validation.inputString();
                        double diemTB = q.layDiemTBKy(listKhoa.get(viTriKhoa).getDsSV(), maSV, hocKy);
                        System.out.println("SV '" + maSV + "' tại kỳ học '" + hocKy + "' điểm TB: " + diemTB);
                    }
                    break;
                //Tổng số SV Chính Quy của 1 Khoa
                case 5:
                    viTriKhoa = q.chonKhoa(listKhoa);
                    if (viTriKhoa == -1) {
                        System.out.println("\nVui lòng thêm các Khoa !\n");
                        break;
                    } else {
                        String tongCQ = listKhoa.get(viTriKhoa).getTongSVChinhQuy();
                        System.out.println(tongCQ);
                    }
                    break;
                //Các SV thủ Khoa
                case 6:
                    System.out.println("Danh sách các thủ khoa: ");
                    for (Khoa khoa : listKhoa) {
                        System.out.println("Khoa " + khoa.getTenKhoa());
                        System.out.println(khoa.getSVDiemDauVaoCaoNhat());
                    }
                    break;
                //Tìm các SV Tại Chức
                case 7:
                    viTriKhoa = q.chonKhoa(listKhoa);
                    if (viTriKhoa == -1) {
                        System.out.println("\nVui lòng thêm các Khoa !\n");
                        break;
                    } else {
                        System.out.print("Nơi liên kết đào tạo: ");
                        String noiLK = Validation.inputString();

                        List<SinhVienTaiChuc> listTC = listKhoa.get(viTriKhoa).getDsTaiChuc(noiLK);
                        if (listTC.isEmpty()) {
                            System.out.println("\nKhông tìm thấy sv tại chức ở khoa này!\n");
                        } else {
                            System.out.println("Danh sách SV tại chức ở " + noiLK + ":");
                            for (SinhVienTaiChuc sinhVienTaiChuc : listTC) {
                                System.out.println(sinhVienTaiChuc.toString());
                            }
                        }
                    }
                    break;
                //Danh Sách SV có Điểm TB kỳ gần nhất >= 8.0
                case 8: 
                    viTriKhoa = q.chonKhoa(listKhoa);
                    if (viTriKhoa == -1) {
                        System.out.println("\nVui lòng thêm các Khoa !\n");
                        break;
                    } else {
                        List<Object> listSVCao = listKhoa.get(viTriKhoa).getDsSVCaoDiem();
                        if (listSVCao.isEmpty()) {
                            System.out.println("\nKhông tìm thấy SV có Điểm TB kỳ gần nhất >= 8.0 ở khoa này!\n");
                        } else {
                            System.out.println("Danh sách SV có Điểm TB kỳ gần nhất >= 8.0 :");
                            for (Object obj : listSVCao) {
                                System.out.println(obj);
                            }
                        }
                    }
                    break;
                //Các SV Có điểm TB kỳ Cao nhất
                case 9:
                    System.out.println("Danh sách SV có điểm TB học kỳ cao nhất: ");
                    for (Khoa khoa : listKhoa) {
                        System.out.println("Khoa " + khoa.getTenKhoa());
                        System.out.println(khoa.getSVDiemHocKyCaoNhat());
                    }
                    break;
                //Danh Sách SV theo Khoa
                case 10:
                    for (Khoa khoa : listKhoa) {
                        khoa.toString();
                    }
                    break;
                //Thống kê SV theo năm
                case 11:
                    q.getThongKe(listSV);
                    break;
                //Thoát.
                case 12: 
                    return;

            }
        }
    }
}
