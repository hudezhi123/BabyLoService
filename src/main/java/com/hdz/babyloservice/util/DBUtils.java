package com.hdz.babyloservice.util;

import java.sql.*;

public class DBUtils {

    private static final String BASE_PATH = "src/hdz/com/doc/";

    private static String DriverName = "";
    private static String Url = "";
    private static String UserName = "";
    private static String Password = "";

    // static {
    // Properties jdbc = new Properties();
    // try {
    // InputStream inputStream = new BufferedInputStream(
    // new FileInputStream(new File(BASE_PATH + "")));
    // InputStream inputStream = DBUtils.class.getResourceAsStream("/driver.properties");
    // jdbc.load(inputStream);
    // DriverName = jdbc.getProperty("DriverName");
    // Url = jdbc.getProperty("ConnectUrl");
    // UserName = jdbc.getProperty("UserName");
    // Password = jdbc.getProperty("Password");
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/android_qq?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true",
                "root", "123456");
        } catch (final ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (final SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(Connection conn, Statement sta, ResultSet res) throws SQLException {
        if (res != null) {
            res.close();
            res = null;
        }
        if (sta != null) {
            sta.close();
            sta = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }

}
