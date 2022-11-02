/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentialmanagement;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static residentialmanagement.adminlogin.adminloginStage;


/**
 *
 * @author prime
 */
public class owner extends Application {
    static Stage  ownerStage = new Stage();
     @Override
public void start(Stage ownerStage) {
  
        Button view_property = new Button("VIEW PROPERTY");
        view_property.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        view_property.setCursor(Cursor.HAND);
        
        Button view_complaints = new Button("VIEW COMPLAINTS");
        view_complaints.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        view_complaints.setCursor(Cursor.HAND);
        
        Button view_payment = new Button("VIEW PAYMENTS");
        view_payment.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        view_payment.setCursor(Cursor.HAND);
        
        Button logout = new Button("Log Out");
        logout.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        logout.setCursor(Cursor.HAND);
       
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
       
        VBox box = new VBox();
        box.setSpacing(20);
        box.setPrefWidth(150);
        view_property.setMinWidth(box.getPrefWidth());
        view_complaints.setMinWidth(box.getPrefWidth());
        view_payment.setMinWidth(box.getPrefWidth());
        box.getChildren().addAll(view_property, view_complaints, view_payment);
        
        gridPane.add(box, 2, 1);
        gridPane.add(logout, 2,2);
       
        ownerStage.setTitle("OWNER INTERFACE");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
         gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        ownerStage.setScene(my_scene);  
       
        ownerStage.show();

    /**
     * @param args the command line arguments
     */
   
   
        logout.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    adminlogin a = new adminlogin();
                    a.start(adminloginStage);
                    
                    ownerStage.close();
                }
               }));
        view_property.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=house&pos=0";
                    view_property.setOnAction(e -> getHostServices().showDocument(webLink));   
                }
               }));
        view_complaints.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=complaint&pos=0";
                    view_complaints.setOnAction(e -> getHostServices().showDocument(webLink));
                    
                }
               }));
        view_payment.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=payment_confirmation&pos=0";
                    view_payment.setOnAction(e -> getHostServices().showDocument(webLink));
                    
                }
               }));
   
}
 public static void main(String args[]){
      launch(args);
   }
}



