package dao;

import connect.JDBCConnection;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

        public List<User> getAllUsers() throws SQLException {
                List<User> users = new ArrayList<User>();

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Users";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        User user = new User();

                        user.setId(rs.getInt("Id"));
                        user.setName(rs.getString("Name"));
                        user.setPhone(rs.getString("Phone"));
                        user.setUsername(rs.getString("Username"));
                        user.setPassword(rs.getString("Password"));
                        user.setAbout(rs.getString("About"));
                        user.setFavourites(rs.getString("Favourites"));
                        user.setRole(rs.getString("Role"));

                        users.add(user);
                }

                return users;
        }

        public User getUserById(int Id) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Users WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                        User user = new User();

                        user.setId(rs.getInt("Id"));
                        user.setName(rs.getString("Name"));
                        user.setPhone(rs.getString("Phone"));
                        user.setUsername(rs.getString("Username"));
                        user.setPassword(rs.getString("Password"));
                        user.setAbout(rs.getString("About"));
                        user.setFavourites(rs.getString("Favourites"));
                        user.setRole(rs.getString("Role"));

                        return user;
                }

                return null;
        }

        public void addUser(User user) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "INSERT INTO Users(Name, Phone, Username, Password, About, Favourites, Role) VALUES(?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPhone());
                preparedStatement.setString(3, user.getUsername());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getAbout());
                preparedStatement.setString(6, user.getFavourites());
                preparedStatement.setString(7, user.getRole());

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }

        public void updateUser(User user) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "UPDATE Users SET Name = ?,Phone = ?,Username = ?,Password = ?,About = ?,Favourite = ?,Role = ? WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPhone());
                preparedStatement.setString(3, user.getUsername());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getAbout());
                preparedStatement.setString(6, user.getFavourites());
                preparedStatement.setString(7, user.getRole());
                preparedStatement.setInt(8, user.getId());

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }

        public void deleteUser(int Id) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "DELETE FROM Users WHERE Id = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, Id);

                int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        }

        public boolean isLoginUser(User user) throws SQLException {

                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Users WHERE Username = ? AND BINARY_CHECKSUM(Password) = BINARY_CHECKSUM(?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());

                ResultSet rs = preparedStatement.executeQuery();
                return rs.next();
        }
        
        public boolean isAdmin(String username) throws SQLException {
                Connection connection = JDBCConnection.getJDBCConnection();

                String sql = "SELECT * FROM Users WHERE Role = 'Role_Admin' AND Username = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);

                ResultSet rs = preparedStatement.executeQuery();
                return rs.next();
        }
}
