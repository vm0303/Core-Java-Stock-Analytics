/**
 * Class that is used to create objects that represent a unique stock in the
 * US Stock Market
 */
public class Stock {

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

    String tickerSymbol; // Instance variables
    String tickerName;
    long marketCap;
    double currentRatio;

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

}
