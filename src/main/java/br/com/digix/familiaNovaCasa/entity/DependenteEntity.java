package br.com.digix.familiaNovaCasa.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.digix.familiaNovaCasa.form.DependentesForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPEDENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DependenteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "IDADE")
	private Integer idade;

	@Column(name = "RENDA")
	private BigDecimal renda;

	@ManyToOne
	private FamiliaEntity familia;

	public DependenteEntity(DependentesForm dependentesForm, FamiliaEntity familiaEntity) {
		this.id = dependentesForm.getId();
		this.name = dependentesForm.getName();
		this.idade = dependentesForm.getIdade();
		this.renda = dependentesForm.getRenda();
		this.familia = familiaEntity;
	}

}
