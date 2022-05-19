package it.annu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    int scelta;
    Scanner scanner;
    ArrayList<Battello> battelli;
    ArrayList<Integer> orari;
    HashMap<Date, Integer> calendario;
    ArrayList<Prenotazione> prenotazioni;

    public Menu() {
        scanner = new Scanner(System.in);
        this.battelli = new ArrayList<>();
        this.orari = new ArrayList<>();
        this.calendario = new HashMap<>();
        this.prenotazioni = new ArrayList<>();
    }

    public void run() throws ParseException {
        while(true) {
            System.out.println(
                    "----------MENU----------\n" +
                    "1 Inserire battello\n" +
                    "2 Aggiungi prenotazione\n" +
                    "3 Cancella prenotazione\n" +
                    "4 Elenco prenotazioni\n" +
                    "0 ESCI\n" +
                    "------------------------"
            );

            scelta = scanner.nextInt();
            scanner.nextLine();
            switch(scelta) {
                case 0:
                    System.out.println("Buon viaggio con IseoLakeTravel");
                    return;
                case 1:
                    Battello b = Battello.inserisciBattello(scanner, orari, battelli);
                    battelli.add(b);
                    break;
                case 2:
                    Prenotazione p = Prenotazione.aggiungiPrenotazione(battelli, orari, calendario);
                    if(p != null) {
                        prenotazioni.add(p);
                    }
                    break;
                case 3:
                    Prenotazione s = new Prenotazione();
                    s.cancellaPrenotazione(orari, prenotazioni, calendario);
                    break;
                case 4:
                    for(Prenotazione i : prenotazioni) {
                        System.out.println(i.toString());
                    }
                    Prenotazione q = new Prenotazione();
                    q.elenco(battelli, orari, calendario);
                    break;
            }
        }
    }
}
