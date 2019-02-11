package br.com.engineering.clientes.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import br.com.engineering.clientes.dto.VendedorDTO;
import br.com.engineering.clientes.model.Vendedor;
import br.com.engineering.clientes.service.VendedorService;
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
@RequestMapping(value = "/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService VendedorService;

    @RequestMapping(value ="/{idVendedor}", method = RequestMethod.GET)
    public ResponseEntity<Vendedor> findVendedorById(@PathVariable Integer idVendedor) {
        Vendedor obj = VendedorService.findVendedorById(idVendedor);
        return ResponseEntity.ok().body(obj);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<VendedorDTO>> findAllVendedores() {
        List<Vendedor> listVendedores = VendedorService.findAllVendendores();
        List <VendedorDTO> listVendedorsDto = listVendedores.stream().map(obj -> new VendedorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listVendedorsDto);
    }

    @Transactional
    @RequestMapping(value = "/cpf", method = RequestMethod.GET)
    public ResponseEntity<Vendedor> findByCpf(@RequestParam(value = "value")String cpf) {
        Integer IntegerCpfConvert = Integer.valueOf(cpf);
        Vendedor obj = VendedorService.findByCpfVendedor(IntegerCpfConvert);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> InsertVendedor(@Valid @RequestBody VendedorDTO cliDto) {
        Vendedor cli = VendedorService.fromDTO(cliDto, null);
        cli = VendedorService.InsertEditVendedor(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idVendedor}").buildAndExpand(cli.getIdVendedor()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value ="/{idVendedor}", method = RequestMethod.PUT)
    public ResponseEntity<Void> EditVendedor(@Valid @RequestBody VendedorDTO cliDto, @PathVariable Integer idVendedor) {
        Vendedor cli = VendedorService.fromDTO(cliDto, idVendedor);
        VendedorService.InsertEditVendedor(cli);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand().toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value ="/{idVendedor}", method = RequestMethod.DELETE)
    public ResponseEntity<Vendedor> deleteVendedorById(@PathVariable Integer idVendedor) {
        VendedorService.deleteVendedor(idVendedor);
        return ResponseEntity.noContent().build();
    }
}
