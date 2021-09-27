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
public class KhachHang {
    private String hoTen;
    private String soNha;
    private int maCT;

    public KhachHang() {
    }

    public KhachHang(String hoTen, String soNha, int maCT) {
        this.hoTen = hoTen;
        this.soNha = soNha;
        this.maCT = maCT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    
    @Override
    public String toString() {
        return  "Chủ hộ: " + hoTen + ", Số nhà: " + soNha + ", Mã CT: " + maCT;
    }
    
}
