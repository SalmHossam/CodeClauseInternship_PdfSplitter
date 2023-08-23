module com.example.pdfsplitter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires pdfbox.app;


    opens com.example.pdfsplitter to javafx.fxml;
    exports com.example.pdfsplitter;
}