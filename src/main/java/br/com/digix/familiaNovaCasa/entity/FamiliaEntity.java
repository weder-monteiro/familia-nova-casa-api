package br.com.digix.familiaNovaCasa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.digix.familiaNovaCasa.form.FamiliaForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FAMILIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamiliaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private ResponsavelEntity responsavel;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private ResponsavelEntity responsavel2;

	@OneToMany(mappedBy = "familia")
	private List<DependenteEntity> dependentes;

	@Column(name = "TOTAL_RENDA")
	private BigDecimal totalRenda = BigDecimal.ZERO;

	@Column(name = "TOTAL_PONTOS")
	private Integer totalPontos = 0;

	public FamiliaEntity(FamiliaForm familiaForm, BigDecimal totalRenda, Integer totalPontos) {
		this.id = familiaForm.getId();
		this.responsavel = new ResponsavelEntity(familiaForm.getResponsavel());
		this.responsavel2 = new ResponsavelEntity(familiaForm.getResponsavel2());
		this.dependentes = familiaForm.getDependentes().stream().map(d -> {
			return new DependenteEntity(d, this);
		}).collect(Collectors.toList());
		this.totalRenda = totalRenda;
		this.totalPontos = totalPontos;
	}

}
