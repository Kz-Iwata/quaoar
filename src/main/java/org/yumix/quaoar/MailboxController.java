package org.yumix.quaoar;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.TextFlow;

public class MailboxController {
	@Inject
	private QuaoarRunner quaoarRunner;
	
	@FXML
	private ListView<TextFlow> receivedMails;
	
	@FXML
	private Button write;
	
	@FXML
	public void onClickWrite(ActionEvent event) {
		quaoarRunner.select("Write");
	}
}
