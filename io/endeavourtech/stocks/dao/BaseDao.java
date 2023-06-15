package io.endeavourtech.stocks.dao;

import io.endeavourtech.stocks.StockException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao implements AutoCloseable{
    protected static final String JDBC_URL = "jdbc:oracle:thin:@//endeavourtech.ddns.net:31963/NE_Srikar";
    protected static final String USERNAME = "endeavourapp";
    protected static final String PASSWORD = "rPRLZx2nkuEQ9H5mH9bs77LzM";
    protected final Connection connection;

    public BaseDao(){
        System.out.println("Initializing database connection");
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            this.connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new StockException("Could not obtain database connection", e);
        }
    }

    @Override
    public void close() throws StockException {
        if(connection != null){
            System.out.println("Closing Connection");
            try{
                connection.close();
            }catch (SQLException e){
                throw new StockException("Error closing connection", e);
            }
        }
    }
}