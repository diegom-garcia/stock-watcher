package com.mycompany.stockwatcher;
import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {
   
    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("TelaRegister");
    }
}
