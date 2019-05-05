package converter;
import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.SkillsEntity;
import com.jhutch50.resumesandwichapplication.model.request.SkillsRequest;

public class SkillsRequestToSkillsEntityConverter implements Converter<SkillsRequest, SkillsEntity>{

	@Override
	public SkillsEntity convert(SkillsRequest source) {
		SkillsEntity skillsEntity = new SkillsEntity();
		
		skillsEntity.setSkillName(source.getSkillName());
		
		if (null != source.getId())
			skillsEntity.setId(source.getId());

		return skillsEntity;
	}

}
