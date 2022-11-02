/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentialmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static residentialmanagement.admin.adminStage;

/**
 *
 * @author omben
 */
public class verifypayment extends Application {
    
    static Stage  verifypaymentStage = new Stage();
   
    @Override
    public void start(Stage verifypaymentStage) {
           Label tenant_lbl = new Label("Tenant ID: ");
           Label payment_lbl = new Label("Payment Type: ");
           Label confirm_lbl = new Label("Payment Confirmation Code: ");
           Label fname_lbl = new Label("First Name: ");
           Label lname_lbl = new Label("Last Name: ");
           Label amount_lbl = new Label("Amount: ");
           Label admin_lbl = new Label("Admin Name: ");
           
           TextField tenant_txt = new TextField();
           TextField payment_txt = new TextField();
           TextField confirm_txt = new TextField();
           TextField fname_txt = new TextField();
           TextField lname_txt = new TextField();
           TextField amount_txt = new TextField();
           TextField admin_txt = new TextField();           
           
           Button submit_btn = new Button("Submit");
           submit_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
           submit_btn.setCursor(Cursor.HAND);
           
           Button back_btn = new Button("BACK");
           back_btn.setStyle("-fx-background-color: SILVER; -fx-border-color: brown;  -fx-text-fill: black; -fx-border-radius: 5;");
           back_btn.setCursor(Cursor.HAND);
           
           GridPane gridPane = new GridPane();
           gridPane.setMinSize(600,400);
           gridPane.setVgap(10);
           gridPane.setHgap(10);
           gridPane.setAlignment(Pos.CENTER);
           
           gridPane.add(tenant_lbl, 1,1);
           gridPane.add(tenant_txt, 2,1);
           gridPane.add(payment_lbl, 1,2);
           gridPane.add(payment_txt, 2,2);
           gridPane.add(confirm_lbl, 1,3);
           gridPane.add(confirm_txt, 2,3);
           gridPane.add(fname_lbl, 1,4);
           gridPane.add(fname_txt, 2,4);
           gridPane.add(lname_lbl, 1,5);
           gridPane.add(lname_txt, 2,5);
           gridPane.add(amount_lbl, 1,6);
           gridPane.add(amount_txt, 2,6);
           gridPane.add(admin_lbl, 1,7);
           gridPane.add(admin_txt, 2,7);
           gridPane.add(submit_btn, 1,8);
           gridPane.add(back_btn, 2,8);

           
           
        verifypaymentStage.setTitle("CONFIRM PAYMENTS");
       
        Scene my_scene=new Scene(gridPane); //This is our scene
        
        gridPane.setStyle("-fx-background-image:url('https://i.pinimg.com/474x/73/21/49/7321495cd2660054405b9989dc2cc779.jpg'); -fx-background-repeat: no-repeat; -fx-background-size: 700 500; -fx-background-position: center center;");
     
        verifypaymentStage.setScene(my_scene);  
       
        verifypaymentStage.show();
        
        back_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
                public void handle(MouseEvent event){
                  admin a = new admin();
                    a.start(adminStage);
                    
                    verifypaymentStage.close();
                }
               }));
           
           submit_btn.setOnMouseClicked((new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
           
             String tenant = tenant_txt.getText();
             String payment = payment_txt.getText();
             String confirm = confirm_txt.getText();
             String fname = fname_txt.getText();
             String lname = lname_txt.getText();
             String amount = amount_txt.getText();
             String admin = admin_txt.getText();
             
             
             
             
             try
             {
                Class.forName("com.mysql.cj.jdbc.Driver");
               
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/residential_management_system","root","kipese@!!!");
               
                Statement st= con.createStatement();                
               
                String query = "INSERT INTO `payment_confirmation` (`Tenant_id`,`Payment_type`,`Payment_confirmation_code`,`First_name`,`Last_name`,`Amount`,`Served_by`) VALUES ('"+tenant+"','"+payment+"','"+confirm+"','"+fname+"','"+lname+"','"+amount+"','"+admin+"'); ";
                st.executeUpdate(query);
               

                    Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                    al.setContentText("Record Addes Succesfully");
                    al.show();
                   
                    tenant_txt.setText("");
                    payment_txt.setText("");
                    confirm_txt.setText("");
                    fname_txt.setText("");
                    lname_txt.setText("");
                    amount_txt.setText("");
                    admin_txt.setText("");
                    
                   

                con.close();
             
             }
            catch(Exception ee){System.out.println(ee);System.out.println("Connection error");}
            {
               
            }
         }
        }));

                   
           
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}


