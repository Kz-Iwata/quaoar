package org.yumix.quaoar;
	
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		Mailbox mailbox = container.instance().select(Mailbox.class).get();
		mailbox.start(primaryStage);
		weld.shutdown();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
