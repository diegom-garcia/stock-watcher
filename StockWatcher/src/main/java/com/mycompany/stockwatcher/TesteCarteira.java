/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockwatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author DIEGO
 */
public class TesteCarteira {

    private static Scene scene;
    private Connection connection;
    private Statement statement;

    public void start(Stage stage) throws IOException {
//
//        scene = new Scene(loadFXML("TelaCarteira"), 600, 750);
//
//        //abrirConexao();
//        stage.setScene(scene);
//        stage.setResizable(false);
//        telaP.setIdUser("77");
//        stage.show();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCarteira.fxml"));
            CarteiraController telaP = new CarteiraController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));
            telaP.setIdUser("77");
            stage.show();
            stage.setResizable(false);
            //funcionaPeloAmorDeDeus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();

    }

    public static void main(String[] args) {
        launch();
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
