package br.com.fatec.controllers;

import br.com.fatec.model.Autos;
import br.com.fatec.model.Cambio;
import br.com.fatec.model.Direcao;
import br.com.fatec.model.Marca;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class DetalheView1Controller implements Initializable {

    @FXML
    private Label lblMarca;
    @FXML
    private Label lblAno;
    @FXML
    private Label lblVelomax;
    @FXML
    private Label lblCambio;
    @FXML
    private Label lblDirecao;
    @FXML
    private Label lblMoto;
    @FXML
    private Label lblComb;
    @FXML
    private Label lblModelo;
    @FXML
    private ImageView imgCarro;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    }
}
