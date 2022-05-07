package it.annu;

public class Battello {
    private String nome;
    private int nPosti;
    private int potenza;

    public Battello(String nome, int nPosti, int potenza) {
        this.nome = nome;
        this.nPosti = nPosti;
        this.potenza = potenza;
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

    public void inserisciBattello() {
        Battello battello = new Battello();
    }
}
