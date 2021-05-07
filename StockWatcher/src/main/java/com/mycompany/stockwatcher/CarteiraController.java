package com.mycompany.stockwatcher;

//import com.mysql.cj.result.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.Cell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CarteiraController {

    @FXML
    private TableView<Carteira> tabelaCarteira;
    @FXML
    private TableColumn<Carteira, String> colNome;

    @FXML
    private TableColumn<Carteira, String> colTipo;

    @FXML
    private TableColumn<Carteira, Integer> colQtd;

    @FXML
    private TableColumn<Carteira, Double> colPrecoMedio;

    @FXML
    private TableColumn<Carteira, Double> colPrecoAtual;

    @FXML
    private TableColumn<Carteira, Double> colPatrimonio;

    @FXML
    private TableColumn<Carteira, Double> colValorGasto;

    @FXML
    private TableColumn<Carteira, Double> colVariacao;

    @FXML
    private TableColumn<Carteira, Double> colVariacaoPor;

    @FXML
    private TableColumn<Carteira, Double> colPosicao;

    @FXML
    private Button btnFavoritos;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnSobre;

    @FXML
    private Button btnHistorico;

    @FXML
    private Button btnDuvida;
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

    @FXML
    void acaoDuvida(ActionEvent event) {
        trocaTelaDuvida();
    }

    @FXML
    void acaoExcel(ActionEvent event) {
        System.out.println("FOI AQUI");
        popular_tabela();
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

    public List<DadosExcel> getExcel(File file) {
        List<DadosExcel> tabelaExcel = null;
        DadosExcel excel = new DadosExcel();
        Integer qtd;
        
        //obtaining input bytes from a file  
        try {
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
            System.out.println(fis.getFD());
            System.out.println(file.getAbsoluteFile());
//creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object 
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
                excel = new DadosExcel();
                Cell cell = cellIterator.next();
                excel.setData((Date) cell.getDateCellValue());
                cell = cellIterator.next();
                excel.setTipo(cell.getStringCellValue());
                cell = cellIterator.next();
                excel.setNome(cell.getStringCellValue());
                cell = cellIterator.next();
                excel.setPreco(cell.getNumericCellValue());
                cell = cellIterator.next();
                excel.setQtd((int) cell.getNumericCellValue());
                cell = cellIterator.next();
                excel.setOperacao(cell.getStringCellValue());

                tabelaExcel.add(excel);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return tabelaExcel;
    }

    public void popular_tabela() {
        File file = getFile();
        System.out.println("After File");
        List<DadosExcel> excel = getExcel(file);
        System.out.println("After Excel");
        List<Carteira> dados = pegar_tabela(excel);
        System.out.println("After Table");
        tabela(dados);
        System.out.println("Working :)");
        //tabelaAcoes.setItems(FXCollections.observableArrayList(carteiras));
    }

    private void tabela(List<Carteira> dados) {
        colNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        colQtd.setCellValueFactory(new PropertyValueFactory("qtd"));
        colPrecoMedio.setCellValueFactory(new PropertyValueFactory("preco_medio"));
        colPrecoAtual.setCellValueFactory(new PropertyValueFactory("preco_atual"));
        colPatrimonio.setCellValueFactory(new PropertyValueFactory("patrimanio_atual"));
        colValorGasto.setCellValueFactory(new PropertyValueFactory("valor_gasto"));
        colVariacao.setCellValueFactory(new PropertyValueFactory("variação_valor"));
        colVariacaoPor.setCellValueFactory(new PropertyValueFactory("variação_porc"));
        colPosicao.setCellValueFactory(new PropertyValueFactory("posição"));

        tabelaCarteira.setItems((ObservableList<Carteira>) dados);
    }

    private List<Carteira> pegar_tabela(List<DadosExcel> excel) {
        ArrayList<String> salvos = new ArrayList<String>();
        List<Carteira> carteiras = null;
        Carteira carteira = null;
        String nome_col;
        int qtd;
        int qtd_compra;
        double valor_compra;
        double total_pago;
        double preco_medio;
        double preco_atual;
        StockGrabber acao = new StockGrabber();
        FiiGrabber fundo = new FiiGrabber();
        for (DadosExcel dado : excel) {
            carteira = null;
            qtd = 0;
            qtd_compra = 0;
            total_pago = 0;
            valor_compra = 0;
            preco_medio = 0;
            preco_atual = 0;
            if (salvos.contains(dado.getNome()) == false) {
                nome_col = dado.getNome();
                for (DadosExcel dado2 : excel) {
                    if (dado2.getNome().equals(nome_col)) {

                        if (dado2.getTipo() == "C") {
                            qtd_compra += dado2.getQtd();
                            total_pago += (dado2.getPreco() * dado2.getQtd());
                            qtd += dado2.getQtd();
                        } else {
                            total_pago -= dado2.getPreco();
                            qtd -= dado2.getQtd();
                        }
                    }
                }
                preco_medio = total_pago / qtd_compra;
                preco_atual = 2;
                if (dado.getTipo() == "C") {
                    preco_atual = Double.parseDouble(acao.grabStock(dado.getNome())[0]);
                } else {
                    preco_atual = Double.parseDouble(fundo.grabFund(dado.getNome())[0]);
                }
                carteira.setNome(dado.getNome());
                carteira.setQtd(qtd);
                carteira.setPreco_medio(preco_medio);
                carteira.setTipo(dado.getTipo());
                //carteira.setTotal_pago(total_pago);
                carteira.setPreco_atual(preco_atual);
                carteira.setPatrimanio_atual(preco_atual * qtd);
                carteira.setValor_gasto(qtd * preco_medio);
                carteira.setVariação_valor((preco_atual * qtd) - (preco_medio * qtd));
                carteira.setVariação_porc((carteira.getVariação_valor() * 100) / (preco_medio * qtd));
                carteira.setPosição(carteira.getVariação_valor() * 100 / carteira.getPatrimanio_atual());

                carteiras.add(carteira);
                salvos.add(nome_col);
            }

        }
        return carteiras;
    }

    void trocaTelaPesquisar(String id
    ) {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaPesquisar.fxml"));
            PesquisarController telaP = new PesquisarController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));
            telaP.setIdUser(id);
            stage.show();
            stage.setResizable(false);
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
            stage.setResizable(false);
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaFavorito(String id
    ) {
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
            stage.setResizable(false);
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaSobre(String id
    ) {
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
            stage.setResizable(false);
            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void trocaTelaDuvida() {
        Stage stage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaDuvidas.fxml"));
            DuvidasController telaP = new DuvidasController();
            loader.setController(telaP);
            stage.setScene(new Scene(loader.load(), 1110, 700));
            stage.show();
            stage.setResizable(false);
//            Stage stage2 = (Stage) btnFavoritos.getScene().getWindow();
//            stage2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
