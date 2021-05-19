package com.onufrei.buildingo.controller.rest;

import com.onufrei.buildingo.model.Brigade;
import com.onufrei.buildingo.service.brigade.interfaces.BrigadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for Brigade object
 *
 * @author Artem Onufrei
 * @version 1
 * @since 15.05.2021
 */

@RequestMapping("api/v1/brigades")
@RestController
public class BrigadeRestController {

	private final BrigadeService service;

	private BrigadeRestController(@Autowired BrigadeService service) {
		this.service = service;
	}

	@ApiOperation(value = "Returns list of all brigades")
	@GetMapping("/")
	private List<Brigade> getAllBrigades() {
		return service.findAll();
	}

	@ApiOperation(value = "Adds new brigade")
	@PostMapping("/")
	private Brigade addBrigade(
			@ApiParam(name = "Brigade", value = "The json of brigade you want to add. Id, createdAt and modifiedAt dates generate automatically")
			@RequestBody Brigade brigade) {
		return service.add(brigade);
	}

	@ApiOperation(value = "Returns brigade of specified id")
	@GetMapping("/{id}")
	private Brigade getBrigadeById(
			@ApiParam(name = "Brigade id", value = "The id of brigade you want to get")
			@PathVariable String id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Updates specified brigade by brigade you pass")
	@PutMapping("/")
	private Brigade updateBrigade(
			@ApiParam(name = "Brigade", value = "The json of brigade you want to update. "
					+ "The id of brigade you pass must correspond to brigade's id you want to update")
			@RequestBody Brigade brigade) {
		return service.update(brigade);
	}

	@ApiOperation(value = "Deletes the brigade with id you specify")
	@DeleteMapping("/{id}")
	private Brigade deleteBrigade(
			@ApiParam(name = "Brigade id", value = "The id of brigade you want to delete")
			@PathVariable String id) {
		return service.delete(id);
	}
}