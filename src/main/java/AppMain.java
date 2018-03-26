import csvReader.CsvReader;
import dbManager.DbManager;
import dbManager.DbManagerImpl;
import model.Customer.Customer;
import model.Customer.CustomerCollector;
import model.Product.Product;
import model.Product.ProductCollector;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class AppMain {
    public static void main(String... args) {
        // Type DB; input Driver class

        // For database H2 use:
        //  "org.h2.Driver" - driver class
        //  "jdbc:h2:mem:store" - name database

        final String DRIVER_CLASS = "org.sqlite.JDBC";
        final String NAME_DB = "jdbc:sqlite:store.s3db";

        CsvReader csvReader = new CsvReader();
        DbManager dbManager = new DbManagerImpl(DRIVER_CLASS, NAME_DB);

        System.out.println("Enter path to file:");
        Scanner scanner = new Scanner(System.in);

        //   Example for enter:
        //                      /path/path/store/Products.csv
        //                      /path/path/store/Customers.csv
        //   Table header should match the example:
        //                      id category material size color dateoflastchange price image
        //                      id firstname lastname username password email gender phone access image

        String csvFile = scanner.nextLine();

        Map<String, List<String>> models = null;
        try {
            models = csvReader.getModel(csvFile);
        } catch (IOException e) {
            System.out.println("Invalid file path.");
            e.printStackTrace();
            System.exit(1);
        }

        if (models == null) {
            System.out.println(".csv file have incorrect format table.");
            System.exit(0);
        }

        models.forEach((tableName, stringList) -> {
            switch (tableName) {
                case "product":
                    ProductCollector productCollector = new ProductCollector();
                    List<Product> products = productCollector.convertStr(stringList);
                    try {
                        dbManager.saveProducts(products);
                        dbManager.findAllFrom(tableName);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "customer":
                    CustomerCollector customerCollector = new CustomerCollector();
                    List<Customer> customers = customerCollector.convertStr(stringList);
                    try {
                        dbManager.saveCustomers(customers);
                        dbManager.findAllFrom("customer");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println(".csv file have the problem with initialization model.");
                    break;
            }
        });
    }
}
