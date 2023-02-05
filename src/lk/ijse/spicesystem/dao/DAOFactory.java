package lk.ijse.spicesystem.dao;

import lk.ijse.spicesystem.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        EMPLOYEE, FINANCE, FINISHEDITEM, FINISHEDSTOCK, MATERIAL, PAYMENTMETHOD, PLACEORDER, PRODUCTION, PRODUCTIONSTOCK, RAWSTOCK, SHOP, SUPPLIER, USER
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case FINANCE:
                return new FinanceDAOImpl();
            case FINISHEDITEM:
                return new FinishedItemDAOImpl();
            case FINISHEDSTOCK:
                return new FinishedStockDAOImpl();
            case MATERIAL:
                return new MaterialDAOImpl();
            case PAYMENTMETHOD:
                return new PaymentMethodDAOImpl();
            case PLACEORDER:
                return new PlaceOrderDAOImpl();
            case PRODUCTION:
                return new ProductionDAOImpl();
            case PRODUCTIONSTOCK:
                return new ProductionStockDAOImpl();
            case RAWSTOCK:
                return new RawStockDAOImpl();
            case SHOP:
                return new ShopDAOImpl();
            case SUPPLIER:
                return new SupplierDAOImpl();
            case USER:
                return new UserDAOImpl();
            default:
                return null;
        }
    }


}
