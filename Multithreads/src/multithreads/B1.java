/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.MathContext;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class B1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        File f = new File("number.txt");
        
        
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(B1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                FileWriter fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write((new Random().nextInt(90)+10)+"");
            } catch (IOException ex) {
                Logger.getLogger(B1.class.getName()).log(Level.SEVERE, null, ex);
            }
            int count =0;
            while(count <500){
                
                try {
                    FileWriter fw = new FileWriter(f, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("\n"+(new Random().nextInt(500)+1));
                    bw.close();
                    
                } catch (IOException ex) {
                    System.out.println("Loi ghi file: " + ex);
                }
                count ++;
            }
        });

        t1.start();

    }

}
