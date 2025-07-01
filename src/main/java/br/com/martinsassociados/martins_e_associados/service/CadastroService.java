
package br.com.martinsassociados.martins_e_associados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired // Spring injeta uma instância de ClienteRepository automaticamente
    private br.com.martinsassociados.repository.ClienteRepository clienteRepository;

    public ClienteService salvarNovoCliente(br.com.martinsassociados.dto.ClienteDTO clienteDTO) {

        ClienteService cliente = new ClienteService();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setEmail(clienteDTO.getEmail());


        return clienteRepository.save(cliente);
    }
}