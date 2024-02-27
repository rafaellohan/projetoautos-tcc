package br.com.fatec.controllers;

import br.com.fatec.DAO.AutosDAO;
import br.com.fatec.DAO.BloqueioDAO;
import br.com.fatec.DAO.CartaoDAO;
import br.com.fatec.DAO.UsuarioDAO;
import br.com.fatec.DAO.UsuarioFrotaDAO;
import br.com.fatec.Telas;
import br.com.fatec.model.Autos;
import br.com.fatec.model.Bloqueio;
import br.com.fatec.model.Cambio;
import br.com.fatec.model.Cartao;
import br.com.fatec.model.Marca;
import br.com.fatec.model.Usuario;
import br.com.fatec.model.UsuarioFrota;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javax.swing.JOptionPane;


public class ConVisualizarView1Controller implements Initializable {

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
    private TextField txtNome;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private TextField txtIden;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCell;
    @FXML
    private TextField txtEnde;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtEstado;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnConsulta;
    @FXML
    private ComboBox<Usuario> cmbConsulta;
    @FXML
    private Label lblAluguel;
    @FXML
    private Label lblStart;
    @FXML
    private Label lblFim;
    @FXML
    private Label lblMarca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblQuilo;
    @FXML
    private Label lblCambio;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblTotal;
    @FXML
    private Button btnDeleta;
    @FXML
    private Pane painelConsultar;
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
    @FXML
    private Label titulo6;
    @FXML
    private Label titulo7;
    @FXML
    private Label titulo8;
    @FXML
    private VBox vboxMenu;
    @FXML
    private Pane painelInfo;
    @FXML
    private Label tituloVisao;
    @FXML
    private Label tituloInfo;
    @FXML
    private Label tituloAluguel;
    @FXML
    private Label tituloComeco;
    @FXML
    private Label tituloFim;
    @FXML
    private Pane pane1;
    @FXML
    private GridPane gridPane1;
    @FXML
    private Label tituloQuilo;
    @FXML
    private Label tituloValor;
    @FXML
    private Label tituloTotal;
    @FXML
    private Label tituloInfo2;
    @FXML
    private Label tituloCambio;
    @FXML
    private SVGPath lupa;
    @FXML
    private Label lblTaxa;
    @FXML
    private Label tituloTaxa;
    @FXML
    private Label lblPlaca;
    @FXML
    private Button btnBlock;
    
    private void mensagem(String texto, int tipo) {
        Alert.AlertType tp;
        if(tipo == 1)
            tp = Alert.AlertType.INFORMATION;
        else
            tp = Alert.AlertType.ERROR;
        
        Alert alerta = new Alert(tp, texto, ButtonType.OK);
        alerta.showAndWait();
    }
    
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ObservableList<Usuario> usuarios = 
            FXCollections.observableArrayList();
    
    private void colocarUsu(Usuario u){
        txtNome.setText(u.getNome());
        txtSobrenome.setText(u.getSobrenome());
        txtIden.setText(u.getCPF());
        txtEmail.setText(u.getEmail());
        txtCell.setText(u.getTelefone());
        txtEnde.setText(u.getEndereco());
        txtCidade.setText(u.getCidade());
        txtEstado.setText(u.getEstado());
    }
    
    private Usuario moveTelaModelUsu(){
        usuario = new Usuario();
        usuario.setNome(txtNome.getText());
        usuario.setSobrenome(txtSobrenome.getText());
        usuario.setCPF(txtIden.getText());
        usuario.setEmail(txtEmail.getText());
        usuario.setTelefone(txtCell.getText());
        usuario.setEndereco(txtEnde.getText());
        usuario.setCidade(txtCidade.getText());
        usuario.setEstado(txtEstado.getText());
        
        return usuario;
    }
    
    private UsuarioFrota usuarioFrota;
    private UsuarioFrotaDAO usuFrotaDAO = new UsuarioFrotaDAO();
        
    public void colocarUsuFrota(UsuarioFrota uf) {
        lblAluguel.setText(uf.getAluguel());
        lblStart.setText(uf.getComeco());
        lblFim.setText(uf.getFim());
        lblTotal.setText(Float.toString(uf.getTotal()));
        lblValor.setText(Float.toString(uf.getSubTotal()));
        lblTaxa.setText(Float.toString(uf.getTaxa()));
    }
    
    private Cartao cartao;
    private CartaoDAO cartaoDAO = new CartaoDAO();
    
    private Cartao moveModelTelaCartao(Cartao cartao) throws SQLException {
        cartao = new Cartao();
        cartao.setNumero(usuario.getCartao().getNumero());
        cartao = cartaoDAO.buscaID(cartao);
        
        return cartao;
    }
    
    private Cambio cambio;
    private Marca marca;
    private Autos auto;
    private AutosDAO autosDAO = new AutosDAO();
    
    public void colocarAuto(Autos a){
        cambio = a.getCambio();
        lblCambio.setText(cambio.getNome());
        marca = a.getMarca();
        lblMarca.setText(marca.getNome());
        lblModelo.setText(a.getModelo());
        lblQuilo.setText(Float.toString(a.getQuilometragem()));
        lblPlaca.setText(a.getPlaca());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            preencherCombo();
            cmbConsulta.setItems(usuarios);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }
    
    private void preencherCombo(){
        try {
            usuarios.addAll(usuarioDAO.lista(""));
        } catch (SQLException ex) {
            mensagem("Erro no preenchimento da Combo Categoria: " + 
                    ex.getMessage(), 2);
        }
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
    private void btnEditar_Click(ActionEvent event) throws IOException, SQLException {
        usuario = new Usuario();
        usuario.setCPF(txtIden.getText());
        usuario = usuarioDAO.buscaID(usuario);
        
        usuarioFrota = new UsuarioFrota();
        usuarioFrota.setUsuario(usuario);
        usuarioFrota = usuFrotaDAO.buscaID(usuarioFrota);
        
        auto = new Autos();
        auto.setPlaca(usuarioFrota.getAutos().getPlaca());
        auto = autosDAO.buscaID(auto);
        
        cartao = new Cartao();
        cartao = moveModelTelaCartao(cartao);
        Telas tela = new Telas(auto, usuario, usuarioFrota, cartao);
        tela.EditarContrato(event);
    }

    @FXML
    private void btnConsulta_Click(ActionEvent event) throws SQLException {
        usuario = new Usuario();
        usuario.setCPF(cmbConsulta.getValue().getCPF());
        usuario = usuarioDAO.buscaID(usuario);
        colocarUsu(usuario);
        
        usuarioFrota = new UsuarioFrota();
        usuarioFrota.setUsuario(usuario);
        usuarioFrota = usuFrotaDAO.buscaID(usuarioFrota);
        colocarUsuFrota(usuarioFrota);
        
        auto = new Autos();
        auto.setPlaca(usuarioFrota.getAutos().getPlaca());
        auto = autosDAO.buscaID(auto);
        colocarAuto(auto);
    }
    
    private Bloqueio block;
    private BloqueioDAO blockDAO = new BloqueioDAO();

    private Bloqueio moveTelaModelBlock() {
        block = new Bloqueio();
        block.setCPFCNPJ(txtIden.getText());
                
        return block;
    };
    
    @FXML
    private void btnBlock_Click(ActionEvent event) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, ""
                 + "Certeza que deseja Bloquear o Contrato?", "Bloquear Contrato", 
                 JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            remover();
            block = moveTelaModelBlock();
            blockDAO.insere(block);
            resetar();
        }
    }

    @FXML
    private void btnDeleta_Click(ActionEvent event) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, ""
                 + "Certeza que deseja Deletar o Contrato?", "Deletar Contrato", 
                 JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            remover();
            resetar();
        }
    }
    
    private void remover() throws SQLException{
        usuario = moveTelaModelUsu();
        usuario = usuarioDAO.buscaID(usuario);
        usuarioFrota = new UsuarioFrota();
        usuarioFrota.setUsuario(usuario);
        usuarioFrota = usuFrotaDAO.buscaID(usuarioFrota);
        cartao = new Cartao();
        cartao = moveModelTelaCartao(cartao);
        usuFrotaDAO.remove(usuarioFrota);
        usuarioDAO.remove(usuario);
        cartaoDAO.remove(cartao);
    }
    
    private void resetar() {
        limpar();
        cmbConsulta.getItems().clear();
        preencherCombo();
        cmbConsulta.setItems(usuarios);
    }
    
    private void limpar(){
        txtNome.clear();
        txtSobrenome.clear();
        txtIden.clear();
        txtEmail.clear();
        txtCell.clear();
        txtEnde.clear();
        txtCidade.clear();
        txtEstado.clear();
        
        txtNome.requestFocus();
    }
}
