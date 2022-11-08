package Kodlama.io.Devs.programmingLanguages.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.programmingLanguages.business.requests.programmingLanguageRequest.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse.GetByIdProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest)throws Exception;
	void update(int id,UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest)throws Exception;
	void delete(int id)throws Exception;
	GetByIdProgrammingLanguageResponse getById(int id)throws Exception; 
	//boolean checkIfNameExist (CreateProgrammingLanguageRequest createProgrammingLanguageRequest)throws Exception;
	List<GetAllProgrammingLanguagesResponse> getAll() throws Exception;
}
