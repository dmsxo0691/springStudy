package com.example.springStudy;

import com.example.springStudy.chap02.AppContext;
import com.example.springStudy.chap02.Greeter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStudyApplication.class, args);

		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}

}
