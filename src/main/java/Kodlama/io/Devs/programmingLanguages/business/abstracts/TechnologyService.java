package Kodlama.io.Devs.programmingLanguages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingLanguages.business.requests.technologyRequest.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technologyRequest.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.technologyResponse.GetAllTechnologiesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.technologyResponse.GetByIdTechnologyResponse;



public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest)throws Exception;
	void update(int id,UpdateTechnologyRequest updateTechnologyRequest)throws Exception;
	void delete(int id)throws Exception;
	GetByIdTechnologyResponse getById(int id)throws Exception; 
	//boolean checkIfNameExist (CreateProgrammingLanguageRequest createProgrammingLanguageRequest)throws Exception;
	List<GetAllTechnologiesResponse> getAll() throws Exception;
}
