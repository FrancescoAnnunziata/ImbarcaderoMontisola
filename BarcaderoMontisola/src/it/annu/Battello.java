package it.annu;

public class Battello {
    private String nome;
    private int nPosti;
    private int potenza;
    private int oraPartenza;

    public Battello(String nome, int nPosti, int potenza, int oraPartenza) {
        this.nome = nome;
        this.nPosti = nPosti;
        this.potenza = potenza;
        this.oraPartenza = oraPartenza;
    }
    public Battello() {
    }

    //Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setnPosti(int nPosti) {
        this.nPosti = nPosti;
    }
    public void setPotenza(int potenza) {
        this.potenza = potenza;
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
    public int getPotenza() {
        return potenza;
    }
    public int getOraPartenza() {
        return oraPartenza;
    }

    public void inserisciBattello() {
        Battello battello = new Battello();
    }
}
