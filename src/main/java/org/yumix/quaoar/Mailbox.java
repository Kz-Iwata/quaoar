package org.yumix.quaoar;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Mailbox {
	@Inject
	private FXMLLoader loader;
	
	public void start(Stage stage) throws IOException {
		try (InputStream fxml = getClass().getResourceAsStream("/org/yumix/quaoar/Mailbox.fxml")) {
			AnchorPane root = loader.load(fxml);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public void select(String s) {
		System.out.println(s);
	}
}
