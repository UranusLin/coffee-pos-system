package service;

import dao.ProductDAO;
import model.Product;
import utils.ExportCSV;

import java.util.List;

public class ProductService implements SERVICE<Product> {
    ProductDAO productDAO = new ProductDAO();
    ExportCSV exportCSV = new ExportCSV();

    @Override
    public boolean insert(Product product) throws Exception {
        if (product.getId() != 0) {
            throw new Exception("Product id not 0");
        }
        return productDAO.insert(product);
    }

    @Override
    public boolean update(Product product) throws Exception {
        return productDAO.update(product);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return productDAO.delete(id);
    }

    @Override
    public Product get(int id) throws Exception {
        return productDAO.get(id);
    }

    @Override
    public List<Product> getAll() throws Exception {
        return productDAO.getAll();
    }

    @Override
    public boolean exportCSV() throws Exception {
        List<Product> productList = productDAO.getAll();
        return exportCSV.exportCSV(productList);
    }

    public List<Product> getProductByName(String name) {
        return productDAO.getProductByName(name);
    }

    public List<Product> getSaleProducts() throws Exception {
        return productDAO.getSaleProducts();
    }
}
