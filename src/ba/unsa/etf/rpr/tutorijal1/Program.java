package ba.unsa.etf.rpr.tutorijal1;

import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        int br_pred=0, br_st=0;
        Student[] st=new Student[100];
        Predmet[] pr= new Predmet[100];
        Scanner ulaz= new Scanner(System.in);

        while(true)
        {
            System.out.println("Unesite 1 Kreiraj predmet, 2 Novi student, 3 Upis studneta na predmet, 4 Ispis studenta sa predmeta, 5 ");
            int opcija = ulaz.nextInt();

            ulaz.nextLine();

            switch(opcija)
            {
                case 1:
                {
                    System.out. println("Unesi ime predmeta");
                    String str1=ulaz.nextLine();

                    System.out.println("Unesite sifru predmeta");
                    int br1=ulaz.nextInt();
                    System.out.println("Unesite max broj studenata");
                    int br2=ulaz.nextInt();
                    pr[br_pred]=new Predmet(br2,str1, br1);
                    br_pred++;
                }
                break;
                case 2:
                {
                    System.out.println("Unesi ime");
                    String ime=ulaz.nextLine();
                    System.out.println("Unesi prezime");
                    String prezime=ulaz.nextLine();
                    System.out.println("Unesi indeks");
                    int indeks=ulaz.nextInt();
                    st[br_st]=new Student(ime, prezime, indeks);
                    br_st++;
                }
                break;
                case 3:
                {
                    System.out.println("Unesi indeks");
                    int indeks=ulaz.nextInt();
                    System.out.println("Unesi broj predmeta");
                    int broj_pred=ulaz.nextInt();

                    for(int i=0; i<br_st; i++)
                    {
                        if(st[i].getBrojIndeksa()==indeks)
                        {
                            for(int j=0; j<br_pred; j++)
                            {
                                if(pr[j].getBrojPredmeta()==broj_pred)
                                {
                                    pr[j].upisi(st[i]);
                                    break;
                                }
                            }
                            break;
                        }
                    }

                }
                break;
                case 4:
                {
                    System.out.println("Unesi indeks");
                    int indeks=ulaz.nextInt();
                    System.out.println("Unesi broj predmeta");
                    int broj_predmeta=ulaz.nextInt();

                    for(int i=0; i<br_st; i++)
                    {
                        if(st[i].getBrojIndeksa()==indeks)
                        {
                            for(int j=0; j<br_pred; j++)
                            {
                                if(pr[j].getBrojPredmeta()==broj_predmeta)
                                {
                                    pr[j].ispisi(st[i]);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
                break;
                case 5:
                {
                    System.out.println("Unesi indeks");
                    int indeks=ulaz.nextInt();

                    for(int i=0; i<br_st; i++)
                    {
                        if(st[i].getBrojIndeksa()==indeks)
                        {
                            for(int j=i; j<br_st-1; j++)
                                st[j]=st[j+1];

                            br_st--;
                            break;
                        }
                    }

                }
                break;
                case 6:
                {
                    System.out.println("Unesi broj premdeta");
                    int broj_predmeta=ulaz.nextInt();

                    for(int i=0; i<br_pred; i++)
                    {
                        if(pr[i].getBrojPredmeta()==broj_predmeta)
                        {
                            for(int j=i; j<br_pred-1; j++)
                                pr[j]=pr[j+1];

                            br_pred--;
                            break;
                        }
                    }
                }
                break;
                case 7:
                {
                    for(int i=1; i<br_pred+1; i++)
                        System.out.println(i+", "+st[i-1]);

                }
                break;
                default:
                    System.exit(0);
            }
        }
    }

}
