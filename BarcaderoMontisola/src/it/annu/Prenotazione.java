package it.annu;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Prenotazione {
    Scanner scanner;
    private int nPosti;
    private String dataGrezza;
    private Date dataFinale;
    private static final int MAX_POSTI_PRENOTAZIONE = 10;  //Numero massimo di posti prenotabili per prenotazione

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

    public void aggiungiPrenotazione() {
        boolean exit = false;
        //Calendar

        do {
            System.out.println("Inserisci la data [gg/mm/yyyy]: ");
            dataGrezza = scanner.nextLine();
            try {
                DateFormat formatoData = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALY);
                formatoData.setLenient(false);
                dataFinale = formatoData.parse(dataGrezza);
                System.out.println("Data: " + dataFinale);
                exit = true;
            } catch(ParseException e) {
                System.out.println("Formato data non valido");
            }
        } while(!exit);

        //TODO Inserire controllo data che non si aprima del giorno della prenotazione (Calendar e Date)


        System.out.println("Inserire il numero di posti (MAX " + MAX_POSTI_PRENOTAZIONE + "): ");
        do {
            nPosti = scanner.nextInt();
        } while(nPosti < 1 || nPosti > 10);

        //TODO Inserire il controllo dei posti disponibili nel battello



    }
}


