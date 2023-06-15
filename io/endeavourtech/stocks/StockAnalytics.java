package io.endeavourtech.stocks;

import io.endeavourtech.stocks.dao.LookUpDAO;
import io.endeavourtech.stocks.service.MarketAnalyticsService;

public class StockAnalytics
{
    public static void main(String[] args)
    {
        LookUpDAO lookUpDAO = new LookUpDAO();
        MarketAnalyticsService marketAnalyticsService = new MarketAnalyticsService(lookUpDAO);
        marketAnalyticsService.getSectorsOfTheEconomy();
        marketAnalyticsService.getSubSectorsOfTheEconomy();
    }
}
