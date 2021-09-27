/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class KetQuaHocTap {
    private String tenHocKy;
    private double diemTbHocKy;

    public KetQuaHocTap(String tenHocKy, double diemTbHocKy) {
        this.tenHocKy = tenHocKy;
        this.diemTbHocKy = diemTbHocKy;
    }

    public KetQuaHocTap() {
    }

    public String getTenHocKy() {
        return tenHocKy;
    }

    public void setTenHocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }

    public double getDiemTbHocKy() {
        return diemTbHocKy;
    }

    public void setDiemTbHocKy(double diemTbHocKy) {
        this.diemTbHocKy = diemTbHocKy;
    }

    
    @Override
    public String toString() {
        return  "Học kỳ: " + tenHocKy + ", Điểm TB: " + diemTbHocKy + '}';
    }
   
}
