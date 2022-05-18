package it.annu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

public class Prenotazione {
    Scanner scanner;
    private int nPosti;
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

    public void aggiungiPrenotazione(ArrayList<Battello> battelli, ArrayList<Integer> orari, HashMap<Date, Integer> calendario) throws ParseException {
        boolean exit = false;

        if(orari.isEmpty()) {
            System.out.println("Non vi è alcun battello disponibile");
            return;
        }

        //DATA
        String data = null;
        String dataGrezza;
        do {
            System.out.println("Inserire la data [gg/mm/yyyy]: ");
            dataGrezza = scanner.nextLine();
            try {
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");                   //Indichiamo il formato della data
                formatoData.setLenient(false);                                                              //Specifichiamo che l'analisi del formato della data inserita sarà rigida
                dataFinale = formatoData.parse(dataGrezza);                                                 //Analizza l'input per produrne la data (la usiamo come controllo)
                data = formatoData.format(dataFinale);
                if (dataFinale.before(Date.from(Instant.now())) || dataFinale.equals(Date.from(Instant.now()))) {
                    throw new Exception();
                }
                exit = true;
            } catch (Exception e) {
                System.out.println("Formato data non valido");
            }
        } while (!exit);

        //ORA
        System.out.println("----------ORARI----------");
        for (int i : orari) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        do {
            System.out.println("Inserire l'orario scegliendo tra quelli disponibili [hh]: ");
            orarioPartenza = scanner.nextInt();
        } while (!orari.contains(orarioPartenza));
        data += " " + orarioPartenza;

        //ELABAROZIONE FINALE
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh");
        Date dataDef = dateFormat.parse(data);
        //System.out.println(dateFormat.format(dataDef));

        //Riempimento hashmap
        if (!calendario.containsKey(dataDef)) {
            int posti;
            for (Battello i : battelli) {
                if (i.getOraPartenza() == orarioPartenza) {
                    posti = i.getnPosti();
                    calendario.put(dataDef, posti);
                }
            }
        }

        //POSTI
        int postiDisponibili = calendario.get(dataDef);
        int postiAggiornati;
        do {
            System.out.println("Posti ancora disponibili: " + postiDisponibili);
            System.out.println("Inserire il numero di posti (MAX " + MAX_POSTI_PRENOTAZIONE + "): ");
            nPosti = scanner.nextInt();
            postiAggiornati = postiDisponibili - nPosti;
            if(postiAggiornati < 0) {
                exit = false;
                System.out.println("Superato il numero massimo di posti disponibli");
                postiAggiornati = postiDisponibili;
            } else {
                calendario.replace(dataDef, postiAggiornati);
                exit = true;
            }
        } while(nPosti < 1 || nPosti > 10 || !exit);
    }
}


