package sopra.ShareYourFood.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import sopra.ShareYourFood.model.Entite;
import sopra.ShareYourFood.model.Views;
import sopra.ShareYourFood.repository.IEntiteRepository;

@RestController
@RequestMapping("/entite")
@CrossOrigin("*")
public class EntiteRestController {

	@Autowired
	private IEntiteRepository entiteRepo;

	@GetMapping("")
	@JsonView(Views.ViewEntite.class)
	public List<Entite> findAll() {
		return entiteRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEntite.class)
	public Entite find(@PathVariable Long id) {

		Optional<Entite> optEntite = entiteRepo.findById(id);

		if (optEntite.isPresent()) {
			return optEntite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	public Entite create(@RequestBody Entite entite) {
		entite = entiteRepo.save(entite);

		return entite;
	}

	@PutMapping("/{id}")
	public Entite update(@RequestBody Entite entite, @PathVariable Long id) {
		if (!entiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		entite = entiteRepo.save(entite);

		return entite;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		entiteRepo.deleteById(id);
	}
}
