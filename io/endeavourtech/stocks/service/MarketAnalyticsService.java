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
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
      // Collections.sort(stockFundamentals);
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
        //Use NullsFirst if you want null to be the lowest value in the list
        //Use NullsLast in you want null to be the highest value in the list
        stockFundamentals.sort(
                Comparator.comparing(StockFundamentalsLookUp::getMarketCap, Comparator.nullsFirst(BigDecimal::compareTo))
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

    //Normal way
    public void getHealthCareStocks()
    {
        List<StockFundamentalsLookUp> allStockFundamentalsLookUpList = stockFundamentalsDAO.getAllStockFundamentalsLookUp();

        //Get healthcare stocks the old-fashioned way.
       allStockFundamentalsLookUpList.forEach(stockFundamentalsLookUp -> {
           if (stockFundamentalsLookUp.getSectorID() ==10)
           {
               System.out.println(stockFundamentalsLookUp);
           }

       });

       //Using Stream to get Healthcare stocks using Streams

        List<StockFundamentalsLookUp> healthCareList = allStockFundamentalsLookUpList.stream()
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getSectorID() == 10) //Intermediate function to filter in only Stocks w/ sectorID 10
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap() != null)
//                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getCurrentRatio() != null) // used to filter and remove any current ratio values that are null
                .sorted(
                        Comparator.comparing(StockFundamentalsLookUp::getMarketCap, Comparator.nullsLast(BigDecimal::compareTo)).reversed()
                                .thenComparing(StockFundamentalsLookUp::getCurrentRatio, Comparator.nullsFirst(BigDecimal::compareTo)))



                .collect(Collectors.toList()); //Terminal function to return  a list of objects that was filtered out the by the intermediate function


        long healthCareStocksCount = allStockFundamentalsLookUpList.stream()
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getSectorID() == 10)
                .count();
        System.out.println("Number of Healthcare stocks is " + healthCareStocksCount);


        // Generate a list of Healthcare Ticker Symbols
        List<String> healthCareTickersList = allStockFundamentalsLookUpList.stream()
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getSectorID() == 10)
                //Note: DO NOT confuse Map Collection and .map stream. Both work in different ways.
                .sorted(Comparator.comparing(StockFundamentalsLookUp::getTickerSymbol).reversed())
                .map(stockFundamentalsLookUp -> stockFundamentalsLookUp.getTickerSymbol())//Map intermediate function transform the map
                .collect(Collectors.toList());
        System.out.println(healthCareTickersList);

    //Calculate total market cap for all health care stocks
        BigDecimal totalMarketCap = BigDecimal.ZERO;
     /*   healthCareList.forEach(stockFundamentalsLookUp -> {
          //  BigDecimal totalMarketCap = BigDecimal.ZERO; //putting this statement here won't work....Google why

        });*/

        for (StockFundamentalsLookUp fundamentalsLookUp : healthCareList) {
            totalMarketCap =totalMarketCap.add(fundamentalsLookUp.getMarketCap());
        }
        System.out.println("Total Healthcare Market Cap is " + totalMarketCap);


        //Calculate total Market cap for health care stocks using Streams
        Optional<BigDecimal> totalMarketCapOptional = healthCareList.stream()
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap() != null)
                .map(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap())
//                .reduce((b1, b2) -> b1.add(b2)); //using lambda
                .reduce(BigDecimal::add); //using functional interface
        if(totalMarketCapOptional.isPresent())
        {
            System.out.println("Total health care market cap using reduce is " + totalMarketCapOptional.get());
        }



    }

    public void classifyBlueChipsSmallCapStocks()
    {
        List<StockFundamentalsLookUp> blueChipsLookUp = stockFundamentalsDAO.getAllStockFundamentalsLookUp();
        List<StockFundamentalsLookUp> smallCapLookUp = stockFundamentalsDAO.getAllStockFundamentalsLookUp();


        //Getting the BlueChips list
        List<StockFundamentalsLookUp> blueChipsList = blueChipsLookUp.stream()
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap() != null && stockFundamentalsLookUp.getMarketCap()
                        .compareTo(new BigDecimal("100000000000")) >= 0)
                .collect(Collectors.toList());

        System.out.println("Number of Blue chip stocks in the US are " +blueChipsList.size());

        //Getting ticker symbol
        List<String> blueChipTickersList = blueChipsList.stream()
                .map(stockFundamentalsLookUp -> stockFundamentalsLookUp.getTickerSymbol())
                .collect(Collectors.toList());
        System.out.println(blueChipTickersList);

        Optional<BigDecimal> blueChipTotalMarketStock = blueChipsList.stream()
                .map(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap())
                .reduce(BigDecimal::add);
        blueChipTotalMarketStock.ifPresent(s-> System.out.println("Total Market cap for Blue Chips stocks is " + s));


        List<StockFundamentalsLookUp> smallCapList = smallCapLookUp.stream()
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap() != null)
                .filter(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap()
                        .compareTo(new BigDecimal("10000000000")) <= 0 && stockFundamentalsLookUp.getMarketCap()
                        .compareTo(new BigDecimal("250000000")) > 0)
                .collect(Collectors.toList());

        System.out.println("Number of small cap stocks in the US are " +smallCapList.size());


        List<String> smallCapTickersList = smallCapList.stream()
                .map(stockFundamentalsLookUp -> stockFundamentalsLookUp.getTickerSymbol())
                .collect(Collectors.toList());
        System.out.println(smallCapTickersList);

        Optional<BigDecimal> smallCapTotalMarketStocks = smallCapList.stream()
                .map(stockFundamentalsLookUp -> stockFundamentalsLookUp.getMarketCap())
                .reduce(BigDecimal::add);
        smallCapTotalMarketStocks.ifPresent(s-> System.out.println("Total market cap for small chip stocks is " + s));


        //1. Create two different lists for Bluechips and SmallCap stocks
        //2. Get tickerSymbol list for BlueChips and Small Cap Stocks
        //3. Calculate total MarketCap for BlueChips and Small cap stocks.
    }

    public void performSectorAnalysis()
    {
        List<StockFundamentalsLookUp> allStockFundamentalsLookUp = stockFundamentalsDAO.getAllStockFundamentalsLookUp();

        Map<Integer, List<StockFundamentalsLookUp>> sectorIDByMap = allStockFundamentalsLookUp.stream()
//                .collect(Collectors.groupingBy(stockFundamentalsLookUp -> stockFundamentalsLookUp.getSectorID()));
        .collect(Collectors.groupingBy(StockFundamentalsLookUp::getSectorID));

        System.out.println(sectorIDByMap);
    }


    /*
    "Print sector names and number of stocks in each sector:
    Healthcare: 510
    Basic Materials: 108
    Financial Services: 486
    Industrials: 391
    Technology: 368
    ...
    Sector lookup data is available from the lookupsDao
    Stock fundamentals data is available from the stockFundamentsDao"
     */

    public void sectorNameAndNumOfStocks()
    {
        List<SectorLookUp> sectorNameList = lookUpDAO.getAllSectorLookUps();
        List <StockFundamentalsLookUp> numOfStocksList = stockFundamentalsDAO.getAllStockFundamentalsLookUp();
        Map<Integer, List<StockFundamentalsLookUp>> sectorIDByMap = numOfStocksList.stream().collect(Collectors.groupingBy(StockFundamentalsLookUp::getSectorID));

        sectorNameList
                .forEach(sectorLookUp -> {
                    int numOfStocksBySector = sectorIDByMap.containsKey(sectorLookUp.getSectorID()) ? sectorIDByMap.get(sectorLookUp.getSectorID()).size() : 0;
                    System.out.println(sectorLookUp.getSectorName() + ": " + numOfStocksBySector);
                });

        }


    }

