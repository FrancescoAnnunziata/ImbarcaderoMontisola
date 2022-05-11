package it.annu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    int scelta;
    Scanner scanner;
    ArrayList<Battello> battelli;

    public Menu() {
        scanner = new Scanner(System.in);
        this.battelli = new ArrayList<>();
    }

    public void run() {
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
                    //inserisciBattello();
                    break;
                case 2:
                    Prenotazione p = new Prenotazione();
                    p.aggiungiPrenotazione(battelli);
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
