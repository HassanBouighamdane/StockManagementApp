module application.app_magasin {
    requires javafx.controls;
    requires javafx.fxml;
    requires  javafx.graphics;
    requires java.sql;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens application.app_magasin to javafx.fxml;
    exports application.app_magasin;
    exports application.app_magasin.MainClasses;
    opens application.app_magasin.MainClasses to javafx.base, javafx.fxml;


}