package service;

import dao.OrderDetailDAO;
import model.OrderDetail;
import utils.ExportCSV;

import java.util.List;

public class OrderDetailService implements SERVICE<OrderDetail> {
    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
    ExportCSV exportCSV = new ExportCSV();

    @Override
    public boolean insert(OrderDetail orderDetail) throws Exception {
        return orderDetailDAO.insert(orderDetail);
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws Exception {
        return orderDetailDAO.update(orderDetail);
    }

    @Override
    public boolean delete(int id) throws Exception {
        return orderDetailDAO.delete(id);
    }

    @Override
    public OrderDetail get(int id) throws Exception {
        return orderDetailDAO.get(id);
    }

    @Override
    public List<OrderDetail> getAll() throws Exception {
        return orderDetailDAO.getAll();
    }

    @Override
    public boolean exportCSV() throws Exception {
        List<OrderDetail> orderDetailList = orderDetailDAO.getAll();
        return exportCSV.exportCSV(orderDetailList);
    }
}
