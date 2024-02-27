package br.com.fatec.controllers;

import br.com.fatec.DAO.AutosDAO;
import br.com.fatec.DAO.CambioDAO;
import br.com.fatec.DAO.CategoriaDAO;
import br.com.fatec.DAO.DirecaoDAO;
import br.com.fatec.DAO.MarcaDAO;
import br.com.fatec.Telas;
import br.com.fatec.model.Autos;
import br.com.fatec.model.Cambio;
import br.com.fatec.model.Categoria;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AddView2Controller implements Initializable {

    @FXML
    private Button btnMenu;
    @FXML
    private Button btnExibir;
    @FXML
    private Button btnAddauto;
    @FXML
    private Button btnContrato;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnLimpar;
    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnSalvar;
    @FXML
    private TextField txtModelo;
    @FXML
    private TextField txtMoto;
    @FXML
    private TextField txtComb;
    @FXML
    private TextField txtVelomax;
    @FXML
    private TextField txtAno;
    @FXML
    private TextField txtValor;
    @FXML
    private ComboBox<Marca> cmbMarca;
    @FXML
    private ComboBox<Cambio> cmbCambio;
    @FXML
    private ComboBox<Direcao> cmbDirecao;
    @FXML
    private ImageView imgCarro;
    @FXML
    private Button btnConsulta;
    @FXML
    private Button btnExcluir;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnAddcontrato;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtChassi;
    @FXML
    private ComboBox<Categoria> cmbCategoria;
    @FXML
    private TextField txtQuilo;
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
    private ImageView imgCarro1;
    @FXML
    private Label lblOrdem;
    @FXML
    private Button btnExcluir1;
    @FXML
    private Button btnSalvar1;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnAnterior;
    @FXML
    private AnchorPane apColecao;
    @FXML
    private Label lblInvisivel;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnEditar1;
    @FXML
    private Label titulo1;
    @FXML
    private Label titulo2;
    @FXML
    private Label titulo6;
    @FXML
    private Label titulo5;
    @FXML
    private Label titulo7;
    @FXML
    private Label titulo8;
    @FXML
    private Label titulo3;
    @FXML
    private Label titulo4;
    @FXML
    private VBox vboxMenu;
    
    private void mensagem(String texto, int tipo) {
        Alert.AlertType tp;
        if(tipo == 1)
            tp = Alert.AlertType.INFORMATION;
        else
            tp = Alert.AlertType.ERROR;
        
        Alert alerta = new Alert(tp, texto, ButtonType.OK);
        alerta.showAndWait();
    }
    
    private int contar = 1;
    private char edit;
    
    private Cambio cambio;
    private ObservableList<Cambio> cambios = 
            FXCollections.observableArrayList();
    private CambioDAO cambioDAO = new CambioDAO();
    
    private Categoria categoria;
    private ObservableList<Categoria> categorias = 
            FXCollections.observableArrayList();
    private CategoriaDAO cateDAO = new CategoriaDAO();
    
    private Direcao direcao;
    private ObservableList<Direcao> direcoes = 
            FXCollections.observableArrayList();
    private DirecaoDAO direDAO = new DirecaoDAO();
    
    private Marca marca;
    private ObservableList<Marca> marcas = 
            FXCollections.observableArrayList();
    private MarcaDAO marcaDAO = new MarcaDAO();
    
    private void preencherCombo(){
        try {
              cambios.addAll(cambioDAO.lista(""));
              categorias.addAll(cateDAO.lista(""));
              direcoes.addAll(direDAO.lista(""));
              marcas.addAll(marcaDAO.lista(""));
        } catch (SQLException ex) {
            mensagem("Erro no preenchimento da Combo Categoria: " + 
                    ex.getMessage(), 2);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherCombo();
        cmbCambio.setItems(cambios);
        cmbCategoria.setItems(categorias);
        cmbDirecao.setItems(direcoes);
        cmbMarca.setItems(marcas);
    }
    
    public void Adicionar(){
        btnSalvar.setVisible(false);
        btnExcluir.setVisible(false);
        btnConsulta.setVisible(false);
        apColecao.setVisible(true);
        btnAdicionar.setVisible(true);
        btnEditar1.setVisible(true);
        lblTitulo.setText("ADICIONAR AUTOMOVEL");
    }
    
    public void Editar(char edit){
        btnAdicionar.setVisible(false);
        btnSalvar.setVisible(true);
        btnExcluir.setVisible(true);
        btnConsulta.setVisible(true);
        btnEditar1.setVisible(false);
        lblTitulo.setText("EDITAR AUTOMOVEL");
    }
    
    public void Editar(char edit, Autos auto) throws SQLException{
        btnAdicionar.setVisible(false);
        btnSalvar.setVisible(true);
        btnExcluir.setVisible(true);
        btnConsulta.setVisible(true);
        lblTitulo.setText("EDITAR AUTOMOVEL");
        apColecao.setVisible(false);
        btnEditar1.setVisible(false);
        
        txtPlaca.setText(auto.getPlaca());
        auto = new Autos();
        auto.setPlaca(txtPlaca.getText());
        auto = autosDAO.buscaID(auto);
        moveModelTela(auto);
        this.edit = edit;
    }
    
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
        lblOrdem.setText(Integer.toString(a.getOrdem()));
        lblInvisivel.setText(a.getPlaca());
    }
    
    private Autos auto;
    private LinkedList<Autos> 
            adicionados = new LinkedList<>();
    private ListIterator<Autos> it = adicionados.listIterator();
    private AutosDAO autosDAO = new AutosDAO();
    
    private Autos moveTelaModel1(){
        auto = new Autos();
        auto = moveTelaModel(auto);
        auto.setOrdem(contar);
        
        return auto;
    }
    
    private Autos moveTelaModel2(){
        auto = new Autos();
        auto = moveTelaModel(auto);
        auto.setOrdem(Integer.parseInt(lblOrdem.getText()));
        
        return auto;
    }
    
    private Autos moveTelaModel(Autos auto){
        auto.setCambio(cmbCambio.getValue());
        auto.setCategoria(cmbCategoria.getValue());
        auto.setChassi(txtChassi.getText());
        auto.setCombustivel(txtComb.getText());
        auto.setDirecao(cmbDirecao.getValue());
        auto.setFabricacao(Integer.parseInt(txtAno.getText()));
        auto.setMarca(cmbMarca.getValue());
        auto.setModelo(txtModelo.getText());
        auto.setMotorizacao(txtMoto.getText());
        auto.setPlaca(txtPlaca.getText());
        auto.setQuilometragem(Float.parseFloat(txtQuilo.getText()));
        auto.setValor(Float.parseFloat(txtValor.getText()));
        auto.setVelocidade(txtVelomax.getText());
        
        return auto;
    }
    
    private void moveModelTela(Autos a){
        txtAno.setText(Integer.toString(a.getFabricacao()));
        txtChassi.setText(a.getChassi());
        txtComb.setText(a.getCombustivel());
        txtModelo.setText(a.getModelo());
        txtMoto.setText(a.getMotorizacao());
        txtPlaca.setText(a.getPlaca());
        txtQuilo.setText(Float.toString(a.getQuilometragem()));
        txtValor.setText(Float.toString(a.getValor()));
        txtVelomax.setText(a.getVelocidade());
        cambio = a.getCambio();
        cmbCambio.setValue(cambio);
        categoria = a.getCategoria();
        cmbCategoria.setValue(categoria);
        direcao = a.getDirecao();
        cmbDirecao.setValue(direcao);
        marca = a.getMarca();
        cmbMarca.setValue(marca);
        lblOrdem.setText(Integer.toString(a.getOrdem()));
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
    private void btnAddauto_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.AddAutos(event);
    }

    @FXML
    private void btnContrato_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.Contratos(event);
    }
    
    @FXML
    private void btnAddcontrato_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.AddContrato(event);
    }

    @FXML
    private void btnCancelar_Click(ActionEvent event) throws IOException {
        if(edit != 'U'){
            Telas tela = new Telas();
            tela.ExibirAutos(event);
        } else {
            Adicionar();
        }
    }
    
    @FXML
    private void btnConsulta_Click(ActionEvent event) throws IOException, SQLException {
        Autos autos = new Autos();
        autos.setPlaca(txtPlaca.getText());
        auto = autosDAO.buscaID(autos);
        Telas tela = new Telas(auto);
        tela.Consulta(event);
    }

    @FXML
    private void btnLimpar_Click(ActionEvent event) {
        limpar();
    }
    
    private void limpar(){
        txtAno.clear();
        txtChassi.clear();
        txtComb.clear();
        txtModelo.clear();
        txtMoto.clear();
        txtPlaca.clear();
        txtQuilo.clear();
        txtValor.clear();
        txtVelomax.clear();
        cmbCambio.valueProperty().set(null);
        cmbCategoria.valueProperty().set(null);
        cmbDirecao.valueProperty().set(null);
        cmbMarca.valueProperty().set(null);
        
        cmbMarca.requestFocus();
    }

    @FXML
    private void btnAdicionar_Click(ActionEvent event) {
        try {
            Autos autos = new Autos();
            autos.setPlaca(txtPlaca.getText());
            autos = autosDAO.buscaID(autos);
            if(autos != null){
                JOptionPane.showMessageDialog(null, "Placa ja existe no Banco de Dados", "Placa Duplicada", JOptionPane.OK_OPTION);
                auto = new Autos();
                auto.setPlaca(txtPlaca.getText());
                auto = autosDAO.buscaID(auto);
                moveModelTela(auto);
            } else {
                auto = moveTelaModel1();
                autosDAO.insere(auto);
                JOptionPane.showMessageDialog(null, "Placa Adicionada no Banco de Dados", "Placa Adicionada", JOptionPane.OK_OPTION);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }
    
    @FXML
    private void btnSalvar_Click(ActionEvent event) throws SQLException {
        try {
            auto = moveTelaModel2();
            Autos autos = new Autos();
            autos.setPlaca(txtPlaca.getText());
            autos = autosDAO.buscaID(autos);
            if(autos != null){
            autosDAO.altera(auto);
            JOptionPane.showMessageDialog(null, "Automovel Alterado com Sucesso", "Automovel Alterado", JOptionPane.OK_OPTION);
            } else if(autos == null) {
                auto = moveTelaModel1();
                autosDAO.insere(auto);
                JOptionPane.showMessageDialog(null, "Placa Adicionada no Banco de Dados", "Placa Adicionada", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }

    @FXML
    private void btnExcluir_Click(ActionEvent event) {
        try {
            auto = moveTelaModel2();
        
            if(edit == 'U'){
            autosDAO.remove(auto);
            JOptionPane.showMessageDialog(null, "Automovel Excluido com Sucesso", "Automovel Excluido", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }
           
    @FXML
    private void btnBuscar_Click(ActionEvent event) {
        try {
            auto = new Autos();
            auto.setPlaca(txtPlaca.getText());
            auto = autosDAO.buscaID(auto);
            moveModelTela(auto);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Placa não existe no Banco de Dados", "Sem Placa", JOptionPane.OK_OPTION);
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }

    @FXML
    private void btnEditar1_Click(ActionEvent event) {
        try {
            edit = 'U';
            Autos autos = new Autos();
            if(txtPlaca.getText().isEmpty()) {
                Editar(edit);
            } else {
                autos.setPlaca(txtPlaca.getText());
                auto = autosDAO.buscaID(autos);
                Telas tela = new Telas(edit,auto);
                tela.EditarAutos(event);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Placa não existe no Banco de Dados", "Sem Placa", JOptionPane.OK_OPTION);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro Ao Chamar Tela: " + ex.getMessage(), "Erro Tela", JOptionPane.OK_OPTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }
}
