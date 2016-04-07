package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Tools {
	 // ���ݿ����ӵ�ַ
    public static String URL;
     // �û���
     public static String USERNAME;
    // ����
     public static String PASSWORD;
     // mysql��������
     public static String DRIVER;
    //�Զ�����.properties  Ĭ��·��src�ĸ�Ŀ¼����  ��ȡ���ʻ���Դ�ļ� ���С��
     private static ResourceBundle rb = ResourceBundle.getBundle("db-config");
     private Tools() {
     }
 
     // ʹ�þ�̬�������������
     static {
         URL = rb.getString("jdbc.url");
         USERNAME = rb.getString("jdbc.username");
         PASSWORD = rb.getString("jdbc.password");
         DRIVER = rb.getString("jdbc.driver");
         try {
             Class.forName(DRIVER);
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
 
     // ����һ����ȡ���ݿ����ӵķ���
     public static Connection getConnection() {
         Connection conn = null;
         try {
             conn =  (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
         } catch (SQLException e) {
             e.printStackTrace();
             System.out.println("��ȡ����ʧ��");
         }
         return conn;
     }
 
     // �ر����ݿ�����
     public static void close(ResultSet rs, Statement stat, Connection conn) {
         try {
             if (rs != null)
                 rs.close();
             if (stat != null)
                 stat.close();
             if (conn != null)
                 conn.close();
         } catch (SQLException e) {
             e.printStackTrace();
        }
    }
 

}

