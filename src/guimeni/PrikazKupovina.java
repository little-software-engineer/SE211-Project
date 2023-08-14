/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimeni;

import baza.DBKontroler;
import entiteti.Korisnik;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class PrikazKupovina {

    public PrikazKupovina(Korisnik prijvaljeniKor) throws ClassNotFoundException, SQLException {
        Stage primaryStage = new Stage();

        HBox main = new HBox(20);//glavni box u kojem su sa leve strane opcije a sa desne tabela

        VBox left = new VBox(35);//box sa leve strane u kome se nalaze polja i opcije

        DBKontroler tblKor = new DBKontroler();
        //kreiramo box u koji cemo smestiti  polja i tekstove

        //pravimo 2 box kako bi u jednom smestili tekstove a u drugom polja
        //box u koji smestamo opcije
        HBox leftMiddle = new HBox(20);
        Button pocetna = new Button("Pocetna");
        leftMiddle.getChildren().addAll(pocetna);
        leftMiddle.setAlignment(Pos.CENTER);

        left.getChildren().addAll(leftMiddle);

        //pravimo tabelu u kojoj cemo ispisivati podatke iz baze
        TableView tv = new TableView();
        tblKor.KupovinaTabel(tv, prijvaljeniKor);

        //Kreiramo alert sa opcijama Yes i NO
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        alert.setTitle("Program!");

        pocetna.setOnAction(e -> {
            primaryStage.close();
        });

        main.getChildren().addAll(left, tv);

        leftMiddle.setId("leftMiddle");
        main.setId("main");
        tv.setId("tv");

        Scene scene = new Scene(main, 700, 650);

        scene.getStylesheets().add("css/Prikaz.css");
        primaryStage.setTitle("Kupovina");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }
}
