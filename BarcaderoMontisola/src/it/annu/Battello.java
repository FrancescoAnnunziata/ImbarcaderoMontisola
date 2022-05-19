package it.annu;

import java.util.ArrayList;
import java.util.Scanner;

public class Battello {
    private Scanner scanner;
    private String nome;
    private int nPosti;
    private int oraPartenza;

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

    public static Battello inserisciBattello(Scanner scanner, ArrayList<Integer> orari, ArrayList<Battello> battelli) {
        Battello battello = new Battello();
        boolean exit = true;

        do {
            exit = true;
            System.out.println("Inserire il nome del battello: ");
            battello.nome = scanner.nextLine();
            for(Battello i : battelli) {
                if(i.getNome().equals(battello.nome)) {
                    System.out.println("Il battello " + battello.nome + " è già resgistrato");
                    exit = false;
                }
            }
        } while(!exit);

        do {
            System.out.println("Inserire i posti disponibili: ");
            battello.nPosti = scanner.nextInt();
        } while(battello.nPosti <= 0);

        do {
            System.out.println("Inserire l'orario di partenza [hh]: ");
            battello.oraPartenza = scanner.nextInt();
            exit = true;
            if(orari.contains(battello.oraPartenza)) {
                System.out.println("In questo orario è già prevista la partenza di un altro battello");
                exit = false;
            }
        } while(battello.oraPartenza <= 0 || battello.oraPartenza > 24 || !exit);
        orari.add(battello.oraPartenza);

        return battello;
    }
}
