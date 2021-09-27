
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
public class Khoa {

    private String tenKhoa;
    private List<Object> dsSV = new ArrayList<>();

    public Khoa() {
    }

    public Khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public void themSV(Object o) {
        this.dsSV.add(o);
    }

    public List<Object> getDsSV() {
        return dsSV;
    }

    public boolean themKQHocTap(String maSV, KetQuaHocTap kq) {
        for (Object obj : dsSV) {
            if (obj.getClass() == SinhVien.class) {
                SinhVien sv = (SinhVien) obj;
                if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                    sv.themKQ(kq);
                    obj = sv;
                    return true;
                }
            }else{
                SinhVienTaiChuc sv = (SinhVienTaiChuc) obj;
                if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                    sv.themKQ(kq);
                    obj = sv;
                    return true;
                }
            }
        }
        return false;
    }

    public String getTongSVChinhQuy() {
        int tongCQ = 0;
        int tong = 0;
        for (Object obj : dsSV) {
            if (obj.getClass() == SinhVien.class) {
                tongCQ++;
            }
            tong++;
        }
        return "Có " + tongCQ + " \\ " + tong + "là SV Chính Quy";
    }

    public Object getSVDiemDauVaoCaoNhat() {
        Object o = new SinhVien("Chưa có thông tin", "Chưa có thông tin", null, 0, 0);

        for (Object obj : dsSV) {
            SinhVien sv = (SinhVien) obj;
            SinhVien sv2 = (SinhVien) o;
            if (sv.getDiemDauvao() >= sv2.getDiemDauvao()) {
                o = obj;
            }
        }
        if (o.getClass() == SinhVienTaiChuc.class) {
            return (SinhVienTaiChuc) o;
        } else {
            return (SinhVien) o;
        }

    }

    public List<SinhVienTaiChuc> getDsTaiChuc(String noiLK) {
        List<SinhVienTaiChuc> result = new ArrayList<>();
        for (Object obj : dsSV) {
            if (obj.getClass() == SinhVienTaiChuc.class) {
                SinhVienTaiChuc svtc = (SinhVienTaiChuc) obj;
                result.add(svtc);
            }
        }
        return result;
    }

    public List<Object> getDsSVCaoDiem() {
        List<Object> result = new ArrayList<>();
        for (Object obj : dsSV) {
            SinhVien sv = (SinhVien) obj;
            if (sv.getKQKyHocMoiNhat() >= 8) {
                result.add(obj);
            }
        }
        return result;
    }

    public Object getSVDiemHocKyCaoNhat() {
        Object o = new SinhVien("", "", null, 0, 0);

        for (Object obj : dsSV) {
            SinhVien sv = (SinhVien) obj;
            SinhVien sv2 = (SinhVien) o;
            if (sv.getKQKyHocCaoNhat() >= sv2.getKQKyHocCaoNhat()) {
                o = obj;
            }
        }
        if (o.getClass() == SinhVienTaiChuc.class) {
            return (SinhVienTaiChuc) o;
        } else {
            return (SinhVien) o;
        }

    }

    
//    public void sapXepSV(){
//        Collections.sort(dsSV);
//    }

    @Override
    public String toString() {
        System.out.println("Khoa: " + tenKhoa);
        for (Object obj : dsSV) {
            System.out.println(obj);
        }
        return ""; //To change body of generated methods, choose Tools | Templates.
    }

}
