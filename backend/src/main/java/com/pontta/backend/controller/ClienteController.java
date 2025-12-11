package com.pontta.backend.controller;

import com.pontta.backend.model.ClienteModel;
import com.pontta.backend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteService clienteService;

    public  ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteModel cadastrar(@Valid @RequestBody ClienteModel cliente){
        return clienteService.cadastra(cliente);
    }

    @GetMapping
    public List<ClienteModel> listar(){
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteModel buscaPorId(@PathVariable Long id){
        return clienteService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteModel atualizar(@Valid @PathVariable Long id, @Valid @RequestBody ClienteModel cliente){
        return clienteService.atualizar(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        clienteService.excluir(id);
    }
}
