package br.com.fatec.model;

import java.util.Objects;

public class Autos {
    private String modelo, placa, chassi;
    private String motorizacao, combustivel, velocidade;
    private int fabricacao, ordem;
    private float valor, quilometragem;
    private Categoria categoria;
    private Cambio cambio;
    private Direcao direcao;
    private Marca marca;

    public Autos() {
    }

    public Autos(String modelo, String placa, String chassi, String motorizacao, String combustivel, String velocidade, int fabricacao, int ordem, float valor, float quilometragem, Categoria categoria, Cambio cambio, Direcao direcao, Marca marca) {
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.motorizacao = motorizacao;
        this.combustivel = combustivel;
        this.velocidade = velocidade;
        this.fabricacao = fabricacao;
        this.ordem = ordem;
        this.valor = valor;
        this.quilometragem = quilometragem;
        this.categoria = categoria;
        this.cambio = cambio;
        this.direcao = direcao;
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(String velocidade) {
        this.velocidade = velocidade;
    }

    public int getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(int fabricacao) {
        this.fabricacao = fabricacao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cambio getCambio() {
        return cambio;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.placa);
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
        final Autos other = (Autos) obj;
        return Objects.equals(this.placa, other.placa);
    }

    @Override
    public String toString() {
        return getPlaca();
    }
    
    public String volta(String extra) {
        switch (extra) {
            case "Placa":
                return getPlaca();
            case "Chassi":
                return getChassi();
            case "Marca":
                return Integer.toString(getMarca().getCodigo());
            case "Modelo":
                return getModelo();
            case "Ano":
                return Integer.toString(getFabricacao());
            case "Combustivel":
                return getCombustivel();
            case "Motorizacao":
                return getMotorizacao();
            case "Cambio":
                return Integer.toString(getCambio().getCodigo());
            case "Direcao":
                return Integer.toString(getDirecao().getCodigo());
            case "Preco":
                return Float.toString(getValor());
            case "Categoria":
                return Integer.toString(getCategoria().getCodigo());
            case "Quilometragem":
                return Float.toString(getQuilometragem());
            case "MaxVelocidade":
                return getVelocidade();
            case "ID":
                return Integer.toString(getOrdem());
            default:
                return getPlaca();
        }
    }
    
    public String voltaString(String extra) {
        switch (extra) {
            case "Placa":
                return getPlaca();
            case "Chassi":
                return getChassi();
            case "Marca":
                return getMarca().getNome();
            case "Modelo":
                return getModelo();
            case "Ano":
                return Integer.toString(getFabricacao());
            case "Combustivel":
                return getCombustivel();
            case "Motorizacao":
                return getMotorizacao();
            case "Cambio":
                return getCambio().getNome();
            case "Direcao":
                return getDirecao().getNome();
            case "Preco":
                return Float.toString(getValor());
            case "Categoria":
                return getCategoria().getNome();
            case "Quilometragem":
                return Float.toString(getQuilometragem());
            case "MaxVelocidade":
                return getVelocidade();
            case "ID":
                return Integer.toString(getOrdem());
            default:
                return getPlaca();
        }
    }
    
}
