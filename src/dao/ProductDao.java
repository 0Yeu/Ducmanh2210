package dao;

import connect.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDao {

        public List<Product> getAllProducts() throws SQLException {
                List<Product> products = new ArrayList<Product>();

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Products";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        Product product = new Product();

                        product.setId(rs.getInt("Id"));
                        product.setProductname(rs.getString("Productname"));
                        product.setPrice(rs.getDouble("Price"));
                        product.setAmount(rs.getInt("Amount"));
                        product.setIdCategory(rs.getInt("IdCategory"));

                        products.add(product);
                }

                return products;
        }

        public Product getProductById(int Id) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Products WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        Product product = new Product();

                        product.setId(rs.getInt("Id"));
                        product.setProductname(rs.getString("ProductName"));

                        return product;
                }

                return null;
        }

        public void addProduct(Product product) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "INSERT INTO Products(ProductName, Price, Amount, IdCategory) VALUES(?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, product.getProductname());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setInt(3, product.getAmount());
                preparedStatement.setInt(4, product.getIdCategory());

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }

        public void updateProduct(Product product) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "UPDATE Products SET ProductName = ?, Price = ?, Amount = ?, IdCategory = ? WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, product.getProductname());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setInt(3, product.getAmount());
                preparedStatement.setInt(4, product.getIdCategory());
                preparedStatement.setInt(5, product.getId());

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }

        public void deleteProduct(int Id) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "DELETE FROM Products WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Id);

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }
}
