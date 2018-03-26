package csvReader;

import model.Customer.Customer;
import model.Product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ModIdentifier {

//    Create input validation
    Map<String, List<String>> identityModel(List<String> csvRows) {
        Product product = new Product();
        Customer customer = new Customer();

        String headersTable = csvRows.get(0);
        csvRows.remove(0);

        if (product.toCompare(headersTable.toLowerCase())) {
            Map<String, List<String>> productStr= new HashMap<>();
            productStr.put("product", csvRows);
            return productStr;
        }
        else if (customer.toCompare(headersTable.toLowerCase())){
            Map<String, List<String>> customerStr= new HashMap<>();
            customerStr.put("customer", csvRows);
            return customerStr;
        }
        else return null;
    }
}
