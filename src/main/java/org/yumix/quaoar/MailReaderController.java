package org.yumix.quaoar;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MailReaderController {
	
	@Inject
	private QuaoarRunner quaoarRunner;
	
	@FXML
	private Button back;
	
	@FXML
	public void onBackAction(ActionEvent event) {
		
	}
}
