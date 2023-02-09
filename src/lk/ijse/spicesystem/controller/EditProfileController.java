package lk.ijse.spicesystem.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lk.ijse.spicesystem.bo.custom.UserBO;
import lk.ijse.spicesystem.bo.custom.impl.UserBOImpl;
import lk.ijse.spicesystem.dto.UserDTO;
import lk.ijse.spicesystem.entity.User;
import lk.ijse.spicesystem.util.Navigation;
import lk.ijse.spicesystem.util.Routes;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.sql.SQLException;

public class EditProfileController {
    public Text lblUsername;
    public JFXTextField txtFname;
    public JFXTextField txtLname;
    public JFXTextField txtEmail;
    public JFXTextField txtTelephone;
    public JFXTextField txtAddress;
    public JFXTextField txtJobrole;
    public AnchorPane pane;

    UserBO userBO = new UserBOImpl();

    public  void initialize(){

        String userName = LoginFormController.userName;

        try {
            UserDTO user = userBO.search(userName);

            lblUsername.setText(userName);
            txtFname.setText(user.getfName());
            txtLname.setText(user.getlName());
            txtEmail.setText(user.getEmail());
            txtJobrole.setText(user.getJobRole());
            txtTelephone.setText(String.valueOf(user.getTelephone()));
            txtAddress.setText(user.getAddress());

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



    public void btnSaveOnAction(ActionEvent actionEvent) {

        UserDTO user = new UserDTO(lblUsername.getText(), txtFname.getText(), txtLname.getText(), txtEmail.getText(), Integer.valueOf(txtTelephone.getText()), txtAddress.getText(), txtJobrole.getText());

        try {
            boolean isUpdated = userBO.add(user);

            if(isUpdated){

                Image image = new Image("/lk/ijse/spicesystem/asset/correct.png");
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("Edit Suuccesful");
                notifications.title("Spice System");
                notifications.hideAfter(Duration.seconds(3));
                notifications.show();

                if(LoginFormController.userName .equals("CEO")){
                    Navigation.navigate(Routes.CEO, pane);
                }else if(LoginFormController.userName .equals("HumanResource")){
                    Navigation.navigate(Routes.HR, pane);
                }else if(LoginFormController.userName .equals("Finance")){
                    Navigation.navigate(Routes.FINANCEMANAGER, pane);
                }else if(LoginFormController.userName .equals("Salesmen")){
                    Navigation.navigate(Routes.SALESMEN, pane);
                }else{
                    Navigation.navigate(Routes.STOCKMANAGER, pane);
                }

            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        if(LoginFormController.userName .equals("CEO")){
            Navigation.navigate(Routes.CEO, pane);
        }else if(LoginFormController.userName .equals("HumanResource")){
            Navigation.navigate(Routes.HR, pane);
        }else if(LoginFormController.userName .equals("Finance")){
            Navigation.navigate(Routes.FINANCEMANAGER, pane);
        }else if(LoginFormController.userName .equals("Salesmen")){
            Navigation.navigate(Routes.SALESMEN, pane);
        }else{
            Navigation.navigate(Routes.STOCKMANAGER, pane);
        }

    }
}
