/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.List;

/**
 *
 * @author Dell
 */
public class Management {
    public List<Student> addStudent(List<Student> list, String id, String name, String address, String priority, String group){
        if (!list.isEmpty()) {
            for (Object obj : list) {
                try {
                    Student s = (Student) obj;
                    if (s.getId().equals(id)) {
                        System.out.println("\n Số báo danh đã tồn tại!\n");
                        return list;
                    }
                } catch (Exception ex) {
                    throw ex;
                }
            }
        }
        list.add(new Student(id, name, address, priority, group));
        System.out.println("Thêm thí sinh '"+id+"' thành công!");
        return list;
    }
    public  void displayStudent(List<Student> list){
        for (Student student : list) {
            System.out.println(student);
        }
    }
    public void searchStudent(List<Student> list , String id){
        for (Student student : list) {
            if(student.getId().equalsIgnoreCase(id)){
                System.out.println("\n"+student+"\n");
            }
        }
    }
}
