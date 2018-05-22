package ch.acme.util;

import java.sql.*;

public class CheckDBConnection {

    private static final String mssqlQuery = "SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE";
    private static final String mysqlQuery = "show tables";
    private static final String oracleQuery = "select table_name from all_tables";

    public static void main(String[] args) {
        String jdbcUrl = args[0];
        String dbUser = args[1];
        String password = args[2];

        System.out.println("-------- JDBC Connection Testing ------");

        String query = findJDBCDriverInLib();

        Connection connection = openConnection(jdbcUrl, dbUser, password);

        showResultSet(loadAllTable(connection, query));

    }

    private static String findJDBCDriverInLib() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver found!");
            return oracleQuery;
        } catch (ClassNotFoundException ignored) {
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Microsoft SQL JDBC Driver found");
            return mssqlQuery;
        } catch (ClassNotFoundException ignored) {
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MYSQL JDBC Driver found");
            return mysqlQuery;
        } catch (ClassNotFoundException ignored) {
        }
        System.out.println("No JDBC Driver found");
        return null;
    }

    private static Connection openConnection(String jdbcUrl, String dbUser, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl, dbUser, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Opened Connection successful");
        } else {
            System.out.println("Failed to make connection!");
        }
        return conn;
    }

    private static ResultSet loadAllTable(Connection conn, String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("ERROR: Can not create Statement on open Connection");
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery(query);
            System.out.println("Execute Query successful, query: "+query);
        } catch (SQLException e) {
            System.out.println("ERROR: Can not execute Query: " + query);
            e.printStackTrace();
        }
        return rs;
    }

    private static void showResultSet(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("ERROR: Can not read Result from ResultSet");
            e.printStackTrace();
        }
    }
}
