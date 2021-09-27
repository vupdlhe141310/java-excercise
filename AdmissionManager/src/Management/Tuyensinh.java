/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Tuyensinh {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Management m = new Management();
        while (true) {
            System.out.println("==================================="
                    + "1 Thêm mới thí sinh.\n"
                    + "2 Hiện thị thông tin của thí sinh và khối thi của thí sinh.\n"
                    + "3 Tìm kiếm theo số báo danh.\n"
                    + "4 Thoát khỏi chương trình.");
            System.out.print("Chọn chức năng: ");
            int choice = Validation.inputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    System.out.print("Số báo danh: ");
                    String id = Validation.inputString();
                    System.out.print("Họ tên: ");
                    String name = Validation.inputString();
                    System.out.print("Địa chỉ: ");
                    String address = Validation.inputString();
                    System.out.print("Mức ưu tiên: ");
                    String priority = Validation.inputString();
                    System.out.print("Khối: ");
                    String group = Validation.inputString();
                    m.addStudent(list, id, name, address, priority, group);
                    break;
                case 2:
                    m.displayStudent(list);
                    break;
                case 3:
                    System.out.print("Số báo danh: ");
                    id = Validation.inputString();
                    m.searchStudent(list, id);
                    break;
                case 4:
                    return;

            }
        }
    }
}
