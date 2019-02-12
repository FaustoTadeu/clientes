package br.com.engineering.clientes.repository;

import br.com.engineering.clientes.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    @Transactional(readOnly = true)
    Vendedor findByCpfVendedor (Long cpfVendedor);
}
