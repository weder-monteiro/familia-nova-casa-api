package br.com.digix.familiaNovaCasa.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.digix.familiaNovaCasa.dto.FamiliaDTO;
import br.com.digix.familiaNovaCasa.form.FamiliaForm;
import br.com.digix.familiaNovaCasa.service.FamiliaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/familias")
public class FamiliaController {

	@Autowired
	private FamiliaService familiaService;

	@ApiOperation(value = "Busca por todas as familias")
	@GetMapping()
	public ResponseEntity<List<FamiliaDTO>> findAll(Sort sort) {
		List<FamiliaDTO> familiaDTOList = familiaService.findAll(sort);

		if (familiaDTOList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(familiaDTOList);
	}

	@ApiOperation(value = "Salva uma nova familia")
	@PostMapping()
	@Transactional
	public ResponseEntity<FamiliaDTO> save(@RequestBody FamiliaForm familiaForm, UriComponentsBuilder uriBuilder) {
		FamiliaDTO familiaDTO = familiaService.save(familiaForm);
		URI uri = uriBuilder.path("/familias/{id}").buildAndExpand(familiaForm.getId()).toUri();

		if (familiaDTO.getId() != null) {
			return ResponseEntity.created(uri).body(familiaDTO);
		}

		return ResponseEntity.notFound().build();
	}

}
