package com.pontta.backend.service;

import com.pontta.backend.model.ClienteModel;
import com.pontta.backend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel cadastra(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public List<ClienteModel> listar(){
        return clienteRepository.findAll();
    }

    public ClienteModel buscaPorId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CLiente não encontrado"));
    }

    public ClienteModel atualizar(Long id, ClienteModel cliente){
        ClienteModel existe=buscaPorId(id);

        existe.setNome(cliente.getNome());
        existe.setEmail(cliente.getEmail());
        return clienteRepository.save(existe);
    }

    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }
}
