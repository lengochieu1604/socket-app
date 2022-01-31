/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doangiuaky.component;

/**
 *
 * @author PC 21H1 OS 19043.928
 */
public class temp {

    public static void main(String[] args) {
        System.out.println("------------------------------------11");
        //byte to string
        byte[] b = {
            'g', 'p', 'c', 'o', 'd', 'e', 'r'
        };
        String str1 = new String(b);
        System.out.println(str1);
        //string to byte 
        byte[] b1=str1.getBytes();
        System.out.println(b1);
        
        //byte to string
        System.out.println("------------------------------------22");
        String str2 = new String(b1);
        System.out.println(str2);
        //String to Byte
        System.out.println(str2.getBytes());  
        
        System.out.println("------------------------------------33");
        byte[] b2=str1.getBytes();
        System.out.println(b2);
        System.out.println(new String(b2));
    }
}
