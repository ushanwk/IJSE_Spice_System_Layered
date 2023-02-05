package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.db.DBConnection;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class FinanceManagerPanelFormController {

    public Label lblDay;
    public Label lblYearMonth;

    static int option = 0;
    public AnchorPane pane;

    public void initialize(){
        lblDay.setText(getDate("dd"));
        lblYearMonth.setText(getDate("yyyy-MM"));
    }

    public String getDate(String s){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(s);
        String date = LocalDateTime.now().format(formatter);
        return date;
    }

    public void btnSalesProfitsOnAction(ActionEvent actionEvent) throws IOException {
        option = 1;

        //Navigation.navigate(Routes.FINANCEMANAGERDASHBOARD, pane);

        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/spicesystem/report/PaymentMethod.jrxml");

        HashMap<String, Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnCostsOnAction(ActionEvent actionEvent) throws IOException {
        option = 2;
        //Navigation.navigate(Routes.FINANCEMANAGERDASHBOARD, pane);

        InputStream inputStream = this.getClass().getResourceAsStream("/lk/ijse/spicesystem/report/Costs.jrxml");

        HashMap<String, Object> hm = new HashMap<>();

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hm, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint);
        } catch (JRException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnNetProfitOnAction(ActionEvent actionEvent) throws IOException {
        option = 3;
        Navigation.navigate(Routes.FINANCEMANAGERDASHBOARD, pane);
    }

    public void btnSignOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnEditProfileOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EDITPROFILE, pane);
    }
}
