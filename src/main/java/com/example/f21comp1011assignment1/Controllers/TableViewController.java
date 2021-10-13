package com.example.f21comp1011assignment1.Controllers;

import com.example.f21comp1011assignment1.Models.Product;
import com.example.f21comp1011assignment1.SceneChanger;
import com.example.f21comp1011assignment1.Utilities.DBUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class TableViewController implements Initializable {

    @FXML
    private Button GraphButton;

    @FXML
    private Button LoadButton;

    @FXML
    private TableView<Product> NutrientsTable;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, Double> proteinColumn;

    @FXML
    private TableColumn<Product, Double> energyColumn;

    @FXML
    private TableColumn<Product, Double> fatColumn;

    @FXML
    private TableColumn<Product, Double> carbsColumn;

    @FXML
    private TableColumn<Product, Double> ashColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<>("fat"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<>("energy"));
        carbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));
        ashColumn.setCellValueFactory(new PropertyValueFactory<>("ash"));

        NutrientsTable.getItems().addAll(DBUtility.loadDataFromDB());
    }

    @FXML
    private void viewGraphButton(ActionEvent event) throws IOException {
        SceneChanger sceneChanger = new SceneChanger();
        sceneChanger.changeScenes(event,"graph-view.fxml", "text");
    }


}
