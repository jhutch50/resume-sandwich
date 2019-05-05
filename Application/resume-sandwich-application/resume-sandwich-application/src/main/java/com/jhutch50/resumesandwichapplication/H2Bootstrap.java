package com.jhutch50.resumesandwichapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jhutch50.resumesandwichapplication.entity.ResumeEntity;
import com.jhutch50.resumesandwichapplication.repository.ResumeRepository;

@Component
public class H2Bootstrap implements CommandLineRunner{

	@Autowired
	ResumeRepository resumeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Bootstrapping Data: ");
		
		resumeRepository.save(new ResumeEntity(1));
		resumeRepository.save(new ResumeEntity(2));
		resumeRepository.save(new ResumeEntity(3));
		
		Iterable<ResumeEntity> itr = resumeRepository.findAll();
		
		System.out.println("Printing Data: ");
		
		for(ResumeEntity resume : itr) {
			System.out.println(resume.getResumeNumber());
		}
	}

}
