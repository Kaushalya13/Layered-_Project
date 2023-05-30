package dao.Custom;

import dao.CrudDAO;
import db.DBConnection;
import model.OrderDTO;

import java.sql.*;

public interface OrderDAO extends CrudDAO<OrderDTO,String> {

//    public String generateOID() throws SQLException, ClassNotFoundException;
//
//    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
//
//    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;

}
