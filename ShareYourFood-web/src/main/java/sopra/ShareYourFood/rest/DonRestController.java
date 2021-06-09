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

import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Views;
import sopra.ShareYourFood.repository.IDonRepository;

@RestController
@RequestMapping("/don")
@CrossOrigin("*")
public class DonRestController {

	@Autowired
	private IDonRepository donRepo;

	@GetMapping("")
	@JsonView(Views.ViewDon.class)
	public List<Don> findAll() {
		return donRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewDon.class)
	public Don find(@PathVariable Long id) {

		Optional<Don> optDon = donRepo.findById(id);

		if (optDon.isPresent()) {
			return optDon.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	public Don create(@RequestBody Don don) {
		don = donRepo.save(don);

		return don;
	}

	@PutMapping("/{id}")
	public Don update(@RequestBody Don don, @PathVariable Long id) {
		if (!donRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		don = donRepo.save(don);

		return don;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		donRepo.deleteById(id);
	}
}
