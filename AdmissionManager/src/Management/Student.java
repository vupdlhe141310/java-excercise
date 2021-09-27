/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

/**
 *
 * @author Dell
 */
public class Student {
    private String id;
    private String name;
    private String address;
    private String priority;
    private String group;

    public Student() {
    }

    public Student(String id, String name, String address, String priority, String group) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.priority = priority;
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Thí sinh{"  + id + ", " + name + ", " + address + ", " + priority + ", Khối: " + group + '}';
    }
    
}
