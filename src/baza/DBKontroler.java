/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import builder.KupovinaBuilder;
import entiteti.Korisnik;
import entiteti.Kupovina;
import entiteti.ProdajniObjekat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author PC
 */
public class DBKontroler {

    public DBKontroler() {

    }

    //Korisnik
    public ArrayList<Korisnik> listaKorisnika() throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `korisnik` ";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Korisnik> lista = new ArrayList<>();
        while (rs.next()) {

            lista.add(new Korisnik(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
        }

        kon.close();
        return lista;
    }

    public void dodajKorisnika(Korisnik k) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "INSERT INTO korisnik (korisnik_username, korisnik_password,korisnik_adresa, bankovni_racun) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = kon.prepareStatement(upit);

        ps.setString(1, k.getUsername());
        ps.setString(2, k.getPassword());
        ps.setString(3, k.getAdresa());
        ps.setString(4, k.getBankovni_racun());

        ps.executeUpdate();
        kon.close();

    }

    public void obrisiKorisnika(String username) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "Delete FROM korisnik where korisnik_username = ? ";
        PreparedStatement ps = kon.prepareStatement(upit);
        ArrayList<Korisnik> lista = listaKorisnika();

        ps.setString(1, username);
        ps.executeUpdate();
        kon.close();

    }

    public void izmeniKorisnika(Korisnik k, String username) throws ClassNotFoundException, SQLException {

        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "UPDATE korisnik SET korisnik_username = ?, korisnik_password = ?,korisnik_adresa = ?, bankovni_racun = ? WHERE korisnik_username = '" + username + "';";
        PreparedStatement ps = kon.prepareStatement(upit);

        ps.setString(1, k.getUsername());
        ps.setString(2, k.getPassword());
        ps.setString(3, k.getAdresa());
        ps.setString(4, k.getBankovni_racun());

        ps.executeUpdate();
        kon.close();

    }

    public ArrayList<Korisnik> prijavljeniKorisnik(String username, String password) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `korisnik` WHERE korisnik_username = '" + username + "' AND korisnik_password = '" + password + "'";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Korisnik> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Korisnik(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
        }

        kon.close();
        return lista;
    }

    public boolean usernameProvera(String username) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT korisnik_username,korisnik_password FROM `korisnik` WHERE korisnik_username = '" + username + "'";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Korisnik> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Korisnik(rs.getString(1), rs.getString(2)));
        }
        boolean provera = false;
        for (int i = 0; i < lista.size(); i++) {
            if (username.equals(lista.get(i).getUsername().replaceAll("\\s", ""))) {
                provera = true;
            }
        }

        kon.close();
        return provera;
    }

    public void KorisnikTabel(TableView tv) throws ClassNotFoundException, SQLException {

        //TableView tv = new TableView();
        //uzimanje vrednosti iz baze 
        ArrayList<Korisnik> p = listaKorisnika();
        //KOLONE

        TableColumn<Korisnik, String> column1 = new TableColumn("Username");
        column1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getUsername() + ""));

        TableColumn<Korisnik, String> column2 = new TableColumn("Password");
        column2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPassword() + ""));

        TableColumn<Korisnik, String> column3 = new TableColumn("Adresa");
        column3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAdresa() + ""));

        TableColumn<Korisnik, String> column4 = new TableColumn("Bankovni racun");
        column4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getBankovni_racun() + ""));

        tv.getColumns().add(column1);
        tv.getColumns().add(column2);
        tv.getColumns().add(column3);
        tv.getColumns().add(column4);

        tv.getItems().addAll(p);
    }

    //Objekti
    public ArrayList<ProdajniObjekat> listaProdajniObjekata() throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `prodajniObjekat` ";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<ProdajniObjekat> lista = new ArrayList<>();
        while (rs.next()) {

            lista.add(new ProdajniObjekat(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }

        kon.close();
        return lista;
    }

    public void ProdajniObjekatTabel(TableView tv) throws ClassNotFoundException, SQLException {

        //TableView tv = new TableView();
        //uzimanje vrednosti iz baze 
        ArrayList<ProdajniObjekat> p = listaProdajniObjekata();
        //KOLONE

        TableColumn<ProdajniObjekat, String> column1 = new TableColumn("Naziv");
        column1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNaziv() + ""));

        TableColumn<ProdajniObjekat, String> column2 = new TableColumn("Adresa");
        column2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getAdresa() + ""));

        TableColumn<ProdajniObjekat, String> column3 = new TableColumn("Grad");
        column3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getGrad() + ""));

        TableColumn<ProdajniObjekat, String> column4 = new TableColumn("Lager kolicina");
        column4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getLagerKolicina() + ""));

        tv.getColumns().add(column1);
        tv.getColumns().add(column2);
        tv.getColumns().add(column3);
        tv.getColumns().add(column4);

        tv.getItems().addAll(p);
    }

    public ArrayList<ProdajniObjekat> filtriraj(String grad, String naziv, String adresa) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM `prodajniObjekat` WHERE grad LIKE '" + grad + "%' ";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<ProdajniObjekat> lista = new ArrayList<>();
        while (rs.next()) {

            lista.add(new ProdajniObjekat(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
        }

        kon.close();
        return lista;
    }

    public boolean proveraStanja(ProdajniObjekat o, int brojProizvoda) throws ClassNotFoundException, SQLException {

        DBKontroler dbKontr = new DBKontroler();
        if (brojProizvoda <= (o.getLagerKolicina() - dbKontr.ukupnoKupljenjo(o)) && brojProizvoda > 0) {
            System.out.println((o.getLagerKolicina() - dbKontr.ukupnoKupljenjo(o)));
            return true;
        } else {
            return false;
        }
    }

    //REZERVACIJA
    public ArrayList<Kupovina> listaKupovina(Korisnik kor) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT * FROM kupovina JOIN korisnik ON kupovina.korisnikId = korisnik.korisnikId  JOIN prodajniobjekat ON kupovina.objekatId = prodajniobjekat.objekatId WHERE korisnik.korisnikId = '" + kor.getKorisnik_id() + "' ORDER BY kupovina.kupovinaId ASC";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        ArrayList<Kupovina> lista = new ArrayList<>();
        while (rs.next()) {
            ProdajniObjekat o = new ProdajniObjekat(rs.getInt(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getInt(18));
            Korisnik k = new Korisnik(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13));

            lista.add(new KupovinaBuilder()
                    .kupovina_id(rs.getInt(1))
                    .Korisnik(k)
                    .ProdajniObjekat(o)
                    .naziv(rs.getString(4))
                    .cena(rs.getDouble(5))
                    .brojProizvoda(rs.getInt(6))
                    .metodPlacanja(rs.getString(7))
                    .build());

        }

        kon.close();
        return lista;
    }

    public void dodajKupovinu(Kupovina r) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();

        String upit = "INSERT INTO kupovina (korisnikId, objekatId,naziv_proizvoda,metod_placanja,broj_proizvoda) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = kon.prepareStatement(upit);

        ps.setInt(1, r.getKorisnik().getKorisnik_id());
        ps.setInt(2, r.getPo().getObjekat_id());
        ps.setString(3, r.getNazivProizvoda());
        ps.setString(4, r.getMetodPlacanja());
        ps.setInt(5, r.getBrojProizvoda());

        ps.executeUpdate();
        kon.close();

    }

    public int ukupnoKupljenjo(ProdajniObjekat o) throws ClassNotFoundException, SQLException {
        DBKonekcija konekcija = new DBKonekcija();
        Connection kon = konekcija.zapocniKonekciju();
        String upit = "SELECT SUM(prodajniObjekat.lagerKolicina) as ukupno FROM kupovina INNER JOIN prodajniObjekat ON kupovina.objekatId = prodajniObjekat.objekatId WHERE prodajniObjekat.objekatId = '" + o.getObjekat_id() + "' ORDER BY kupovina.kupovinaId ASC";
        PreparedStatement ps = kon.prepareStatement(upit);

        ResultSet rs = ps.executeQuery();
        int ukupno = 0;
        while (rs.next()) {

            ukupno = rs.getInt(1);
        }

        kon.close();
        return ukupno;
    }

    public void KupovinaTabel(TableView tv, Korisnik kor) throws ClassNotFoundException, SQLException {

        //TableView tv = new TableView();
        //uzimanje vrednosti iz baze 
        ArrayList<Kupovina> p = listaKupovina(kor);
        //KOLONE

        TableColumn<Kupovina, String> column1 = new TableColumn("id");
        column1.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getKupovina_id() + ""));

        TableColumn<Kupovina, String> column2 = new TableColumn("korisnik");
        column2.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getKorisnik().getKorisnik_id() + ""));

        TableColumn<Kupovina, String> column3 = new TableColumn("prodajniObjekat");
        column3.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPo().getObjekat_id() + ""));

        TableColumn<Kupovina, String> column4 = new TableColumn("Naziv Proizvoda");
        column4.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getNazivProizvoda() + ""));

        TableColumn<Kupovina, String> column5 = new TableColumn("Cena");
        column5.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCena() + ""));

        TableColumn<Kupovina, String> column7 = new TableColumn("Broj proizvoda");
        column7.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getBrojProizvoda() + ""));

        TableColumn<Kupovina, String> column6 = new TableColumn("Metod placanja");
        column6.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getMetodPlacanja() + ""));

        tv.getColumns().add(column1);
        tv.getColumns().add(column2);
        tv.getColumns().add(column3);
        tv.getColumns().add(column4);
        tv.getColumns().add(column5);
        tv.getColumns().add(column6);
        tv.getColumns().add(column7);

        tv.getItems().addAll(p);
    }
}
