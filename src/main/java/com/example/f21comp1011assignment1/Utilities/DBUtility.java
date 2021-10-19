package com.example.f21comp1011assignment1.Utilities;

import com.example.f21comp1011assignment1.Models.Product;
import javafx.scene.chart.XYChart;
import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String pw = "student";
    private static String connectURL = "jdbc:mysql://localhost:3306/javaProjects";

    /**
     * Query the database to get information about the amount of nutrients of each product
     * @return Product object ArrayList
     */
    public static ArrayList<Product> loadDataFromDB()
    {
        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM nutrients" +
                " ORDER BY Product;";
        int id = 0;
        String name = "";
        double protein = 0, carbs = 0, fat = 0, ash = 0, energy = 0;
        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while(resultSet.next())
            {
                if(id != resultSet.getInt("ID")){
                    // when the id of the entry changes it creates the Product object and adds it
                    // to the list
                    if(id != 0) {
                        products.add(new Product(id,name,protein,carbs, fat, ash, energy));
                        //set all nutrients to 0 not to have any missing value
                        protein = carbs = fat = ash = energy = 0;
                    }
                    name = resultSet.getString("Product");
                    id = resultSet.getInt("Id");
                }
                switch (resultSet.getString("Nutrient")){
                    case "PROT":
                        protein = resultSet.getDouble("Value");
                        break;
                    case "CARB":
                        carbs = resultSet.getDouble("Value");
                        break;
                    case "ASH":
                        ash = resultSet.getDouble("Value");
                        break;
                    case "FAT":
                        fat = resultSet.getDouble("Value");
                    default:
                        energy = resultSet.getDouble("Value");
                }
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }

    /**
     * Query the database for the amount of nutrients depending on the nutrient type
     * @return the nutrient data to show on the Barchart view
     */
    public static XYChart.Series<String, Double> getNutrientInformation(String nutrient){

        XYChart.Series<String, Double> nutrientData = new XYChart.Series<>();
        String where;
        //defines the nutrient depending on the combobox
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
        //defines the query depending on the nutrient
        String sql = "SELECT * FROM nutrients" +
                " WHERE Nutrient = '" + where +
                "' AND Value > 0 " +
                " ORDER BY Value DESC" +
                " LIMIT 10;";

        try(
                Connection conn = DriverManager.getConnection(connectURL,user,pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next())
            {
                String product = resultSet.getString("Product");
                //cuts the product name into fewer characters and adds productID
                if(product.contains(" "))
                    product = "[" + resultSet.getString("ID") + "] " +
                            product.split(" ")[0].replace(",","");
                nutrientData.getData().add(new XYChart.Data<>(product,resultSet.getDouble("Value")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return nutrientData;
    }
}
