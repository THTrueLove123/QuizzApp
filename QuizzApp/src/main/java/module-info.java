module com.nguyentanhuy.quizzapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.nguyentanhuy.quizzapp to javafx.fxml;
    exports com.nguyentanhuy.quizzapp;
    exports com.nguyentanhuy.pojo;
}
