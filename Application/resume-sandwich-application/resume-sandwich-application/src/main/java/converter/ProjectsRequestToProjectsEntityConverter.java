package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.ProjectsEntity;
import com.jhutch50.resumesandwichapplication.model.request.ProjectsRequest;

public class ProjectsRequestToProjectsEntityConverter implements Converter<ProjectsRequest, ProjectsEntity>{

	@Override
	public ProjectsEntity convert(ProjectsRequest source) {
		ProjectsEntity projectsEntity = new ProjectsEntity();
		
		projectsEntity.setProjectName(source.getProjectName());
		projectsEntity.setEndDate(source.getEndDate());
		projectsEntity.setStartDate(source.getStartDate());
		projectsEntity.setSkillsA(source.getSkillsA());
		projectsEntity.setSkillsB(source.getSkillsB());
		projectsEntity.setSkillsC(source.getSkillsC());
		projectsEntity.setProjectRole(source.getProjectRole());

		
		if (null != source.getId())
			projectsEntity.setId(source.getId());
		return projectsEntity;
	}
}