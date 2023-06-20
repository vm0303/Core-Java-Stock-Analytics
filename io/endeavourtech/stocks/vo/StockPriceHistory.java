package io.endeavourtech.stocks.vo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class StockPriceHistory
{
    private String sphTickerSymbol;
    private LocalDate sphDate;

    private BigDecimal sphHighPrice;

    private BigDecimal sphLowPrice;

    private BigDecimal sphVolume;

    private BigDecimal sphClosePrice;

    public BigDecimal getSphClosePrice() {
        return sphClosePrice;
    }

    public void setSphClosePrice(BigDecimal sphClosePrice) {
        this.sphClosePrice = sphClosePrice;
    }

    public String getSphTickerSymbol() {
        return sphTickerSymbol;
    }

    public void setSphTickerSymbol(String sphTickerSymbol) {
        this.sphTickerSymbol = sphTickerSymbol;
    }

    public LocalDate getSphDate() {
        return sphDate;
    }

    public void setSphDate(LocalDate sphDate) {
        this.sphDate = sphDate;
    }

    public BigDecimal getSphHighPrice() {
        return sphHighPrice;
    }

    public void setSphHighPrice(BigDecimal sphHighPrice) {
        this.sphHighPrice = sphHighPrice;
    }

    public BigDecimal getSphLowPrice() {
        return sphLowPrice;
    }

    public void setSphLowPrice(BigDecimal sphLowPrice) {
        this.sphLowPrice = sphLowPrice;
    }

    public BigDecimal getSphVolume() {
        return sphVolume;
    }

    public void setSphVolume(BigDecimal sphVolume) {
        this.sphVolume = sphVolume;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StockPriceHistory{");
        sb.append("sphTickerSymbol='").append(sphTickerSymbol).append('\'');
        sb.append(", sphDate=").append(sphDate);
        sb.append(", sphLowPrice=").append(sphLowPrice);
        sb.append(", sphHighPrice=").append(sphHighPrice);
        sb.append(", sphVolume=").append(sphVolume);
        sb.append('}');
        return sb.toString();
    }
}
