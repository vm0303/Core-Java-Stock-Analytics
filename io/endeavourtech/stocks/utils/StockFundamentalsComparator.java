package io.endeavourtech.stocks.utils;

import io.endeavourtech.stocks.vo.StockFundamentalsLookUp;

import java.util.Comparator;

public class StockFundamentalsComparator implements Comparator<StockFundamentalsLookUp>
{

    @Override
    public int compare(StockFundamentalsLookUp o1, StockFundamentalsLookUp o2) {

        return o2.getMarketCap().compareTo(o1.getMarketCap());
    }
}
