package ba.unsa.etf.rpr.tutorijal1;

public class Student
{
     String ime, prezime;
     int br_ind;

     public Student(String ime, String prezime, int br_ind)
     {
         this.ime=ime;
         this.prezime=prezime;
         this.br_ind=br_ind;
     }

     public Student(Student s)
     {
         ime=s.ime;
         prezime=s.prezime;
         br_ind=s.br_ind;
     }

     public String getImeStudenta()
     {
         return ime;
     }

    public String getPrezimeStudenta()
    {
        return prezime;
    }
    public int getBrojIndeksa()
    {
        return br_ind;
    }
    public String toString()
    {
        return prezime+" "+ime+" ("+br_ind+")";
    }
    public void setImeStudenta(String ime)
    {
        this.ime=ime;
    }
    public void setPrezimeStudenta(String prezime)
    {
        this.prezime=prezime;
    }

    public void setBrojIndeksa(int br_ind)
    {
        this.br_ind=br_ind;
    }

}
