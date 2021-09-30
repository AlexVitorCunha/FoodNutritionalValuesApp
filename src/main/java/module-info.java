module com.example.f21comp1011assignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f21comp1011assignment1 to javafx.fxml;
    exports com.example.f21comp1011assignment1;
}