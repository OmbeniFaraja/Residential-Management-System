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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import static residentialmanagement.announcements.announcementsStage;
import static residentialmanagement.registerowner.registerownerStage;
import static residentialmanagement.registerservice.registerserviceStage;
import static residentialmanagement.registertenant.registertenantStage;
import static residentialmanagement.verifypayment.verifypaymentStage;

/**
 *
 * @author prime
 */
public class admin extends Application {
    static Stage  adminStage = new Stage();
     @Override
public void start(Stage adminStage) {
       
                Label welcome = new Label ("WELCOME ADMIN");
        
        welcome.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
                Button register_owner = new Button("Register Owner");
        register_owner.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        register_owner.setCursor(Cursor.HAND);
                Button register_tenant = new Button("Register Tenant");
        register_tenant.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        register_tenant.setCursor(Cursor.HAND);
                Button announce_btn = new Button("Announcements");
        announce_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        announce_btn.setCursor(Cursor.HAND);
                Button view_houses = new Button("View Properties");
        view_houses.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        view_houses.setCursor(Cursor.HAND);
                Button view_tenants = new Button("View Tenants");
        view_tenants.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        view_tenants.setCursor(Cursor.HAND);
                Button edit_requests = new Button("Password Edit Requests");
        edit_requests.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        edit_requests.setCursor(Cursor.HAND);
                Button verify_payment = new Button("Verify Payments");
        verify_payment.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        verify_payment.setCursor(Cursor.HAND);
                Button register_service = new Button("Register Service");
        register_service.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        register_service.setCursor(Cursor.HAND);
                Button edit_tenant = new Button("Edit Tenants");
        edit_tenant.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        edit_tenant.setCursor(Cursor.HAND);
                Button view_owners = new Button("View Owners");
        view_owners.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        view_owners.setCursor(Cursor.HAND);
                Button logout_btn = new Button("Log Out");
        logout_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        logout_btn.setCursor(Cursor.HAND);
                
        
       
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
        
        VBox box1 = new VBox();
        box1.setSpacing(20);
        box1.setPrefWidth(200);
        register_owner.setMinWidth(box1.getPrefWidth());
        announce_btn.setMinWidth(box1.getPrefWidth());
        view_tenants.setMinWidth(box1.getPrefWidth());
        edit_requests.setMinWidth(box1.getPrefWidth());
        register_service.setMinWidth(box1.getPrefWidth());
        box1.getChildren().addAll(register_owner, announce_btn, view_tenants, edit_requests, register_service);
        
        
        VBox box2 = new VBox();
        box2.setSpacing(20);
        box2.setPrefWidth(200);
        register_tenant.setMinWidth(box1.getPrefWidth());
        view_houses.setMinWidth(box1.getPrefWidth());
        view_owners.setMinWidth(box1.getPrefWidth());
        verify_payment.setMinWidth(box1.getPrefWidth());
        edit_tenant.setMinWidth(box1.getPrefWidth());
        box2.getChildren().addAll(register_tenant, view_houses, view_owners, verify_payment, edit_tenant);
        
        gridPane.add(welcome, 2, 1);
        gridPane.add(box1, 2, 2);
        gridPane.add(box2, 3, 2);
        gridPane.add(logout_btn, 2, 3);
        
            register_owner.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    registerowner a = new registerowner();
                    a.start(registerownerStage);
                    
                    adminStage.close();
                }
               }));
            
            register_tenant.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    registertenant a = new registertenant();
                    a.start(registertenantStage);
                    
                    adminStage.close();
                }
               }));
            
            announce_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    announcements a = new announcements();
                    a.start(announcementsStage);
                    
                    adminStage.close();
                }
               }));
            view_houses.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=house&pos=0";
                    view_houses.setOnAction(e -> getHostServices().showDocument(webLink));
                }
               }));
            view_tenants.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=tenant&pos=0";
                    view_tenants.setOnAction(e -> getHostServices().showDocument(webLink));
                    
                    adminStage.close();
                }
               }));
            view_owners.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=owner&pos=0";
                    view_owners.setOnAction(e -> getHostServices().showDocument(webLink));
                    
                    adminStage.close();
                }
               }));
            edit_requests.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=tenant_password_change&pos=0";
                    edit_requests.setOnAction(e -> getHostServices().showDocument(webLink));
                    
                    adminStage.close();
                }
               }));
            verify_payment.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    verifypayment a = new verifypayment();
                    a.start(verifypaymentStage);
                    
                    adminStage.close();
                }
               }));
            register_service.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    registerservice a = new registerservice();
                    a.start(registerserviceStage);
                    
                    adminStage.close();
                }
               }));
            edit_tenant.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    String webLink = "http://localhost/phpmyadmin/index.php?route=/sql&server=1&db=residential_management_system&table=tenant&pos=0";
                    edit_tenant.setOnAction(e -> getHostServices().showDocument(webLink));
                    
                    adminStage.close();
                }
               }));
       
        adminStage.setTitle("ADMIN INTERFACE");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
         gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        adminStage.setScene(my_scene);  
       
        adminStage.show();

    /**
     * @param args the command line arguments
     */
   
   
   
   
}
 public static void main(String args[]){
      launch(args);
   }
}



