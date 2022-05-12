package it.annu;

import java.util.ArrayList;
import java.util.Scanner;

public class Battello {
    private Scanner scanner;
    private String nome;
    private int nPosti;
    private int oraPartenza;


    /*public Battello(String nome, int nPosti, int potenza, int oraPartenza) {
        this.nome = nome;
        this.nPosti = nPosti;
        this.potenza = potenza;
        this.oraPartenza = oraPartenza;
        scanner = new Scanner(System.in);
    }*/
    //TODO COntrolla l'effettiva utilità di questo costruttore

    public Battello() {
        scanner = new Scanner(System.in);
    }

    //Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setnPosti(int nPosti) {
        this.nPosti = nPosti;
    }
    public void setOraPartenza(int oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    //Getter
    public String getNome() {
        return nome;
    }
    public int getnPosti() {
        return nPosti;
    }
    public int getOraPartenza() {
        return oraPartenza;
    }

    public void inserisciBattello(ArrayList<Battello> battelli, ArrayList<Integer> orari) {
        Battello battello = new Battello();
        System.out.println("Inserire il nome del battello: ");
        nome = scanner.nextLine();
        do {
            System.out.println("Inserire i posti disponibili: ");
            nPosti = scanner.nextInt();
        } while(nPosti <= 0);
        boolean exit = false;
        do {
            System.out.println("Inserire l'orario di partenza [hh]: ");
            oraPartenza = scanner.nextInt();
        } while(oraPartenza <= 0 || oraPartenza > 24 && exit == false);
        //TODO Continua da qui
        orari.add(oraPartenza);
        battelli.add(battello);
    }
}
