package lk.ijse.spicesystem.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.spicesystem.bo.custom.RawStockBO;
import lk.ijse.spicesystem.dao.DAOFactory;
import lk.ijse.spicesystem.dao.custom.*;
import lk.ijse.spicesystem.dto.RawStockDTO;
import lk.ijse.spicesystem.entity.RawStock;
import lk.ijse.spicesystem.entity.Supplier;

import java.sql.SQLException;

public class RawStockBOImpl implements RawStockBO {

    RawStockDAO rawStockDAO = (RawStockDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RAWSTOCK);
    MaterialDAO materialDAO = (MaterialDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MATERIAL);
    PaymentMethodDAO paymentMethodDAO = (PaymentMethodDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENTMETHOD);
    FinanceDAO financeDAO = (FinanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.FINANCE);
    SupplierDAO supplierDAO = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    @Override
    public boolean add(RawStockDTO rawStockDTO) throws SQLException, ClassNotFoundException {
        RawStock rawStock = new RawStock(rawStockDTO.getBatchId(), rawStockDTO.getMaterialId(), rawStockDTO.getAmount(), rawStockDTO.getSupplierId(), rawStockDTO.getDate());
        return rawStockDAO.add(rawStock);
    }

    @Override
    public ObservableList<String> getBatchID(String materialId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.getBatchID(materialId);
    }

    @Override
    public int getQtyOnHandBatchId(String batchId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.getQtyOnHandBatchId(batchId);
    }

    @Override
    public boolean RawStockTable(int amount, String batchId) throws SQLException, ClassNotFoundException {
        return rawStockDAO.RawStockTable(amount, batchId);
    }

    @Override
    public String nextBatchID(String id) throws SQLException, ClassNotFoundException {
        return rawStockDAO.nextBatchID(id);
    }

    public ObservableList<String> getAllMaterials() throws SQLException, ClassNotFoundException {
        return materialDAO.getAllMaterials();
    }

    public boolean updateMaterial(int amount, String id) throws SQLException, ClassNotFoundException {
        return materialDAO.updateMaterial(amount, id);
    }

    public ObservableList<String> paymentmethod() throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.paymentmethod();
    }

    public boolean updatePaymentMethodMinus(int cost, String paymentMethod) throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.updatePaymentMethodMinus(cost, paymentMethod);
    }

    public String getPaymentId(String Paymnt) throws SQLException, ClassNotFoundException {
        return paymentMethodDAO.getPaymentId(Paymnt);
    }

    public boolean updateFinance(String payment, int Price) throws SQLException, ClassNotFoundException {
        return financeDAO.updateFinance(payment, Price);
    }

    public ObservableList<String> getAllId() throws SQLException, ClassNotFoundException {
        return supplierDAO.getAllId();
    }

    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(id);
    }

}
