import java.util.Objects;

/**
 * Class that is used to create objects that represent a unique stock in the
 * US Stock Market
 */
public class Stock {

    static
    {
        System.out.println(" Coming from static block.");
    }
    static String value = "HelloWhatever";
    static String printSomeWords(String someWords)
    {
        System.out.println("Printing some words from static method " + someWords + someWords);
        return someWords + someWords;
    }

    /**
     * Constructor that accepts tickerSymbol and TickerName to create Stock Objects
     * @param outsidetickerSymbol - Ticker Symbol for the Stock object
     * @param outsidetickerName - Ticker Name for the Stock object
     */
    public Stock(String outsidetickerSymbol, String outsidetickerName) {
        this.tickerSymbol = outsidetickerSymbol;
        this.tickerName = outsidetickerName;
    }

    /**
     *  Default constructor
     */
    public Stock() {
    }

    public Stock(String outsidetickerSymbol) {
        this.tickerSymbol = outsidetickerSymbol;
    }

    private String tickerSymbol; // Instance variables
    private String tickerName;
    private long marketCap;
    private double currentRatio;

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String outsideTickerName) {
        this.tickerName = outsideTickerName;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(long outsideMarketCap) {
        this.marketCap = outsideMarketCap;
    }

    public double getCurrentRatio() {
        return currentRatio;
    }

    public void setCurrentRatio(double outsideCurrentRatio) {
        this.currentRatio = outsideCurrentRatio;
    }

    /**
     * Method that evaluates whether a given stock is good or not
     * @return True or False
     */
    public boolean isGoodStock(){ // Instance method
        if (currentRatio> 2.0)
            return true;
        else
            return false;
    }
    public void printStockDetails(){
        System.out.println("TickerSymbol: "+tickerSymbol+", TickerName: "+tickerName+", MarketCap: "+marketCap+"," +
                "currentRatio: "+currentRatio);
    }


    /**
     * This generated code overrides the equal method in Java.lang.Object in order to properly
     * check whether two string values are the same or not.
     * @param otherObj - This variable compares with the "this" keyword to compare and contrast the string values.
     * @return
     */
 /*   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(tickerSymbol, stock.tickerSymbol) && Objects.equals(tickerName, stock.tickerName);
    }*/

    /**
     * This written code also overrides the equal method in Java.lang.Object in order to properly
     * check whether two string values are the same or not.
     * @param otherObj - This variable compares with the "this" keyword to compare and contrast the string values.
     * @return
     */
    @Override
    public boolean equals(Object otherObj) {
        boolean isEqual = false;
        Stock otherStockObj =null;
      if (otherObj instanceof Stock && otherObj != null)
      {
          otherStockObj = (Stock) otherObj;
          if (this.tickerSymbol.equals(otherStockObj.getTickerSymbol()) && this.tickerName.equals(otherStockObj.getTickerName()))
          {
              isEqual =true;
          }

      }

      return isEqual;

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
