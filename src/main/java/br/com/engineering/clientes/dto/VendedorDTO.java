package br.com.engineering.clientes.dto;

import br.com.engineering.clientes.model.Vendedor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class VendedorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idVendedor;

    @NotNull(message = "Não pode ser nulo!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(min = 10, max = 50, message = "O tamanho deve ser pelo menos 3 caracteres!")
    private String nomeVendedor;

    private Long cpfVendedor;


    public VendedorDTO() {
    }

    public VendedorDTO(Vendedor cli)  {
        idVendedor = cli.getIdVendedor();
        nomeVendedor = cli.getNomeVendedor();
        cpfVendedor = cli.getCpfVendedor();
    }

    public Integer getIdVendedor() { return idVendedor; }

    public void setIdVendedor(Integer idVendedor) { this.idVendedor = idVendedor; }

    public String getNomeVendedor() { return nomeVendedor; }

    public void setNomeVendedor(String nomeVendedor) { this.nomeVendedor = nomeVendedor; }

    public Long getCpfVendedor() { return cpfVendedor; }

    public void setCpfVendedor(Long cpfVendedor) { this.cpfVendedor = cpfVendedor; }

}
