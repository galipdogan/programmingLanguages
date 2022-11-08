package Kodlama.io.Devs.programmingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.programmingLanguages.business.abstracts.TechnologyService;
import Kodlama.io.Devs.programmingLanguages.business.requests.technologyRequest.CreateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.requests.technologyRequest.UpdateTechnologyRequest;
import Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse.GetByIdProgrammingLanguageResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.technologyResponse.GetAllTechnologiesResponse;
import Kodlama.io.Devs.programmingLanguages.business.responses.technologyResponse.GetByIdTechnologyResponse;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.programmingLanguages.dataAccess.abstracts.TechnologyRepository;
import Kodlama.io.Devs.programmingLanguages.entities.ProgrammingLanguage;
import Kodlama.io.Devs.programmingLanguages.entities.Technology;

@Service
public class TechnologyManager implements TechnologyService {
	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		this.technologyRepository = technologyRepository;
		this.programmingLanguageRepository=programmingLanguageRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		Technology technology = new Technology();
        technology.setTechnologyName(createTechnologyRequest.getTechnologyName());
        if (technology.getTechnologyName().isEmpty() || technology.getTechnologyName().isBlank()) {
            throw new Exception("Teknoloji Adı Gerekli");
        }
        if (findByName(createTechnologyRequest.getTechnologyName())) {
            throw new Exception("Teknoloji adı zaten mevcut");
        }

        ProgrammingLanguage language = programmingLanguageRepository.findById(createTechnologyRequest.getProgrammingLanguageId())
                .orElseThrow(() -> new Exception("Programlama Dili Bulunamadı"));
        technology.setProgrammingLanguage(language);
        technologyRepository.save(technology);

	}

	@Override
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new Exception("Teknoloji Bulunamadı!"));
        if (technology.getTechnologyName().isEmpty() || technology.getTechnologyName().isBlank()) {
            throw new Exception("Teknoloji Adı Gerekli!");
        }
        if (findByName(updateTechnologyRequest.getTechnologyName())) {
            throw new Exception("Teknoloji adı zaten mevcut");
        }

        technology.setTechnologyName(updateTechnologyRequest.getTechnologyName());
        technologyRepository.save(technology);

	}

	@Override
	public void delete(int id) throws Exception {
		Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new Exception("Teknoloji Bulunamadı!"));
        technologyRepository.delete(technology);

	}

	@Override
	public GetByIdTechnologyResponse getById(int id) throws Exception {
		Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new Exception("Teknoloji bulunamadı!"));

		GetByIdTechnologyResponse responseItem = new GetByIdTechnologyResponse();
        responseItem.setTechnologyId(technology.getTechnologyId());
        responseItem.setTechnologyName(technology.getTechnologyName());
        responseItem.setProgrammingLanguageName(technology.getProgrammingLanguage().getProgrammingLanguageName());

        return responseItem;
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() throws Exception {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> allTechnologyResponses = new ArrayList<GetAllTechnologiesResponse>();
		for (Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setId(technology.getTechnologyId());
			responseItem.setTechnologyName(technology.getTechnologyName());
			responseItem.setProgrammingLanguageName(technology.getProgrammingLanguage().getProgrammingLanguageName());
			allTechnologyResponses.add(responseItem);
		}
		return allTechnologyResponses;
	}

	public boolean findByName(String name) {
		List<Technology> technologies = technologyRepository.findAll();
		for(Technology t:technologies) {
			if(t.getTechnologyName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
