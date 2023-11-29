module com.divisas.converterdiv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.divisas.converterdiv to javafx.fxml;
    exports com.divisas.converterdiv;
}