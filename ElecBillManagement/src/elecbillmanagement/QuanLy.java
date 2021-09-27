/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecbillmanagement;

import java.util.List;

/**
 *
 * @author Dell
 */
public class QuanLy {

    public int timBLBangMaCT(List<BienLai> list, int maCT) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKhach().getMaCT()==maCT) {
                return i;
            }
        }
        return -1;
    }

    public int timKhachHangBangMaCT(List<KhachHang> list, int maCT) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaCT()==maCT) {
                return i;
            }
        }
        return -1;
    }

    public List<KhachHang> themKhachHang(List<KhachHang> list, String hoTen, String soNha, int maCT) {
        for (KhachHang khachHang : list) {
            if (khachHang.getMaCT() == maCT ) {
                System.out.println("\nSố công tơ bị trùng!\n");
                return list;
            }
        }

        list.add(new KhachHang(hoTen, soNha, maCT));
        System.out.println("\nĐã thêm khách '" + hoTen + "' !\n");
        return list;
    }

    public void suaKhach(List<KhachHang> listKH, List<BienLai> listBL, int maCTcu, String hoTen, String soNha, int maCTmoi) {
        //lay vi tri khach trong list
        int index = timKhachHangBangMaCT(listKH, maCTcu);
        if (index != -1) {
            //check  so ct ton tai chưa
            for (KhachHang khachHang : listKH) {
                if (khachHang.getMaCT() == maCTmoi && maCTcu!=maCTmoi) {
                    System.out.println("\nMã công tơ bị trùng!\n");
                    return ;
                }
            }
        }
        //cap nhat
        KhachHang khMoi= new KhachHang(hoTen, soNha, maCTmoi);
        //list Khách
        listKH.remove(index);
        listKH.add(khMoi);
        //list Bien lai
        for (BienLai bienlai : listBL) {
            if(bienlai.getKhach().getMaCT() == maCTcu){
                bienlai.setKhach(khMoi);
            }
        }
        System.out.println("\nĐã sửa thông tin cho khách '" + hoTen + "' !\n");
    }

    public List<BienLai> themBienLai(List<BienLai> list, int csCu, int csMoi, KhachHang khach) {
        list.add(new BienLai(csCu, csMoi, khach));
        System.out.println("\nĐã thêm Biên Lai cho khách '" + khach.getHoTen() + "' !\n");
        return list;
    }

    public List<BienLai> suaBienLai(List<BienLai> list, int index, KhachHang khach) {

        //cap nhat
        list.get(index).setKhach(khach);
        System.out.println("\nĐã sửa thông tin cho khách '" + khach.getHoTen() + "' !\n");
        return list;
    }
}
