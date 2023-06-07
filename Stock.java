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

}
