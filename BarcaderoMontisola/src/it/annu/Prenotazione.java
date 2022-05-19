package it.annu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Prenotazione {
    Scanner scanner;
    private Cliente cliente;
    private Date dataDef;
    private int nPosti;
    private static final int MAX_POSTI_PRENOTAZIONE = 10;                                                  //Numero massimo di posti prenotabili per prenotazione

    public Prenotazione() {
        scanner = new Scanner(System.in);
        this.cliente = new Cliente();
    }

    public void setnPosti(int nPosti) {
        this.nPosti = nPosti;
    }

    public int getnPosti() {
        return nPosti;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Date getDataDef() {
        return dataDef;
    }

    public static Prenotazione aggiungiPrenotazione(ArrayList<Battello> battelli, ArrayList<Integer> orari, HashMap<Date, Integer> calendario) throws ParseException {
        Prenotazione prenotazione = new Prenotazione();
        if(orari.isEmpty()) {
            System.out.println("Non vi è alcun battello disponibile");
            return prenotazione = null;
        } else {
            boolean exit = false;

            //CLIENTE
            prenotazione.cliente = Cliente.nuovoCliente();

            //DATA
            Data data = new Data();
            prenotazione.dataDef = data.elaborazioneFinale(orari);

            //Riempimento hashmap
            if (!calendario.containsKey(prenotazione.dataDef)) {
                int posti;
                for (Battello i : battelli) {
                    if (i.getOraPartenza() == data.getOra()) {
                        posti = i.getnPosti();
                        calendario.put(prenotazione.dataDef, posti);
                    }
                }
            }

            //POSTI
            int postiDisponibili = calendario.get(prenotazione.dataDef);
            if(postiDisponibili == 0) {
                System.out.println("Il battello è già al completo");
                return prenotazione = null;
            } else {
                int postiAggiornati;
                do {
                    System.out.println("Posti ancora disponibili: " + postiDisponibili);
                    System.out.println("Inserire il numero di posti (MAX " + MAX_POSTI_PRENOTAZIONE + "): ");
                    prenotazione.nPosti = prenotazione.scanner.nextInt();
                    postiAggiornati = postiDisponibili - prenotazione.nPosti;
                    if(postiAggiornati < 0) {
                        exit = false;
                        System.out.println("Superato il numero massimo di posti disponibli");
                        postiAggiornati = postiDisponibili;
                    } else {
                        calendario.replace(prenotazione.dataDef, postiAggiornati);
                        exit = true;
                    }
                } while(prenotazione.nPosti < 1 || prenotazione.nPosti > 10 || !exit);
            }
        }
        return prenotazione;
    }

    public void cancellaPrenotazione(ArrayList<Integer> orari, ArrayList<Prenotazione> prenotazioni, HashMap<Date, Integer> calendario) throws ParseException {
        if(orari.isEmpty()) {
            System.out.println("Non vi è alcun battello disponibile");
            return;
        } else {
            System.out.println("Inserire i dati della prenotazione: ");
            int postiDisponibili;
            cliente = Cliente.nuovoCliente();
            for(Prenotazione i : prenotazioni) {
                String n1 = cliente.getNome(), c1 = cliente.getCognome(), l1 = cliente.getCognome();
                String n2 = i.cliente.getNome(), c2 = i.cliente.getCognome(), l2 = i.cliente.getCognome();
                if(n1.equalsIgnoreCase(n2) && c1.equalsIgnoreCase(c2) && l1.equalsIgnoreCase(l2)) {
                    Data data = new Data();
                    dataDef = data.elaborazioneFinale(orari);
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh");
                    String d1 = df.format(dataDef), d2 = df.format(i.getDataDef());
                    if(d1.equals(d2)) {
                        postiDisponibili = calendario.get(dataDef) + i.getnPosti();
                        calendario.replace(dataDef, postiDisponibili);
                        prenotazioni.remove(i);
                    }
                } else {
                    System.out.println("Non esiste alcuna prenotazione associata ai dati inseriti");
                }
            }
        }
    }

    public void elenco(ArrayList<Battello> battelli, ArrayList<Integer> orari, HashMap<Date, Integer> calendario) throws ParseException {
        if(orari.isEmpty()) {
            System.out.println("Non vi è alcun battello disponibile");
            return;
        } else {
            Data d = new Data();
            System.out.println("Inserire i dati riguardanti la data che si vuole esaminare: ");
            Date data = d.elaborazioneFinale(orari);
            float posti = calendario.get(data);
            for (Battello i : battelli) {
                if (d.getOra() == i.getOraPartenza()) {
                    int postiIniziali = i.getnPosti();
                    float percentuale = 100 - ((posti / postiIniziali) * 100);
                    System.out.println("Percentuale di posti occupati del battello " + i.getNome() + " nel giorno " + d.getData() + ": " + percentuale + "%\n");
                }
            }
        }

    }

    @Override
    public String toString() {
        return "-------------------------\n" +
                cliente +
                "\nDATA: " + dataDef +
                "\nPOSTI: " + nPosti +
                "\n-------------------------";
    }
}


