package Kodlama.io.Devs.programmingLanguages.business.responses.technologyResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTechnologyResponse {
	private int technologyId;
	private String programmingLanguageName;
	private String technologyName;
}
