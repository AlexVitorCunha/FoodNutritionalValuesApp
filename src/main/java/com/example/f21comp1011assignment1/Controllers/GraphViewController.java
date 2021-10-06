package com.example.f21comp1011assignment1.Controllers;

import com.example.f21comp1011assignment1.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class GraphViewController implements Initializable{

    @FXML
    private BarChart<String, Float> barChart;

    @FXML
    private ComboBox<String> nutrientComboBox;

    @FXML
    private Button viewTableButton;

    @FXML
    private CategoryAxis foodAxis;

    @FXML
    private NumberAxis nutrientAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> nutrients = Arrays.asList("Protein","Carbs","Fat", "Sugar","Ash", "Energy");
        nutrientComboBox.getItems().addAll(nutrients);
    }

    @FXML
    private void viewTableButton(ActionEvent event) throws IOException {
        SceneChanger sceneChanger = new SceneChanger();
        sceneChanger.changeScenes(event,"table-view.fxml", "Nutrients Graph");

    }

    //updates the graph depending on the chosen nutrient
    @FXML
    private void updateGraph()
    {
        System.out.println(nutrientComboBox.getValue());
    }
}
