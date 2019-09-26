package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.geometry.Insets;


import java.awt.*;
import java.io.File;
import java.time.LocalDate;

public class AppCalendar extends Application {

    @Override
    public void start(Stage stage) {

        final Button buttonExcel = new Button("Générer le fichier excel");
        DatePicker datePickerStart = new DatePicker();
        DatePicker datePickerEnd = new DatePicker();

        VBox root = new VBox();
        Scene scene = new Scene(root, 300, 200);

        root.setSpacing(10);
        root.setPadding(new Insets(15,20, 10,10));

        LocalDate ldt = LocalDate.now();

        datePickerStart.setValue(ldt);
        datePickerStart.setShowWeekNumbers(true);
        datePickerEnd.setValue(ldt);
        datePickerEnd.setShowWeekNumbers(true);


        Label labelStart = new Label("Début : ");
        Label labelEnd = new Label("Fin : ");


        root.getChildren().addAll(labelStart, datePickerStart);
        root.getChildren().addAll(labelEnd, datePickerEnd);
        root.getChildren().addAll(buttonExcel);


        stage.setTitle("DatePicker");
        stage.setScene(scene);
        stage.show();


        //add a element in list view
        buttonExcel.setOnAction((event) -> {
            final DirectoryChooser dialog = new DirectoryChooser();
            final File directory = dialog.showDialog(buttonExcel.getScene().getWindow());
            if (directory != null) {
                // Effectuer le traitement.
            }
        });

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
