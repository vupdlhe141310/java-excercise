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
public class Doc {
    private String code;
    private String publish;
    private int number;

    public Doc(String code, String publish, int number) {
        this.code = code;
        this.publish = publish;
        this.number = number;
    }

    public Doc() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   

    @Override
    public String toString() {
        return code + " | " + publish + " | " + number;
    }
    
    
    
    
}
