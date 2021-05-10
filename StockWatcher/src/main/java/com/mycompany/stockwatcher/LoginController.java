package com.mycompany.stockwatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.security.krb5.Credentials;
import sun.security.krb5.EncryptionKey;

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

    private Stage thisStage;

    void trocaTela(String id) {
        // Create the new stage
        Stage stage = new Stage();

        // Load the FXML file
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPrimaria.fxml"));

            // Set this class as the controller
            TelaPrimariaController telaP = new TelaPrimariaController();
            loader.setController(telaP);

            // Load the scene
            stage.setScene(new Scene(loader.load(),1110,700));
            
            // Setup the window/stage
           //  thisStage.setTitle("Passing Controllers Example - Layout1");
           telaP.setIdUser(id);
           stage.show();
           stage.setResizable(false);
           Stage stage2 = (Stage) loginButton.getScene().getWindow();
            stage2.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void acaoLoginBtn(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);
        String teste = txtUsername.getText();
        String novo;
        GetCredentials credentials = new GetCredentials();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            //Class.forName("com.mysql.jdbc.driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", credentials.getUser(), credentials.getPassword());
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            alert.setContentText("Conexão com o banco falhada");
            alert.show();
        }
        if (txtUsername.getText().equals("") || txtPassword.getText().equals("")) {
            alert.setContentText("Preencha todos os campos");
            alert.show();
        } else {
            try {
                PreparedStatement stmt = connection.prepareStatement("SELECT *from usuario");
                ResultSet result = stmt.executeQuery();
                while (result.next()) {
                    if ((result.getString("login").equals(txtUsername.getText())) && (result.getString("senha").equals(txtPassword.getText()))) {
                        c++;
                        break;

                    }
                }
                if (c > 0) {
                    novo = result.getString("id_usuario");
                    statement.close();
                    connection.close();
                    trocaTela(novo);
                } else {
                    System.out.println("Usuário ou senha incorretos");
                    alert.setContentText("Usuário e/ou senha incorreto");
                    alert.show();
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
