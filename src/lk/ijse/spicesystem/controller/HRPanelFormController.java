package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HRPanelFormController {

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

    public void btnEmployeesOnAction(ActionEvent actionEvent) throws IOException {
        option = 1;
        Navigation.navigate(Routes.HRDASHBOARD, pane);
    }

    public void btnAttendenceOnAction(ActionEvent actionEvent) throws IOException {
        option = 2;
        Navigation.navigate(Routes.HRDASHBOARD, pane);
    }

    public void btnSalaryRecOnAction(ActionEvent actionEvent) throws IOException {
        option = 3;
        Navigation.navigate(Routes.HRDASHBOARD, pane);
    }

    public void btnSignOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnEditProfileOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EDITPROFILE, pane);
    }
}
