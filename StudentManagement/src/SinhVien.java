
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
public class SinhVien implements Comparable<Object>{
    private String maSV;
    private String hoTen;
    private Date ngaySinh;
    private int namNhapHoc;
    private double diemDauvao;
    private List<KetQuaHocTap> dsKQ = new ArrayList<>();

    public SinhVien() {
    }

    public SinhVien(String maSV, String hoTen, Date ngaySinh, int namNhapHoc, double diemDauvao) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.namNhapHoc = namNhapHoc;
        this.diemDauvao = diemDauvao;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    public double getDiemDauvao() {
        return diemDauvao;
    }

    public void setDiemDauvao(double diemDauvao) {
        this.diemDauvao = diemDauvao;
    }
    

    public void getDsKQ() {
        for (KetQuaHocTap ketQuaHocTap : dsKQ) {
            System.out.println(ketQuaHocTap.toString());
        }
    }

    public void setDsKQ(List<KetQuaHocTap> dsKQ) {
        this.dsKQ = dsKQ;
    }
    
    public void themKQ(KetQuaHocTap kqht){
        this.dsKQ.add(kqht);
    }
    public double getKQKyHoc(String kyHoc){
        for (KetQuaHocTap ketQuaHocTap : dsKQ) {
            if(ketQuaHocTap.getTenHocKy().equalsIgnoreCase(kyHoc)){
                return ketQuaHocTap.getDiemTbHocKy();
            }
        }
        return -1;
    }
    public double getKQKyHocMoiNhat(){
        double result = -1;
        try{
            result = dsKQ.get(dsKQ.size()-1).getDiemTbHocKy();
        }catch(Exception ex){
            
        }
        return result;
    }
    public double getKQKyHocCaoNhat(){
        double result = -1;
        for (KetQuaHocTap ketQuaHocTap : dsKQ) {
            if(ketQuaHocTap.getDiemTbHocKy()>= result){
                result = ketQuaHocTap.getDiemTbHocKy();
            }
        }
        return result;
    }
    
    @Override
    public String toString() {

        return "Mã SV: " + maSV + ", Họ Tên: " + hoTen + ", Ngày sinh: " + ngaySinh + ", Nhập học: " + namNhapHoc + ", Điểm nhập học: " + diemDauvao;

    }

    @Override
    public int compareTo(Object obj) {
        SinhVien sv = (SinhVien) obj;
       return sv.getNamNhapHoc() - this.getNamNhapHoc();
    }
    
    
}
