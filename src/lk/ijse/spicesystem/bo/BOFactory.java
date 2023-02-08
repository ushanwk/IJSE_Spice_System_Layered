package lk.ijse.spicesystem.bo;


import lk.ijse.spicesystem.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        EMPLOYEE, FINANCE, FINISHEDITEM, FINISHEDSTOCK, MATERIAL, PAYMENTMETHOD, PLACEORDER, PRODUCTION, PRODUCTIONSTOCK, RAWSTOCK, SHOP, SUPPLIER, USER
    }

    public SuperBO getBO(BOTypes types){
        switch (types) {
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case FINANCE:
                return new FinanceBOImpl();
            case FINISHEDITEM:
                return new FinishedItemBOImpl();
            case FINISHEDSTOCK:
                return new FinishedStockBOImpl();
            case MATERIAL:
                return new MaterialBOImpl();
            case PAYMENTMETHOD:
                return new PaymentMethodBOImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            case PRODUCTION:
                return new ProductionBOImpl();
            case PRODUCTIONSTOCK:
                return new ProductionStockBOImpl();
            case RAWSTOCK:
                return new RawStockBOImpl();
            case SHOP:
                return new ShopBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }


}
