package br.com.digix.familiaNovaCasa.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.digix.familiaNovaCasa.entity.FamiliaEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FamiliaDTO {

	private Long id;
	private String responsavel;
	private String responsavel2;
	private List<String> dependentes;
	private BigDecimal totalRenda;
	private Integer totalPontos;

	public FamiliaDTO(FamiliaEntity familiaEntity) {
		this.id = familiaEntity.getId();
		this.responsavel = familiaEntity.getResponsavel() != null ? familiaEntity.getResponsavel().getName() : null;
		this.responsavel2 = familiaEntity.getResponsavel2() != null ? familiaEntity.getResponsavel2().getName() : null;
		this.dependentes = familiaEntity.getDependentes().stream().map(d -> d.getName()).collect(Collectors.toList());
		this.totalRenda = familiaEntity.getTotalRenda();
		this.totalPontos = familiaEntity.getTotalPontos();
	}

}
