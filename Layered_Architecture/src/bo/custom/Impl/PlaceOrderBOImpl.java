package bo.custom.Impl;

import dao.Custom.Impl.CustomerDAOImpl;
import dao.Custom.Impl.ItemDAOImpl;
import dao.Custom.Impl.OrderDAOImpl;
import dao.Custom.Impl.OrderDetailsDAOImpl;
import dao.Custom.ItemDAO;
import dao.Custom.OrderDAO;
import dao.Custom.OrderDetailsDAO;
import db.DBConnection;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBOImpl {
    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    ItemDAO itemDAO = new ItemDAOImpl();

    public boolean PlaceOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails){
        Connection connection = null;
        try {
            connection= DBConnection.getDbConnection().getConnection();

            //Check order id already exist or not
//            OrderDAOImpl orderDAO = new OrderDAOImpl();

//            OrderDAOImpl orderDAO = new OrderDAOImpl();
            boolean b1 = orderDAO.exist(orderId);

            /*if order id already exist*/
            if (b1) {
                return false;
            }

            connection.setAutoCommit(false);

            //Save the Order to the order table
            OrderDAOImpl orderDAO1 = new OrderDAOImpl();
            boolean b2 = orderDAO1.add(new OrderDTO(orderId, orderDate, customerId));

            if (!b2) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }


            // add data to the Order Details table
//            OrderDetailsDAOImpl orderDetailsDAO = new OrderDetailsDAOImpl();
            for (OrderDetailDTO detail : orderDetails) {
                boolean b3 = orderDetailsDAO.add(detail);
                if (!b3) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

                //Search & Update Item
                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                //update item
//                ItemDAOImpl itemDAO = new ItemDAOImpl();
                boolean b = itemDAO.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!b) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    public ItemDTO findItem(String code) {
        try {
//            ItemDAOImpl itemDAO = new ItemDAOImpl();
            return itemDAO.search(code);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

