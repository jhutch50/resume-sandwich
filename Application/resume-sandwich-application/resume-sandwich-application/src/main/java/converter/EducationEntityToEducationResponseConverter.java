package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.EducationEntity;
import com.jhutch50.resumesandwichapplication.model.response.EducationResponse;

public class EducationEntityToEducationResponseConverter implements Converter<EducationEntity, EducationResponse>{

	@Override
	public EducationResponse convert(EducationEntity source) {
		EducationResponse educationResponse = new EducationResponse();
		
		educationResponse.setUniversityName(source.getUniversityName());
		educationResponse.setEndDate(source.getEndDate());
		educationResponse.setStartDate(source.getStartDate());
		educationResponse.setConcentration(source.getConcentration());
		educationResponse.setHonors(source.getHonors());
		educationResponse.setMajor(source.getMajor());
		educationResponse.setCity(source.getCity());
		educationResponse.setDegree(source.getDegree());
		educationResponse.setGpa(source.getGpa());
		educationResponse.setState(source.getState());
		
		if(null != source.getResumeEntity())
			educationResponse.setId(source.getResumeEntity().getId());
		return educationResponse;
	}

}