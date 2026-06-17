module com.nguyentanhuy.quizzapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.nguyentanhuy.quizzapp to javafx.fxml;
    exports com.nguyentanhuy.quizzapp;
}
