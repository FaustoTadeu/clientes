package br.com.engineering.clientes.repository;

import br.com.engineering.clientes.model.Cliente;
import br.com.engineering.clientes.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    @Transactional(readOnly = true)
    Cliente findByCpfCliente (Long cpfCliente);

    @Transactional(readOnly = true)
    public List<Cliente> findByVendedor(Vendedor vendedor);

}
