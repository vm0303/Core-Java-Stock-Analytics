package io.endeavourtech.stocks.dao;

import io.endeavourtech.stocks.vo.StockFundamentalsLookUp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockFundamentalsDAO extends BaseDao {

    /**
     * This method executes the given SQL query in order to return the values we want from the Stock Fundamentals table
     * @return list of the given values from the Stock Fundamentals table
     */
    public List<StockFundamentalsLookUp> getAllStockFundamentalsLookUp()
    {
        List<StockFundamentalsLookUp> sfLookUpList = new ArrayList<>();
        String sqlQuery =
                """
                SELECT 
                    sf.TICKER_SYMBOL, sf.SECTOR_ID, sf.MARKET_CAP, sf.CURRENT_RATIO      
                FROM
                    ENDEAVOUR.STOCK_FUNDAMENTALS sf   
                """;

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                StockFundamentalsLookUp stockFundamentalsLookUp = new StockFundamentalsLookUp(
                        resultSet.getString("TICKER_SYMBOL"),
                        resultSet.getInt("SECTOR_ID"),
                        resultSet.getBigDecimal("MARKET_CAP"),
                        resultSet.getBigDecimal("CURRENT_RATIO")
                );
                sfLookUpList.add(stockFundamentalsLookUp);
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return sfLookUpList;


    }
}
