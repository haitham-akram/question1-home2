/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Haitham
 */
public class Home2 extends Application {
   
    @Override
    public void start(Stage primaryStage) {
       // Label alart =new Label("");
        Button btn = new Button("Copy>>>");
       ListView<String> listfirst = new ListView<String>();
       ListView<String> listsecond = new ListView<String>();
        listfirst.setPrefSize(150, 200);
        listsecond.setPrefSize(150, 200);
        listfirst.getItems().addAll("Black","blue","Dark Gray","Gray","Green");
        listfirst.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        HBox hbox = new HBox(10,listfirst,btn,listsecond);
        VBox vbox= new VBox(hbox);
        hbox.setPadding(new Insets(15));
        hbox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
         Alert alt=new Alert(Alert.AlertType.ERROR, "there no selected item to copy please select item");
        btn.addEventFilter(MouseEvent.MOUSE_CLICKED,new EventHandler<Event> () {
             
            @Override
            public void handle(Event event) {
              if (!listfirst.getSelectionModel().getSelectedItems().isEmpty() ){
                listsecond.getItems().setAll(listfirst.getSelectionModel().getSelectedItems());
               
            }else{
              alt.show();
         //alart.setText("there no selected item to copy please select item"); 
        }
            }
        } );
        
        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Multiple Selection Lists");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
