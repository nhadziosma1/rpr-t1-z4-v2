package ba.unsa.etf.rpr.tutorijal1;

import java.util.*;

public class Program
{

    public static void main(String[] args)
    {
        Student[] studenti=new Student[100];
        Predmet[] predmeti=new Predmet[100];
        int br_s_un=0, br_p_un=0;

        while (true)
        {
            System.out.println("Unesite: 0- za prekid programa, 1-kreiraj novi predmet, 2-kreiraj novog studenta, 3-upis studenta na predmet, 4-ispis studenta s predmeta, 5-brisanje predmeta, 6-ispis spisak studenata na predmetu");
            Scanner unos = new Scanner(System.in);

            int br = unos.nextInt();

            if(br<0 || br>6)
            {
                System.out.println("Unijeli ste pogresan broj, unesite ponovo!");

                do {
                    br=unos.nextInt();
                }while(br<0 || br>6);
            }

            unos.nextLine(); //da bi pokupio enter koji se unosi nakon unosa broja

            if (br==0)
            {
                break;
            }
            else if(br == 1)
            {
                //kreiraj novi predmet
                String ime_pr, sif_pr;
                int max;

                System.out.println("Uneiste ime predmeta:");
                ime_pr=unos.nextLine();
                System.out.println("Uneiste šifru predmeta:");
                sif_pr=unos.nextLine();
                System.out.println("Uneiste koliko maksimalno osoba moze slusati predmet");
                max=unos.nextInt();

                predmeti[br_p_un]= new Predmet(max, ime_pr, sif_pr);
                br_p_un++;
            }
            else if(br==2)
            {
                //kreiraj novog studneta
                String ime, prezime;
                int indeks;

                System.out.println("Uneiste ime studneta:");
                ime=unos.nextLine();
                System.out.println("Uneiste prezime predmeta:");
                prezime=unos.nextLine();
                System.out.println("Unesite indeks studneta");
                indeks=unos.nextInt();

                studenti[br_s_un]=new Student(ime, prezime, indeks);
                br_s_un++;
            }
            else if(br==3)
            {
                //upis studenta na predmet

                System.out.println("Unesite ime predmeta: ");
                String predmet=unos.nextLine();
                System.out.println("Uneiste sifru predmeta:");
                String sifra=unos.nextLine();

                int i, prekidac=0;
                for(i=0; i<br_p_un; i++)
                {
                    if( predmet.equals(predmeti[i].naziv_pr) && sifra.equals(predmeti[i].sifra_pr))
                    {
                        if(predmeti[i].vec_upisanih+1 >= predmeti[i].MAX_ST)
                        {
                            System.out.println("Unos novog studneta na "+predmet+"nije moguć, jer su kapaciteti na njemu popunjeni");
                            prekidac=1;
                            break;
                        }

                        System.out.println("Uneiste ime studneta:");
                        String ime=unos.nextLine();
                        System.out.println("Uneiste prezime predmeta:");
                        String prezime=unos.nextLine();
                        System.out.println("Unesite indeks studneta");
                        int indeks=unos.nextInt();

                        int j;
                        for(j=0; j<predmeti[i].vec_upisanih; j++)
                        {
                            if(predmeti[i].niz_st[j].ime.equals(ime) && predmeti[i].niz_st[j].prezime.equals(prezime) && predmeti[i].niz_st[j].br_ind==indeks)
                            {
                                System.out.println("Unešeni student vec slusa predmet, pa ga ne morate ponovno upisivati");
                                prekidac=2;
                                break;
                            }
                        }

                        if(prekidac==0)
                        {
                            predmeti[i].niz_st[ predmeti[i].vec_upisanih ]=new Student(ime, prezime, indeks);
                            predmeti[i].vec_upisanih++;
                        }

                        break;
                    }
                }

                if(i==br_p_un && prekidac==0)
                    System.out.println("Ne moze se student upisati na: "+predmet+", jer on, pod sifrom: "+sifra+" ne postoji!");
            }
            else if(br==4)
            {
                //ispis studenta s predmeta

                System.out.println("Unesite ime predmeta: ");
                String predmet=unos.nextLine();
                System.out.println("Uneiste sifru predmeta:");
                String sifra=unos.nextLine();

                int i, prekidac=0;
                for(i=0; i<br_p_un; i++)
                {
                    if(predmet.equals(predmeti[i].naziv_pr) && sifra.equals(predmeti[i].sifra_pr))
                    {
                        if(predmeti[i].vec_upisanih-1 < 0)
                        {
                            System.out.println("Ispis studneta sa: "+predmet+" nije moguć, jer nema studenata na predmetu");
                            prekidac=1;
                            break;
                        }

                        System.out.println("Uneiste ime studneta:");
                        String ime=unos.nextLine();
                        System.out.println("Uneiste prezime studenta:");
                        String prezime=unos.nextLine();
                        System.out.println("Unesite indeks studneta");
                        int indeks=unos.nextInt();

                        int j;
                        for(j=0; j<predmeti[i].vec_upisanih; j++)
                        {
                            if(predmeti[i].niz_st[j].ime.equals(ime) && predmeti[i].niz_st[j].prezime.equals(prezime) && predmeti[i].niz_st[j].br_ind==indeks)
                            {
                                int k;
                                for(k=j; i<predmeti[i].vec_upisanih-1; k++)
                                    predmeti[i].niz_st[k]=predmeti[i].niz_st[k+1];

                                predmeti[i].niz_st[k] = null;

                                predmeti[i].vec_upisanih--;

                                prekidac=2;
                                break;
                            }
                        }

                        if(j==predmeti[i].vec_upisanih && prekidac==0)
                        {
                            System.out.println("Ne postoji studnet: "+ime+" "+prezime+" na predmetu "+predmet+" sa sifrom: "+sifra);
                            prekidac=1;
                        }

                        break;
                    }
                }

                if(i==br_p_un && prekidac==0)
                    System.out.println("Ne moze se student ispisati sa: "+predmet+", jer on, pod si: "+sifra+" ne postoji!");
            }
            else if(br==5)
            {
                //brisanje predmeta

                System.out.println("Unesite ime predmeta: ");
                String predmet=unos.nextLine();
                System.out.println("Uneiste sifru predmeta:");
                String sifra=unos.nextLine();

                int i, prekidac=0;
                for(i=0; i<br_p_un; i++)
                {
                    if(predmet.equals(predmeti[i].naziv_pr) && sifra.equals(predmeti[i].sifra_pr))
                    {
                        for(int j=i; j<br_p_un-1; j++)
                            predmeti[j]=predmeti[j+1];

                        predmeti[br_p_un-1]=null;
                        br_p_un--;

                        prekidac=1;
                        break;
                    }
                }

                if(prekidac==0)  //morala se uvesti promjenjliva prekidac, jer se nije mogaoa iskoristiti uslov "br_p_un==i" jer bi on bio zadovoljen i da je traeni predmeta nadjen kao predzadnji predmet u nizu predmeta
                {
                    System.out.println("U nizu unesenih predmeta ne postoji predmet: "+predmet+" sa sifrom: "+sifra+", pa ga ne mozemo ni izbrisati");
                }
            }
            else if(br==6)
            {
                //Ispisi sve studnete na nekom predmetu
                System.out.println("Unesite ime predmeta: ");
                String predmet=unos.nextLine();
                System.out.println("Uneiste sifru predmeta:");
                String sifra=unos.nextLine();

                int i, prekidac=0;
                for(i=0; i<br_p_un; i++)
                {
                    if( predmet.equals(predmeti[i].naziv_pr) && sifra.equals(predmeti[i].sifra_pr))
                    {
                        if(predmeti[i].vec_upisanih == 0)
                        {
                            System.out.println("Nema upisanih studenata na predmetu: "+predmet+", sa sifrom: "+sifra);
                            break;
                        }

                        int j;
                        for(j=0; j<predmeti[i].vec_upisanih; j++)
                            System.out.println( Integer.toString(j+1) + "." + predmeti[i].niz_st[j].toString() );

                        prekidac=1;
                        break;
                    }
                }

                if(i==br_p_un && prekidac==0)
                    System.out.println("Nije unesen predmet: "+predmet+", sa sifrom: "+sifra);
            }
        }
    }
}
