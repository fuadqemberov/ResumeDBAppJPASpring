package com.company;

import com.company.Entity.Skill;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ResumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeApplication.class, args);
	}


	@Autowired
	SkillServiceInter dao;

	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

			Skill s = new Skill();
			s.setName("Kotlin");
			dao.insertSkill(s);
			}

		};
		return clr;

	}


}



