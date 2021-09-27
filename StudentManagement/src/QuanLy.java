
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell
 */
public class QuanLy {

    public int timSVbangMSSV(List<Object> list, String maSV) {
        for (int i = 0; i < list.size(); i++) {
            SinhVien sv = (SinhVien) list.get(i);
            if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                return i;
            }
        }
        return -1;
    }

    public void nhapSV(List<Object> list, String maSV, String hoTen, Date ngaySinh, int namNhapHoc, double diemDauvao, String noiLKDaoTao, Khoa khoa) {
        if (timSVbangMSSV(list, maSV) != -1) {
            System.out.println("\nMã Sinh viên đã tồn tại !\n");
        } else {
            if (noiLKDaoTao.isEmpty()) {
                list.add(new SinhVien(maSV, hoTen, ngaySinh, namNhapHoc, diemDauvao));
                khoa.themSV(new SinhVien(maSV, hoTen, ngaySinh, namNhapHoc, diemDauvao));
                System.out.println("\nĐã thêm SV " + maSV + " !\n");
            } else {
                list.add(new SinhVienTaiChuc(maSV, hoTen, ngaySinh, namNhapHoc, diemDauvao, noiLKDaoTao));
                khoa.themSV(new SinhVienTaiChuc(maSV, hoTen, ngaySinh, namNhapHoc, diemDauvao, noiLKDaoTao));
            }
        }

    }

    public boolean chinhQuyhayko(List<Object> list, String maSV) {
        for (Object obj : list) {
            if (obj.getClass() == SinhVien.class) {
                return true;
            }
        }
        return false;
    }

    public double layDiemTBKy(List<Object> list, String maSV, String tenHocKy) {
        int index = timSVbangMSSV(list, maSV);
        if (index == -1) {
            return -1;
        } else {
            SinhVien sv = (SinhVien) list.get(index);
            return sv.getKQKyHoc(tenHocKy);
        }
    }

    public int timKhoa(List<Khoa> list, String tenKhoa) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTenKhoa().equalsIgnoreCase(tenKhoa)) {
                return i;
            }
        }
        return -1;
    }

    public int chonKhoa(List<Khoa> listKhoa) {
        if (listKhoa.isEmpty()) {
            return -1;
        } else {
            System.out.println("Danh sách Khoa:");
            for (int i = 0; i < listKhoa.size(); i++) {
                System.out.println((i + 1) + " " + listKhoa.get(i).getTenKhoa());
            }
            System.out.println("---------------");
            System.out.print("Chọn Khoa: ");
            int viTriKhoa = Validation.inputIntLimit(1, listKhoa.size())-1;
            return viTriKhoa;
        }

    }
    public void getThongKe(List<Object> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Object obj : list) {
            SinhVien sv = (SinhVien) obj;
            int namHoc = sv.getNamNhapHoc();
            if (!map.containsKey(namHoc)) {
                map.put(namHoc, 1);
            } else {
                map.put(namHoc, map.get(namHoc) + 1);
            }

        }
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.println(key + ": " + map.get(key));
        }

    }

}
