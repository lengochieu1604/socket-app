/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doangiuaky.AES;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author PC 21H1 OS 19043.928
 */
public class AES_Server {
    public static final int port_AES = 8002;

    public static String DemKyTu(String str) {
        String thongBao = "";
        int counter[] = new int[256];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            counter[str.charAt(i)]++;
        }
        char array[] = new char[str.length()];
        for (int i = 0; i < len; i++) {
            array[i] = str.charAt(i);
            int flag = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == array[j]) {
                    flag++;
                }
            }
            if (flag == 1) {
                thongBao += "Số lần xuất hiện của " + str.charAt(i) + " trong chuỗi:" + counter[str.charAt(i)] + "\n";
            }
        }
        return thongBao;
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        //KHAI BÁO SOCKET, CỔNG CỦA SERVER 
        ServerSocket socket = new ServerSocket(port_AES);
        System.out.println("Server đang đợi kết nối!");

        while (true) {
            Socket client = socket.accept();
            System.out.println("Đã có client kết nối lên Server!!");

            //KHAI BÁO CÁC ĐỐI TƯỢNG IN VÀ OUT ĐỂ GỬI/LẤY TỪ SOCKET
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());

            //NHẬN DỮ LIỆU TỪ CLIENT
            String encryptedClient = din.readUTF();
            System.out.println("encryptedClient :" + encryptedClient);
            String key = din.readUTF();
            System.out.println("Key :" + key);

            String byteEncryptedClient = din.readUTF();
            System.out.println("byteEncryptedClient  :" + byteEncryptedClient);

            System.out.println("-------------------------------------");
            //XỬ LÝ 
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] byteEncryptedClient1 = cipher.doFinal(byteEncryptedClient.getBytes());
            System.out.println("byteEncryptedClient1 :" + byteEncryptedClient1);
            //System.out.println(new String(byteEncryptedClient1));
//            byte[] byteEncrypted = cipher.doFinal(plainText.getBytes());
//            String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);

            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] byteDecrypted = cipher.doFinal(byteEncryptedClient1);
            String decryptedServer = new String(byteDecrypted);

            System.out.println("decrypted text: " + decryptedServer);

            //GỬI DỮ LIỆU VỀ CLIENT
            dout.writeUTF(decryptedServer);
            dout.writeUTF(DemKyTu(decryptedServer));
            System.out.println(DemKyTu(decryptedServer));
        }
    }
}
