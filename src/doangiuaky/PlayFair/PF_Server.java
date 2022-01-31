/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doangiuaky.PlayFair;

import doangiuaky.component.playfairCipherDecryption;
import static doangiuaky.component.playfairCipherDecryption.viTriChuoiCon;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author PC 21H1 OS 19043.928
 */
public class PF_Server {
    
    public static final int port_PF = 8001;
          
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        //KHAI BÁO SOCKET, CỔNG CỦA SERVER 
        ServerSocket socket = new ServerSocket(port_PF);
        System.out.println("Server đang đợi kết nối!");

        while (true) {
            Socket client = socket.accept();
            System.out.println("Đã có client kết nối lên Server!!");

            //KHAI BÁO CÁC ĐỐI TƯỢNG IN VÀ OUT ĐỂ GỬI/LẤY TỪ SOCKET
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());

            //NHẬN DỮ LIỆU TỪ CLIENT
            String keyPlayfair = din.readUTF(); 
            System.out.println("keyPlayfair     :" + keyPlayfair);
            String encryptedClient = din.readUTF(); 
            System.out.println("encryptedClient :" + encryptedClient);
            String subString = din.readUTF();
            System.out.println("-------------------------------------");  
                                    
            playfairCipherDecryption x = new playfairCipherDecryption(); 
            x.setKey(keyPlayfair);
            x.KeyGen();  
            String decryptedServer = x.decryptMessage(encryptedClient);
            System.out.println("decryptedClient :"+decryptedServer);
            
            
            System.out.println("subString              :" + subString);
            String cacViTriChuoiCon = viTriChuoiCon(decryptedServer, subString);
            System.out.println("vi tri subString       :" + cacViTriChuoiCon);
             

            //GỮI DỮ LIỆU LÊN SERVER
            dout.writeUTF(decryptedServer); 
            dout.writeUTF(cacViTriChuoiCon);

        }

    }
}
