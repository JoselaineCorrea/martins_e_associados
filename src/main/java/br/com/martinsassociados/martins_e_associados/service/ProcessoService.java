package br.com.martinsassociados.martins_e_associados.service;

import br.com.martinsassociados.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessoService {

    @Autowired
    private ProcessosRepository processosRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Processo> create(ProcessoDTO processoDTO) {
        // Busca o cliente pelo ID fornecido no DTO
        Optional<Cliente> clienteOpt = clienteRepository.findById(processoDTO.getClienteId());

        if (clienteOpt.isEmpty()) {
            return Optional.empty(); // Retorna vazio se o cliente não for encontrado
        }

        Cliente cliente = clienteOpt.get();
        Processo processo = new Processo();
        processo.setNumeroProcesso(processoDTO.getNumeroProcesso());
        processo.setDescricao(processoDTO.getDescricao());
        processo.setPrazo(processoDTO.getPrazo());
        processo.setCliente(cliente); // Associa o processo ao cliente encontrado

        return Optional.of(processosRepository.save(processo));
    }

    public List<Processo> findAll() {
        return processosRepository.findAll();
    }

    public Optional<Processo> findById(Long id) {
        return processosRepository.findById(id);
    }
}
