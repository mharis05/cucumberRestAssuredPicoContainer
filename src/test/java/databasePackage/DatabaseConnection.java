package databasePackage;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DatabaseConnection {

    private String dbUser = "app_user";
    private String dbPassword = "59c66f84104ced45525abda5528796248235e06b1d1b064a8d0e5cbc08299b4c";
    private ResultSet myResultset = null;
    private String dbConnectionString = "jdbc:mysql://10.4.10.105:3306/ecommerce_app";
    private Connection myConn;

    public void initConnection(String dbUser, String dbPassword, String connectionString) throws ClassNotFoundException, SQLException {
        myConn = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        Class.forName("com.mysql.jdbc.Driver");
    }


    public DatabaseConnection() throws SQLException, ClassNotFoundException {
        initConnection(this.dbUser,this.dbPassword,this.dbConnectionString);
    }

    public ResultSet execute(String query) throws SQLException, ClassNotFoundException {


        Statement myStatement = myConn.createStatement();
        myResultset = myStatement.executeQuery(query);

        return myResultset;
    }

    public void closeConnection() throws SQLException {

        myConn.close();

    }
}
