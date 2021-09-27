/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Dell
 */
public class Book extends  Doc{
    private String author;
    private int numberOfPage;

    public Book() {
    }

    
    public Book(String code, String publish, int number,String author, int numberOfPage) {
        super(code, publish, number);
        this.author = author;
        this.numberOfPage = numberOfPage;
    }

    @Override
    public String toString() {
        return "Sách | "+super.toString()+" | "+ author + " | " + numberOfPage ;
    }
    
    
    
}
