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

import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.model.Views;
import sopra.ShareYourFood.repository.IEntiteRepository;


@RestController
@RequestMapping("/particulier")
@CrossOrigin("*")
public class ParticulierRestController {
	

	@Autowired
	private IEntiteRepository entiteRepo;

	@GetMapping("")
	@JsonView(Views.ViewParticulier.class)
	public List<Particulier> findAll() {
		return entiteRepo.findAllParticulier();
	}

//	@GetMapping("/{id}")
//	@JsonView(Views.ViewParticulierDetail.class)
//	public Particulier find(@PathVariable Long id) {
//		Optional<Particulier> optParticulier = entiteRepo.findById(id);
//
//		if (optParticulier.isPresent()) {
//			return optParticulier.get();
//		} else {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
//		}
//	}

	@PostMapping("")
	@JsonView(Views.ViewParticulierDetail.class)
	public Particulier create(@Valid @RequestBody Particulier particulier, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid");
		}

		particulier = entiteRepo.save(particulier);

		return particulier;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewParticulier.class)
	public Particulier update(@RequestBody Particulier particulier, @PathVariable Long id) {
		if (!entiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		particulier = entiteRepo.save(particulier);

		return particulier;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		entiteRepo.deleteById(id);
	}

}
