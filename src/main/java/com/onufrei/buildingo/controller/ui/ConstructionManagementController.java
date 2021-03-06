package com.onufrei.buildingo.controller.ui;

import com.onufrei.buildingo.model.ConstructionManagement;
import com.onufrei.buildingo.service.constructionManagement.interfaces.ConstructionManagementService;
import com.onufrei.buildingo.service.employee.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

/**
 * Represents object of ConstructionManagementController
 *
 * @author Artem Onufrei
 * @version 1
 * @since 20.05.2021
 */

@RequestMapping("/managements")
@Controller
public class ConstructionManagementController {

	private final ConstructionManagementService service;

	public ConstructionManagementController(@Autowired ConstructionManagementService service) {
		this.service = service;
	}

	@GetMapping
	private String showAllManagements(Model model) {
		model.addAttribute("managements", service.findAll());

		return "constructionManagement/managements-page";
	}

	@GetMapping("/show/{id}")
	private String showManagement(Model model, @PathVariable String id) {
		model.addAttribute("management", service.findById(id));

		return "constructionManagement/show-management-page";
	}

	@GetMapping("/add")
	private String showAddManagement(Model model) {
		model.addAttribute("management", new ConstructionManagement("", "", "", "",  LocalDateTime.now(), LocalDateTime.now()));

		return "constructionManagement/add-management-page";
	}

	@GetMapping("/edit/{id}")
	private String showEditManagement(Model model, @PathVariable String id) {
		model.addAttribute("management", service.findById(id));

		return "constructionManagement/edit-management-page";
	}

	@PostMapping("/add")
	private String addManagement(Model model, @ModelAttribute ConstructionManagement mng) {
		ConstructionManagement management = new ConstructionManagement("", mng.getName(), mng.getDescription(), mng.getAddress(),
				mng.getCreatedAt(), mng.getModifiedAt());

		service.add(management);

		return "redirect:/managements";
	}

	@PostMapping("/edit/{id}")
	private String updateManagement(Model model, @ModelAttribute ConstructionManagement mng,
			@PathVariable String id) {
		ConstructionManagement management = new ConstructionManagement(id, mng.getName(), mng.getDescription(),
				mng.getAddress(), mng.getCreatedAt(), mng.getModifiedAt());

		service.update(management);
		return "redirect:/managements";
	}

	@PostMapping("/delete/{id}")
	private String deleteManagement(Model model, @PathVariable String id) {
		service.delete(id);
		return "redirect:/managements";
	}

}
