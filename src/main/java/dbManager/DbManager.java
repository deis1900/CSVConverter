package dbManager;

import model.Customer.Customer;
import model.Product.Product;

import java.sql.SQLException;
import java.util.List;

public interface DbManager {

   void saveProducts (List<Product> products) throws SQLException;

   void saveCustomers (List<Customer> customers) throws SQLException;

   void findAllFrom(String nameDb) throws SQLException;
}
