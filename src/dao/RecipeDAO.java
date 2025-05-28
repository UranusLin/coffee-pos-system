package dao;

import model.Recipe;

import java.sql.SQLException;
import java.util.List;

public class RecipeDAO implements DAO<Recipe> {
    @Override
    public boolean insert(Recipe recipe) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Recipe recipe) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Recipe get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Recipe> getAll() throws SQLException {
        return List.of();
    }
}
