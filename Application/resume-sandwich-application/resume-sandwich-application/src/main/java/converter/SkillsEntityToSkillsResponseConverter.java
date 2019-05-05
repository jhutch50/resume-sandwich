package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.SkillsEntity;
import com.jhutch50.resumesandwichapplication.model.response.SkillsResponse;

public class SkillsEntityToSkillsResponseConverter implements Converter<SkillsEntity, SkillsResponse>{

	@Override
	public SkillsResponse convert(SkillsEntity source) {
		SkillsResponse skillsResponse = new SkillsResponse();
		
		skillsResponse.setSkillName(source.getSkillName());
		
		if(null != source.getResumeEntity())
			skillsResponse.setId(source.getResumeEntity().getId());
		return skillsResponse;
	}

}