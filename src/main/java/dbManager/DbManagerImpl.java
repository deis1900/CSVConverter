package dbManager;

import model.Customer.Customer;
import model.Product.Product;

import java.sql.*;
import java.util.List;

public class DbManagerImpl implements DbManager {

    private static String driverClass;
    private static String nameDB;
    private Connection connection;

    public DbManagerImpl(String driverClass, String nameDB) {
        DbManagerImpl.driverClass = driverClass;
        DbManagerImpl.nameDB = nameDB;
    }

    private void getConnection() throws SQLException {
        try {
            connection = null;
            Class.forName(driverClass);
            connection = DriverManager.getConnection(nameDB);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e + "Driver class not found.");
        }
    }


    private void createTable(String tableName) throws SQLException {
        Statement statement = connection.createStatement();
        switch (tableName) {
            case "customer":
                statement.execute("DROP TABLE IF EXISTS customer");
                statement.execute("CREATE TABLE if not exists " + tableName + " (" +
                        "id integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                        "firstName text, " +
                        "lastName text, " +
                        "userName text, " +
                        "password text, " +
                        "email text, " +
                        "gender text, " +
                        "phone text, " +
                        "access boolean," +
                        " image text);");
                break;
            case "product":
                statement.execute("DROP TABLE IF EXISTS product");
                statement.execute("CREATE TABLE if not exists " + tableName + " (" +
                        "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        "category TEXT NOT NULL , " +
                        "material TEXT NOT NULL , " +
                        "size TEXT, " +
                        "color TEXT, " +
                        "dateOfLastChange INTEGER NOT NULL, " +
                        "price DOUBLE, " +
                        "image TEXT);");
                break;
            default:
                System.out.println("Incorrect. The table does not exist. ");
                System.exit(0);
        }
    }

    @Override
    public void saveProducts(List<Product> products) throws SQLException {
        getConnection();
        createTable("product");

        String query = "INSERT INTO product (category, material, size, color, dateOfLastChange, price, image)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (Product product : products) {
            int i = 0;
            preparedStatement.setString(++i, product.getCategory());
            preparedStatement.setString(++i, product.getMaterial());
            preparedStatement.setString(++i, product.getSize());
            preparedStatement.setString(++i, product.getColor());
            preparedStatement.setLong(++i, product.getDateOfLastChange());
            preparedStatement.setDouble(++i, product.getPrice());
            preparedStatement.setString(++i, product.getImage());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }

    @Override
    public void saveCustomers(List<Customer> customers) throws SQLException{
        getConnection();
        createTable("customer");
        String query = "INSERT INTO customer (firstName, lastName, userName, password, email, " +
                "gender, phone, access, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        for (Customer customer: customers) {
            int i = 0;
            preparedStatement.setString(++i, customer.getFirstName());
            preparedStatement.setString(++i, customer.getLastName());
            preparedStatement.setString(++i, customer.getUserName());
            preparedStatement.setString(++i, customer.getPassword());
            preparedStatement.setString(++i, customer.getEmail());
            preparedStatement.setString(++i, customer.getGender());
            preparedStatement.setString(++i, customer.getPhone());
            preparedStatement.setBoolean(++i, customer.getAccess());
            preparedStatement.setString(++i, customer.getImage());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.close();
    }

    @Override
    public void findAllFrom(String nameTable) throws SQLException {
        getConnection();
        String query = "SELECT * FROM " + nameTable.toUpperCase() + " ORDER BY 'id' DESC LIMIT 0,100 ;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (nameTable.equals("product")) {
            System.out.println("Table Customers:");
            while (resultSet.next()) {
                System.out.println(new Product(
                        resultSet.getLong("id"),
                        resultSet.getString("category"),
                        resultSet.getString("material"),
                        resultSet.getString("size"),
                        resultSet.getString("color"),
                        resultSet.getString("image"),
                        resultSet.getLong("dateOfLastChange"),
                        resultSet.getDouble("price")).toString());
            }
        } else if (nameTable.equals("customer")) {
            System.out.println("Table Customers:");
            while (resultSet.next()) {
                System.out.println(new Customer(resultSet.getLong("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("userName"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("gender"),
                resultSet.getString("phone"),
                resultSet.getBoolean("access"),
                resultSet.getString("image")).toString());
            }
        }
        System.out.println("The End.");
        connection.close();
    }
}