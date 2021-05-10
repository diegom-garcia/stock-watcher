/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TelaRegisterController implements Initializable {

    private Connection connection;
    private Statement statement;

    @FXML
    private TextField txtUserRegister;
    @FXML
    private TextField txtNameRegister;
    @FXML
    private PasswordField txtPassRegister;
    @FXML
    private PasswordField txtConPassRegister;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnVoltar;

    String sql = "INSERT INTO usuario (nome, login, senha) values (?,?,?)";
    //String sql2 = "SELECT login from usuario where login = 'gustavo'";
    int c = 0;
    int a = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void acaoDoBotao(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);
        Alert alert2 = new Alert(AlertType.CONFIRMATION);
        GetCredentials credentials = new GetCredentials();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", credentials.getUser(), credentials.getPassword());
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("oie");

        }

        if (txtUserRegister.getText().equals("") || txtNameRegister.getText().equals("") || txtPassRegister.getText().equals("") || txtConPassRegister.getText().equals("")) {
            alert.setContentText("Preencha todos os campos");
            alert.show();

        } else {
            if (!txtPassRegister.getText().equals(txtConPassRegister.getText())) {
                alert.setContentText("As senhas não estão iguais");
                alert.show();
            } else {

                try {
                    PreparedStatement stmt = connection.prepareStatement("SELECT *from usuario");
                    ResultSet result = stmt.executeQuery();

                    while (result.next()) {
                        if (result.getString("login").equals(txtUserRegister.getText()) == true) {
                            c++;
                        }
                    }
                    if (c == 0) {
                        a++;
                        try {
                            alert2.setTitle("Sucesso");
                            alert2.setContentText("Usuário criado com sucesso!");
                            alert2.show();
                            PreparedStatement stm = connection.prepareStatement(sql);
                            stm.setString(1, txtNameRegister.getText());
                            stm.setString(2, txtUserRegister.getText());
                            stm.setString(3, txtPassRegister.getText());
                            stm.execute();
                            stm.close();
                            try {
                                statement.close();
                                connection.close();
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    } else {
                        alert.setContentText("Usuário inválido, tente outro");
                        alert.show();
                        c = 0;
                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        if (a > 0) {

            try {
                App.setRoot("TelaLogin");
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("TelaLogin");
    }
}
