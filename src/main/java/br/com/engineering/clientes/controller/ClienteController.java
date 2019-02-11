package br.com.engineering.clientes.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import br.com.engineering.clientes.dto.ClienteDTO;
import br.com.engineering.clientes.model.Cliente;
import br.com.engineering.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value ="/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findClienteById(@PathVariable Integer idCliente) {
        Cliente obj = clienteService.findClienteById(idCliente);
        return ResponseEntity.ok().body(obj);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAllClientes() {
        List<Cliente> listClientes = clienteService.findAllClientes();
        List <ClienteDTO> listClientesDto = listClientes.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listClientesDto);
    }

    @Transactional
    @RequestMapping(value = "/cpf", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findByCpf(@RequestParam(value = "value")String cpf) {
        Integer IntegerCpfConvert = Integer.valueOf(cpf);
        Cliente obj = clienteService.findByCpfVendedor(IntegerCpfConvert);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InsertCliente(@Valid @RequestBody ClienteDTO cliDto) {
        Cliente cli = clienteService.fromDTO(cliDto, null);
        cli = clienteService.InsertEditCliente(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idCliente}").buildAndExpand(cli.getIdCliente()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value ="/{idCliente}", method = RequestMethod.PUT)
    public ResponseEntity<Void> EditCliente(@Valid @RequestBody ClienteDTO cliDto, @PathVariable Integer idCliente) {
        Cliente cli = clienteService.fromDTO(cliDto, idCliente);
        clienteService.InsertEditCliente(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value ="/{idCliente}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteClienteById(@PathVariable Integer idCliente) {
        clienteService.deleteCliente(idCliente);
        return ResponseEntity.noContent().build();
    }
}