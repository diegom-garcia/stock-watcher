package com.mycompany.stock.watcher;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("primary");
    }
}