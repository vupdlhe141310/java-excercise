/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.util.Date;

/**
 *
 * @author Dell
 */
public class News extends Doc{
    private Date publishDate;

    public News() {
    }

    public News( String code, String publish, int number, Date publishDate) {
        super(code, publish, number);
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Báo | "+ super.toString()+ " | " + publishDate;
    }
    
    
}
