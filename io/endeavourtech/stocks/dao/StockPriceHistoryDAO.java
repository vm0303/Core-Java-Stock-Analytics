package io.endeavourtech.stocks.dao;


import io.endeavourtech.stocks.vo.StockPriceHistory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockPriceHistoryDAO extends BaseDao
{
    public List<StockPriceHistory>sphListMethod()
    {
        List<StockPriceHistory> sphLookUpList = new ArrayList<>();
        String sqlQuery =
                        """              
                         SELECT TICKER_SYMBOL, TRADING_DATE , LOW_PRICE, HIGH_PRICE, VOLUME
                         FROM ENDEAVOUR.STOCKS_PRICE_HISTORY sph
                         WHERE
                         EXTRACT (YEAR FROM SPH.TRADING_DATE) = 2022
                         AND
                         EXTRACT (MONTH FROM SPH.TRADING_DATE) = 12
                         AND LOW_PRICE IS NOT NULL
                         AND HIGH_PRICE IS NOT NULL
                         AND VOLUME IS NOT NULL
                        """;

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                StockPriceHistory stockPriceHistory = new StockPriceHistory();
                stockPriceHistory.setSphTickerSymbol(resultSet.getString("TICKER_SYMBOL"));
                stockPriceHistory.setSphDate(resultSet.getDate("TRADING_DATE"));
                stockPriceHistory.setSphHighPrice(resultSet.getBigDecimal("HIGH_PRICE"));
                stockPriceHistory.setSphLowPrice(resultSet.getBigDecimal("LOW_PRICE"));
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
