package br.com.fatec.model;


public class Cartao {
    private String tipo, bandeira, nome, vence;
    private int numero, CVV;

    public Cartao() {
    }

    public Cartao(String tipo, String bandeira, String nome, String vence, int numero, int CVV) {
        this.tipo = tipo;
        this.bandeira = bandeira;
        this.nome = nome;
        this.vence = vence;
        this.numero = numero;
        this.CVV = CVV;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVence() {
        return vence;
    }

    public void setVence(String vence) {
        this.vence = vence;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cartao other = (Cartao) obj;
        return this.numero == other.numero;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
