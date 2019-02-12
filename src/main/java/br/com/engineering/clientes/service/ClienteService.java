package br.com.engineering.clientes.service;

import br.com.engineering.clientes.dto.ClienteDTO;
import br.com.engineering.clientes.model.Cliente;
import br.com.engineering.clientes.model.Vendedor;
import br.com.engineering.clientes.repository.ClienteRepository;
import br.com.engineering.clientes.repository.VendedorRepository;
import br.com.engineering.clientes.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public Cliente findClienteById(Integer idCat) {
        Optional<Cliente> obj = clienteRepository.findById(idCat);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + idCat + ", Tipo: " + Cliente.class.getName()
        ));
    }

    public List<Cliente> findAllClientes() {
        List<Cliente> obj = null;
        try {
            obj =  clienteRepository.findAll();
        }catch (Exception e) {
            new ObjectNotFoundException("Objetos do tipo " + Cliente.class.getName() + " não encontrados");
        }
        return obj;
    }

    public Cliente findByCpfVendedor (Long cpfCliente) {
        Cliente obj  = clienteRepository.findByCpfCliente(cpfCliente);
        if(obj == null) {
            throw  new ObjectNotFoundException("Objeto não encontrado! CPF: " + cpfCliente + " Tipo: " + Cliente.class);
        }
        return obj;
    }

    public Cliente InsertEditCliente(Cliente cli) {
        if (cli.getIdCliente() != null) {
            findClienteById(cli.getIdCliente());
        }
        return clienteRepository.save(cli);
    }

    public void deleteCliente(Integer idCli) {
        Cliente cli =  findClienteById(idCli);
        try{
            clienteRepository.delete(cli);
        } catch (Exception e) {
            throw e;
        }
    }

    public Cliente fromDTO (ClienteDTO cliDto, Integer idCliente) {
        Vendedor vendedor = vendedorRepository.getOne(cliDto.getIdVendedor());
        return new Cliente(idCliente == null ? null : idCliente, cliDto.getNomeCliente(), cliDto.getCpfCliente(), cliDto.getSexoCliente() == null ? null : cliDto.getSexoCliente(), vendedor);
    }

}
