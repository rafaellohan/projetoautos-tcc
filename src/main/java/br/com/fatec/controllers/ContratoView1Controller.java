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
import br.com.fatec.model.Direcao;
import br.com.fatec.model.Marca;
import br.com.fatec.model.Usuario;
import br.com.fatec.model.UsuarioFrota;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class ContratoView1Controller implements Initializable {

    @FXML
    private TextField txtNome;
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
    private Button btnMenu;
    @FXML
    private Button btnExibir;
    @FXML
    private Button btnAddauto;
    @FXML
    private Button btnContrato;
    @FXML
    private RadioButton rdbDiario;
    @FXML
    private RadioButton rdbSemanal;
    @FXML
    private RadioButton rdbQuize;
    @FXML
    private RadioButton rdbMes;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblAluguel;
    @FXML
    private RadioButton rdbDebito;
    @FXML
    private RadioButton rdbCredito;
    @FXML
    private Button btnConcluir;
    @FXML
    private Label lblSubtotal;
    @FXML
    private Label lblTaxa;
    @FXML
    private Label lblTotal;
    @FXML
    private TextField txtNomecard;
    @FXML
    private TextField txtNumcard;
    @FXML
    private TextField txtCVVcard;
    @FXML
    private TextField txtVencicard;
    @FXML
    private TextField txtSobrenome;
    @FXML
    private Button btnAddcontrato;
    @FXML
    private Pane pnCarros;
    @FXML
    private ToggleGroup aluguel;
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
    private Button btnDetalhar;
    @FXML
    private Label lblOrdem;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnAnterior;
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
    private ToggleGroup cartao;
    @FXML
    private Button btnLimpar;
    @FXML
    private RadioButton rdbMaster;
    @FXML
    private RadioButton rdbVisa;
    @FXML
    private ToggleGroup bandeira;
    @FXML
    private TextField txtStart;
    @FXML
    private TextField txtFim;
    @FXML
    private Label lblPlaca;
    @FXML
    private Pane painelContratos;
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
    private Label tituloInfo;
    @FXML
    private VBox vboxMenu;
    @FXML
    private Pane painelAluguel;
    @FXML
    private Pane painelPagamento;
    @FXML
    private Label tituloBandeira;
    @FXML
    private Label txtSub;
    @FXML
    private Label txtTax;
    @FXML
    private Label txtTotal;
    @FXML
    private Label tituloCNome;
    @FXML
    private Label tituloCNumero;
    @FXML
    private Label tituloCCVV;
    @FXML
    private Label tituloCVencimento;
    @FXML
    private Pane painelCarro;
    @FXML
    private Label tituloQ;
    @FXML
    private Label tituloC;
    @FXML
    private Label tituloF;
    @FXML
    private Label tituloD;
    @FXML
    private Pane painelPreco;
    @FXML
    private Label tituloPreco;
    @FXML
    private Label tituloAluguel;
    @FXML
    private Label tituloComeco1;
    @FXML
    private Label tituloTermino;
    @FXML
    private Label tituloVisao;
    
    private void mensagem(String texto, int tipo) {
        Alert.AlertType tp;
        if(tipo == 1)
            tp = Alert.AlertType.INFORMATION;
        else
            tp = Alert.AlertType.ERROR;
        
        Alert alerta = new Alert(tp, texto, ButtonType.OK);
        alerta.showAndWait();
    }
    
    private int conta = 1, totalAuto;
    private Cambio cambio;
    private Direcao direcao;
    private Marca marca;
    private Autos auto;
    private LinkedList<Autos> 
            adicionados = new LinkedList<>();
    private ListIterator<Autos> it = adicionados.listIterator();
    private AutosDAO autosDAO = new AutosDAO();
    
    public void colocarAuto(Autos a){
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
        lblPlaca.setText(a.getPlaca());
    }
    
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Collection<Usuario> usuarios = new ArrayList<>();
    private Iterator<Usuario> usu = usuarios.iterator();
    
    private Usuario moveTelaModelUsu(){
        try {
            usuario = new Usuario();
            usuario.setNome(txtNome.getText());
            usuario.setSobrenome(txtSobrenome.getText());
            usuario.setCPF(txtIden.getText());
            usuario.setEmail(txtEmail.getText());
            usuario.setTelefone(txtCell.getText());
            usuario.setEndereco(txtEnde.getText());
            usuario.setCidade(txtCidade.getText());
            usuario.setEstado(txtEstado.getText());
            carta.setNumero(Integer.parseInt(txtNumcard.getText()));
            usuario.setCartao(cartaoDAO.buscaID(carta));
            usuario.setCartao(moveTelaModelCartao());
        } /*catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        }*/ catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Usuario: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
        return usuario;
    }
    
    public void colocarUsu(Usuario u) {
        txtNome.setText(u.getNome());
        txtSobrenome.setText(u.getSobrenome());
        txtIden.setText(u.getCPF());
        txtEmail.setText(u.getEmail());
        txtCell.setText(u.getTelefone());
        txtEnde.setText(u.getEndereco());
        txtCidade.setText(u.getCidade());
        txtEstado.setText(u.getEstado());
    }
    
    private UsuarioFrota usuarioFrota;
    private UsuarioFrotaDAO usuFrotaDAO = new UsuarioFrotaDAO();
    
    private UsuarioFrota moveTelaModelUsuFrota(){
        try {
            usuarioFrota = new UsuarioFrota();
            usuarioFrota.setAluguel(lblAluguel.getText());
            usuarioFrota.setComeco(txtStart.getText());
            usuarioFrota.setFim(txtFim.getText());
            usuarioFrota.setTotal(total);
            usuarioFrota.setTaxa(valorTaxa);
            usuarioFrota.setSubTotal(subTotal);
            Autos auto = new Autos();
            auto.setPlaca(lblPlaca.getText());
            usuarioFrota.setAutos(autosDAO.buscaID(auto));
            usuarioFrota.setUsuario(moveTelaModelUsu());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No UsuarioFrota: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
        return usuarioFrota;
    }
    
    public void colocarUsuFrota(UsuarioFrota uf) {
        lblAluguel.setText(uf.getAluguel());
        txtStart.setText(uf.getComeco());
        txtFim.setText(uf.getFim());
        lblTotal.setText(Float.toString(uf.getTotal()));
        lblSubtotal.setText(Float.toString(uf.getSubTotal()));
        lblTaxa.setText(Float.toString(uf.getTaxa()));
        switch (lblAluguel.getText()) {
            case "Diaria":
                rdbDiario.setSelected(true);
                break;
            case "Semanal":
                rdbSemanal.setSelected(true);
                break;
            case "Quinzenal":
                rdbQuize.setSelected(true);
                break;
            case "Mensal":
                rdbMes.setSelected(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Erro No Java: ", "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }
    
    private Cartao carta;
    private CartaoDAO cartaoDAO = new CartaoDAO();
    
    public Cartao moveTelaModelCartao(){
        carta = new Cartao();
        carta.setCVV(Integer.parseInt(txtCVVcard.getText()));
        carta.setNome(txtNomecard.getText());
        carta.setNumero(Integer.parseInt(txtNumcard.getText()));
        carta.setVence(txtVencicard.getText());
        if(rdbCredito.isSelected()){
            carta.setTipo("Credito");
        } else if(rdbDebito.isSelected()) {
            carta.setTipo("Debido");
        }
        if(rdbMaster.isSelected()){
            carta.setBandeira("MasterCard");
        } else if(rdbVisa.isSelected()){
            carta.setBandeira("Visa");
        }
        
        return carta;
    }
    
    public void colocarCartao(Cartao c){
        txtNomecard.setText(c.getNome());
        txtNumcard.setText(Integer.toString(c.getNumero()));
        txtVencicard.setText(c.getVence());
        txtCVVcard.setText(Integer.toString(c.getCVV()));
        if(c.getTipo().equals("Credito")){
            rdbCredito.setSelected(true);
        } else if(c.getTipo().equals("Debito")) {
            rdbDebito.setSelected(true);
        }
        if(c.getBandeira().equals("MasterCard")){
            rdbMaster.setSelected(true);
        } else if(c.getBandeira().equals("Visa")){
            rdbVisa.setSelected(true);
        }
    }
    
    public void cartaos(){
        if(rdbCredito.isSelected()){
            carta.setTipo("Credito");
        } else if(rdbDebito.isSelected()) {
            carta.setTipo("Debido");
        }
        if(rdbMaster.isSelected()){
            carta.setBandeira("MasterCard");
        } else if(rdbVisa.isSelected()){
            carta.setBandeira("Visa");
        }
    }
    
    private Bloqueio block;
    private BloqueioDAO blockDAO = new BloqueioDAO();

    private Bloqueio moveTelaModelBlock() {
        block = new Bloqueio();
        block.setCPFCNPJ(txtIden.getText());
                
        return block;
    };
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            preencherCombo();
            cmbFiltros.setItems(filtros);
            adicionados = new LinkedList<>();
            adicionados = autosDAO.Puxar("");
            it = adicionados.listIterator();
            Autos a = new Autos();
            a = it.next();
            colocarAuto(a);
            it.previous();
            while(it.hasNext()){
                it.next();
                totalAuto++;
            }
            totalAuto++;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(totalAuto));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
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
    private void btnDetalhar_Click(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Telas tela = new Telas(auto);
        tela.Detalhe(stage);
    }
    
    @FXML
    private void btnConcluir_Click(ActionEvent event) {
        try {
            char InUp = 'I';
            block = new Bloqueio();
            block = moveTelaModelBlock();
            block = blockDAO.buscaID(block);
            if(block != null){
                InUp = 'B';
            }
            usuarios = new ArrayList<>();
            usuarios = usuarioDAO.lista("");
            if(!usuarios.isEmpty() || InUp == 'I'){
                usu = usuarios.iterator();
                while(usu.hasNext()){
                    usuario = usu.next();
                    if(usuario.getCPF().equals(txtIden.getText())){
                        InUp = 'U';
                        break;
                    }
                }
            }
            colocar_alterar(InUp);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        } 
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Concluir: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }
    
    private void colocar_alterar(char InUp) throws SQLException {
        if(InUp == 'I'){
            carta = moveTelaModelCartao();
            cartaoDAO.insere(carta);
            usuario = moveTelaModelUsu();
            usuarioDAO.insere(usuario);
            usuarioFrota = moveTelaModelUsuFrota();
            usuFrotaDAO.insere(usuarioFrota);
            JOptionPane.showMessageDialog(null, "Contrato Salvo com Sucesso", "Contrato Salvo", JOptionPane.OK_OPTION);
        } else if(InUp == 'U'){
            carta = moveTelaModelCartao();
            cartaoDAO.altera(carta);
            usuario = moveTelaModelUsu();
            usuarioDAO.altera(usuario);
            usuarioFrota = moveTelaModelUsuFrota();
            usuFrotaDAO.altera(usuarioFrota);
            JOptionPane.showMessageDialog(null, "Contrato Alterado com Sucesso", "Alterado Salvo", JOptionPane.OK_OPTION);
        } else {
            int resp = JOptionPane.showConfirmDialog(null, ""
             + "Deseja Desbloquear Contrato?", "Contrato Bloqueado", 
             JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                carta = moveTelaModelCartao();
                cartaoDAO.insere(carta);
                usuario = moveTelaModelUsu();
                usuarioDAO.insere(usuario);
                usuarioFrota = moveTelaModelUsuFrota();
                usuFrotaDAO.insere(usuarioFrota);
                blockDAO.remove(block);
                JOptionPane.showMessageDialog(null, "Contrato Salvo com Sucesso", "Contrato Salvo", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Contrato Esta Bloqueado", "Contrato Bloqueado", JOptionPane.OK_OPTION);
            }
        }
    }

    @FXML
    private void btnProximo_Click(ActionEvent event) {
        try {
            if(it.hasPrevious()){
            colocarAuto(it.previous());
            calculo();
            conta++;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(totalAuto));
        }
        else {
            JOptionPane.showMessageDialog(null, "Voce chegou no Fim da Lista", "Fim da Lista", JOptionPane.OK_OPTION);
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }

    @FXML
    private void btnAnterior_Click(ActionEvent event) {
        try {
            if(it.hasNext()){
            colocarAuto(it.next());
            calculo();
            conta--;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(totalAuto));
        }
        else {
            JOptionPane.showMessageDialog(null, "Voce chegou no Fim da Lista", "Fim da Lista", JOptionPane.OK_OPTION);
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
            totalAuto = 0;
            while(it.hasNext()){
                auto = it.next();
                totalAuto++;
                colocarAuto(auto);
            }
            totalAuto++;
            conta = 1;
            lblOrdem.setText(Integer.toString(conta) + "/" + Integer.toString(totalAuto));
            calculo();
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
        } catch (Exception ex){
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
    
    @FXML
    private void btnLimpar_Click(ActionEvent event) {
        limpar();
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
        txtNomecard.clear();
        txtNumcard.clear();
        txtVencicard.clear();
        txtCVVcard.clear();
        txtStart.clear();
        txtFim.clear();
        lblAluguel.setText("");
        lblSubtotal.setText("");
        lblTaxa.setText("");
        lblTotal.setText("");
        limparRadio();
        
        txtNome.requestFocus();
    }
    
    private void limparRadio() {
        if(rdbDiario.isSelected()) {
            rdbDiario.setSelected(false);
        }
        else if(rdbSemanal.isSelected()) {
            rdbSemanal.setSelected(false);
        }
        else if(rdbQuize.isSelected()) {
            rdbQuize.setSelected(false);
        }
        else if(rdbMes.isSelected()) {
            rdbMes.setSelected(false);
        }
        
        if(rdbDebito.isSelected()) {
            rdbDebito.setSelected(false);
        }
        else if(rdbCredito.isSelected()) {
            rdbCredito.setSelected(false);
        }
        
        if(rdbMaster.isSelected()) {
            rdbMaster.setSelected(false);
        }
        else if(rdbVisa.isSelected()) {
            rdbVisa.setSelected(false);
        }
    }
    
    private static final DecimalFormat decfors = new DecimalFormat("0.00");
    private float total, subTotal, valorTaxa;
    private final float taxa = (float)0.12;

    @FXML
    private void rdbDiario_Select(ActionEvent event) {
        calculo();
    }

    @FXML
    private void rdbSemanal_Select(ActionEvent event) {
        calculo();
    }

    @FXML
    private void rdbQuize_Select(ActionEvent event) {
        calculo();
    }

    @FXML
    private void rdbMes_Select(ActionEvent event) {
        calculo();
    }
        
    private void calculo(){
        subTotal = Float.parseFloat(lblValor.getText());
        if(rdbDiario.isSelected()) {
            subTotal *= 1;
            lblAluguel.setText("Diaria");
        }
        else if(rdbSemanal.isSelected()) {
            subTotal *= 7;
            lblAluguel.setText("Semanal");
        }
        else if(rdbQuize.isSelected()) {
            subTotal *= 15;
            lblAluguel.setText("Quinzenal");
        }
        else if(rdbMes.isSelected()) {
            subTotal *= 30;
            lblAluguel.setText("Mensal");
        }
        lblSubtotal.setText(decfors.format(subTotal));
        valorTaxa = subTotal * this.taxa;
        lblTaxa.setText(decfors.format(valorTaxa));
        total = subTotal + valorTaxa;
        lblTotal.setText(decfors.format(total));
    }
}   