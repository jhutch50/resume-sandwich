package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.WorkExperienceEntity;
import com.jhutch50.resumesandwichapplication.model.response.WorkExperienceResponse;

public class WorkExperienceEntityToWorkExperienceResponseConverter implements Converter<WorkExperienceEntity, WorkExperienceResponse>{

	@Override
	public WorkExperienceResponse convert(WorkExperienceEntity source) {
		WorkExperienceResponse workExperienceResponse = new WorkExperienceResponse();
		
		workExperienceResponse.setCompany(source.getCompany());
		workExperienceResponse.setEndDate(source.getEndDate());
		workExperienceResponse.setStartDate(source.getStartDate());
		workExperienceResponse.setSkillsA(source.getSkillsA());
		workExperienceResponse.setSkillsB(source.getSkillsB());
		workExperienceResponse.setSkillsC(source.getSkillsC());
		workExperienceResponse.setTitle(source.getTitle());
		workExperienceResponse.setCity(source.getCity());
		workExperienceResponse.setState(source.getState());
		
		if(null != source.getResumeEntity())
			workExperienceResponse.setId(source.getResumeEntity().getId());
		return workExperienceResponse;
	}

}
