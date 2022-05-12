package it.annu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class Prenotazione {
    Scanner scanner;
    private int nPosti;
    private String dataGrezza;
    private Date dataFinale;
    private int orarioPartenza;
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

    public void aggiungiPrenotazione(ArrayList<Battello> battelli, ArrayList<Integer> orari) throws ParseException {
        boolean exit = false;

        //DATA
        do {
            System.out.println("Inserire la data [gg/mm/yyyy]: ");
            dataGrezza = scanner.nextLine();
            try {
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");                   //Indichiamo il formato della data
                formatoData.setLenient(false);                                                              //Specifichiamo che l'analisi del formato della data inserita sarà rigida
                dataFinale  = formatoData.parse(dataGrezza);                                                //Analizza l'input per produrne la data (la usiamo come controllo)
                if(dataFinale.before(Date.from(Instant.now())) || dataFinale.equals(Date.from(Instant.now()))) {
                    throw new Exception();
                }
                exit = true;
            } catch(Exception e) {
                System.out.println("Formato data non valido");
            }
        } while(!exit);

        //ORA
        System.out.println("----------ORARI----------");
        for(int i : orari) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        do {
            System.out.println("Inserire l'orario scegliendo tra quelli disponibili [hh]: ");
            orarioPartenza = scanner.nextInt();
        } while(!orari.contains(orarioPartenza));

        /*//ELABAROZIONE FINALE
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh");
        Date hours = dateFormat.parse(String.valueOf(orarioPartenza));
        dataFinale.setTime(hours.getTime());
        System.out.println(dataFinale);
        //System.out.println(dateFormat.format(dataFinale));*/
        //TODO Contollare se effetivamente serve l'elaborazione finale

        System.out.println("Inserire il numero di posti (MAX " + MAX_POSTI_PRENOTAZIONE + "): ");
        do {
            nPosti = scanner.nextInt();
        } while(nPosti < 1 || nPosti > 10);

        //TODO Inserire il controllo dei posti disponibili nel battello



    }
}


