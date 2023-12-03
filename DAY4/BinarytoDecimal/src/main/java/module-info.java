module com.binary.binarytodecimal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.binary.binarytodecimal to javafx.fxml;
    exports com.binary.binarytodecimal;
}