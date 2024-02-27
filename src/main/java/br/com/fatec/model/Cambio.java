package br.com.fatec.model;

public class Cambio {
    private int codigo;
    private String nome;

    public Cambio() {
    }

    public Cambio(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.codigo;
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
        final Cambio other = (Cambio) obj;
        return this.codigo == other.codigo;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    
}
