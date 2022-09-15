package br.com.digix.familiaNovaCasa.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.digix.familiaNovaCasa.form.ResponsavelForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RESPONSAVEL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsavelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "RENDA")
	private BigDecimal renda;

	public ResponsavelEntity(Long id) {
		this.id = id;
	}

	public ResponsavelEntity(ResponsavelForm responsavelForm) {
		this.id = responsavelForm.getId();
		this.name = responsavelForm.getName();
		this.renda = responsavelForm.getRenda();
	}

}
