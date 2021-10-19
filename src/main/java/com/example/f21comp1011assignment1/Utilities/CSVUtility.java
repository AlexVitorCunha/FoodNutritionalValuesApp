package com.example.f21comp1011assignment1.Utilities;

import java.io.*;
import java.util.Formatter;



public class CSVUtility {
    public static void convertCSVToSQL(File fileToRead, String sqlFileName){

        try(
                FileReader fr = new FileReader(fileToRead);
                BufferedReader br = new BufferedReader(fr);
                Formatter formatter = new Formatter(sqlFileName);
                )
        {
            String line = br.readLine(); //skips the line of fields names
            line = br.readLine(); // read first line of values
            while(line != null)
            {
                String[] record  = line.split(",");//splitting lines
                //only adds to the query entries with all the fields
                if(record.length == 8){
                    formatter.format("INSERT INTO nutrientName VALUES (%s,%s,'%s','%s','%s','%s','%s',%s);%n",
                            record[0],record[1],record[2],record[3],record[4],record[5],record[6],record[7]);
                }
                line = br.readLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        convertCSVToSQL(new File("C:\\Users\\alexv\\Documents\\NUTRIENTNAME.csv"),"nutrientname.sql");
    }
}
