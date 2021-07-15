module ch.bbw._project_mvn_openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens ch.bbw._project_mvn_openjfx to javafx.fxml;
    exports ch.bbw._project_mvn_openjfx;
}