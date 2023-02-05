package lk.ijse.spicesystem.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case SIGNUP:
                initUI("SignUpForm.fxml");
                break;

            case LOGIN:
                initUI("LoginForm.fxml");
                break;

            case CEO:
                initUI("CEOPanelForm.fxml");
                window.setTitle("CEO Panel");
                break;

            case CEODASHBOARD:
                initUI("CEOPanelDashboardForm.fxml");
                window.setTitle("CEO Panel Dashboard");
                break;

            case STOCKMANAGER:
                initUI("StockManagerPanelForm.fxml");
                window.setTitle("RMW / Production Manager Panel");
                break;

            case HR:
                initUI("HRPanelForm.fxml");
                window.setTitle("Huaman Resources Manager Panel");
                break;

            case FINANCEMANAGER:
                initUI("FinanceManagerPanelForm.fxml");
                window.setTitle("Finance Manager Panel");
                break;

            case SALESMEN:
                initUI("SalesmenPanelForm.fxml");
                window.setTitle("Salesmen Panel");
                break;

            case FINANCEMANAGERDASHBOARD:
                initUI("FinanceManagerPanelDashboardForm.fxml");
                window.setTitle("Finance Manager Panel");
                break;

            case HRDASHBOARD:
                initUI("HRPanelDashboardForm.fxml");
                window.setTitle("HR Manager Panel");
                break;

            case SALESMENDASHBOARD:
                initUI("SalesmenPanelDashboardForm.fxml");
                window.setTitle("Salesmen Panel");
                break;

            case STOCKMANAGERDASHBOARD:
                initUI("StockManagerPanelDashboardForm.fxml");
                window.setTitle("Stock Manager Panel");
                break;

            case ADDSHOPFORM:
                initUI("AddShopForm.fxml");
                window.setTitle("");
                break;

            case CUSTOMERDASHBOARD:
                initUI("CustomerDashboardForm.fxml");
                window.setTitle("");
                break;

            case SEARCHSHOPFORM:
                initUI("SearchShopForm.fxml");
                window.setTitle("");
                break;

            case UPDATESHOPFORM:
                initUI("UpdateShopForm.fxml");
                window.setTitle("");
                break;

            case DELETESHOPFORM:
                initUI("DeleteShopForm.fxml");
                window.setTitle("");
                break;

            case ADDFINISHEDSTOCK:
                initUI("AddFinishedStockForm.fxml");
                window.setTitle("");
                break;

            case ADDPRODUCTIONSTOCK:
                initUI("AddProductionStockForm.fxml");
                window.setTitle("");
                break;

            case ADDRAWSTOCK:
                initUI("AddRawStockForm.fxml");
                window.setTitle("");
                break;

            case ADDSUPPLIER:
                initUI("AddSupplierForm.fxml");
                window.setTitle("");
                break;

            case SEARCHSUPPLIER:
                initUI("SearchSupplierForm.fxml");
                window.setTitle("");
                break;

            case UPDATESUPPLIER:
                initUI("UpdateSupplierForm.fxml");
                window.setTitle("");
                break;

            case DELETESUPPLIER:
                initUI("DeleteSupplierForm.fxml");
                window.setTitle("");
                break;

            case SUPPLIERDASHBOARD:
                initUI("SuuplierDashboardForm.fxml");
                window.setTitle("");
                break;

            case EMPLOYEEDASHBOARD:
                initUI("EmployeeDashboardForm.fxml");
                window.setTitle("");
                break;

            case ADDEMPLOYEE:
                initUI("AddEmployeeForm.fxml");
                window.setTitle("");
                break;

            case SEARCHEMPLOYEE:
                initUI("SearchEmployeeForm.fxml");
                window.setTitle("");
                break;

            case UPDATEEMPLOYEE:
                initUI("UpdateEmployeeForm.fxml");
                window.setTitle("");
                break;

            case DELETEEMPLOYEE:
                initUI("DeleteEmployeeForm.fxml");
                window.setTitle("");
                break;

            case EDITPROFILE:
                initUI("EditProfile.fxml");
                window.setTitle("");
                break;

            case PLACEORDER:
                initUI("PlaceOrderForm.fxml");
                window.setTitle("");
                break;

            case SALARYRECCOMEND:
                initUI("SalaryReccomendation.fxml");
                window.setTitle("");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/spicesystem/view/" + location)));
    }
}
