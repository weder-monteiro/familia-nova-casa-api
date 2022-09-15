package br.com.digix.familiaNovaCasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.familiaNovaCasa.entity.FamiliaEntity;

@Repository
public interface FamiliaRepository extends JpaRepository<FamiliaEntity, Long> {

}
