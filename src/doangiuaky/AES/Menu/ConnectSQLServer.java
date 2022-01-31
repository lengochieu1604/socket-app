/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doangiuaky.AES.Menu;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;

/**
 *
 * @author PC 21H1 OS 19043.928
 */
public class ConnectSQLServer {

    Connection cn = null;

    public Connection getConnectBD() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=KIEMTRALTM";;
            String user = "sa";
            String pass = "123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Kết nối DB thành công!");
        } catch (Exception e) {
            System.out.println("Không thể kết nối được!!!");
        }
        return cn;
    }

    public static void main(String[] args) {  
    }
}

//    public static void main(String[] args){
//        var sqlServer = "DESKTOP-U7RA1GN";
//        var username = "sa";
//        var password = "123456";
//        var db = "SOCKET_DOANGIUAKY";
//        var port = 1433;  
//        SQLServerDataSource ds = new SQLServerDataSource();
//        ds.setUser(username);
//        ds.setPassword(password);
//        ds.setDatabaseName(db);
//        ds.setServerName(sqlServer);
//        ds.setPortNumber(port);
//        try(Connection conn = ds.getConnection()){
//            System.out.println("Kết nối SQL Server thành công!");
//            System.out.println(conn.getCatalog());
//            
//        }catch(SQLException ex){
//            ex.printStackTrace();
//        }
//    }
//}
