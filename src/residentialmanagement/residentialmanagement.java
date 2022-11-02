/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentialmanagement;

import com.sun.javafx.tk.Toolkit;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static residentialmanagement.admin.adminStage;
import static residentialmanagement.adminlogin.adminloginStage;
import static residentialmanagement.ownerlogin.ownerloginStage;
import static residentialmanagement.tenantlogin.tenantloginStage;

/**
 *
 * @author prime
 */
public class residentialmanagement extends Application {
    
    static Stage  myStage = new Stage();
 
    @Override
public void start(Stage myStage) {
       
        Text homepage_lbl = new Text("WELCOME TO THE RESIDENTIAL MANAGEMENT SYSTEM.");
        homepage_lbl.setFill(Color.BLACK);
        homepage_lbl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Text message_lbl = new Text("LOGIN AS: ");
        message_lbl.setFill(Color.BLACK);
        message_lbl.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        
        Button admin_btn = new Button("ADMIN");
        admin_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown; -fx-text-fill: black; -fx-border-radius: 5;");
        admin_btn.setCursor(Cursor.HAND);
        
        Button tenant_btn = new Button("TENANT");
        tenant_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        tenant_btn.setCursor(Cursor.HAND);
        
        Button owner_btn = new Button("OWNER");
        owner_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
        owner_btn.setCursor(Cursor.HAND);
       
    admin_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    adminlogin a = new adminlogin();
                   a.start(adminloginStage);
                   
                   myStage.close();
                }
                }));
    
     owner_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    ownerlogin a = new ownerlogin();
                    a.start(ownerloginStage);
                    
                    myStage.close();
                }
               }));
    
     tenant_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                    tenantlogin a = new tenantlogin();
                    a.start(tenantloginStage);
                    
                    myStage.close();
                }
               }));
       
       
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(600,400);
        gridPane.setVgap(20);
        gridPane.setHgap(20);
        gridPane.setAlignment(Pos.CENTER);
     
        gridPane.add(homepage_lbl,1, 1);
        gridPane.add(message_lbl,1, 3);
        HBox myButtons = new HBox();
       
        myButtons.setSpacing(10);
        myButtons.setPadding(new Insets(0, 0, 0, 0));
        myButtons.getChildren().addAll(admin_btn, tenant_btn, owner_btn);
       
        gridPane.add(myButtons, 1, 4 ,1,4);
       
        myStage.setTitle("RESIDENTIAL MANAGEMENT");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
        gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/a3/77/25/a37725098cc82903a43e8253c1a3fab2.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");

        myStage.setScene(my_scene); 
       
        myStage.show();
        
        

    /**
     * @param args the command line arguments
     */
   
   
}
 public static void main(String args[]){
      launch(args);
   }
}

