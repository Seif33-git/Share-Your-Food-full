package sopra.ShareYourFood.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Views;
import sopra.ShareYourFood.repository.IEntiteRepository;

@RestController
@RequestMapping("/association")
@CrossOrigin("*")
public class AssociationRestController {
	
	@Autowired
	private IEntiteRepository entiteRepo;

	@GetMapping("")
	@JsonView(Views.ViewAssociation.class)
	public List<Association> findAll() {
		return entiteRepo.findAllAssociation();
	}

//	@GetMapping("/{id}")
//	@JsonView(Views.ViewAssociationDetail.class)
//	public Association find(@PathVariable Long id) {
//		Optional<Association> optAssociation = entiteRepo.findById(id);
//
//		if (optAssociation.isPresent()) {
//			return optAssociation.get();
//		} else {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}
//	}

	@PostMapping("")
	@JsonView(Views.ViewAssociationDetail.class)
	public Association create(@Valid @RequestBody Association association, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid");
		}

		association = entiteRepo.save(association);

		return association;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewAssociation.class)
	public Association update(@RequestBody Association association, @PathVariable Long id) {
		if (!entiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		association = entiteRepo.save(association);

		return association;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		entiteRepo.deleteById(id);
	}
	

}
