package br.com.fatec;

import br.com.fatec.controllers.AddView2Controller;
import br.com.fatec.controllers.ContratoView1Controller;
import br.com.fatec.controllers.DetalheView1Controller;
import br.com.fatec.model.Autos;
import br.com.fatec.model.Cartao;
import br.com.fatec.model.Usuario;
import br.com.fatec.model.UsuarioFrota;
import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Telas {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private char edit;
    private Autos autos;
    private Usuario usuario;
    private UsuarioFrota usuFrota;
    private Cartao cartao;

    public Telas(char edit, Autos autos) {
        this.edit = edit;
        this.autos = autos;
    }
    public Telas(char edit) {
        this.edit = edit;
    }
    public Telas(Autos autos) {
        this.autos = autos;
    }
    public Telas(Usuario usuario) {
        this.usuario = usuario;
    }
    public Telas(Autos autos, Usuario usuario, UsuarioFrota usuFrota, Cartao cartao) {
        this.autos = autos;
        this.usuario = usuario;
        this.usuFrota = usuFrota;
        this.cartao = cartao;
    }
    public Telas() {
    }
    
    public void Menu(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("views/MenuView1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MENU PRINCIPAL");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void Contratos(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("views/ConVisualizarView1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CONTRATOS");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void Consulta(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("views/ConsultaView1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CONSULTAR AUTOS");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void AddContrato(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("views/ContratoView1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ADICIONAR CONTRATO");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void EditarContrato(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/ContratoView1.fxml"));
        root = loader.load();
        
        ContratoView1Controller add = loader.getController();
        add.colocarUsu(usuario);
        add.colocarUsuFrota(usuFrota);
        add.colocarAuto(autos);
        add.colocarCartao(cartao);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("EDITAR CONTRATO");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void Detalhe(Stage stage) throws IOException{
        setStage(stage);
        
        FXMLLoader loader = new FXMLLoader(App.class.getResource("views/DetalheView1.fxml"));
        root = loader.load();
        
        DetalheView1Controller add = loader.getController();
        add.colocar(autos);
        
        scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("DETALHES AUTOMOVEL");
        stage.centerOnScreen();
        stage.show();
        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("imagens/Vector.png")));
    }
    
    public void setStage(Stage t) {
        stage = t;
    }
    
    public void AddAutos(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/AddView2.fxml"));
        root = loader.load();
        
        AddView2Controller add = loader.getController();
        add.Adicionar();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ADICIONAR AUTOMOVEL");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void ExibirAutos(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("views/ExibirAutosView1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AUTOMOVEIS");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void EditarAutos(ActionEvent event) throws IOException, SQLException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("views/AddView2.fxml"));
        root = loader.load();
        
        AddView2Controller add = loader.getController();
        add.Editar(edit,autos);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("EDITAR AUTOMOVEIS");
        stage.centerOnScreen();
        stage.show();
    }
    
    public void Verificar(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("views/VerificarView1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("VERIFICAÇÃO MANUAL");
        stage.centerOnScreen();
        stage.show();
    }
}
