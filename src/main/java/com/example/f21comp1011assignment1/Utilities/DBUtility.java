package com.example.f21comp1011assignment1.Utilities;

import com.example.f21comp1011assignment1.Models.Product;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String pw = "student";
    private static String connectURL = "jdbc:mysql://localhost:3306/javaProjects";


    public static ArrayList<Product> loadDataFromDB()
    {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM nutrients" +
                " ORDER BY ID" +
                " LIMIT 30;";
        int id = 0;
        Product newProduct = new Product();
        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while(resultSet.next())
            {

                if(id != resultSet.getInt("ID")){
                    if(id != 0) {products.add(newProduct);}
                    newProduct.setName(resultSet.getString("Product"));
                    newProduct.resetData();
                    id = resultSet.getInt("ID");
                }
                switch (resultSet.getString("Nutrient")){
                    case "PROT":
                        newProduct.setProtein(resultSet.getDouble("Value"));
                        break;
                    case "CARB":
                        newProduct.setCarbs(resultSet.getDouble("Value"));
                        break;
                    case "ASH":
                        newProduct.setAsh(resultSet.getDouble("Value"));
                        break;
                    case "FAT":
                        newProduct.setFat(resultSet.getDouble("Value"));
                    default:
                        newProduct.setEnergy(resultSet.getDouble("Value"));
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }

    public static XYChart.Series<String, Double> getNutrientInformation(String nutrient){

        XYChart.Series<String, Double> nutrientData = new XYChart.Series<>();
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
            case "Fat":
                where = "FAT";
            default:
                where = "KCAL";
        }


        String sql = "SELECT * FROM nutrients" +
                " WHERE Nutrient = '" + where +
                "' AND Value > 0 " +
                " ORDER BY Value DESC" +
                " LIMIT 20;";

        try(
                Connection conn = DriverManager.getConnection(connectURL,user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next())
            {
                String product = resultSet.getString("Product");
                if(product.contains(" "))
                    product = product.split(" ")[0] + " " + product.split(" ")[1];
                nutrientData.getData().add(new XYChart.Data<>(product,resultSet.getDouble("Value")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return nutrientData;
    }
}
