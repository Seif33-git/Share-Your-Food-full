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

import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Views;
import sopra.ShareYourFood.repository.IEntiteRepository;

@RestController
@RequestMapping("/entreprise")
@CrossOrigin("*")
public class EntrepriseRestController {
	
	@Autowired
	private IEntiteRepository entiteRepo;

	@GetMapping("")
	@JsonView(Views.ViewEntreprise.class)
	public List<Entreprise> findAll() {
		return entiteRepo.findAllEntreprise();
	}

//	@GetMapping("/{id}")
//	@JsonView(Views.ViewEntrepriseDetail.class)
//	public Entreprise find(@PathVariable Long id) {
//		Optional<Entreprise> optEntreprise = entiteRepo.findById(id);
//
//		if (optEntreprise.isPresent()) {
//			return optEntreprise.get();
//		} else {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}
//	}

	@PostMapping("")
	@JsonView(Views.ViewEntrepriseDetail.class)
	public Entreprise create(@Valid @RequestBody Entreprise entreprise, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid");
		}

		entreprise = entiteRepo.save(entreprise);

		return entreprise;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewEntreprise.class)
	public Entreprise update(@RequestBody Entreprise entreprise, @PathVariable Long id) {
		if (!entiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		entreprise = entiteRepo.save(entreprise);

		return entreprise;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		entiteRepo.deleteById(id);
	}
	

}
