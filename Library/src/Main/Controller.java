/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Object.Book;
import Object.Doc;
import Object.Magazine;
import Object.News;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Controller {

    public List<Object> addBook(List<Object> list, String code, String publisher, int number, String author, int numberOfPage) {
        //list not empty
        if (!list.isEmpty()) {
            for (Object obj : list) {
                try {
                    Doc doc = (Doc) obj;
                    if (doc.getCode().equals(code)) {
                        System.out.println("\nMã tài liệu đã tồn tại!\n");
                        return list;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
        //add
        list.add(new Book(code, publisher, number, author, numberOfPage));
        System.out.println("\nThêm sách '" + code + "' thành công!\n");
        return list;
    }

    public List<Object> addMagazine(List<Object> list, String code, String publish, int number, int publishNumber, int publishMonth) {
        //list not empty
        if (!list.isEmpty()) {
            for (Object obj : list) {
                try {
                    Doc doc = (Doc) obj;
                    if (doc.getCode().equals(code)) {
                        System.out.println("\nMã tài liệu đã tồn tại!\n");
                        return list;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
        //add
        list.add(new Magazine(code, publish, number, publishNumber, publishMonth));
        System.out.println("\nThêm tạp chí '" + code + "' thành công!\n");
        return list;
    }

    public List<Object> addNews(List<Object> list, String code, String publish, int number, Date publishDate) {
        //list not empty
        if (!list.isEmpty()) {
            for (Object obj : list) {
                try {
                    Doc doc = (Doc) obj;
                    if (doc.getCode().equals(code)) {
                        System.out.println("\nMã tài liệu đã tồn tại!\n");
                        return list;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
        //add
        list.add(new News(code, publish, number, publishDate));
        System.out.println("\nThêm báo '" + code + "' thành công!\n");
        return list;
    }

    public List<Object> removeDoc(List<Object> list, String code) {
        if (!list.isEmpty()) {
            System.out.println("\nDanh sách tài liệu trống !\n");
        }
        for (Object obj : list) {
            Doc d = (Doc) obj;
            if (d.getCode().equals(code)) {
                list.remove(obj);
                System.out.println("\nĐã xóa tài liệu mã '" + code + "' \n");
                return list;
            }
        }
        System.out.println("\nKhông tìm thấy tài liệu mã '" + code + "' !\n");
        return list;
    }

    public void searchDoc(List<Object> list, int type) {
        switch (type) {
            case 1:
                System.out.println("-----------------------------------");
                for (Object obj : list) {
                    if (obj.getClass() == Book.class) {
                        Book f = (Book) obj;
                        System.out.println(f);
                    }
                }
                break;
            case 2:
                System.out.println("-----------------------------------");
                for (Object obj : list) {
                    if (obj.getClass() == Book.class) {
                        Magazine f = (Magazine) obj;
                        System.out.println(f);
                    }
                }
                break;
            case 3:
                System.out.println("-----------------------------------");
                for (Object obj : list) {
                    if (obj.getClass() == Book.class) {
                        News f = (News) obj;
                        System.out.println(f);
                    }
                }
                break;
        }
    }

    public void displayDoc(List<Object> list) {
        System.out.println("-----------------------------------");
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
