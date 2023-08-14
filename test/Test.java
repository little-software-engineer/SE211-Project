
import baza.DBKontroler;
import entiteti.ProdajniObjekat;
import exceptions.GreskaUUnosu;
import exceptions.NemaNaStanju;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class Test {

    public Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  @org.junit.Test
    public void test1() throws ClassNotFoundException, SQLException, NemaNaStanju, GreskaUUnosu {
        ProdajniObjekat prodajniObjekat = new ProdajniObjekat(1, "Lilly", "Dositeja Obradovica 1", "Beograd", 123);
        DBKontroler db = new DBKontroler();

        boolean exp = true;
        boolean result = db.proveraStanja(prodajniObjekat, 50);
        assertEquals(exp, result);
    }

    @org.junit.Test
    public void test2() throws ClassNotFoundException, SQLException, NemaNaStanju, GreskaUUnosu {
        ProdajniObjekat prodajniObjekat = new ProdajniObjekat(1, "Lilly", "Dositeja Obradovica 1", "Beograd", 123);
        DBKontroler db = new DBKontroler();

        boolean exp = false;
        boolean result = db.proveraStanja(prodajniObjekat, 125);
        assertEquals(exp, result);
    }

    @org.junit.Test
    public void test3() throws ClassNotFoundException, SQLException, NemaNaStanju, GreskaUUnosu {
        ProdajniObjekat prodajniObjekat = new ProdajniObjekat(1, "Lilly", "Dositeja Obradovica 1", "Beograd", 123);
        DBKontroler db = new DBKontroler();

        boolean exp = false;
        boolean result = db.proveraStanja(prodajniObjekat, -150);
        assertEquals(exp, result);
    }

    @org.junit.Test
    public void test4() throws ClassNotFoundException, SQLException, NemaNaStanju, GreskaUUnosu {
        ProdajniObjekat prodajniObjekat = new ProdajniObjekat(1, "Lilly", "Dositeja Obradovica 1", "Beograd", 123);
        DBKontroler db = new DBKontroler();

        boolean exp = false;
        boolean result = db.proveraStanja(prodajniObjekat, 0);
        assertEquals(exp, result);
    }
}
