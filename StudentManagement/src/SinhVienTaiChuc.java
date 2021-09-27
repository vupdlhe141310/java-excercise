
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
public class SinhVienTaiChuc extends SinhVien implements Comparable<Object>{
    private String noiLKDaoTao;

    public SinhVienTaiChuc() {
    }

    public SinhVienTaiChuc(String maSV, String hoTen, Date ngaySinh, int namNhapHoc, double diemDauvao,String noiLKDaoTao) {
        super(maSV, hoTen, ngaySinh, namNhapHoc, diemDauvao);
        this.noiLKDaoTao = noiLKDaoTao;
    }

    @Override
    public String toString() {
        return super.toString() +", Nơi LK đào tạo: "+noiLKDaoTao;
    }
    
    
}
