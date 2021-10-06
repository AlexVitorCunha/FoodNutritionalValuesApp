package com.example.f21comp1011assignment1.Utilities;

import com.example.f21comp1011assignment1.Models.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBUtility {
    public static ObservableList loadDataFromDB() throws SQLException
    {
        ObservableList<Product> products = FXCollections.observableArrayList();
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nutrients", "root", "Password");
            String sql = "SELECT * FROM tbl_nutrients";
            statement = con.createStatement();
            resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                Product newProduct = new Product(resultSet.getString("product_name"),
                                                resultSet.getFloat("protein"),
                                                resultSet.getFloat("fat"),
                                                resultSet.getFloat("carbs"),
                                                resultSet.getFloat("ash"),
                                                resultSet.getFloat("energy"));
                products.add(newProduct);
            }

        }
        catch(Exception e)
        {
            System.err.print(e.getMessage());
        }
        finally {
            if(con != null)
                con.close();
            if(statement != null)
                statement.close();
            if(resultSet != null)
                resultSet.close();
        }
        System.out.println(products);
        return products;
    }
}
