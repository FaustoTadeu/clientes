package br.com.engineering.clientes.dto;

import br.com.engineering.clientes.model.Cliente;
import br.com.engineering.clientes.model.Vendedor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCliente;

    @NotNull(message = "Não pode ser nulo!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(min = 10, max = 50, message = "O tamanho do nome deve ser entre 10 e 50 caracteres !")
    private String nomeCliente;

    private Long cpfCliente;

    private String sexoCliente;

    private Integer idVendedor;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cli)  {
        this.idCliente = cli.getIdCliente();
        this.nomeCliente = cli.getNomeCliente();
        this.cpfCliente = cli.getCpfCliente();
        this.sexoCliente = cli.getSexoCliente();
        this.idVendedor = cli.getVendedor().getIdVendedor();

    }

    public Integer getIdCliente() { return idCliente; }

    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public String getNomeCliente() { return nomeCliente; }

    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public Long getCpfCliente() { return cpfCliente; }

    public void setCpfCliente(Long cpfCliente) { this.cpfCliente = cpfCliente; }

    public String getSexoCliente() { return sexoCliente; }

    public void setSexoCliente(String sexoCliente) { this.sexoCliente = sexoCliente; }

    public Integer getIdVendedor() { return idVendedor; }

    public void setIdVendedor(Integer idVendedor) { this.idVendedor = idVendedor; }
}
