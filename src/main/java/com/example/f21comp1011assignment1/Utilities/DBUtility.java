package com.example.f21comp1011assignment1.Utilities;

import com.example.f21comp1011assignment1.Models.Product;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String pw = "student";
    private static String connectURL = "jdbc:mysql://localhost:3306/javaProjects";

    public static ArrayList loadDataFromDB()
    {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM table_name;";

        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){

            while(resultSet.next())
            {
                Product newProduct = new Product(resultSet.getString("product_name"),
                                                resultSet.getFloat("protein"),
                                                resultSet.getFloat("fat"),
                                                resultSet.getFloat("carbs"),
                                                resultSet.getFloat("ash"),
                                                resultSet.getFloat("energy"));
                newProduct.getName();
                products.add(newProduct);
            }

        }
        catch(Exception e)
        {
            System.err.print(e.getMessage());
        }
        return products;
    }

    public static XYChart.Series<String, Float> getNutrientInformation(String nutrient){

        XYChart.Series<String, Float> nutrientData = new XYChart.Series<>();
        String where;
        switch(nutrient){
            case "Protein":
                where = "PROT";
                break;
            case "Carbs":
                where = "CARB";
                break;
            case "Ash":
                where = "ASH";
                break;
            default:
                where = "KCAL";
        }

        String sql = "SELECT substring(FN.FoodDescription, 1, 5) AS Product, NN.NutrientName AS Nutrient, NA.NutrientValue AS Value\n" +
                "FROM food_name FN LEFT OUTER JOIN nutrient_amount NA\n" +
                "ON FN.FoodID = NA.FoodID\n" +
                "JOIN nutrients_name NN\n" +
                "ON NA.NutrientID = NN.NutrientID\n" +
                "WHERE NN.NutrientSymbol = '" + where +
                "' AND NA.NutrientValue > 0 " +
                " ORDER BY FN.FoodID DESC";

        try(
                Connection conn = DriverManager.getConnection(connectURL,user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next())
            {
                nutrientData.getData().add(new XYChart.Data<>(resultSet.getString("Product"),resultSet.getFloat("Value")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return nutrientData;
    }
}
