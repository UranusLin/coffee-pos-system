package service;

import dao.OrderDAO;
import model.Modal;
import model.Orders;
import utils.ExportCSV;

import java.util.Collections;
import java.util.List;

public class OrderService implements SERVICE<Orders> {
    OrderDAO orderDAO = new OrderDAO();
    ExportCSV exportCSV = new ExportCSV();

    @Override
    public boolean insert(Orders orders) throws Exception {
        return orderDAO.insert(orders);
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        return orderDAO.update(orders);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return orderDAO.delete(id);
    }

    @Override
    public Orders get(int id) throws Exception {
        return orderDAO.get(id);
    }

    @Override
    public List<Orders> getAll() throws Exception {
        return orderDAO.getAll();
    }

    public boolean exportCSV() throws Exception {
        List<Orders> orders = orderDAO.getAll();
        return exportCSV.exportCSV(orders);
    }
}
