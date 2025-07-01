package br.com.martinsassociados.martins_e_associados.service;

import br.com.martinsassociados.dto.ClienteDTO;
import br.com.martinsassociados.martins_e_associados.model.Cliente;
import br.com.martinsassociados.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Criar um novo cliente
    public Cliente create(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());
        return clienteRepository.save(cliente);
    }

    // Buscar todos os clientes
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Buscar um cliente por ID
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    // Atualizar um cliente
    public Optional<Cliente> update(Long id, ClienteDTO clienteDetails) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(clienteDetails.getNome());
            cliente.setCpf(clienteDetails.getCpf());
            cliente.setEmail(clienteDetails.getEmail());
            return clienteRepository.save(cliente);
        });
    }

    // Deletar um cliente
    public boolean delete(Long id) {
        return clienteRepository.findById(id).map(cliente -> {
            clienteRepository.delete(cliente);
            return true;
        }).orElse(false);
    }
}