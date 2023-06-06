public class PassingVariables {

    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", "Apple Inc.");
        appleStock.setMarketCap(2800);
        appleStock.setCurrentRatio(2.86);
        appleStock.printStockDetails();
        playingWithPassingVariables(appleStock, appleStock.getMarketCap());
        appleStock.printStockDetails();

    }

    private static void playingWithPassingVariables(Stock inputStockParameter, long inputMarketCapParameter) {
        System.out.println("Value of the stock name is " + inputStockParameter.getTickerName());
        System.out.println("Stock Ticker Symbol from object is " + inputStockParameter.getTickerSymbol());
        System.out.println("Stock Market Cap from object is " + inputStockParameter.getMarketCap());
        inputStockParameter.setMarketCap(3100);
        System.out.println("Stock Market Cap from method parameter before change is " + inputMarketCapParameter);
        inputMarketCapParameter =3900;
        System.out.println("Stock Market Cap from method parameter AFTER change is " + inputMarketCapParameter);
        inputStockParameter.setMarketCap(4100);
        System.out.println("Stock Market Cap from object AFTER method parameter change is " + inputStockParameter.getMarketCap());


        inputStockParameter = new Stock("MSFT", "Microsoft Corp.");
        inputStockParameter.setCurrentRatio(0.6);
        inputStockParameter.setMarketCap(1058);
        inputStockParameter.printStockDetails();


        Stock appleStock = new Stock("GOOGL", "Alphabet Inc.");
        appleStock.setMarketCap(1700);
        appleStock.setCurrentRatio(1.8);
        appleStock.printStockDetails();

        inputStockParameter = appleStock;
        inputStockParameter.printStockDetails();


    }
}
