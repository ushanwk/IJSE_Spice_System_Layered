package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;

public class HRPanelDashboardFormContrller {
    public ImageView imgEmployeesSelected;
    public ImageView imgAttendanceSelected;
    public ImageView imgSalaryRecSelected;
    public ImageView imgEmployeesSelectedRec;
    public ImageView imgAttendanceSelectedRec;
    public ImageView imgSalaryRecSelectedRec;
    public AnchorPane panel;
    public AnchorPane dashboardPane;

    public void initialize(){
        imgEmployeesSelected.setVisible(false);
        imgAttendanceSelected.setVisible(false);
        imgSalaryRecSelected.setVisible(false);

        imgEmployeesSelectedRec.setVisible(false);
        imgAttendanceSelectedRec.setVisible(false);
        imgSalaryRecSelectedRec.setVisible(false);

        if(HRPanelFormController.option == 1){
            imgEmployeesSelectedRec.setVisible(true);
        }else if(HRPanelFormController.option == 2){
            imgAttendanceSelectedRec.setVisible(true);
        }else{
            imgSalaryRecSelectedRec.setVisible(true);
        }
    }

    public void btnEmployeeOnMouseEntered(MouseEvent mouseEvent) {
        imgEmployeesSelected.setVisible(true);
    }

    public void btnAttendenceOnMouseEntered(MouseEvent mouseEvent) {
        imgAttendanceSelected.setVisible(true);
    }

    public void btnSalaryRecOnMouseEntered(MouseEvent mouseEvent) {
        imgSalaryRecSelected.setVisible(true);
    }

    public void btnEmployeeOnMouseExited(MouseEvent mouseEvent) {
        imgEmployeesSelected.setVisible(false);
    }

    public void btnAttendenceOnMouseExited(MouseEvent mouseEvent) {
        imgAttendanceSelected.setVisible(false);
    }

    public void btnSalaryRecOnMouseExited(MouseEvent mouseEvent) {
        imgSalaryRecSelected.setVisible(false);
    }

    public void btnEmployeeOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgEmployeesSelectedRec.setVisible(true);
        imgAttendanceSelectedRec.setVisible(false);
        imgSalaryRecSelectedRec.setVisible(false);

        Navigation.navigate(Routes.EMPLOYEEDASHBOARD, dashboardPane);
    }

    public void btnAttendenceOnMouseClicked(MouseEvent mouseEvent) {
        imgEmployeesSelectedRec.setVisible(false);
        imgAttendanceSelectedRec.setVisible(true);
        imgSalaryRecSelectedRec.setVisible(false);
    }

    public void btnSalaryRecOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        imgEmployeesSelectedRec.setVisible(false);
        imgAttendanceSelectedRec.setVisible(false);
        imgSalaryRecSelectedRec.setVisible(true);

        Navigation.navigate(Routes.SALARYRECCOMEND, dashboardPane);
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.HR, panel);
    }
}
