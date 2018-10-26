package ba.unsa.etf.rpr.tutorijal1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PredmetTest 
{
    @Test
    void Predmet(int MAX_ST, String naziv_pr, String sifra_pr) throws ArithmeticException
    {
        assertThrows(ArithmeticException.class, ()->{ new Predmet(-1, "nebitno", "2" );} );

        Predmet p = new Predmet(5, "neki", "3");
        assertEquals("neki", p.naziv_pr);
        assertEquals(5, p.MAX_ST);
        assertEquals("3", p.sifra_pr);
        assertEquals(0, p.vec_upisanih);
    }

    @Test
    void upisi(Student s) throws ArithmeticException
    {
        Predmet p=new Predmet(1, "a", "4");
        assertThrows(ArithmeticException.class, ()->{
                                                        p.upisi(s);} );

        Predmet p2=new Predmet(100, "MA", "1");
        Student s2=new Student("Alex", "Ferguson", 18033 );
        p.upisi(s2);
        assertEquals("Alex", p2.niz_st[0].ime);
        assertEquals("Ferguson", p2.niz_st[0].prezime);
        assertEquals(18033, p2.niz_st[0].br_ind);
        assertEquals(1, p2.vec_upisanih);


        Student s3=new Student("Alex", "Ferguson", 18033 );
        assertThrows(ArithmeticException.class, ()->{p.upisi(s3);} );
    }


    @Test
    void ispisi(Student s) throws ArithmeticException
    {
        Predmet p=new Predmet(100, "TP", "8");

        assertThrows(ArithmeticException.class, ()->{ p.ispisi(s);} );

        p.upisi(s);
        Student s2=new Student("Pol", "Skols", 22);
        p.upisi(s2);

        assertEquals(2, p.vec_upisanih);
        p.ispisi(s);
        assertEquals(1, p.vec_upisanih);

        Student s3=new Student("Rajan", "Giks", 11);
        assertThrows(ArithmeticException.class, ()->{p.ispisi(s3);} );
    }
}