//Vanessa Metayani_1872044//
package com.vanessa.controller;

import com.vanessa.entity.tableinfo;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private TextField nameInput;
    @FXML
    private TextField priceInput;
    @FXML
    private ComboBox<tableinfo> categoryCombo;
    @FXML
    private TableView<tableinfo> tableInfo;
    @FXML
    private TextField categoryInput;
    @FXML
    private CheckBox yesValid;
    @FXML
    private TableColumn<tableinfo, String> colName;
    @FXML
    private TableColumn<tableinfo, Integer> colPrice;
    @FXML
    private TableColumn<tableinfo, String> colCategory;
    @FXML
    private TableColumn<tableinfo, Boolean> colRecommended;
    private ObservableList<tableinfo> Info;

    @FXML
    private void savecatAct(ActionEvent actionEvent) {
        if(categoryInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Fill the Category field");
            alert.showAndWait();
        }
        else{
            tableinfo tableinfo = new tableinfo();
            tableinfo.getCategoryInput(categoryInput.getText().trim());
            Info.add(tableinfo);
        }
    }

    @FXML
    private void saveAct(ActionEvent actionEvent) {
        if(nameInput.getText().trim().isEmpty() || priceInput.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Fill all the field");
            alert.showAndWait();
        }
        else{
            tableinfo tableinfo = new tableinfo();
            tableinfo.setNameInput(nameInput.getText().trim());
            tableinfo.setPriceInput(priceInput.getText().trim());
            Info.add(tableinfo);
        }
    }

    @FXML
    private void resetAct(ActionEvent actionEvent) {

    }

    @FXML
    private void updateAct(ActionEvent actionEvent) {
        resetform();
        tableinfo tableinfo = new tableinfo();
        tableinfo.setNameInput(nameInput.getText().trim());
        tableinfo.setPriceInput(priceInput.getText().trim());
        Info.add(tableinfo);
    }

    @FXML
    private void yesValid(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       Info = FXCollections.observableArrayList();
       categoryCombo.setItems(Info);
       tableInfo.setItems(Info);
       colName.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNameInput()));
       colCategory.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategoryInput(categoryInput.getText().trim())));
       colPrice.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPriceInput(priceInput.getText().trim())));
    }

    private void resetform(){
        nameInput.clear();
        priceInput.clear();
        categoryInput.clear();
    }

}
