package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StockManagerPanelFormController {

    public Label lblDay;
    public Label lblYearMonth;
    public AnchorPane pane;

    static int option = 0;

    public void initialize(){
        lblDay.setText(getDate("dd"));
        lblYearMonth.setText(getDate("yyyy-MM"));
    }

    public String getDate(String s){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(s);
        String date = LocalDateTime.now().format(formatter);
        return date;
    }


    public void btnRawOnAction(ActionEvent actionEvent) throws IOException {
        option = 1;
        Navigation.navigate(Routes.STOCKMANAGERDASHBOARD, pane);
    }

    public void btnProductionOnActon(ActionEvent actionEvent) throws IOException {
        option = 2;
        Navigation.navigate(Routes.STOCKMANAGERDASHBOARD, pane);
    }

    public void btnFinishedOnAction(ActionEvent actionEvent) throws IOException {
        option = 3;
        Navigation.navigate(Routes.STOCKMANAGERDASHBOARD, pane);
    }

    public void btnSuppliersOnAction(ActionEvent actionEvent) throws IOException {
        option = 4;
        Navigation.navigate(Routes.STOCKMANAGERDASHBOARD, pane);
    }

    public void btnBatchesOnAction(ActionEvent actionEvent) throws IOException {
        option = 5;
        Navigation.navigate(Routes.STOCKMANAGERDASHBOARD, pane);
    }

    public void btnSignOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnEditProfileOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EDITPROFILE, pane);
    }
}
