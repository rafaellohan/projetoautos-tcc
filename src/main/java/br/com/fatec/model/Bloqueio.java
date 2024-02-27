package br.com.fatec.model;

import java.util.Objects;

public class Bloqueio {
    private String CPFCNPJ;
    
    public Bloqueio() {
    };
    
    public Bloqueio(String CPFCNPJ) {
        this.CPFCNPJ = CPFCNPJ;
    }

    public String getCPFCNPJ() {
        return CPFCNPJ;
    }

    public void setCPFCNPJ(String CPFCNPJ) {
        this.CPFCNPJ = CPFCNPJ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.CPFCNPJ);
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
        final Bloqueio other = (Bloqueio) obj;
        return Objects.equals(this.CPFCNPJ, other.CPFCNPJ);
    }

    @Override
    public String toString() {
        return getCPFCNPJ();
    }
    
}

