package io.endeavourtech.stocks.service;

import io.endeavourtech.stocks.dao.LookUpDAO;
import io.endeavourtech.stocks.dao.StockFundamentalsDAO;
import io.endeavourtech.stocks.utils.StockFundamentalsComparator;
import io.endeavourtech.stocks.utils.SubSectorComparator;
import io.endeavourtech.stocks.vo.SectorLookUp;
import io.endeavourtech.stocks.vo.StockFundamentalsLookUp;
import io.endeavourtech.stocks.vo.SubsectorLookUp;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MarketAnalyticsService
{
    private LookUpDAO lookUpDAO;

    private StockFundamentalsDAO stockFundamentalsDAO;



    public MarketAnalyticsService(LookUpDAO lookUpDAO, StockFundamentalsDAO stockFundamentalsDAO) {
        this.lookUpDAO = lookUpDAO;
        this.stockFundamentalsDAO = stockFundamentalsDAO;
    }




    public void getSectorsOfTheEconomy() {
        List<SectorLookUp> allSectorLookUpsList = lookUpDAO.getAllSectorLookUps();
        System.out.println("Number of records in SectorLookup table is " + allSectorLookUpsList.size());
        System.out.println(allSectorLookUpsList);

    }

    public void getSubSectorsOfTheEconomy()
    {
        List<SubsectorLookUp> allSubSectorsLookups = lookUpDAO.getAllSubSectorsLookups();
        System.out.println("Number of records in all SubSectorLookup table is " + allSubSectorsLookups.size());
        System.out.println(allSubSectorsLookups);
        Collections.sort(allSubSectorsLookups); //Sorting based on natural order, which is SubSectorID desc coming from compareto() method in StockFundamentalsLookUp via "Comparable"
        Collections.sort(allSubSectorsLookups, new SubSectorComparator()); //Sorting based on SubSector name Asc coming from compare method from "Comparator"

    }
    public void getTopStocks()
    {
        List<StockFundamentalsLookUp> stockFundamentals = stockFundamentalsDAO.getAllStockFundamentalsLookUp();
        StockFundamentalsLookUp pbtSfLookup = new StockFundamentalsLookUp("PBT", 20, 1160559360, 0.0 );
        System.out.println("Does PBT exist in the list from the database? " + stockFundamentals.contains(pbtSfLookup));
        System.out.println("Number of records in the Stock Fundamentals table is " + stockFundamentals.size());
        System.out.println(stockFundamentals);
        Collections.sort(stockFundamentals);
       // Collections.sort(stockFundamentals, new StockFundamentalsComparator());

        //Anonymous Inner Class - Bad way to write code
        stockFundamentals.sort(new Comparator<StockFundamentalsLookUp>() {
            @Override
            public int compare(StockFundamentalsLookUp o1, StockFundamentalsLookUp o2) {
                if (o1.getMarketCap() == o2.getMarketCap())
                {
                    return 0;
                } else if (o1.getMarketCap() > o2.getMarketCap())
                {
                    return -1;
                }else
                    return 1;
            }
        });
    }



}
