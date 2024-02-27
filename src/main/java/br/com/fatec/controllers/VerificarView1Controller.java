package br.com.fatec.controllers;

import br.com.fatec.DAO.AutosDAO;
import br.com.fatec.Telas;
import br.com.fatec.model.Autos;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class VerificarView1Controller implements Initializable {
    
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
    private CheckBox cbVer1;
    @FXML
    private CheckBox cbVer2;
    @FXML
    private CheckBox cbVer3;
    @FXML
    private CheckBox cbVer4;
    @FXML
    private CheckBox cbVer5;
    @FXML
    private CheckBox cbVer6;
    @FXML
    private CheckBox cbVer7;
    @FXML
    private CheckBox cbVer8;
    @FXML
    private CheckBox cbVer9;
    @FXML
    private CheckBox cbVerA;
    @FXML
    private TextField txtVer1;
    @FXML
    private TextField txtVer2;
    @FXML
    private TextField txtVer3;
    @FXML
    private TextField txtVer4;
    @FXML
    private TextField txtVer5;
    @FXML
    private TextField txtVer6;
    @FXML
    private TextField txtVer7;
    @FXML
    private TextField txtVer8;
    @FXML
    private TextField txtVer9;
    @FXML
    private TextField txtVerA;
    @FXML
    private ToggleGroup Ver1;
    @FXML
    private ToggleGroup Ver2;
    @FXML
    private ToggleGroup Ver3;
    @FXML
    private ToggleGroup Ver4;
    @FXML
    private ToggleGroup Ver5;
    @FXML
    private ToggleGroup Ver6;
    @FXML
    private ToggleGroup Ver7;
    @FXML
    private ToggleGroup Ver8;
    @FXML
    private ToggleGroup Ver9;
    @FXML
    private ToggleGroup VerA;
    @FXML
    private RadioButton rdbVer1;
    @FXML
    private RadioButton rdbNVer1;
    @FXML
    private RadioButton rdbVer2;
    @FXML
    private RadioButton rdbNVer2;
    @FXML
    private RadioButton rdbVer3;
    @FXML
    private RadioButton rdbNVer3;
    @FXML
    private RadioButton rdbVer4;
    @FXML
    private RadioButton rdbNVer4;
    @FXML
    private RadioButton rdbVer5;
    @FXML
    private RadioButton rdbNVer5;
    @FXML
    private RadioButton rdbVer6;
    @FXML
    private RadioButton rdbNVer6;
    @FXML
    private RadioButton rdbVer7;
    @FXML
    private RadioButton rdbNVer7;
    @FXML
    private RadioButton rdbVer8;
    @FXML
    private RadioButton rdbNVer8;
    @FXML
    private RadioButton rdbVer9;
    @FXML
    private RadioButton rdbNVer9;
    @FXML
    private RadioButton rdbVerA;
    @FXML
    private RadioButton rdbNVerA;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnLimpar;
    @FXML
    private Button btnVerifica;
    @FXML
    private Button btnConsulta;
    @FXML
    private ComboBox<Autos> cmbFiltros;
    
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
    private void txtVer1(MouseEvent event) {
        if(txtVer1.isFocused() == true){
            txtVer1.selectAll();
        }
        if(!"Em Branco".equals(txtVer1.getText())){
            cbVer1.setSelected(true);
        } else {
            cbVer1.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer2(MouseEvent event) {
        if(txtVer2.isFocused() == true){
            txtVer2.selectAll();
        }
        if(!"Em Branco".equals(txtVer2.getText())){
            cbVer2.setSelected(true);
        } else {
            cbVer2.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer3(MouseEvent event) {
        if(txtVer3.isFocused() == true){
            txtVer3.selectAll();
        }
        if(!"Em Branco".equals(txtVer3.getText())){
            cbVer3.setSelected(true);
        } else {
            cbVer3.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer4(MouseEvent event) {
        if(txtVer4.isFocused() == true){
            txtVer4.selectAll();
        }
        if(!"Em Branco".equals(txtVer4.getText())){
            cbVer4.setSelected(true);
        } else {
            cbVer4.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer5(MouseEvent event) {
        if(txtVer5.isFocused() == true){
            txtVer5.selectAll();
        }
        if(!"Em Branco".equals(txtVer5.getText())){
            cbVer5.setSelected(true);
        } else {
            cbVer5.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer6(MouseEvent event) {
        if(txtVer6.isFocused() == true){
            txtVer6.selectAll();
        }
        if(!"Em Branco".equals(txtVer6.getText())){
            cbVer6.setSelected(true);
        } else {
            cbVer6.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer7(MouseEvent event) {
        if(txtVer7.isFocused() == true){
            txtVer7.selectAll();
        }
        if(!"Em Branco".equals(txtVer7.getText())){
            cbVer7.setSelected(true);
        } else {
            cbVer7.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer8(MouseEvent event) {
        if(txtVer8.isFocused() == true){
            txtVer8.selectAll();
        }
        if(!"Em Branco".equals(txtVer8.getText())){
            cbVer8.setSelected(true);
        } else {
            cbVer8.setSelected(false);
        }
    }
    
    @FXML
    private void txtVer9(MouseEvent event) {
        if(txtVer9.isFocused() == true){
            txtVer9.selectAll();
        }
        if(!"Em Branco".equals(txtVer9.getText())){
            cbVer9.setSelected(true);
        } else {
            cbVer9.setSelected(false);
        }
    }
    
    @FXML
    private void txtVerA(MouseEvent event) {
        if(txtVerA.isFocused() == true){
            txtVerA.selectAll();
        }
        if(!"Em Branco".equals(txtVerA.getText())){
            cbVerA.setSelected(true);
        } else {
            cbVerA.setSelected(false);
        }
    }

    @FXML
    private void btnSalvar_Click(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Verificações Salvas no Banco de Dados", "Verificações do Auto", JOptionPane.OK_OPTION);
    }

    @FXML
    private void btnLimpar_Click(ActionEvent event) {
        txtVer1.setText("Em Branco");
        txtVer2.setText("Em Branco");
        txtVer3.setText("Em Branco");
        txtVer4.setText("Em Branco");
        txtVer5.setText("Em Branco");
        txtVer6.setText("Em Branco");
        txtVer7.setText("Em Branco");
        txtVer8.setText("Em Branco");
        txtVer9.setText("Em Branco");
        txtVerA.setText("Em Branco");
        limpaCheck();
        limpaRadio();
    }
    
    private void limpaCheck() {
        cbVer1.setSelected(false);
        cbVer2.setSelected(false);
        cbVer3.setSelected(false);
        cbVer4.setSelected(false);
        cbVer5.setSelected(false);
        cbVer6.setSelected(false);
        cbVer7.setSelected(false);
        cbVer8.setSelected(false);
        cbVer9.setSelected(false);
        cbVerA.setSelected(false);
    }
    
    private void limpaRadio() {
        if(rdbVer1.isSelected()) {
            rdbVer1.setSelected(false);
        }
        else if(rdbNVer1.isSelected()) {
            rdbNVer1.setSelected(false);
        }
        if(rdbVer2.isSelected()) {
            rdbVer2.setSelected(false);
        }
        else if(rdbNVer2.isSelected()) {
            rdbNVer2.setSelected(false);
        }
        if(rdbVer3.isSelected()) {
            rdbVer3.setSelected(false);
        }
        else if(rdbNVer3.isSelected()) {
            rdbNVer3.setSelected(false);
        }
        if(rdbVer4.isSelected()) {
            rdbVer4.setSelected(false);
        }
        else if(rdbNVer4.isSelected()) {
            rdbNVer4.setSelected(false);
        }
        if(rdbVer5.isSelected()) {
            rdbVer5.setSelected(false);
        }
        else if(rdbNVer5.isSelected()) {
            rdbNVer5.setSelected(false);
        }
        if(rdbVer6.isSelected()) {
            rdbVer6.setSelected(false);
        }
        else if(rdbNVer6.isSelected()) {
            rdbNVer6.setSelected(false);
        }
        if(rdbVer7.isSelected()) {
            rdbVer7.setSelected(false);
        }
        else if(rdbNVer7.isSelected()) {
            rdbNVer7.setSelected(false);
        }
        if(rdbVer8.isSelected()) {
            rdbVer8.setSelected(false);
        }
        else if(rdbNVer8.isSelected()) {
            rdbNVer8.setSelected(false);
        }
        if(rdbVer9.isSelected()) {
            rdbVer9.setSelected(false);
        }
        else if(rdbNVer9.isSelected()) {
            rdbNVer9.setSelected(false);
        }
        if(rdbVerA.isSelected()) {
            rdbVerA.setSelected(false);
        }
        else if(rdbNVerA.isSelected()) {
            rdbNVerA.setSelected(false);
        }
    }

    private static final DecimalFormat decfors = new DecimalFormat("0.00");
    private final float taxa = (float)0.05, subtotal = 100;
    
    @FXML
    private void btnVerifica_Click(ActionEvent event) {
        float total = 100;
        if(rdbNVer1.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer2.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer3.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer4.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer5.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer6.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer7.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer8.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVer9.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        if(rdbNVerA.isSelected() == true){
            total = total + (subtotal * taxa);
        }
        JOptionPane.showMessageDialog(null, decfors.format(total) + " Reais", "Valor da Multa", JOptionPane.OK_OPTION);
    }

    @FXML
    private void btnConsulta_Click(ActionEvent event) throws SQLException {
        Autos autos = new Autos();
        autos.setPlaca(cmbFiltros.getValue().getPlaca());
        autos = autoDAO.buscaID(autos);
        /*colocar(autos);*/
    }
}
