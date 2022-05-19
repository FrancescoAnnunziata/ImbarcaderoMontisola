package it.annu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Data {
    Scanner scanner;
    private Date data;
    private int ora;
    private Date dataCompleta;

    public Data() {
        scanner = new Scanner(System.in);
        this.data = new Date();
        this.dataCompleta = new Date();
    }

    public String setData() {
        boolean exit = false;
        String date = null;
        String dataGrezza;
        do {
            System.out.println("Inserire la data della prenotazione [gg/mm/yyyy]: ");
            dataGrezza = scanner.nextLine();
            try {
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");                   //Indichiamo il formato della data
                formatoData.setLenient(false);                                                              //Specifichiamo che l'analisi del formato della data inserita sarà rigida
                data = formatoData.parse(dataGrezza);                                                 //Analizza l'input per produrne la data (la usiamo come controllo)
                date = formatoData.format(data);
                if (data.before(Date.from(Instant.now())) || data.equals(Date.from(Instant.now()))) {
                    throw new Exception();
                }
                exit = true;
            } catch (Exception e) {
                System.out.println("Formato data non valido");
            }
        } while (!exit);

        return date;
    }

    public String setOra(ArrayList<Integer> orari) {
        int orarioPartenza;
        System.out.println("----------ORARI----------");
        for (int i : orari) {
            System.out.println(i);
        }
        System.out.println("-------------------------");
        do {
            System.out.println("Inserire l'orario scegliendo tra quelli disponibili [hh]: ");
            orarioPartenza = scanner.nextInt();
        } while (!orari.contains(orarioPartenza));
        ora = orarioPartenza;

        return String.valueOf(orarioPartenza);
    }

    public int getOra() {
        return ora;
    }

    public Date getData() {
        return data;
    }

    public Date elaborazioneFinale(ArrayList<Integer> orari) throws ParseException {
        String date = setData() + " " + setOra(orari);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh");
        dataCompleta = dateFormat.parse(date);

        return dataCompleta;
    }
}
