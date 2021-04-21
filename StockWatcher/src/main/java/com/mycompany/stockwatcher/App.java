package com.mycompany.stockwatcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


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
        abrirConexao();
        stage.setScene(scene);
        stage.show();
       
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

   
    public void abrirConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tradeworldbase", "root", "123");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("oie");
        }
    }

    public void fecharConexao() throws Exception {
        statement.close();
        connection.close();
    }
    
    public void testeSelect() {

        try {
            ResultSet result = DBConnection.getInstance().getStatement().executeQuery("SELECT * FROM produto"); //NOI18N
            while (result.next()) {
                String linha[] = {
                    String.valueOf(result.getInt(1)),
                    result.getString(2),
                    result.getString(3),
                    String.valueOf(result.getInt(4))
                };
                modelo.addRow(linha);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
}



}
