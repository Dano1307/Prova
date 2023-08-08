package com.example.prova;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pazientiipertesi", "root", "");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM paziente;");

            while(rs.next()){
                System.out.println(rs.getString("nome") + " " + rs.getString("cognome"));
            }

            System.out.println("Chiusura connessione col DB");

            con.close();
        }
        catch(SQLException e){
           System.out.println("Errore nella connessione al DB");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}