package jdbc.lesson09.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class JDBCConnectionUtil {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер обнаружен");

            Locale.setDefault(Locale.ENGLISH);

            String url = "jdbc:mysql://localhost:3306?useSSL=false";
            String user = "root";
            String pass = "root";

            Connection connection =
                    DriverManager.getConnection(url, user, pass);
            if(connection != null){
                System.out.println("Соединение установлено");
                connection.close();
            }

        }catch (SQLException e){
            System.out.println("Соединение не установлено");
            //e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.println("Драйвер не обнаружен");
        }
    }
}
