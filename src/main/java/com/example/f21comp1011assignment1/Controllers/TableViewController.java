package com.example.f21comp1011assignment1.Controllers;

import com.example.f21comp1011assignment1.Models.Product;
import com.example.f21comp1011assignment1.Utilities.DBUtility;
import com.example.f21comp1011assignment1.SceneChanger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private TableColumn<Product, Float> proteinColumn;

    @FXML
    private TableColumn<Product, Float> energyColumn;

    @FXML
    private TableColumn<Product, Float> fatColumn;

    @FXML
    private TableColumn<Product, Float> carbsColumn;

    @FXML
    private TableColumn<Product, Float> ashColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<Product,Float>("protein"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("fat"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("energy"));
        carbsColumn.setCellValueFactory(new PropertyValueFactory<Product,Float>("carbs"));
        ashColumn.setCellValueFactory(new PropertyValueFactory<Product,Float>("ash"));

        try{
            final ObservableList<Product> products = DBUtility.loadDataFromDB();
            NutrientsTable.getItems().addAll(products);



        }catch (SQLException e){
            System.err.print(e);
        }
    }

    @FXML
    private void viewGraphButton(ActionEvent event) throws IOException {
        SceneChanger sceneChanger = new SceneChanger();
        sceneChanger.changeScenes(event,"graph-view.fxml", "text");
    }


}
