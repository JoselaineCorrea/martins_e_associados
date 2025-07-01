package br.com.martinsassociados.martins_e_associados.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private String nome;
    private String cpf;
    private String email;
}