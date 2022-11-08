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
import Kodlama.io.Devs.programmingLanguages.business.abstracts.TechnologyService;
import Kodlama.io.Devs.programmingLanguages.business.requests.technologyRequest.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technologyRequest.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.technologyResponse.GetAllTechnologiesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.technologyResponse.GetByIdTechnologyResponse;

@RestController
@RequestMapping("/api/technologycontroller")
public class TechnologiesController {
	private TechnologyService technologyService;
	//private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService,ProgrammingLanguageService programmingLanguageService) {
		this.technologyService = technologyService;
		//this.programmingLanguageService=programmingLanguageService;
	}
	
	@GetMapping("getall")
	public List<GetAllTechnologiesResponse> getall() throws Exception{
	 return	this.technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest technologyRequest) throws Exception {
		 this.technologyService.add(technologyRequest);
	}
	
	@PutMapping("/update/{id}")
	public void Update(int id,UpdateTechnologyRequest updateTechnologyRequest)throws Exception{
		this.technologyService.update(id, updateTechnologyRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public void Delete(int id) throws Exception{
		this.technologyService.delete(id);
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdTechnologyResponse getbyid (int id) throws Exception{
		return this.technologyService.getById(id);
	}
	
}
