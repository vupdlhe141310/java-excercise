/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                System.err.println("Không được để trống!");
                System.out.print("Nhập lại: ");
            } else {
                return result;
            }
        }
    }

    public static double inputDouble() {
        //loop until user input correct
        while (true) {
            Scanner sc = new Scanner(System.in);
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result<0 || result>10) {
                    System.err.println("Vui lòng nhập số nguyên dương <=10!");
                    System.out.print("Nhập lại: ");
                } else {
                    return result;
                }
            }catch(Exception e){
                System.err.println("Vui lòng nhập số nguyên dương <=10!");
                System.out.print("Nhập lại: ");
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
    public static Date inputDate() {
        //loop until user input correct
        while (true) {
            Scanner sc = new Scanner(System.in);
            String result = sc.nextLine().trim();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                df.parse(result);
                return df.parse(result);
            } catch (ParseException e) {
                System.err.println("Vui lòng nhập ngày theo định dạng dd/MM/yyyy VD: 31/12/2021");
                System.out.print("Nhập lại: ");
            }
        }
    }
}
