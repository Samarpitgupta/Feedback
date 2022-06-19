package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import play.GlobalSettings;

public class Global extends GlobalSettings {

	@Autowired
	ApplicationContext applicationContext;

	@Override
	public void onStart(play.Application app) {
		applicationContext = new ClassPathXmlApplicationContext("/application.xml");
	}
}
