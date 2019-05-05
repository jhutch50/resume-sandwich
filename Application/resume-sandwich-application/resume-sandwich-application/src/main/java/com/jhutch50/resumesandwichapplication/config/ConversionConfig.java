package com.jhutch50.resumesandwichapplication.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import converter.WorkExperienceEntityToWorkExperienceResponseConverter;
import converter.WorkExperienceRequestToWorkExperienceEntityConverter;
import converter.ActivityEntityToActivityResponseConverter;
import converter.EducationEntityToEducationResponseConverter;
import converter.ProjectsEntityToProjectsResponseConverter;
import converter.SkillsEntityToSkillsResponseConverter;
import converter.UserInfoEntityToUserInfoResponseConverter;
import converter.VolunteerExperienceEntityToVolunteerExperienceResponseConverter;
import converter.ActivityRequestToActivityEntityConverter;
import converter.EducationRequestToEducationEntityConverter;
import converter.ProjectsRequestToProjectsEntityConverter;
import converter.SkillsRequestToSkillsEntityConverter;
import converter.UserInfoRequestToUserInfoEntityConverter;
import converter.VolunteerExperienceRequestToVolunteerExperienceEntityConverter;
import converter.ResumeEntityToDisplayResumeResponseConverter;


import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {
	
	private Set<Converter> getConverters(){
		Set<Converter> converters = new HashSet<Converter>();
		converters.add(new WorkExperienceRequestToWorkExperienceEntityConverter());
		converters.add(new WorkExperienceEntityToWorkExperienceResponseConverter());
		converters.add(new ActivityEntityToActivityResponseConverter());
		converters.add(new EducationEntityToEducationResponseConverter());
		converters.add(new ProjectsEntityToProjectsResponseConverter());
		converters.add(new SkillsEntityToSkillsResponseConverter());
		converters.add(new UserInfoEntityToUserInfoResponseConverter());
		converters.add(new VolunteerExperienceEntityToVolunteerExperienceResponseConverter());
		converters.add(new ActivityRequestToActivityEntityConverter());
		converters.add(new EducationRequestToEducationEntityConverter());
		converters.add(new ProjectsRequestToProjectsEntityConverter());
		converters.add(new SkillsRequestToSkillsEntityConverter());
		converters.add(new UserInfoRequestToUserInfoEntityConverter());
		converters.add(new VolunteerExperienceRequestToVolunteerExperienceEntityConverter());
		converters.add(new ResumeEntityToDisplayResumeResponseConverter());

		return converters;
	}
	
	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		
		return bean.getObject();
	}
}
