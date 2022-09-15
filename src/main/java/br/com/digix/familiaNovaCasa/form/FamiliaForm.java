package br.com.digix.familiaNovaCasa.form;

import java.util.List;

import lombok.Data;

@Data
public class FamiliaForm {

	private Long id;
	private ResponsavelForm responsavel;
	private ResponsavelForm responsavel2;
	private List<DependentesForm> dependentes;

}
