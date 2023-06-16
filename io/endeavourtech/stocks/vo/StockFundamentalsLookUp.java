package io.endeavourtech.stocks.vo;

import java.util.Objects;

public class StockFundamentalsLookUp implements Comparable<StockFundamentalsLookUp> {
    private String tickerSymbol;
    private int sectorID;

    private long marketCap;

    private double currentRatio;

    public StockFundamentalsLookUp(String tickerSymbol, int sectorID, long marketCap, double currentRatio) {
        this.tickerSymbol = tickerSymbol;
        this.sectorID = sectorID;
        this.marketCap = marketCap;
        this.currentRatio = currentRatio;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public int getSectorID() {
        return sectorID;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public double getCurrentRatio() {
        return currentRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockFundamentalsLookUp that = (StockFundamentalsLookUp) o;
        return Objects.equals(tickerSymbol, that.tickerSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickerSymbol);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StockFundamentalsLookUp{");
        sb.append("tickerSymbol='").append(tickerSymbol).append('\'');
        sb.append(", sectorID=").append(sectorID);
        sb.append(", marketCap=").append(marketCap);
        sb.append(", currentRatio=").append(currentRatio);
        sb.append('}');
        return sb.toString();
    }


    @Override
    public int compareTo(StockFundamentalsLookUp otherSF) {
        return this.getTickerSymbol().compareTo(otherSF.getTickerSymbol());
    }
}
