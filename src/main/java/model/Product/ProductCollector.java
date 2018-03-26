package model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCollector {

    private String csvSplitBy = ",";

    public List<Product> convertStr(List<String> csvRows) throws NumberFormatException{
        if (csvRows == null) {
            System.out.println("Table is not have a data.");
            return null;
        }
        List<Product> products = new ArrayList<>();
        csvRows.forEach(row -> {
            Product product = new Product();
            String[] column = row.split(csvSplitBy);
            product.setId(Long.parseLong(column[0]));
            product.setCategory(column[1]);
            product.setMaterial(column[2]);
            product.setSize(column[3]);
            product.setColor(column[4]);
            product.setDateOfLastChange(Long.parseLong(column[5]));
            product.setPrice(Double.parseDouble(column[6]));
            product.setImage(column[7]);
            products.add(product);
        });
        return products;
    }
}
