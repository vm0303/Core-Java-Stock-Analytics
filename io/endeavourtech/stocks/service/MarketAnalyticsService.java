package io.endeavourtech.stocks.service;

import io.endeavourtech.stocks.dao.LookUpDAO;
import io.endeavourtech.stocks.dao.StockFundamentalsDAO;
import io.endeavourtech.stocks.dao.StockPriceHistoryDAO;
import io.endeavourtech.stocks.utils.SubSectorComparator;
import io.endeavourtech.stocks.vo.SectorLookUp;
import io.endeavourtech.stocks.vo.StockFundamentalsLookUp;
import io.endeavourtech.stocks.vo.StockPriceHistory;
import io.endeavourtech.stocks.vo.SubsectorLookUp;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MarketAnalyticsService
{
    private LookUpDAO lookUpDAO;

    private StockFundamentalsDAO stockFundamentalsDAO;

    private StockPriceHistoryDAO stockPriceHistoryDAO;



    public MarketAnalyticsService(LookUpDAO lookUpDAO, StockFundamentalsDAO stockFundamentalsDAO, StockPriceHistoryDAO sphDAO) {
        this.lookUpDAO = lookUpDAO;
        this.stockFundamentalsDAO = stockFundamentalsDAO;
        this.stockPriceHistoryDAO =sphDAO;
    }




    public void getSectorsOfTheEconomy() {
        List<SectorLookUp> allSectorLookUpsList = lookUpDAO.getAllSectorLookUps();
        System.out.println("Number of records in SectorLookup table is " + allSectorLookUpsList.size());
        System.out.println(allSectorLookUpsList);
        //Sort using Lambda function
//         allSectorLookUpsList.sort((o1, o2) -> {
//            return o1.getSectorName().compareTo(o2.getSectorName());
//        });

        //Sort using Functional Interfaces
//        allSectorLookUpsList.sort(Comparator.comparing(SectorLookUp::getSectorName));

        //Another way
        allSectorLookUpsList.sort(
                Comparator.comparing(SectorLookUp::getSectorName)
                        .thenComparing(SectorLookUp::getSectorID)
        );

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
        StockFundamentalsLookUp pbtSfLookup = new StockFundamentalsLookUp("PBT", 20, new BigDecimal(1160559360), new BigDecimal(0.0) );
        System.out.println("Does PBT exist in the list from the database? " + stockFundamentals.contains(pbtSfLookup));
        System.out.println("Number of records in the Stock Fundamentals table is " + stockFundamentals.size());
        //System.out.println(stockFundamentals);
        Collections.sort(stockFundamentals);
       // Collections.sort(stockFundamentals, new StockFundamentalsComparator());

        //Anonymous Inner Class - Bad way to write code
        /*stockFundamentals.sort(new Comparator<StockFundamentalsLookUp>() {
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



        });*/
//        //Using lambda functions
//        stockFundamentals.sort((o1, o2) -> {
//            if (o1.getMarketCap() == o2.getMarketCap())
//            {
//                return 0;
//            } else if (o1.getMarketCap() > o2.getMarketCap())
//            {
//                return -1;
//            }else
//                return 1;
//        });


        StockFundamentalsLookUp dummyAppleStock = new StockFundamentalsLookUp("SAAPLE", 13, new BigDecimal("2729798795265"), new BigDecimal("7.5"));
        stockFundamentals.add(dummyAppleStock);

        //Using functional interfaces
        stockFundamentals.sort(
                Comparator.comparing(StockFundamentalsLookUp::getMarketCap).reversed()
                .thenComparing(Comparator.comparing(StockFundamentalsLookUp::getTickerSymbol).reversed())
        );
    }

    public void sphHistory() {
        List<StockPriceHistory> stockPriceHistories = stockPriceHistoryDAO.sphListMethod();
        System.out.println("Number of records in the Stock Fundamentals table dating to Dec 2022 is " + stockPriceHistories.size());
        System.out.println(stockPriceHistories);

        //Sort by Ticker symbol DESC
       stockPriceHistories.sort(new Comparator<StockPriceHistory>() {
           /**
            * Establishes an order (Ticker symbol descending) for sorting 2 object of the type Stock Price History
            * @param o1 the first object to be compared.
            * @param o2 the second object to be compared.
            * @return the compared objects via the compare() method
            */
           @Override
           public int compare(StockPriceHistory o1, StockPriceHistory o2) {
               return o2.getSphTickerSymbol().compareTo(o1.getSphTickerSymbol());

           }



       });

        //Sort by Low price ASC
        stockPriceHistories.sort(new Comparator<StockPriceHistory>() {
            /**
             * Establishes an order (Low Price Ascending) for sorting 2 object of the type Stock Price History
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return the compared objects via the compare() method
             */
            @Override
            public int compare(StockPriceHistory o1, StockPriceHistory o2) {

                return o1.getSphLowPrice().compareTo(o2.getSphLowPrice());

            }



        });

        //Sort by High Price DESC
        stockPriceHistories.sort(new Comparator<StockPriceHistory>() {
            /**
             * Establishes an order (High Price Descending) for sorting 2 object of the type Stock Price History
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return the compared objects via the compare() method
             */
            @Override
            public int compare(StockPriceHistory o1, StockPriceHistory o2) {
                return o2.getSphHighPrice().compareTo(o1.getSphHighPrice());

            }


        });

        //Sort by Volume DESC
        stockPriceHistories.sort(new Comparator<StockPriceHistory>() {
            /**
             * Establishes an order (Volume Descending) for sorting 2 object of the type Stock Price History
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return the compared objects via the compare() method
             */
            @Override
            public int compare(StockPriceHistory o1, StockPriceHistory o2) {
                return o2.getSphVolume().compareTo(o1.getSphVolume());

            }


        });

        // Sort by Close_Price DESC
        stockPriceHistories.sort(new Comparator<StockPriceHistory>() {
            /**
             * Establishes an order (Close Price DESC) for sorting 2 object of the type Stock Price History
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return the compared objects via the compare() method
             */
            @Override
            public int compare(StockPriceHistory o1, StockPriceHistory o2) {
                return o2.getSphClosePrice().compareTo(o1.getSphClosePrice());

            }


        });

        // Sort by Date DESC
        stockPriceHistories.sort(new Comparator<StockPriceHistory>() {
            /**
             * Establishes an order (Date Descending) for sorting 2 object of the type Stock Price History
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return the compared objects via the compare() method
             */
            @Override
            public int compare(StockPriceHistory o1, StockPriceHistory o2) {
                return o2.getSphDate().compareTo(o1.getSphDate());

            }


        });


    }
}
