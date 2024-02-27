package br.com.fatec.controllers;

import br.com.fatec.DAO.AutosDAO;
import br.com.fatec.Telas;
import br.com.fatec.model.Autos;
import br.com.fatec.model.Cambio;
import br.com.fatec.model.Direcao;
import br.com.fatec.model.Marca;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ExibirAutosView1Controller implements Initializable {

    @FXML
    private Label lblMarca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblQuilo;
    @FXML
    private Label lblCambio;
    @FXML
    private Label lblAno;
    @FXML
    private Label lblDirec;
    @FXML
    private Label lblValor;
    @FXML
    private Button btnDetalhar;
    @FXML
    private Button btnEditar;
    @FXML
    private Label lblOrdem;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnAnterior;
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnExibir;
    @FXML
    private Button btnContrato;
    @FXML
    private Button btnAddauto;
    @FXML
    private Button btnAddcontrato;
    @FXML
    private Button btnConsulta;
    @FXML
    private ComboBox<String> cmbFiltros;
    private ObservableList<String> filtros = 
            FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> cmbItens;
    private ObservableList<String> itens = 
            FXCollections.observableArrayList();
    
    @FXML
    private HBox hboxMenu;
    @FXML
    private Pane painelExibeAuto;
    @FXML
    private Pane painelInfo;
    @FXML
    private Label titulo1;
    @FXML
    private Label titulo2;
    @FXML
    private Label titulo3;
    @FXML
    private Label titulo4;
    @FXML
    private Label titulo5;
    
    private void mensagem(String texto, int tipo) {
        Alert.AlertType tp;
        if(tipo == 1)
            tp = Alert.AlertType.INFORMATION;
        else
            tp = Alert.AlertType.ERROR;
        
        Alert alerta = new Alert(tp, texto, ButtonType.OK);
        alerta.showAndWait();
    }
    
    private int conta = 1, total;
    private char edit = 'U';
    private Cambio cambio;
    private Direcao direcao;
    private Marca marca;
    private Autos auto;
    private LinkedList<Autos> 
            adicionados = new LinkedList<>();
    private ListIterator<Autos> it = adicionados.listIterator();
    private AutosDAO autosDAO = new AutosDAO();

    public void colocar(Autos a){
        lblAno.setText(Float.toString(a.getFabricacao()));
        cambio = a.getCambio();
        lblCambio.setText(cambio.getNome());
        direcao = a.getDirecao();
        lblDirec.setText(direcao.getNome());
        marca = a.getMarca();
        lblMarca.setText(marca.getNome());
        lblModelo.setText(a.getModelo());
        lblQuilo.setText(Float.toString(a.getQuilometragem()));
        lblValor.setText(Float.toString(a.getValor()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            preencherCombo();
            cmbFiltros.setItems(filtros);
            adicionados = new LinkedList<>();
            adicionados = autosDAO.Puxar("");
            it = adicionados.listIterator();
            while(it.hasNext()){
                auto = it.next();
                total++;
                colocar(auto);
            }
            total++;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(total));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }    
    
    private void preencherCombo(){
        try {
            filtros();
        } catch (Exception ex) {
            mensagem("Erro no preenchimento da Combo Categoria: " + 
                    ex.getMessage(), 2);
        }
    }
    
    private void filtros(){
        filtros.add("Placa");
        filtros.add("Chassi");
        filtros.add("Marca");
        filtros.add("Modelo");
        filtros.add("Ano");
        filtros.add("Combustivel");
        filtros.add("Motorizacao");
        filtros.add("Cambio");
        filtros.add("Direcao");
        filtros.add("Preco");
        filtros.add("Categoria");
        filtros.add("Quilometragem");
        filtros.add("MaxVelocidade");
        filtros.add("ID");
    }
    
    @FXML
    private void btnMenu_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.Menu(event);
    }

    @FXML
    private void btnExibir_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.ExibirAutos(event);
    }

    @FXML
    private void btnContrato_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.Contratos(event);
    }

    @FXML
    private void btnAddauto_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.AddAutos(event);
    }

    @FXML
    private void btnAddcontrato_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.AddContrato(event);
    }
    
    @FXML
    private void btnDetalhar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Telas tela = new Telas(auto);
        tela.Detalhe(stage);
    }

    @FXML
    private void btnEditar_Click(ActionEvent event) throws IOException, SQLException {
        Autos autos = new Autos();
        autos.setPlaca(auto.getPlaca());
        auto = autosDAO.buscaID(autos);
        Telas tela = new Telas(edit,auto);
        tela.EditarAutos(event);
    }

    @FXML
    private void btnProximo_Click(ActionEvent event) {
        try {
            if(it.hasPrevious()){
            colocar(it.previous());
            conta++;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(total));
        }
        else {
            JOptionPane.showMessageDialog(null, "Voce chegou no Fim da Lista", "Fim da Lista", JOptionPane.YES_OPTION);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }

    @FXML
    private void btnAnterior_Click(ActionEvent event) {
        try {
            if(it.hasNext()){
            colocar(it.next());
            conta--;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(total));
        }
        else {
            JOptionPane.showMessageDialog(null, "Voce chegou no Fim da Lista", "Fim da Lista", JOptionPane.YES_OPTION);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }

    @FXML
    private void btnConsulta_Click(ActionEvent event) {
        try {
            String teste = cmbFiltros.getValue();
            teste = consultarBD(teste);
            String filtro = cmbFiltros.getValue() + " = '" + teste + "'";
            adicionados = new LinkedList<>();
            adicionados = autosDAO.Puxar(filtro);
            it = adicionados.listIterator();
            total = 0;
            while(it.hasNext()){
                auto = it.next();
                total++;
                colocar(auto);
            }
            total++;
            conta = 1;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(total));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }

    @FXML
    private void cmbFiltro_Click(ActionEvent event) {
        preencherItens();
        cmbItens.setItems(itens);
    }
    
    private void preencherItens() {
        try {
            String filtro = cmbFiltros.getValue();
            adicionados = new LinkedList<>();
            adicionados = autosDAO.Puxar("");
            it = adicionados.listIterator();
            if(cmbItens.getItems() != null) {
                cmbItens.getItems().clear();
            }
            while(it.hasNext()){
                auto = it.next();
                itens.add(auto.voltaString(filtro));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }
    
    private String consultarBD(String aqui) throws SQLException {
        switch (aqui) {
            case "Placa":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getPlaca().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Chassi":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getChassi().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Marca":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getMarca().getNome().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Modelo":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getModelo().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Ano":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(Integer.toString(auto.getFabricacao()).equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Combustivel":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getCombustivel().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Motorizacao":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getMotorizacao().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Cambio":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getCambio().getNome().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Direcao":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getDirecao().getNome().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Preco":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(Float.toString(auto.getValor()).equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Categoria":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getCategoria().getNome().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "Quilometragem":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(Float.toString(auto.getQuilometragem()).equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "MaxVelocidade":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getVelocidade().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            case "ID":
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(Integer.toString(auto.getOrdem()).equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
            default:
                adicionados = new LinkedList<>();
                adicionados = autosDAO.Puxar("");
                it = adicionados.listIterator();
                while(it.hasNext()){
                    auto = it.next();
                    if(auto.getPlaca().equals(cmbItens.getValue())){
                        aqui = auto.volta(cmbFiltros.getValue());
                        break;
                    }
                }
                return aqui;
        }
    }
}
