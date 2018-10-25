package ba.unsa.etf.rpr.tutorijal1;

public class Predmet
{
    Student[] niz_st;
    String naziv_pr;
    String sifra_pr;
    final int MAX_ST;
    int vec_upisanih;

    public Student[] getNiz_st() {
        return niz_st;
    }

    public void setNiz_st(Student[] niz_st) {
        this.niz_st = niz_st;
    }

    public String getNaziv_pr() {
        return naziv_pr;
    }

    public void setNaziv_pr(String naziv_pr) {
        this.naziv_pr = naziv_pr;
    }

    public String getSifra_pr() {
        return sifra_pr;
    }

    public void setSifra_pr(String sifra_pr) {
        this.sifra_pr = sifra_pr;
    }

    Predmet(int MAX_ST, String naziv_pr, String sifra_pr) throws ArithmeticException
    {
        if(MAX_ST<=0)
        {
            throw new ArithmeticException("Velicina niza ne moze biti 0 ili manja od 0");
        }

        niz_st=new Student[MAX_ST];
        this.naziv_pr = naziv_pr;                 //(String)naziv_pr.clone();
        this.sifra_pr = sifra_pr;                 //(String)sifra_pr.clone();
        this.MAX_ST=MAX_ST;
        vec_upisanih=0;
    }

    public void upisi(Student s)
    {
        if(vec_upisanih+1 >= MAX_ST)
        {
            System.out.println("Prekoracen maksimalni broj studenata u nizu");
            return;
        }

        niz_st[vec_upisanih] = new Student(s);
        vec_upisanih++;
    }

    public void ispisi(Student s)
    {
        if(vec_upisanih-1 < 0)
        {
            System.out.println("Nema vise studenata u nizu");
            return;
        }

        niz_st[vec_upisanih]=null;
        vec_upisanih--;
    }
}
