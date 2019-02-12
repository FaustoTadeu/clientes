package br.com.engineering.clientes.service;

import br.com.engineering.clientes.dto.VendedorDTO;
import br.com.engineering.clientes.model.Vendedor;
import br.com.engineering.clientes.repository.VendedorRepository;
import br.com.engineering.clientes.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor findVendedorById(Integer idVend) {
        Optional<Vendedor> obj = vendedorRepository.findById(idVend);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + idVend + ", Tipo: " + Vendedor.class.getName()
        ));
    }

    public List<Vendedor> findAllVendendores() {
        List<Vendedor> obj = null;
        try {
            obj =  vendedorRepository.findAll();
        }catch (Exception e) {
            new ObjectNotFoundException("Objetos do tipo " + Vendedor.class.getName() + " não encontrados");
        }
        return obj;
    }

    public Vendedor findByCpfVendedor (Long cpfVendedor) {
        Vendedor obj  = vendedorRepository.findByCpfVendedor(cpfVendedor);
        if(obj == null) {
            throw  new ObjectNotFoundException("Objeto não encontrado! CPF: " + cpfVendedor + " Tipo: " + Vendedor.class);
        }
        return obj;
    }

    public Vendedor InsertEditVendedor(Vendedor vend) {
        if (vend.getIdVendedor() != null) {
            findVendedorById(vend.getIdVendedor());
        }
        return vendedorRepository.save(vend);
    }

    public void deleteVendedor(Integer idVend) {
        Vendedor cli =  findVendedorById(idVend);
        try{
            vendedorRepository.delete(cli);
        } catch (Exception e) {
            throw e;
        }
    }

    public Vendedor fromDTO (VendedorDTO vendDto, Integer idVendedor) {
        return new Vendedor(idVendedor == null ? null : idVendedor, vendDto.getNomeVendedor(), vendDto.getCpfVendedor());
    }

}
