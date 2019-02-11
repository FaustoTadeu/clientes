package br.com.engineering.clientes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity(name = "vendedor")
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVendedor;

    private String nomeVendedor;

    private Integer cpfVendedor;

    @JsonIgnore
    @OneToMany(mappedBy = "vendedor")
    private List<Cliente> clientes = new ArrayList<>();

    public Vendedor() { }

    public Vendedor(Integer idVendedor, String nomeVendedor, Integer cpfVendedor) {
        this.idVendedor = idVendedor;
        this.nomeVendedor = nomeVendedor;
        this.cpfVendedor = cpfVendedor;
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Integer getCpfVendedor() {
        return cpfVendedor;
    }

    public void setCpfVendedor(Integer cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public List<Cliente> getClientes() { return clientes; }

    public void setClientes(List<Cliente> clientes) { this.clientes = clientes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(idVendedor, vendedor.idVendedor) &&
                nomeVendedor.equals(vendedor.nomeVendedor) &&
                cpfVendedor.equals(vendedor.cpfVendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVendedor, nomeVendedor, cpfVendedor);
    }
}

