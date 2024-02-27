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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

public class ConsultaView1Controller implements Initializable {

    @FXML
    private Button btnAplicar;
    @FXML
    private Label lblMarca;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblComb;
    @FXML
    private Label lblMoto;
    @FXML
    private Label lblDirecao;
    @FXML
    private Label lblCambio;
    @FXML
    private Label lblVelomax;
    @FXML
    private Label lblAno;
    @FXML
    private Button btnConsulta;
    @FXML
    private Label lblPlaca;
    @FXML
    private ComboBox<Autos> cmbFiltros;
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
    
    private Cambio cambio;
    private Direcao direcao;
    private Marca marca;
    
    private char edit = 'U';
    
    private AutosDAO autoDAO = new AutosDAO();
    private ObservableList<Autos> autos = 
            FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherCombo();
        cmbFiltros.setItems(autos);
    }
    
    private void preencherCombo(){
        try {
            autos.addAll(autoDAO.lista(""));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Na String SQL: " + ex.getMessage(), "Erro SQL", JOptionPane.OK_OPTION);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro No Java: " + ex.getMessage(), "Erro Desconhecido", JOptionPane.OK_OPTION);
        }
    }

    @FXML
    private void btnAplicar_Click(ActionEvent event) throws SQLException, IOException {
        Autos autos = new Autos();
        autos.setPlaca(lblPlaca.getText());
        autos = autoDAO.buscaID(autos);
        Telas tela = new Telas(edit,autos);
        tela.EditarAutos(event);
    }

    @FXML
    private void btnConsulta_Click(ActionEvent event) throws SQLException {
        Autos autos = new Autos();
        autos.setPlaca(cmbFiltros.getValue().getPlaca());
        autos = autoDAO.buscaID(autos);
        colocar(autos);
    }
    
    public void colocar(Autos autos){
        lblAno.setText(Float.toString(autos.getFabricacao()));
        cambio = autos.getCambio();
        lblCambio.setText(cambio.getNome());
        direcao = autos.getDirecao();
        lblDirecao.setText(direcao.getNome());
        marca = autos.getMarca();
        lblMarca.setText(marca.getNome());
        lblModelo.setText(autos.getModelo());
        lblVelomax.setText(autos.getVelocidade());
        lblMoto.setText(autos.getMotorizacao());
        lblComb.setText(autos.getCombustivel());
        lblPlaca.setText(autos.getPlaca());
    }
}
