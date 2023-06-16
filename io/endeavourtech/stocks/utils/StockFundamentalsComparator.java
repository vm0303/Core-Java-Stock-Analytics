package io.endeavourtech.stocks.utils;

import io.endeavourtech.stocks.vo.StockFundamentalsLookUp;

import java.util.Comparator;

public class StockFundamentalsComparator implements Comparator<StockFundamentalsLookUp>
{

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
}
