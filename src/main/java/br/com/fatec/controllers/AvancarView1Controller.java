package br.com.fatec.controllers;

import br.com.fatec.model.Autos;
import br.com.fatec.model.Cambio;
import br.com.fatec.model.Direcao;
import br.com.fatec.model.Marca;
import java.net.URL;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

public class AvancarView1Controller implements Initializable {

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
    private ImageView imgCarro;
    @FXML
    private Label lblOrdem;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnAnterior;

    private Autos auto;
    private Cambio cambio;
    private Direcao direcao;
    private Marca marca;
    
    int contar = 1;
    
    private ArrayList<Autos> adicionados =
            new ArrayList<>();
    private ListIterator<Autos> it = adicionados.listIterator();
    @FXML
    private Button btnVoltar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnSalvar;
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

    AvancarView1Controller(ArrayList<Autos> adicionados) {
        ListIterator<Autos> aux = adicionados.listIterator();
        
        while(aux.hasNext()){
            this.adicionados.add(aux.next());
            aux.next();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void Adicionar(Autos auto){
        adicionados.add(auto);
        it = adicionados.listIterator();
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
        lblOrdem.setText(Integer.toString(contar));
        contar++;
        lblQuilo.setText(Float.toString(a.getQuilometragem()));
        lblValor.setText(Float.toString(a.getValor()));
    }

    @FXML
    private void btnDetalhar_Click(ActionEvent event) {
    }

    @FXML
    private void btnEditar_Click(ActionEvent event) {
    }


    @FXML
    private void btnProximo_Click(ActionEvent event) {
        if(it.hasNext()){
            colocar(it.next());
            it.next();
        }
        else {
            JOptionPane.showConfirmDialog(null, "Voce chegou no Fim da Lista", "Fim da Lista", JOptionPane.YES_OPTION);
        }
    }

    @FXML
    private void btnAnterior_Click(ActionEvent event) {
        if(it.hasPrevious()){
            colocar(it.previous());
            it.previous();
        }
        else {
            JOptionPane.showConfirmDialog(null, "Voce chegou no Fim da Lista", "Fim da Lista", JOptionPane.YES_OPTION);
        }
    }

    @FXML
    private void btnVoltar_Click(ActionEvent event) {
    }

    @FXML
    private void btnExcluir_click(ActionEvent event) {
    }

    @FXML
    private void btnSalvar_Click(ActionEvent event) {
    }

    
}
