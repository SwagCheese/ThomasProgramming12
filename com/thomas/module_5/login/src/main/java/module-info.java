module com.thomas.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.logging;
    requires java.sql;

    opens com.thomas.login to javafx.fxml;
    exports com.thomas.login;
}