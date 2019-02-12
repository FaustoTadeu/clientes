package br.com.engineering.clientes.model;

import java.io.Serializable;

import java.util.Objects;
import javax.persistence.*;

@Entity(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nomeCliente;

    private Long cpfCliente;

    private String sexoCliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    public Cliente() { }

    public Cliente(Integer idCliente, String nomeCliente, Long cpfCliente, String sexoCliente) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.sexoCliente = sexoCliente;
    }


    public Cliente(Integer idCliente, String nomeCliente, Long cpfCliente, String sexoCliente, Vendedor vendedor) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.sexoCliente = sexoCliente;
        this.vendedor = vendedor;
    }

    public Integer getIdCliente() { return idCliente; }

    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public String getNomeCliente() { return nomeCliente; }

    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public Long getCpfCliente() { return cpfCliente; }

    public void setCpfCliente(Long cpfCliente) { this.cpfCliente = cpfCliente; }

    public String getSexoCliente() { return sexoCliente; }

    public void setSexoCliente(String sexoCliente) { this.sexoCliente = sexoCliente; }

    public Vendedor getVendedor() { return vendedor; }

    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente) &&
                nomeCliente.equals(cliente.nomeCliente) &&
                cpfCliente.equals(cliente.cpfCliente) &&
                Objects.equals(sexoCliente, cliente.sexoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nomeCliente, cpfCliente, sexoCliente);
    }
}

