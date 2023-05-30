package bo.custom.Impl;

import bo.custom.ItemBO;
import dao.Custom.Impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAOImpl itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO > getAllItem() throws SQLException, ClassNotFoundException {
//        ItemDAOImpl itemDAO = new ItemDAOImpl();
        return itemDAO.getAll();
    }

    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.add(dto);
    }
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(dto);
    }

    public boolean existItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }

    public String generateNewID() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewID();
    }

    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(id);
    }

    public ItemDTO searchItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDAO.search(itemDTO.getCode());
    }
}
