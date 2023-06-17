package io.endeavourtech.stocks.sorting;

import io.endeavourtech.stocks.vo.StockFundamentalsLookUp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingFun {
    public static void main(String[] args) {
        StockFundamentalsLookUp appleStock = new StockFundamentalsLookUp("AAPL", 15, new BigDecimal("150"), new BigDecimal("4.5"));
        StockFundamentalsLookUp microsoftStock = new StockFundamentalsLookUp("MSFT", 12, new BigDecimal("150"), new BigDecimal("3.7"));
        StockFundamentalsLookUp googleStock = new StockFundamentalsLookUp("GOOGL", 14, new BigDecimal("95"), new BigDecimal("2.5"));
        StockFundamentalsLookUp teslaStock = new StockFundamentalsLookUp("TSLA", 11, new BigDecimal("65"), new BigDecimal("9.5"));

        //Immutable list...can't sort or be changed
        //List<StockFundamentalsLookUp> someSampleImmutableList = List.of(appleStock,microsoftStock,googleStock,teslaStock);

        List<StockFundamentalsLookUp> someSampleList = new ArrayList<>();
        someSampleList.add(googleStock);
        someSampleList.add(microsoftStock);
        someSampleList.add(appleStock);
        someSampleList.add(teslaStock);

        //Iterating a list using forEach lambda function
        someSampleList.forEach(stockFundamentalsLookUp -> {
            System.out.println("Values in List using forEach lambda" + stockFundamentalsLookUp);
        });

        //Iterating a list using functional interface
        someSampleList.forEach(System.out::println);



        someSampleList.sort(Comparator.comparing(StockFundamentalsLookUp::getMarketCap)
                .thenComparing(Comparator.comparing(StockFundamentalsLookUp::getCurrentRatio).reversed())
                .thenComparing(Comparator.comparing(StockFundamentalsLookUp::getTickerSymbol)));
    }
}
