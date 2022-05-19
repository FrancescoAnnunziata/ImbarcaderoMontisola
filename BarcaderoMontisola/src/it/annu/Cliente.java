package it.annu;

import java.util.Scanner;

public class Cliente {
    Scanner scanner;
    private String nome;
    private String cognome;
    private String luogoNascita;

    public Cliente() {
        scanner = new Scanner(System.in);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public static Cliente nuovoCliente() {
        Cliente cliente = new Cliente();
        System.out.println("Inserire i propri dati: ");
        System.out.println("NOME: ");
        cliente.nome = cliente.scanner.nextLine();
        System.out.println("COGNOME: ");
        cliente.cognome = cliente.scanner.nextLine();
        System.out.println("CITTÀ di NASCITA: ");
        cliente.luogoNascita = cliente.scanner.nextLine();

        return cliente;
    }

    @Override
    public String toString() {
        return "NOME CLIENTE: " + nome +
                "\nCOGNOME CLIENTE: " + cognome +
                "\nCITTÀ DI NASCITA: " + luogoNascita;
    }
}
