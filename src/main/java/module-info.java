module com.example.f21comp1011assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.f21comp1011assignment1 to javafx.fxml;
    exports com.example.f21comp1011assignment1;
    exports com.example.f21comp1011assignment1.Controllers;
    opens com.example.f21comp1011assignment1.Controllers to javafx.fxml;
}