package ba.unsa.etf.rpr.tutorijal1;

public class Predmet
{
    String naziv_pr;
    Student[] niz_st;
    int max_br_st, br_upisanih, br_pred;

    public Predmet(int max_br_st, String naziv_pr, int br_pred)
    {
        if(max_br_st < 0)
            max_br_st=0;

        this.max_br_st=max_br_st;
        this.naziv_pr=naziv_pr;
        this.br_pred=br_pred;
        this.br_upisanih=0;
        niz_st=new Student[max_br_st];
    }

    public int upisi(Student st)
    {
        if(br_upisanih < max_br_st)
        {
            niz_st[br_upisanih] = new Student(st);
            br_upisanih++;
        }
        return br_upisanih;
    }

    public int ispisi(Student st)
    {
        for(int i=0; i<br_upisanih; i++)
        {
            if(st.getBrojIndeksa() == niz_st[i].getBrojIndeksa())
            {
                for(int j=i; j<(br_upisanih-1); j++)
                    niz_st[j] = niz_st[j+1];

                br_upisanih--;
                break;
            }
        }
        return br_upisanih;
    }

    public String getNazivPredmeta()
    {
        return naziv_pr;
    }

    public int getBrojUpisanih()
    {
        return br_upisanih;
    }

    public int getBrojPredmeta()
    {
        return br_pred;
    }

    public int getMaxBrojStudenata()
    {
        return max_br_st;
    }

    public void setNazivPredmeta(String naziv)
    {
        this.naziv_pr=naziv;
    }
    public void setBrojUpisanih(int up)
    {
        this.br_upisanih=up;
    }

    public void setBrojPredmeta(int br_pred)
    {
        this.br_pred=br_pred;
    }

}
