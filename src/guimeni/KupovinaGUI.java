/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimeni;

import baza.DBKontroler;
import builder.KupovinaBuilder;
import entiteti.Korisnik;
import entiteti.ProdajniObjekat;
import java.sql.SQLException;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class KupovinaGUI {

    public KupovinaGUI(Korisnik prijvaljeniKor, ProdajniObjekat o) throws ClassNotFoundException, SQLException {
        Stage primaryStage = new Stage();

        HBox main = new HBox(20);//glavni box u kojem su sa leve strane opcije a sa desne tabela

        VBox left = new VBox(35);//box sa leve strane u kojem su polja i opcije
        left.setAlignment(Pos.CENTER);

        DBKontroler tblRez = new DBKontroler();
        //kreiramo box u koji smestamo polja i tekstove
        HBox leftUp = new HBox(5);
        leftUp.setAlignment(Pos.CENTER);

        Label tekst1 = new Label("Naziv proizvoda:");
        TextField nazivProiz = new TextField();

        Label tekst2 = new Label("Broj Proizvoda:");
        TextField brProiz = new TextField();
        Pattern pattern2 = Pattern.compile("\\d{0,2}|\\d{2}");
        TextFormatter formatter2 = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return pattern2.matcher(change.getControlNewText()).matches() ? change : null;
        });
        brProiz.setTextFormatter(formatter2);

        Label tekst3 = new Label("Metod placanja:");
        TextField placanje = new TextField();

        Label tekst4 = new Label("Cena:");
        TextField cena = new TextField();

        //pravimo 2 box kako bi u jedan smestili tekstove a u drugi polja
        VBox tekst = new VBox(15);
        tekst.getChildren().addAll(tekst1, tekst2, tekst3, tekst4);
        VBox polja = new VBox(6.5);
        polja.getChildren().addAll(nazivProiz, brProiz, placanje, cena);

        leftUp.getChildren().addAll(tekst, polja);

        //box u koji smestamo opcije
        HBox leftMiddle = new HBox(20);
        Button rezervisi = new Button("Kupi");
        leftMiddle.getChildren().addAll(rezervisi);
        leftMiddle.setAlignment(Pos.CENTER);

        left.getChildren().addAll(leftUp, leftMiddle);

        //pravimo tabelu u kojoj cemo ispisivati podatke iz baze
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        alert.setTitle("Program!");

        rezervisi.setOnAction(e -> {
            alert.setContentText("Da li zelite da kupite proizvode?");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES && !nazivProiz.getText().isEmpty() && !brProiz.getText().isEmpty() && !placanje.getText().isEmpty() && !cena.getText().isEmpty()) {
                try {
                    if (tblRez.proveraStanja(o, Integer.parseInt(brProiz.getText())) == true) {
                        try {
                            tblRez.dodajKupovinu(
                                    new KupovinaBuilder()
                                            .Korisnik(prijvaljeniKor)
                                            .ProdajniObjekat(o)
                                            .naziv(nazivProiz.getText())
                                            .cena(Double.parseDouble(cena.getText()))
                                            .brojProizvoda(Integer.parseInt(brProiz.getText()))
                                            .metodPlacanja(placanje.getText())
                                            .build());
                            PrikazKupovina prikazRez = new PrikazKupovina(prijvaljeniKor);
                            primaryStage.close();
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(KupovinaGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Program!");
                        alert1.setContentText("Rezervacija nije uspela.Objekat nema trazeni broj proizvoda.");
                        alert1.showAndWait();
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(KupovinaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Projekat!");
                alert1.setContentText("Niste uneli trazene podatke.");
                alert1.showAndWait();
            }

        });
        main.getChildren().addAll(left);
        main.setAlignment(Pos.CENTER);

        leftMiddle.setId("leftMiddle");
        main.setId("main");
        leftUp.setId("leftUp");
        //tv.setId("tv");

        Scene scene = new Scene(main, 700, 500);

        scene.getStylesheets().add("css/Prikaz.css");
        primaryStage.setTitle("Kupovina");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }
}
