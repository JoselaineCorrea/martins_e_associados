package br.com.martinsassociados.repository;

import br.com.martinsassociados.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // O JpaRepository já fornece todos os métodos CRUD básicos.
}