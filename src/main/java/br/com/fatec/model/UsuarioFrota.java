package br.com.fatec.model;

import java.util.Objects;


public class UsuarioFrota {
    private String comeco, fim, aluguel;
    private float total, subTotal, taxa;
    private Autos autos;
    private Usuario usuario;

    public UsuarioFrota() {
    }

    public UsuarioFrota(String comeco, String fim, String aluguel, float total, float subTotal, float taxa, Autos autos, Usuario usuario) {
        this.comeco = comeco;
        this.fim = fim;
        this.aluguel = aluguel;
        this.total = total;
        this.subTotal = subTotal;
        this.taxa = taxa;
        this.autos = autos;
        this.usuario = usuario;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public String getComeco() {
        return comeco;
    }

    public void setComeco(String comeco) {
        this.comeco = comeco;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public String getAluguel() {
        return aluguel;
    }

    public void setAluguel(String aluguel) {
        this.aluguel = aluguel;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Autos getAutos() {
        return autos;
    }

    public void setAutos(Autos autos) {
        this.autos = autos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.usuario);
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
        final UsuarioFrota other = (UsuarioFrota) obj;
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return getUsuario().getCPF();
    }
}
