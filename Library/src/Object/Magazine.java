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
public class Magazine extends Doc{
    private int publishNumber;
    private int publishMonth;

    public Magazine() {
    }

    public Magazine(String code, String publish, int number,int publishNumber, int publishMonth) {
        super(code, publish, number);
        this.publishNumber = publishNumber;
        this.publishMonth = publishMonth;
    }

    @Override
    public String toString() {
        return "Tạp chí | "+super.toString() + " | " + publishNumber + " | " + publishMonth ;
    }
    
    
    
}
