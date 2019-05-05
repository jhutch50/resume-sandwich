package converter;

import org.springframework.core.convert.converter.Converter;

import com.jhutch50.resumesandwichapplication.entity.ProjectsEntity;
import com.jhutch50.resumesandwichapplication.model.response.ProjectsResponse;

public class ProjectsEntityToProjectsResponseConverter implements Converter<ProjectsEntity, ProjectsResponse>{

	@Override
	public ProjectsResponse convert(ProjectsEntity source) {
		ProjectsResponse projectsResponse = new ProjectsResponse();
		
		projectsResponse.setProjectName(source.getProjectName());
		projectsResponse.setEndDate(source.getEndDate());
		projectsResponse.setStartDate(source.getStartDate());
		projectsResponse.setSkillsA(source.getSkillsA());
		projectsResponse.setSkillsB(source.getSkillsB());
		projectsResponse.setSkillsC(source.getSkillsC());
		projectsResponse.setProjectRole(source.getProjectRole());

		
		if(null != source.getResumeEntity())
			projectsResponse.setId(source.getResumeEntity().getId());
		return projectsResponse;
	}

}