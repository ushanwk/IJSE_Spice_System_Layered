package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.ShopBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.ShopDAO;
import lk.ijse.spicesystem.dto.ShopDTO;
import lk.ijse.spicesystem.entity.Shop;

import java.sql.SQLException;

public class ShopBOImpl implements ShopBO {

    ShopDAO shopDAO = (ShopDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SHOP);

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        return shopDAO.nextId();
    }

    @Override
    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException {
        return shopDAO.getAllId();
    }

    @Override
    public boolean add(ShopDTO shopDTO) throws SQLException, ClassNotFoundException {
        Shop shop = new Shop(shopDTO.getShopId(), shopDTO.getShopName(), shopDTO.getAddress(), shopDTO.getEmail(), shopDTO.getShopTelephone(), shopDTO.getOwnerName(), shopDTO.getOwnerNic(), shopDTO.getOwnerTelephone());
        return shopDAO.add(shop);
    }

    @Override
    public ShopDTO search(String id) throws SQLException, ClassNotFoundException {
        Shop shop = shopDAO.search(id);
        return new ShopDTO(shop.getShopId(), shop.getShopName(), shop.getAddress(), shop.getEmail(), shop.getShopTelephone(), shop.getOwnerName(), shop.getOwnerNic(), shop.getOwnerTelephone());
    }

    @Override
    public boolean update(ShopDTO shopDTO) throws SQLException, ClassNotFoundException {
        Shop shop = new Shop(shopDTO.getShopId(), shopDTO.getShopName(), shopDTO.getAddress(), shopDTO.getEmail(), shopDTO.getShopTelephone(), shopDTO.getOwnerName(), shopDTO.getOwnerNic(), shopDTO.getOwnerTelephone());
        return shopDAO.update(shop);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return shopDAO.delete(id);
    }

    @Override
    public ObservableList getShopId() throws SQLException, ClassNotFoundException {
        return shopDAO.getShopId();
    }

    @Override
    public String getShopName(String id) throws SQLException, ClassNotFoundException {
        return shopDAO.getShopName(id);
    }
}
