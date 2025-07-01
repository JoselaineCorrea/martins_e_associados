package br.com.martinsassociados.martins_e_associados.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class ProcessoDTO {
    private String numeroProcesso;
    private String descricao;
    private LocalDate prazo;
    private Long clienteId;
}
