package lk.ijse.spicesystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalesmenPanelFormController {

    public Label lblDay;
    public Label lblYearMonth;
    public AnchorPane pane;

    static int option = 0;
    public BarChart<?, ?> barchart;

    public void initialize(){
        lblDay.setText(getDate("dd"));
        lblYearMonth.setText(getDate("yyyy-MM"));

        XYChart.Series series = new XYChart.Series();
        series.setName("Finished Stock");

        series.getData().add(new XYChart.Data("Ch Pi 100", 20));
        series.getData().add(new XYChart.Data("Ch Po 100", 25));
        series.getData().add(new XYChart.Data("Pe Pi 100", 15));
        series.getData().add(new XYChart.Data("Pe Po 100", 10));
        series.getData().add(new XYChart.Data("Ter 100 ", 20));
        series.getData().add(new XYChart.Data("Ch Po 50", 25));
        series.getData().add(new XYChart.Data("Pe Pi 50", 10));
        series.getData().add(new XYChart.Data("Pe Po 100", 15));
        series.getData().add(new XYChart.Data("Ter 100 ", 20));

        barchart.getData().addAll(series);
    }

    public String getDate(String s){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(s);
        String date = LocalDateTime.now().format(formatter);
        return date;
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        option = 1;
        Navigation.navigate(Routes.SALESMENDASHBOARD, pane);
    }

    public void btnFinishedStores(ActionEvent actionEvent) throws IOException {
        option = 2;
        Navigation.navigate(Routes.SALESMENDASHBOARD, pane);
    }

    public void btnOrdersOnACtion(ActionEvent actionEvent) throws IOException {
        option = 3;
        Navigation.navigate(Routes.SALESMENDASHBOARD, pane);
    }

    public void btnSignOutOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void btnEditOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.EDITPROFILE, pane);
    }
}
