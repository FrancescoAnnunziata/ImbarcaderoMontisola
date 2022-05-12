package it.annu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    int scelta;
    Scanner scanner;
    ArrayList<Battello> battelli = new ArrayList<Battello>();
    ArrayList<Integer> orari = new ArrayList<Integer>();

    public Menu() {
        scanner = new Scanner(System.in);
        this.battelli = new ArrayList<>();
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
            switch(scelta) {
                case 0:
                    System.out.println("Esecuzione terminata con successo");
                    return;
                case 1:
                    Battello b = new Battello();
                    b.inserisciBattello(battelli, orari);
                    break;
                case 2:
                    Prenotazione p = new Prenotazione();
                    p.aggiungiPrenotazione(battelli, orari);
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
