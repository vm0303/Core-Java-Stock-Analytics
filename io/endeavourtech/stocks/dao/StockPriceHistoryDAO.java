

package io.endeavourtech.stocks.dao;

import io.endeavourtech.stocks.StockException;
import io.endeavourtech.stocks.vo.StockPriceHistory;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StockPriceHistoryDAO extends BaseDao {
    public List<StockPriceHistory> getStockPriceHistory(String tickerSymbol, LocalDate fromDate, LocalDate toDate) {
        List<StockPriceHistory> stocksPriceHistoryList = new ArrayList<>();
        String sqlQuery = """                 	
                SELECT                 		
                sph.TICKER_SYMBOL,                 		
                sph.TRADING_DATE,                 		
                sph.OPEN_PRICE, 
                sph.HIGH_PRICE,                		
                sph.CLOSE_PRICE,                 		
                sph.VOLUME                 	
                FROM ENDEAVOUR.STOCKS_PRICE_HISTORY sph                 	
                WHERE                 		
                sph.TICKER_SYMBOL = ?                 		
                AND sph.TRADING_DATE BETWEEN ? AND ?                 
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, tickerSymbol);
            preparedStatement.setDate(2, Date.valueOf(fromDate));
            preparedStatement.setDate(3, Date.valueOf(toDate));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                StockPriceHistory stocksPriceHistory = new StockPriceHistory(
                        resultSet.getString("TICKER_SYMBOL"),
                        resultSet.getDate("TRADING_DATE").toLocalDate(),
                        resultSet.getBigDecimal("OPEN_PRICE"),
                        resultSet.getBigDecimal("HIGH_PRICE"),
                        resultSet.getBigDecimal("CLOSE_PRICE"),
                        resultSet.getLong("VOLUME"));
                stocksPriceHistoryList.add(stocksPriceHistory);
            }
        } catch (SQLException e) {
            throw new StockException("Unable to fetch Price History Data", e);
        }
        return stocksPriceHistoryList;
    }


}

