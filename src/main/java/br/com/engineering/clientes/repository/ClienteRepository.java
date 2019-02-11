package br.com.engineering.clientes.repository;

import br.com.engineering.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    @Transactional(readOnly = true)
    Cliente findByCpfCliente (Integer cpfCliente);

}
