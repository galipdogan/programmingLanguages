package Kodlama.io.Devs.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.programmingLanguages.business.requests.programmingLanguageRequest.CreateProgrammingLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.programmingLanguageRequest.UpdateProgrammingLanguageRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse.GetAllProgrammingLanguagesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.programmingLanguages.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() throws Exception {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> allProgrammingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
			responseItem.setProgrammingLanguageId(programmingLanguage.getProgrammingLanguageId());
			responseItem.setProgrammingLanguageName(programmingLanguage.getProgrammingLanguageName());
			allProgrammingLanguagesResponses.add(responseItem);
		}
		return allProgrammingLanguagesResponses;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		//List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		//List<GetAllProgrammingLanguagesResponse> allProgrammingLanguagesResponses = new ArrayList<GetAllProgrammingLanguagesResponse>();
		//for (ProgrammingLanguage pL : programmingLanguages) {
			if (findByName(createProgrammingLanguageRequest.getProgrammingLanguageName())
					|| createProgrammingLanguageRequest.getProgrammingLanguageName() == null
					|| createProgrammingLanguageRequest.getProgrammingLanguageName().length() == 0) {
				throw new Exception("Boyle bir kayit zaten mevcut ya da alanlar bos gecilmis");
			}
			ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
			programmingLanguage.setProgrammingLanguageName(createProgrammingLanguageRequest.getProgrammingLanguageName());
			this.programmingLanguageRepository.save(programmingLanguage);
		//}
	}

	@Override
	public void update(int id, UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		// TODO Auto-generated method stub
		ProgrammingLanguage pL = programmingLanguageRepository.findById(id)
				.orElseThrow(() -> new Exception("Guncellenecek kayit bulunamadi"));

		if (findByName( updateProgrammingLanguageRequest.getProgrammingLanguageName())
				|| updateProgrammingLanguageRequest.getProgrammingLanguageName() == null
				|| updateProgrammingLanguageRequest.getProgrammingLanguageName().length() == 0) {
			throw new Exception("Boyle bir kayit zaten mevcut ya da alanlar bos gecilmis");
		}
		pL.setProgrammingLanguageName(updateProgrammingLanguageRequest.getProgrammingLanguageName());
		programmingLanguageRepository.save(pL);

	}

	@Override
	public void delete(int id) throws Exception {
		if (programmingLanguageRepository.findById(id) != null) {
			programmingLanguageRepository.deleteById(id);
		}

	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) throws Exception {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Id bulunamadi"));

		GetByIdProgrammingLanguageResponse responseItem = new GetByIdProgrammingLanguageResponse();
		responseItem.setProgrammingLanguageId(programmingLanguage.getProgrammingLanguageId());
		responseItem.setProgrammingLanguageName(programmingLanguage.getProgrammingLanguageName());

		return responseItem;
	}

	public boolean findByName(String name) {
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
		for(ProgrammingLanguage pl:programmingLanguages) {
			if(pl.programmingLanguageName.equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * @Override public void update(ProgrammingLanguage programmingLanguage) throws
	 * Exception {
	 * 
	 * if (!programmingLanguageRepository.checkIfNameExist(programmingLanguage) ||
	 * programmingLanguage.getName() == null ||
	 * programmingLanguage.getName().length() == 0) {
	 * this.programmingLanguageRepository.update(programmingLanguage); }
	 * 
	 * 
	 * programmingLanguageRepository.update(programmingLanguage); }
	 * 
	 * @Override public void delete(int id) throws Exception { if
	 * (programmingLanguageRepository.getById(id) != null) {
	 * programmingLanguageRepository.delete(id); }
	 * 
	 * }
	 * 
	 * @Override public ProgrammingLanguage getById(int id) throws Exception {
	 * return programmingLanguageRepository.getById(id); }
	 * 
	 * @Override public boolean checkIfNameExist(ProgrammingLanguage
	 * programmingLanguage) throws Exception { if
	 * (programmingLanguageRepository.checkIfNameExist(programmingLanguage)) {
	 * return true; } return false; }
	 */

}
