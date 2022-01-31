/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doangiuaky.AES.Menu;

import doangiuaky.AES.AES_Server;
import doangiuaky.component.playfairCipherDecryption;
import static doangiuaky.component.playfairCipherDecryption.viTriChuoiCon;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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
public class MainServer {

    final int port_PF = 8001;
    final int port_AES = 8002;

    public static void AES_Server_void(ServerSocket socket) throws IOException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException {
        //KHAI BÁO SOCKET, CỔNG CỦA SERVER  
        System.out.println("                                          Server đang đợi kết nối!");

       // while (true) {
            Socket client = socket.accept();
            System.out.println("                                      Đã có client kết nối lên Server!!");

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
            AES_Server a = new AES_Server();
            dout.writeUTF(a.DemKyTu(decryptedServer));
            System.out.println(a.DemKyTu(decryptedServer)); 
//            dout.writeUTF(DemKyTu(decryptedServer));
//            System.out.println(DemKyTu(decryptedServer));
        //} 
    }

    public static void PF_Server_void(ServerSocket socket) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        //KHAI BÁO SOCKET, CỔNG CỦA SERVER 
//        ServerSocket socket = new ServerSocket(8002);
        System.out.println("                                          Server đang đợi kết nối!");

        //while (true) {
            Socket client = socket.accept();
            System.out.println("                                      Đã có client kết nối lên Server!!");

            //KHAI BÁO CÁC ĐỐI TƯỢNG IN VÀ OUT ĐỂ GỬI/LẤY TỪ SOCKET
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            din = new DataInputStream(client.getInputStream());
            dout = new DataOutputStream(client.getOutputStream());

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
            System.out.println("decryptedClient :" + decryptedServer);

            System.out.println("subString              :" + subString);
            String cacViTriChuoiCon = viTriChuoiCon(decryptedServer, subString);
            System.out.println("vi tri subString       :" + cacViTriChuoiCon);

            //GỮI DỮ LIỆU LÊN SERVER
            dout.writeUTF(decryptedServer);
            dout.writeUTF(cacViTriChuoiCon);

        //}

    }

    public static void UDP_Server_void(String[] args) throws IOException {
        //Khai báo socket Server 
        DatagramSocket server = new DatagramSocket(9001);
        ServerSocket socket2 = new ServerSocket(8002);
        System.out.println("SERVER đang chạy!!!!!!!!!!");
        while (true) {

            //Trao đổi dữ liệu
            //KHAI BÁO PACKET ĐỂ NHẬN DỮ LIỆU
            byte str[] = new byte[256];
            DatagramPacket nhanStr = new DatagramPacket(str, str.length);
            server.receive(nhanStr);

            String s = new String(nhanStr.getData(), 0, nhanStr.getLength());
            String[] mang = s.split(" ");

            //XỬ LÝ
            String max = "";
            int vitri = 0;
            for (int x = 0; x < mang.length; x++) {
                if (mang[x].length() > max.length()) {
                    max = mang[x];
                    vitri = x;
                }
            }

            //Tạo Packet để gửi đi
            byte strMax[] = new byte[256];
            strMax = max.getBytes(); //String -> Bytes
            DatagramPacket guiStrMax = new DatagramPacket(strMax, strMax.length, nhanStr.getAddress(), nhanStr.getPort());
            server.send(guiStrMax);

            byte strViTri[] = new byte[256];
            strViTri = String.valueOf(vitri).getBytes();
            DatagramPacket guiStrViTri = new DatagramPacket(strViTri, strViTri.length, nhanStr.getAddress(), nhanStr.getPort());
            server.send(guiStrViTri);
            System.out.println("viTri :" + guiStrViTri);
        }
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

        while (true) {
            ServerSocket socket = new ServerSocket(8888);
            Socket client = socket.accept();
            System.out.println("                                                     Đã có client kết nối lên Server!!");
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            String s = din.readUTF();
            switch (s) {
                case "1": {
                    System.out.println("                                             flag 1:" + s); 
                    ServerSocket socket1 = new ServerSocket(8001);
                    PF_Server_void(socket1);
                    
//                    ServerSocket socket2 = new ServerSocket(8002);
//                    AES_Server_void(socket2); 
                }
                break;
                case "2": {
                    System.out.println("                                             flag 2:" + s); 
                    ServerSocket socket2 = new ServerSocket(8002);
                    AES_Server_void(socket2);
                }
                break;
                default: {
                }
                break;
            }
            socket.close();
        }

//        while (true) {
//            ServerSocket socket = new ServerSocket(8888);
//            Socket client = socket.accept();
//            System.out.println("                                                     Đã có client kết nối lên Server!!");
//            DataInputStream din = new DataInputStream(client.getInputStream());
//            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
//            String s = din.readUTF();
//            switch (s) {
//                case "1": {
//                    System.out.println("                                             flag 1:" + s);
//                    //**************************************************************
//                    ServerSocket socket1 = new ServerSocket(8001);  
//                    PF_Server_void(socket1);
//                    socket1.close();
//                    //**************************************************************  
//                }
//                break;
//                case "2": {
//                    System.out.println("                                             flag 2:" + s);
//                    //**************************************************************
//                    ServerSocket socket2 = new ServerSocket(8002);  
//                    AES_Server_void(socket2);
//                    socket2.close();
//                    //************************************************************** 
//                }
//                break;
//                default: {
//                }
//                break;
//            }
//            socket.close();
//        }
    }
}
