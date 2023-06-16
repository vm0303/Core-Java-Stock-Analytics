package io.endeavourtech.stocks;

import io.endeavourtech.stocks.dao.LookUpDAO;
import io.endeavourtech.stocks.dao.StockFundamentalsDAO;

import io.endeavourtech.stocks.service.MarketAnalyticsService;

public class StockAnalytics
{
    public static void main(String[] args)
    {
        try(    LookUpDAO lookUpDAO = new LookUpDAO();
                StockFundamentalsDAO sfDAO = new StockFundamentalsDAO()) { //try with resources
            //The try method above is common in the industry. Don't forget

            MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookUpDAO, sfDAO);
           // marketAnalyticsService.getSectorsOfTheEconomy();
            // marketAnalyticsService.getSubSectorsOfTheEconomy();
         marketAnalyticsService.getTopStocks();
        }
        catch (StockException e)
        {
            e.printStackTrace();
        }
    }
}
