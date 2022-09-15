package br.com.digix.familiaNovaCasa.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.digix.familiaNovaCasa.dto.FamiliaDTO;
import br.com.digix.familiaNovaCasa.entity.FamiliaEntity;
import br.com.digix.familiaNovaCasa.form.DependentesForm;
import br.com.digix.familiaNovaCasa.form.FamiliaForm;
import br.com.digix.familiaNovaCasa.repository.FamiliaRepository;

@Service
public class FamiliaService {

	@Autowired
	private FamiliaRepository familiaRepository;

	public List<FamiliaDTO> findAll(Sort sort) {
		List<FamiliaEntity> familias = familiaRepository.findAll(sort);

		return familias.stream().map(FamiliaDTO::new).collect(Collectors.toList());
	}

	public FamiliaDTO save(FamiliaForm familiaForm) {
		BigDecimal renda = getRenda(familiaForm);
		FamiliaEntity familiaEntity = new FamiliaEntity(familiaForm, renda, getPontos(familiaForm, renda));

		familiaEntity = familiaRepository.save(familiaEntity);

		if (familiaEntity.getId() != null) {
			return new FamiliaDTO(familiaEntity);
		}

		return new FamiliaDTO();
	}

	private BigDecimal getRenda(FamiliaForm familiaForm) {
		BigDecimal renda = BigDecimal.ZERO;

		if (familiaForm.getResponsavel() != null) {
			renda = renda.add(familiaForm.getResponsavel().getRenda());
		}

		if (familiaForm.getResponsavel2() != null) {
			renda = renda.add(familiaForm.getResponsavel2().getRenda());
		}

		for (DependentesForm dependentesForm : familiaForm.getDependentes()) {
			renda = renda.add(dependentesForm.getRenda());
		}

		return renda;
	}

	private Integer getPontos(FamiliaForm familiaForm, BigDecimal renda) {
		Integer pontos = 0;
		Integer quantidadeDependentesMenor = 0;

		if (renda.doubleValue() <= 900) {
			pontos = pontos + 5;
		}

		if (renda.doubleValue() > 900 && renda.doubleValue() <= 1500) {
			pontos = pontos + 3;
		}

		for (DependentesForm dependentesForm : familiaForm.getDependentes()) {
			if (dependentesForm.getIdade() <= 18) {
				quantidadeDependentesMenor = quantidadeDependentesMenor + 1;
			}
		}

		if (quantidadeDependentesMenor >= 3) {
			pontos = pontos + 3;
		}

		if (quantidadeDependentesMenor > 0 && quantidadeDependentesMenor <= 2) {
			pontos = pontos + 2;
		}

		return pontos;
	}

}
