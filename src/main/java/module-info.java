module ch.bbw._project_mvn_openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    opens ch.bbw._project_mvn_openjfx to javafx.fxml;
    exports ch.bbw._project_mvn_openjfx;
}