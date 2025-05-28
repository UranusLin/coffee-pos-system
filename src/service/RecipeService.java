package service;

import model.Recipe;

import java.util.List;

public class RecipeService implements SERVICE<Recipe> {
    @Override
    public boolean insert(Recipe recipe) throws Exception {
        return false;
    }

    @Override
    public boolean update(Recipe recipe) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        return false;
    }

    @Override
    public Recipe get(int id) throws Exception {
        return null;
    }

    @Override
    public List<Recipe> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean exportCSV() throws Exception {
        return false;
    }
}
