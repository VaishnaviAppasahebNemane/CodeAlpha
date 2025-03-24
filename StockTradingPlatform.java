package StockTradingPlatform;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StockTradingPlatform {

    // Stock class represents a stock with a ticker and price
    static class Stock {
        private String ticker;
        private double price;

        public Stock(String ticker, double price) {
            this.ticker = ticker;
            this.price = price;
        }

        public String getTicker() {
            return ticker;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Stock{ticker='" + ticker + "', price=" + price + "}";
        }
    }

    // Account class represents the user account, balance, and stock portfolio
    static class Account {
        private String username;
        private double balance;
        private Map<String, Integer> portfolio; // Holds stock ticker and quantity

        public Account(String username, double initialBalance) {
            this.username = username;
            this.balance = initialBalance;
            this.portfolio = new HashMap<>();
        }

        public String getUsername() {
            return username;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        // Buy stock and update balance and portfolio
        public void buyStock(Stock stock, int quantity) {
            double totalCost = stock.getPrice() * quantity;
            if (balance >= totalCost) {
                balance -= totalCost;
                portfolio.put(stock.getTicker(), portfolio.getOrDefault(stock.getTicker(), 0) + quantity);
                System.out.println("Bought " + quantity + " shares of " + stock.getTicker());
            } else {
                System.out.println("Insufficient funds to buy " + quantity + " shares of " + stock.getTicker());
            }
        }

        // Sell stock and update balance and portfolio
        public void sellStock(Stock stock, int quantity) {
            int ownedQuantity = portfolio.getOrDefault(stock.getTicker(), 0);
            if (ownedQuantity >= quantity) {
                portfolio.put(stock.getTicker(), ownedQuantity - quantity);
                double totalRevenue = stock.getPrice() * quantity;
                balance += totalRevenue;
                System.out.println("Sold " + quantity + " shares of " + stock.getTicker());
            } else {
                System.out.println("Insufficient shares to sell " + quantity + " shares of " + stock.getTicker());
            }
        }

        // Print portfolio summary
        public void printPortfolio() {
            System.out.println("Portfolio for " + username);
            portfolio.forEach((ticker, quantity) -> {
                System.out.println(ticker + ": " + quantity + " shares");
            });
            System.out.println("Balance: $" + balance);
        }
    }

    // Main method where the platform logic runs
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account userAccount = new Account("JohnDoe", 10000.00); // Initialize account with $10,000

        Stock apple = new Stock("AAPL", 150.00);
        Stock google = new Stock("GOOGL", 2800.00);

        while (true) {
            System.out.println("\nWelcome to the Stock Trading Platform!");
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Select a stock to buy:");
                    System.out.println("1. Apple (AAPL) - $150.00");
                    System.out.println("2. Google (GOOGL) - $2800.00");
                    System.out.print("Enter choice: ");
                    int buyChoice = scanner.nextInt();
                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    if (buyChoice == 1) {
                        userAccount.buyStock(apple, buyQuantity);
                    } else if (buyChoice == 2) {
                        userAccount.buyStock(google, buyQuantity);
                    }
                    break;

                case 2:
                    System.out.println("Select a stock to sell:");
                    System.out.println("1. Apple (AAPL) - $150.00");
                    System.out.println("2. Google (GOOGL) - $2800.00");
                    System.out.print("Enter choice: ");
                    int sellChoice = scanner.nextInt();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    if (sellChoice == 1) {
                        userAccount.sellStock(apple, sellQuantity);
                    } else if (sellChoice == 2) {
                        userAccount.sellStock(google, sellQuantity);
                    }
                    break;

                case 3:
                    userAccount.printPortfolio();
                    break;

                case 4:
                    System.out.println("Exiting platform...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
