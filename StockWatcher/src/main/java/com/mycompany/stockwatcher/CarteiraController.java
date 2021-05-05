package com.mycompany.stockwatcher;

//import com.mysql.cj.result.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Cell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CarteiraController {

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnHistorico;

    String idUser;

    @FXML
    void acaoPesquisar(ActionEvent event) {
        trocaTelaPesquisar(idUser);
    }

    @FXML
    void acaoFavoritos(ActionEvent event) {
        trocaTelaFavorito(idUser);
    }

    @FXML
    void acaoHistorico(ActionEvent event) {
        trocaTelaHistorico(idUser);
    }

    @FXML
    void acaoSobre(ActionEvent event) {
        trocaTelaSobre(idUser);
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public File getFile() {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Abrir Excel");
        File file = filechooser.showOpenDialog(btnSobre.getScene().getWindow());
        return file;
    }

    public List<Carteira> getCarteiras(File file) {
        List<Carteira> carteiras = null;
        Carteira carteira = new Carteira();
        //obtaining input bytes from a file  
        try {
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
//creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
                carteira = new Carteira();
                Cell cell = cellIterator.next();
                carteira.setData((Date) cell.getDateCellValue());
                cell = cellIterator.next();
                carteira.setTipo(cell.getStringCellValue());
                cell = cellIterator.next();
                carteira.setNome(cell.getStringCellValue());
                cell = cellIterator.next();
                carteira.setPreco(cell.getNumericCellValue());
                cell = cellIterator.next();
                carteira.setQtd(cell.getNumericCellValue());
                cell = cellIterator.next();
                carteira.setOperacao(cell.getStringCellValue());

                carteiras.add(carteira);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return carteiras;
    }

    public void popular_tabela() {
        File file = getFile();
        //List<Carteira> carteiras =  getCarteiras(file);
        //tabelaAcoes.setItems(FXCollections.observableArrayList(carteiras));
    }

    void trocaTelaPesquisar(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPesquisar.fxml"));
            PesquisarController telaP = new PesquisarController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));
            telaP.setIdUser(id);
            stage.show();
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaHistorico(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaHistorico.fxml"));
            HistoricoController telaP = new HistoricoController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));
            telaP.setIdUser(id);
            stage.show();
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaFavorito(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaFavoritos.fxml"));
            FavoritosController telaP = new FavoritosController();
            loader.setController(telaP);
            Scene scene = new Scene(loader.load(), 1110, 700);
            scene.getStylesheets().add("Style.css");
            stage.setScene(scene);;
            telaP.setIdUser(id);
            telaP.initTable();
            stage.show();
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaSobre(String id) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaSobre.fxml"));
            SobreController telaP = new SobreController();
            loader.setController(telaP);
            Scene scene = new Scene(loader.load(), 1110, 700);
            scene.getStylesheets().add("Style.css");
            stage.setScene(scene);;
            telaP.setIdUser(id);
            // telaP.initTable();
            stage.show();
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
