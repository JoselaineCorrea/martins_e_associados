package br.com.martinsassociados.martins_e_associados.controller;

import br.com.martinsassociados.martins_e_associados.dto.ProcessoDTO;
import br.com.martinsassociados.martins_e_associados.Processo;
import br.com.martinsassociados.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @PostMapping
    public ResponseEntity<Processo> createProcesso(@RequestBody ProcessoDTO processoDTO) {
        return processoService.create(processoDTO)
                .map(processo -> new ResponseEntity<>(processo, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST)); // Retorna erro se o clienteId for inválido
    }

    @GetMapping
    public ResponseEntity<List<Processo>> getAllProcessos() {
        List<Processo> processos = processoService.findAll();
        return ResponseEntity.ok(processos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Processo> getProcessoById(@PathVariable Long id) {
        return processoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
