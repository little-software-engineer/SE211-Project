/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guimeni;

import baza.DBKontroler;
import entiteti.Korisnik;
import entiteti.ProdajniObjekat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PC
 */
public class PrikazProdajnihObjekata {

    public PrikazProdajnihObjekata(Korisnik prijvaljeniKor) throws ClassNotFoundException, SQLException {
        Stage primaryStage = new Stage();

        HBox main = new HBox(20);//glavni box u kojem su sa leve strane opcije a sa desne tabela

        VBox left = new VBox(35);//box sa leve strane u kojem se nalaze polja i opcije

        DBKontroler tblLok = new DBKontroler();
        //kreiramo box u koje smestamo polja i tekstove
        HBox leftUp = new HBox(5);
        leftUp.setAlignment(Pos.CENTER);

        Label tekst1 = new Label("Naziv:");
        TextField nazivTF = new TextField();

        Label tekst2 = new Label("Adresa: ");
        TextField adresaTF = new TextField();

        Label tekst3 = new Label("Grad: ");
        TextField gradTF = new TextField();

        //pravimo 2 box kako bi u jedan smestili tekstove a u drugi polja
        VBox tekst = new VBox(15);
        tekst.getChildren().addAll(tekst1, tekst2, tekst3);
        VBox polja = new VBox(6.5);
        polja.getChildren().addAll(nazivTF, adresaTF, gradTF);

        leftUp.getChildren().addAll(tekst, polja);

        //box u koji smestamo opcije
        HBox leftMiddle = new HBox(20);
        Button rezervisi = new Button("Kupi");
        Button filtriraj = new Button("Filtriraj");
        leftMiddle.getChildren().addAll(rezervisi, filtriraj);
        leftMiddle.setAlignment(Pos.CENTER);

        left.getChildren().addAll(leftUp, leftMiddle);

        //pravimo tabelu u kojoj cemo ispisivati podatke iz baze
        TableView tv = new TableView();
        tblLok.ProdajniObjekatTabel(tv);

        rezervisi.setDisable(true);

        //Kreiramo alert sa opcijama Yes i NO
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
        alert.setTitle("Program!");

        rezervisi.setOnAction(e -> {
            try {
                if (!tv.getSelectionModel().isEmpty()) {
                    int id = tblLok.listaProdajniObjekata().get(tv.getSelectionModel().getSelectedIndex()).getObjekat_id();
                    String naziv = tblLok.listaProdajniObjekata().get(tv.getSelectionModel().getSelectedIndex()).getNaziv();
                    String adresa = tblLok.listaProdajniObjekata().get(tv.getSelectionModel().getSelectedIndex()).getAdresa();
                    String grad = tblLok.listaProdajniObjekata().get(tv.getSelectionModel().getSelectedIndex()).getGrad();

                    ProdajniObjekat objekat = new ProdajniObjekat(id, naziv, adresa, grad);
                    KupovinaGUI rezervacija = new KupovinaGUI(prijvaljeniKor, objekat);
                    primaryStage.close();
                } else if (tv.getSelectionModel().isEmpty()) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Program");
                    alert1.setContentText("Niste izabrali red iz tabele.");
                    alert1.showAndWait();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PrikazKorisnika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        filtriraj.setOnAction(e -> {
            try {
                alert.setContentText("Da li zelite da filtrirate tekuce zapise?");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.YES) {
                    tv.getItems().clear();
                    tv.getItems().addAll(tblLok.filtriraj(gradTF.getText(), adresaTF.getText(), nazivTF.getText()));
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PrikazKorisnika.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        tv.setOnMouseClicked(e -> {
            if (tv.getSelectionModel().getSelectedItem() != null) {
                rezervisi.setDisable(false);
            }
        });

        main.getChildren().addAll(left, tv);

        leftMiddle.setId("leftMiddle");
        main.setId("main");;
        tv.setId("tv");

        Scene scene = new Scene(main, 800, 650);

        scene.getStylesheets().add("css/Prikaz.css");
        primaryStage.setTitle("Objekti");
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }
}
