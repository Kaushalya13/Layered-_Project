package bo.custom.Impl;

import bo.custom.CustomerBO;
import dao.Custom.CustomerDAO;
import dao.Custom.Impl.CustomerDAOImpl;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
         return customerDAO.getAll();
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.add(dto);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(dto);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return customerDAO.generateNewID();
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public CustomerDTO searchCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.search(customerDTO.getId());
    }

   /* CustomerDAO customerDAO = new CustomerDAOImpl();

    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAOImpl();
        return customerDAO.getAll();
    }

    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.add(dto);
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.update(dto);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.exist(id);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.generateNewID();
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.delete(id);
    }

    public CustomerDTO searchCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.search(customerDTO.getId());
    }*/
}
