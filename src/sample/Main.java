package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Observable;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        BorderPane borderPaneRoot = new BorderPane();                                       //Main Panel
        Scene scene = new Scene(borderPaneRoot, 800, 600);                    //scene        //alternatives->primaryStage.setScene(new Scene(root, 800, 600));

        HBox hBox1 = new HBox();                                                            //Hbox First part body
        VBox vBox1 = new VBox();                                                            //Second part body

        //mes composants bouttons
        final Button buttonAdd = new Button("Ajouter");
        final Button buttonAction = new Button("Charger");

        //mes composants autres
        Label labelNom = new Label("Fruit : ");
        TextField textFieldNom = new TextField();
        ObservableList<String> observableList = FXCollections.observableArrayList();        //Retourner une liste de type observable de type ArrayList
        ListView<String> listView1 = new ListView<>(observableList);                        //Instance d'une liste        //listView1.getItems().addAll("Oranges", "Pommes");


        labelNom.setPadding(new Insets(5));
        hBox1.setPadding(new Insets(10));
        hBox1.setSpacing(10);
        hBox1.getChildren().addAll(labelNom, textFieldNom, buttonAdd, buttonAction);
        vBox1.setPadding(new Insets(10));
        vBox1.getChildren().add(listView1);
        borderPaneRoot.setTop(hBox1);
        borderPaneRoot.setCenter(vBox1);
        primaryStage.setTitle("Fruits");
        primaryStage.setScene(scene);
        observableList.addAll("Oranges", "Pommes");

        /*
         *************afficher composants**********************
         */
        primaryStage.show();

        /*
         *************EVENTS / ACTIONS composants**********************
         */

        //add a element in list view
        buttonAdd.setOnAction((event) -> {
            String nom = textFieldNom.getText();
            observableList.add(nom);
        });

        //upload
        buttonAction.setOnAction(actionEvent -> {
            final DirectoryChooser dialog = new DirectoryChooser();
            final File directory = dialog.showDialog(buttonAction.getScene().getWindow());
            if (directory != null) {
                // Effectuer le traitement.
            }
        });
    }





    public static void main(String[] args) {
        launch(args);
    }
}
