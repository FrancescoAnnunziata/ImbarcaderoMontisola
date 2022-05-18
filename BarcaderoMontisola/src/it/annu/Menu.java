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


    public Menu() {
        scanner = new Scanner(System.in);
        this.battelli = new ArrayList<>();
        this.orari = new ArrayList<>();
        this.calendario = new HashMap<>();
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
                    Prenotazione p = new Prenotazione();
                    p.aggiungiPrenotazione(battelli, orari, calendario);
                    break;
                case 3:
                    //cancellaPrenotazione();
                    break;
                case 4:
                    //elenco();
                    break;
            }
        }
    }
}
