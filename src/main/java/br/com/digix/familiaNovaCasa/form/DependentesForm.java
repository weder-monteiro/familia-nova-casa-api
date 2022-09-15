package br.com.digix.familiaNovaCasa.form;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DependentesForm {

	private Long id;
	private String name;
	private Integer idade;
	private BigDecimal renda;

}
