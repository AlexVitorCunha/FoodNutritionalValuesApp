package com.example.f21comp1011assignment1.Controllers;

import com.example.f21comp1011assignment1.Utilities.SceneChanger;
import com.example.f21comp1011assignment1.Utilities.DBUtility;
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
    private BarChart<String, Double> barChart;

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
        List<String> nutrients = Arrays.asList("Protein","Carbs","Fat","Ash", "Energy");
        nutrientComboBox.getItems().addAll(nutrients);
        nutrientComboBox.getSelectionModel().selectFirst();
        updateGraph();
        foodAxis.setLabel("Food Name");
        nutrientAxis.setLabel("Amount of Nutrient");
    }

    // Changes the view to the table view when the button is pressed
    @FXML
    private void viewTableButton(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"table-view.fxml", "Nutrients Table");
    }

    //updates the graph depending on the chosen nutrient on the Combobox
    @FXML
    private void updateGraph()
    {
        barChart.getData().clear();
        barChart.getData().addAll(DBUtility.getNutrientInformation(nutrientComboBox.getValue()));
        switch(nutrientComboBox.getValue()){
            case "Energy":
                nutrientAxis.setLabel("Amount of Nutrient (kCal)");
                break;
            default:
                nutrientAxis.setLabel("Amount of Nutrient (g)");
        }

    }
}
