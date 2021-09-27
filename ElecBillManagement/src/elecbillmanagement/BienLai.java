/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecbillmanagement;

/**
 *
 * @author Dell
 */
public class BienLai {

    private int csCu;
    private int csMoi;
    private double thanhTien;
    private KhachHang khach;

    public BienLai() {
    }

    private double tinhTien(int csCu, int csMoi) {
        return (double) ((csMoi - csCu) * 5);
    }

    public BienLai(int csCu, int csMoi, KhachHang khach) {
        this.csCu = csCu;
        this.csMoi = csMoi;
        this.thanhTien = tinhTien(csCu, csMoi);
        this.khach = khach;
    }

    public KhachHang getKhach() {
        return khach;
    }

    public void setKhach(KhachHang khach) {
        this.khach = khach;
    }

    
    @Override
    public String toString() {
        System.out.println(khach);
        return "Số cũ: " + csCu + ", Số mới: " + csMoi + ", Thành Tiền: " + thanhTien;
    }

}
