/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class B2 extends Thread {

    private Thread t;
    private String threadName;
    private int number;

    public B2() {
    }

    public B2(String threadName, int number) {
        this.threadName = threadName;
        this.number = number;
    }

    @Override
    public void run() {
        if (threadName.equalsIgnoreCase("2")) {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("");
        } else {
            System.out.println(number * number);
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        File f = new File("number.txt");
        FileReader fr;

        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            Thread t1 = new Thread(() -> {
                try {
                    while (br.readLine() != null) {
                        int n = Integer.parseInt(br.readLine());
                        if (n % 2 == 0) {
                            B2 t2 = new B2("2", Integer.parseInt(br.readLine()));
                            t2.start();
                        } else {
                            B2 t3 = new B2("3", Integer.parseInt(br.readLine()));
                            t3.start();
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(B2.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            t1.start();
        } catch (Exception ex) {
            Logger.getLogger(B2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
