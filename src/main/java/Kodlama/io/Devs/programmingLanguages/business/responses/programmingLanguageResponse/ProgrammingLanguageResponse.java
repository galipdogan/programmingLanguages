package Kodlama.io.Devs.programmingLanguages.business.responses.programmingLanguageResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageResponse {
	private int programmingLanguageId;
	private String programmingLanguageName;
   // private List<String> technologyNames;
}
