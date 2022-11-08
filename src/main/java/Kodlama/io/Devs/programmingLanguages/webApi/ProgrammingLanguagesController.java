package Kodlama.io.Devs.programmingLanguages.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.programmingLanguages.business.requests.programmingLanguageRequest.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse.GetByIdProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguage")
public class ProgrammingLanguagesController {
	public ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll() throws Exception {
		return programmingLanguageService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest programmingLanguage) throws Exception {
		programmingLanguageService.add(programmingLanguage);
	}

	@PutMapping("/update/{id}")
	public void update(int id, UpdateProgrammingLanguageRequest programmingLanguage) throws Exception {
		programmingLanguageService.update(id, programmingLanguage);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(int id) throws Exception {
		programmingLanguageService.delete(id);
	}

	@GetMapping("/getbyid/{id}")
	public GetByIdProgrammingLanguageResponse getbyid(int id) throws Exception {
		return programmingLanguageService.getById(id);
	}

}
