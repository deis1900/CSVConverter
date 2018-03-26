package model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerCollector {

    private String csvSplitBy = ",";

    public List<Customer> convertStr(List<String> csvRows) {
        if (csvRows == null) {
            System.out.println("Table is not have a data.");
            return null;
        }
        List<Customer> customers = new ArrayList<>();
        csvRows.forEach(row -> {
                Customer customer = new Customer();
                String[] column = row.split(csvSplitBy);
                customer.setId(Long.parseLong(column[0]));
                customer.setFirstName(column[1]);
                customer.setLastName(column[2]);
                customer.setUserName(column[3]);
                customer.setPassword(column[4]);
                customer.setEmail(column[5]);
                customer.setGender(column[6]);
                customer.setPhone(column[7]);
                customer.setAccess(Boolean.parseBoolean(column[8]));
                customer.setImage(column[9]);
                customers.add(customer);
        });
        return customers;
    }
}
