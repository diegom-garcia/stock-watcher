package com.mycompany.stockwatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField txtPassword;
    private Connection connection;
    private Statement statement;
    int c = 0;

    @FXML
    void acaoLoginBtn(ActionEvent event) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", "root", "123");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("oie");

        }
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
            System.out.println("Preencha todos os campos");
        } else {
            try {
                PreparedStatement stmt = connection.prepareStatement("SELECT *from usuario");
                ResultSet result = stmt.executeQuery();
                while (result.next()) {
                    if ((result.getString("login").equals(txtUsername.getText())) && (result.getString("senha").equals(txtPassword.getText()))) {
                        c++;
                    }
                }
                if (c > 0) {
                    statement.close();
                    connection.close();
                    App.setRoot("secondary");
                } else {
                    System.out.println("Usuário ou senha incorretos");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("TelaRegister");
    }
}
