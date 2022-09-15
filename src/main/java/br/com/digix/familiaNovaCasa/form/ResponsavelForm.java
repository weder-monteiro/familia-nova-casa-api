package br.com.digix.familiaNovaCasa.form;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ResponsavelForm {

	private Long id;
	private String name;
	private BigDecimal renda;

}
