package ba.unsa.etf.rpr.tutorijal1;

public class Student
{
    String ime;
    String prezime;
    int br_ind;


    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBr_ind() {
        return br_ind;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setBr_ind(int br_ind) {
        this.br_ind = br_ind;
    }

    Student(String ime, String prezime, int br_ind)
    {                                          //ZASTO NE MOZE SA "(konverzija)objekt.clone()", NIJE BAS NA NETU FINO OBAJšNJENO??????
        this.ime=ime;                         //(String)ime.clone();
        this.prezime=prezime;                   //(String)prezime.clone();
        this.br_ind=br_ind;
    }

    Student(Student s)
    {
        ime=s.ime;                              //(String)s.ime.clone();
        prezime=s.prezime;                      //(String)s.prezime.clone();
        br_ind=s.br_ind;
    }

    public String toString()
    {
        return ime+" "+prezime+"("+br_ind+")";
    }
}
