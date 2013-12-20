package org.yumix.quaoar;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MailWriterController {
	
	@Inject
	private QuaoarRunner quaoarRunner;
	
	@FXML
	private Button send;
	
	@FXML
	private Button cancel;
	
	@FXML
	public void onClickSend(ActionEvent event) {
		
	}
	
	@FXML
	public void onClickCancel(ActionEvent event) {
		quaoarRunner.select(WhichScene.MAILBOX);
	}
}
