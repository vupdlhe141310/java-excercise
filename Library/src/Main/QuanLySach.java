/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Object.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class QuanLySach {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Controller c = new Controller();
        while (true) {
            //Show menu option
            System.out.println("===================================\n"
                    + "1 Thêm mới tài liêu: Sách, tạp chí, báo.\n"
                    + "2 Xoá tài liệu theo mã tài liệu.\n"
                    + "3 Hiện thị thông tin về tài liệu.\n"
                    + "4 Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.\n"
                    + "5 Thoát khỏi chương trình.");
            System.out.print("Chọn chức năng: ");
            int choice = Validation.inputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    System.out.println("1 Thêm sách\n2 Thêm tạp chí\n3 Thêm báo");
                    System.out.print("Chọn loại tài liệu: ");
                    int type = Validation.inputIntLimit(1, 3);

                    System.out.print("Nhập mã tài liệu: ");
                    String code = Validation.inputString();
                    System.out.print("Nhập tên nhà xuất bản: ");
                    String publisher = Validation.inputString();
                    System.out.print("Nhập số bản phát hành: ");
                    int number = Validation.inputIntLimit(1, Integer.MAX_VALUE);

                    switch (type) {
                        case 1:
                            System.out.print("Nhập tên tác giả: ");
                            String author = Validation.inputString();
                            System.out.print("Nhập số trang: ");
                            int numberOfPage = Validation.inputIntLimit(1, Integer.MAX_VALUE);
                            list = c.addBook(list, code, publisher, number, author, numberOfPage);
                            break;
                        case 2:
                            System.out.print("Nhập số phát hành: ");
                            int publishNumber = Validation.inputIntLimit(1, Integer.MAX_VALUE);
                            System.out.print("Nhập tháng phát hành: ");
                            int publishMonth = Validation.inputIntLimit(1, 12);
                            list = c.addMagazine(list, code, publisher, number, publishNumber, publishMonth);
                            break;
                        case 3:
                            System.out.print("Nhập ngày phát hành: ");
                            Date publishDate = Validation.inputDate();
                            list = c.addNews(list, code, publisher, number, publishDate);
                            break;

                    }
                    break;

                case 2:
                    System.out.print("Nhập mã tài liệu: ");
                    code = Validation.inputString();
                    list = c.removeDoc(list, code);
                    break;
                case 3:
                    c.displayDoc(list);
                    break;
                case 4:
                    System.out.println("1 Sách\n2 Tạp chí\n3 Báo");
                    System.out.print("Chọn loại tài liệu: ");
                    type = Validation.inputIntLimit(1, 3);
                    c.searchDoc(list, type);

                    break;
                case 5:
                    return;
            }

        }

    }
}
