package io.endeavourtech.stocks;

import io.endeavourtech.stocks.dao.LookUpDAO;
import io.endeavourtech.stocks.dao.StockFundamentalsDAO;

import io.endeavourtech.stocks.service.MarketAnalyticsService;

public class StockAnalytics
{
    public static void main(String[] args)
    {
        LookUpDAO lookUpDAO = new LookUpDAO();
        StockFundamentalsDAO sfDAO = new StockFundamentalsDAO();
        MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookUpDAO);
        MarketAnalyticsService marketAnalyticsService1= new MarketAnalyticsService(sfDAO);
        marketAnalyticsService.getSectorsOfTheEconomy();
        marketAnalyticsService.getSubSectorsOfTheEconomy();
        marketAnalyticsService1.getStockFundamentalsOfTheEconomy();
    }
}
