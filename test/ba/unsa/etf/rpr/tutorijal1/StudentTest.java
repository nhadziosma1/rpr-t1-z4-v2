package ba.unsa.etf.rpr.tutorijal1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest
{
    @Test
    void getImeStudenta()
    {
        Student s=new Student("Nedzad", "Hadzuiosmanovic", 18033);
        assertEquals("Nedzad", s.getIme());
    }

    @Test
    void getPrezimeStudenta()
    {
        Student s=new Student("Nedzad", "Hadziosmanovic", 18033);
        assertEquals("Hadziosmanovic", s.getPrezime());
    }

    @Test
    void getBrojIndeksa()
    {
        Student s=new Student("Nedzad", "Hadzuiosmanovic", 18033);
        assertEquals(18033, s.getBr_ind());
    }

    @Test
    void setImeStudenta()
    {
        Student s=new Student("Nedzad", "Hadzuiosmanovic", 18033);
        s.setIme("Hamo");
        assertEquals("Hamo", s.getIme());
    }

    @Test
    void setPrezimeStudenta()
    {
        Student s=new Student("Nedzad", "Hadzuiosmanovic", 18033);
        s.setPrezime("Lange");
        assertEquals("Lange", s.getPrezime());
    }

    @Test
    void setBrojIndeksa()
    {
        Student s=new Student("Nedzad", "Hadzuiosmanovic", 18033);
        s.setBr_ind(10000);
        assertEquals(10000, s.getBr_ind());
    }
}