package org.yumix.quaoar;
	
import javax.enterprise.inject.Produces;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.yumix.quaoar.qualifier.PrimaryStage;

import javafx.application.Application;
import javafx.stage.Stage;

public class QuaoarApplication extends Application {
	
	private static Stage primaryStage;
	
	@Produces
	@PrimaryStage
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		QuaoarApplication.primaryStage = primaryStage;
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		QuaoarRunner quaoarRunner = container.instance().select(QuaoarRunner.class).get();
		quaoarRunner.start();
		weld.shutdown();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
