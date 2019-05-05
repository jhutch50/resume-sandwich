package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.WorkExperienceEntity;
import com.jhutch50.resumesandwichapplication.model.request.WorkExperienceRequest;

public class WorkExperienceRequestToWorkExperienceEntityConverter
		implements Converter<WorkExperienceRequest, WorkExperienceEntity> {

	@Override
	public WorkExperienceEntity convert(WorkExperienceRequest source) {

		WorkExperienceEntity workExperienceEntity = new WorkExperienceEntity();

		workExperienceEntity.setCompany(source.getCompany());
		workExperienceEntity.setEndDate(source.getEndDate());
		workExperienceEntity.setStartDate(source.getStartDate());
		workExperienceEntity.setSkillsA(source.getSkillsA());
		workExperienceEntity.setSkillsB(source.getSkillsB());
		workExperienceEntity.setSkillsC(source.getSkillsC());
		workExperienceEntity.setTitle(source.getTitle());
		workExperienceEntity.setCity(source.getCity());
		workExperienceEntity.setState(source.getState());

		if (null != source.getId())
			workExperienceEntity.setId(source.getId());

		return workExperienceEntity;
	}

}
