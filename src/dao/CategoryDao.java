package dao;

import connect.JDBCConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

public class CategoryDao {

        public List<Category> getAllCategories() throws SQLException {
                List<Category> categories = new ArrayList<Category>();

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Categories";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        Category category = new Category();

                        category.setId(rs.getInt("Id"));
                        category.setCategoryname(rs.getString("CategoryName"));

                        categories.add(category);
                }

                return categories;
        }

        public Category getCategoryById(int Id) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Categories WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        Category category = new Category();

                        category.setId(rs.getInt("Id"));
                        category.setCategoryname(rs.getString("CategoryName"));

                        return category;
                }

                return null;
        }

        public void addCategory(Category category) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "INSERT INTO Categories(CategoryName) VALUES(?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, category.getCategoryname());

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }

        public void updateCategory(Category category) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "UPDATE Categories SET CategoryName = ? WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, category.getCategoryname());
                preparedStatement.setInt(2, category.getId());

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }

        public void deleteCategory(int Id) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "DELETE FROM category WHERE ID = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Id);

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }
}
