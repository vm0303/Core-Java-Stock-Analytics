

package io.endeavourtech.stocks.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class StockPriceHistory {
    private String tickerSymbol;
    private LocalDate tradingDate;
    private BigDecimal openPrice;
    private BigDecimal closePrice;
    private long volume;

    public StockPriceHistory(String tickerSymbol, LocalDate tradingDate, BigDecimal openPrice, BigDecimal closePrice, long volume) {
        this.tickerSymbol = tickerSymbol;
        this.tradingDate = tradingDate;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.volume = volume;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public LocalDate getTradingDate() {
        return tradingDate;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public long getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "StocksPriceHistory{" + "tickerSymbol='" + tickerSymbol + '\'' + ", tradingDate=" + tradingDate + ", openPrice=" + openPrice + ", closePrice=" + closePrice + ", volume=" + volume + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPriceHistory that = (StockPriceHistory) o;
        return Objects.equals(tickerSymbol, that.tickerSymbol) && Objects.equals(tradingDate, that.tradingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickerSymbol, tradingDate);
    }
}

