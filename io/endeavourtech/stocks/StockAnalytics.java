package io.endeavourtech.stocks;

import io.endeavourtech.stocks.dao.LookUpDAO;
import io.endeavourtech.stocks.dao.StockFundamentalsDAO;

import io.endeavourtech.stocks.dao.StockPriceHistoryDAO;
import io.endeavourtech.stocks.service.MarketAnalyticsService;

public class StockAnalytics
{
    public static void main(String[] args)
    {
        //The try method below is common in the industry. Don't forget
        try
                (
                LookUpDAO lookUpDAO = new LookUpDAO();
                StockFundamentalsDAO sfDAO = new StockFundamentalsDAO();
                StockPriceHistoryDAO sphDAO = new StockPriceHistoryDAO();
                )
        { //try with resources


            MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookUpDAO, sfDAO, sphDAO);
            //marketAnalyticsService.getSectorsOfTheEconomy();
            // marketAnalyticsService.getSubSectorsOfTheEconomy();
           // marketAnalyticsService.getTopStocks();
            //marketAnalyticsService.sphHistory();
           marketAnalyticsService.getHealthCareStocks();
            //marketAnalyticsService.classifyBlueChipsSmallCapStocks();
            marketAnalyticsService.performSectorAnalysis();
            marketAnalyticsService.sectorNameAndNumOfStocks();
        }
        catch (StockException e)
        {
            e.printStackTrace();
        }
    }
}
