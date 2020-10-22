package oleg;

import java.sql.*;

public class Mainsql {

//        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DATABASE_URL = "jdbc:mysql://localhost:3306/itacademia?useUnicode=true&serverTimezone=UTC";

        public static void main(String[] args) throws SQLException {
            Connection connection = null;
            Statement statement = null;

//            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            statement = connection.createStatement();
            String sql= "SELECT * FROM pc";

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                System.out.println(resultSet.getInt("code"));
                System.out.println(resultSet.getString("model"));
            }
            resultSet.close();
            connection.close();
            statement.close();

        }
    }



