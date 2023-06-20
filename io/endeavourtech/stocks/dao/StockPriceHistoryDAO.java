package io.endeavourtech.stocks.dao;


import io.endeavourtech.stocks.vo.StockPriceHistory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StockPriceHistoryDAO extends BaseDao
{
    public List<StockPriceHistory>sphListMethod(String tickerSymbol, LocalDate fromDate, LocalDate toDate)
    {
        List<StockPriceHistory> sphLookUpList = new ArrayList<>();
        String sqlQuery =
                        """              
                                        SELECT
                                                    sph.TICKER_SYMBOL,
                                                      sph.TRADING_DATE,
                                                       sph.OPEN_PRICE,
                                                        sph.CLOSE_PRICE,
                                                        sph.VOLUME
                                                        FROM
                                                        	ENDEAVOUR.STOCKS_PRICE_HISTORY sph
                                                        	WHERE
                                                        		sph.TICKER_SYMBOL = ?
                                                        		AND sph.TRADING_DATE BETWEEN ? AND ?
                                                          
                                """;

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, tickerSymbol);
            preparedStatement.setDate(2, Date.valueOf(fromDate));
            preparedStatement.setDate(3, Date.valueOf(toDate));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                StockPriceHistory stockPriceHistory = new StockPriceHistory();
                stockPriceHistory.setSphTickerSymbol(resultSet.getString("TICKER_SYMBOL"));
                stockPriceHistory.setSphDate(resultSet.getDate("TRADING_DATE").toLocalDate());
                stockPriceHistory.setSphHighPrice(resultSet.getBigDecimal("OPEN_PRICE"));
                stockPriceHistory.setSphLowPrice(resultSet.getBigDecimal("CLOSE_PRICE"));
                stockPriceHistory.setSphVolume(resultSet.getBigDecimal("VOLUME"));
                sphLookUpList.add(stockPriceHistory);
            }

        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return sphLookUpList;


    }

}
