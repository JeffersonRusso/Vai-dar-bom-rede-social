package com.vaiDarBom.vaiDarBomPlataformaDeEstudos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaiDarBom.vaiDarBomPlataformaDeEstudos.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

}
