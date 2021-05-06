package com.mycompany.stockwatcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    private Connection connection;
    private Statement statement;
    

    
    @Override
    public void start(Stage stage) throws IOException {
       
        scene = new Scene(loadFXML("TelaLogin"), 600, 750);
        
        //abrirConexao();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        //funcionaPeloAmorDeDeus();
       
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
