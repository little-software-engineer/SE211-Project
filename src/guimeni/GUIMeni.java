/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimeni;

import entiteti.Korisnik;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class GUIMeni {

    public GUIMeni(Korisnik prijvaljeniKor) throws ClassNotFoundException, SQLException {

        Stage primaryStage = new Stage();

        Button listaKor = new Button("Lista korisnika");
        Button listaKup = new Button("Lista kupovina");
        Button listaObjekata = new Button("Lista prodajnih objekata");

        Button odjava = new Button("Odjava, " + prijvaljeniKor.getUsername());
        VBox scena = new VBox(120);

        VBox main = new VBox(10);
        main.setAlignment(Pos.CENTER);

        HBox hbox1 = new HBox(15);

        hbox1.getChildren().addAll(listaObjekata);
        HBox hbox2 = new HBox(15);

        if (prijvaljeniKor.getTip_korisnika() == 1) {
            hbox2.getChildren().addAll(listaKup, listaKor);

        } else {

        }

        HBox header = new HBox();
        header.setAlignment(Pos.TOP_RIGHT);
        header.getChildren().addAll(odjava);

        VBox sideMenu = new VBox();

        odjava.setOnAction(e -> {
            primaryStage.close();
        });

        listaKor.setOnAction(e -> {
            try {
                PrikazKorisnika prikazKor = new PrikazKorisnika(prijvaljeniKor);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIMeni.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        listaObjekata.setOnAction(e -> {
            try {
                PrikazProdajnihObjekata prikazObjekata = new PrikazProdajnihObjekata(prijvaljeniKor);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIMeni.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        listaKup.setOnAction(e -> {
            try {
                PrikazKupovina prikazRezervaciju = new PrikazKupovina(prijvaljeniKor);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIMeni.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        sideMenu.setId("sideMenu");

        main.getChildren().addAll(hbox1, hbox2);

        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);

        scena.getChildren().addAll(header, main);

        Scene scene = new Scene(scena, 450, 450);

        scene.getStylesheets().add("css/Work.css");
        primaryStage.setTitle("Projekat!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
