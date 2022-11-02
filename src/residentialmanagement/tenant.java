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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import static residentialmanagement.admin.adminStage;
import static residentialmanagement.announcements.announcementsStage;
import static residentialmanagement.complains.complainsStage;
import static residentialmanagement.compliments.complimentsStage;
import static residentialmanagement.invoice.invoiceStage;
import static residentialmanagement.ownerlogin.ownerloginStage;
import static residentialmanagement.registerowner.registerownerStage;
import static residentialmanagement.registertenant.registertenantStage;
import static residentialmanagement.statement.statementStage;
import static residentialmanagement.tenantlogin.tenantloginStage;


/**
 *
 * @author prime
 */
public class tenant extends Application {
    static Stage  tenantStage = new Stage();
     @Override
public void start(Stage tenantStage) {
       
  
        Button complaint = new Button("ADD COMPLAINT");
        complaint.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        complaint.setCursor(Cursor.HAND);
        
        Button services = new Button("VIEW SERVICES");
        services.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        services.setCursor(Cursor.HAND);
        
        Button announcement = new Button("VIEW ANNOUNCEMENTS");
        announcement.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        announcement.setCursor(Cursor.HAND);
        
        Button invoice = new Button("VIEW INVOICE");
        invoice.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        invoice.setCursor(Cursor.HAND);
        
        Button statement = new Button("GET PAYMENTS STATEMENTS");
        statement.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        statement.setCursor(Cursor.HAND);
        
        Button logout = new Button("Log Out");
        logout.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        logout.setCursor(Cursor.HAND);
        
       
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
        VBox box = new VBox();
        box.setPrefWidth(200);
        box.setSpacing(20);
        box.getChildren().addAll(complaint,services, announcement, invoice, statement);
        
        gridPane.add(box, 2,1);
        gridPane.add(logout, 2, 2);
        
        logout.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    tenantlogin a = new tenantlogin();
                    a.start(tenantloginStage);
                    
                    tenantStage.close();
                }
               }));
       
        
        
            complaint.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    complains a = new complains();
                    a.start(complainsStage);
                    
                    tenantStage.close();
                }
               }));
            
            services.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=service&pos=0";
                    services.setOnAction(e -> getHostServices().showDocument(webLink));
                }
               }));
            announcement.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=announcement&pos=0";
                    announcement.setOnAction(e -> getHostServices().showDocument(webLink));
                }
               }));
            invoice.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "";
                    invoice.setOnAction(e -> getHostServices().showDocument(webLink));
                }
               }));
            statement.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=payment_confirmation&pos=0";
                    statement.setOnAction(e -> getHostServices().showDocument(webLink));
                }
               }));
       
        tenantStage.setTitle("TENANT INTERFACE");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
         gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        tenantStage.setScene(my_scene);  
       
        tenantStage.show();

    /**
     * @param args the command line arguments
     */
   
   
   
   
}
 public static void main(String args[]){
      launch(args);
   }
}

