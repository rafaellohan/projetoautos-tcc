package br.com.fatec.controllers;

import br.com.fatec.Telas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MenuView1Controller implements Initializable {

    @FXML
    private Button btnMenu;
    @FXML
    private Button btnExibir;
    @FXML
    private Button btnAddauto;
    @FXML
    private Button btnContrato;
    @FXML
    private Button btnAddcontrato;
    @FXML
    private Label titulo;
    @FXML
    private Label titulo1;
    @FXML
    private Label titulo2;
    @FXML
    private Label titulo3;
    @FXML
    private Label titulo4;
    @FXML
    private Button btnVerificar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    private void btnVerificar_Click(ActionEvent event) throws IOException {
        Telas tela = new Telas();
        tela.Verificar(event);
    }
    
}
