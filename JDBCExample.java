import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample
{
    private static final String jdbcURL ="jdbc:oracle:thin:@//endeavourtech.ddns.net:31963/NE_Srikar";

    private static final String userName ="endeavourapp";

    private static final String password ="rPRLZx2nkuEQ9H5mH9bs77LzM";
    public static void main(String[] args) throws SQLException {
       DriverManager.registerDriver(new OracleDriver()); //Register the Oracle DB driver with the DriverManager in Java.
        Connection dbConnection = DriverManager.getConnection(jdbcURL, userName, password); // Get a connection object to connect to the database.

        getSectorsLookUpInformation(dbConnection);

        getSectorsLookUpInformationByID(dbConnection, 16);

        List<String> tickerList = new ArrayList<>();
        tickerList.add("AAPL");
        tickerList.add("MSFT");
        tickerList.add("GOOGL");
        tickerList.add("TSLA");
        tickerList.add("V");

        getStockFundamentalsForTickers(dbConnection, tickerList);
    }

    private static void getStockFundamentalsForTickers(Connection dbConnection, List<String> tickerList) throws SQLException {
        String questionMarks= "?,".repeat(tickerList.size());
        questionMarks = questionMarks.substring(0, questionMarks.length() - 1);
        String sqlQuery= """
                SELECT
                    TICKER_SYMBOL,
                    MARKET_CAP,
                    CURRENT_RATIO
                FROM
                    ENDEAVOUR.STOCK_FUNDAMENTALS sf
                WHERE
                    sf.TICKER_SYMBOL IN (
                """;
        String finalQuery = sqlQuery + questionMarks + ")";
        PreparedStatement preparedStatement = dbConnection.prepareStatement(finalQuery);
        for (int i = 0; i < tickerList.size(); i++) {
           preparedStatement.setString(i+1, tickerList.get(i));
        }
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next())
        {
            String tickerSymbol =resultSet.getString("TICKER_SYMBOL");
            long marketCap = resultSet.getLong("MARKET_CAP");
            double currentRatio = resultSet.getDouble("CURRENT_RATIO");
            System.out.println("Ticker Symbol: " + tickerSymbol + ", Market Cap: " + marketCap + ", Current Ratio: " + currentRatio);
        }

    }

    private static void getSectorsLookUpInformationByID(Connection dbConnection, int sectorID) throws SQLException {
        String sqlQuery = """
                SELECT
                    SECTOR_ID,
                    SECTOR_NAME
                FROM
                    ENDEAVOUR.SECTOR_LOOKUP sl
                WHERE
                    sl.SECTOR_ID = ?
                                
                """;
        PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, sectorID); //Replaces the question mark in the query with the sectorID value
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            int resultSectorID=resultSet.getInt("SECTOR_ID");
            String sectorName = resultSet.getString("SECTOR_NAME");
            System.out.println("Sector ID: " + resultSectorID + ", Sector Name: " + sectorName);

        }

    }

    private static void getSectorsLookUpInformation(Connection dbConnection) throws SQLException {
        String sqlQuery = """
                SELECT
                    SECTOR_ID,
                    SECTOR_NAME
                FROM
                    ENDEAVOUR.SECTOR_LOOKUP sl
                """;

        PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next())
        {
            int sectorID = resultSet.getInt("SECTOR_ID");
            String sectorName = resultSet.getString("SECTOR_NAME");
            System.out.println("Sector ID is " + sectorID + " and Sector name is " + sectorName);
        }
    }

}

