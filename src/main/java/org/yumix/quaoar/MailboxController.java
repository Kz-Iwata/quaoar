package org.yumix.quaoar;

import javax.inject.Inject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MailboxController {
	@Inject
	private Mailbox mailbox;
	
	@FXML
	private Button read;
	
	@FXML
	private Button write;
	
	@FXML
	public void onClickRead(ActionEvent event) {
		mailbox.select("Read");
	}
	
	@FXML
	public void onClickWrite(ActionEvent event) {
		mailbox.select("Write");
	}
}
