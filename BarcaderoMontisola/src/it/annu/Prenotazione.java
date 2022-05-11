package it.annu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Prenotazione {
    Scanner scanner;
    private int nPosti;
    private String dataGrezza;
    private Date dataFinale;
    private int orarioPartenza;
    private ArrayList<Integer> orari = new ArrayList<Integer>();
    private static final int MAX_POSTI_PRENOTAZIONE = 10;                                                  //Numero massimo di posti prenotabili per prenotazione

    public Prenotazione() {
        scanner = new Scanner(System.in);
        this.dataFinale = new Date();
    }

    public void setnPosti(int nPosti) {
        this.nPosti = nPosti;
    }

    public int getnPosti() {
        return nPosti;
    }

    public void aggiungiPrenotazione(ArrayList<Battello> battelli){
        boolean exit = false;

        //DATA
        do {
            System.out.println("Inserire la data [gg/mm/yyyy]: ");
            dataGrezza = scanner.nextLine();
            try {
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");                   //Indichiamo il formato della data
                formatoData.setLenient(false);                                                              //Specifichiamo che l'analisi del formato della data inserita sarà rigida
                dataFinale  = formatoData.parse(dataGrezza);                                                //Analizza l'input per produrne la data (la usiamo come controllo)
                System.out.println(formatoData.format(dataFinale));
                //if(dataFinale.after())
                exit = true;
            } catch(ParseException e) {
                System.out.println("Formato data non valido");
            }
        } while(!exit);

        //TODO contollare compatibilità Date e Calendar

        //ORA
        System.out.println("----------ORARI----------");
        for(Battello i : battelli) {
            System.out.println(i.getOraPartenza());
            orari.add(i.getOraPartenza());
        }
        System.out.println("-------------------------");
        do {
            System.out.println("Inserire l'orario scegliendo tra quelli disponibili [hh]: ");
            orarioPartenza = scanner.nextInt();
        } while(!orari.contains(orarioPartenza));



        //ELABAROZIONE FINALE
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //dataFinale = dateFormat.parse(dataGrezza);
        //System.out.println(dateFormat.format(dataFinale));

        //TODO Inserire controllo data che non sia prima del giorno della prenotazione (Calendar e Date)


        System.out.println("Inserire il numero di posti (MAX " + MAX_POSTI_PRENOTAZIONE + "): ");
        do {
            nPosti = scanner.nextInt();
        } while(nPosti < 1 || nPosti > 10);

        //TODO Inserire il controllo dei posti disponibili nel battello



    }
}


