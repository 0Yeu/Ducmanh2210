package service;

import dao.CategoryDao;
import java.sql.SQLException;
import java.util.List;
import model.Category;

public class CategoryService {

        private CategoryDao categoryDao;

        public CategoryService() {
                categoryDao = new CategoryDao();
        }

        public List<Category> getAllCategories() throws SQLException {
                return categoryDao.getAllCategories();
        }

        public void addCategory(Category category) throws SQLException {
                categoryDao.addCategory(category);
        }

        public void deleteCategory(int Id) throws SQLException {
                categoryDao.deleteCategory(Id);
        }

        public Category getCategoryById(int Id) throws SQLException {
                return categoryDao.getCategoryById(Id);
        }

        public void updateCategory(Category category) throws SQLException {
                categoryDao.updateCategory(category);
        }
}
