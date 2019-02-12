package br.com.engineering.clientes.service;


import br.com.engineering.clientes.model.Cliente;
import br.com.engineering.clientes.model.Vendedor;
import br.com.engineering.clientes.repository.ClienteRepository;
import br.com.engineering.clientes.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Bean
    public void instatiateTestDatabase() throws ParseException {

        Vendedor vend1 = new Vendedor(null, "João da Silva", 12345678910L);
        Vendedor vend2 = new Vendedor(null, "Maria dos Santos", 10987654321L);

        Cliente cli1 = new Cliente (null, "Antônio Ferreira", 22233344456L, "M", vend1);
        Cliente cli2 = new Cliente (null, "Fernanda Cavalcanti", 66677744432L, "F", vend1);
        Cliente cli3 = new Cliente (null, "Flávia Araujo", 77765432100L, "F", vend1);
        Cliente cli4 = new Cliente (null, "Henrique Oliveira", 84756398723L, "M", vend1);
        Cliente cli5 = new Cliente (null, "Francisco Alves", 54875496533L, "M", vend2);
        Cliente cli6 = new Cliente (null, "Ana Carla Silva", 21548754899L, "F", vend2);

        vend1.getClientes().addAll(Arrays.asList(cli1, cli2, cli3, cli4));
        vend2.getClientes().addAll(Arrays.asList(cli5, cli6));

        vendedorRepository.saveAll(Arrays.asList(vend1, vend2));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));


    }
}