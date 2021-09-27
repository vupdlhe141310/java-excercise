/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Validation {

    public static String inputString() {
        //loop until user input correct
        while (true) {
            Scanner sc = new Scanner(System.in);
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static int inputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số trong khoảng [" + min + ", " + max + "]");
                System.out.print("Nhập lại: ");
            }
        }
    }

}
