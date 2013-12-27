package org.yumix.quaoar;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.inject.Inject;
import javax.mail.Session;

import org.yumix.mail.sender.Mail;
import org.yumix.mail.session.UserSetting;
import org.yumix.mail.session.SessionProvider;
import org.yumix.mail.session.qualifier.ICloud;

public class MailWriterController implements Initializable {
	
	@Inject
	private QuaoarRunner quaoarRunner;
	
	@FXML
	private Button send;
	
	@FXML
	private Button cancel;
	
	@FXML
	private TextField fromAddr;
	
	@FXML
	private TextField ccAddr;
	
	@FXML
	private TextField bccAddr;
	
	@FXML
	private TextField toAddr;
	
	@FXML
	private TextField subject;
	
	@FXML
	private TextArea messageBody;
	
	@Inject
	private UserSetting userSetting;
	
	@Inject
	@ICloud
	private SessionProvider sessionProvider;
	
	@FXML
	public void onClickSend(ActionEvent event) {
		String[] toList = this.toAddr.getText().split("[,;]");
		String[] ccList = this.ccAddr.getText().split("[,;]");
		String[] bccList = this.bccAddr.getText().split("[,;]");
		String subject = this.subject.getText();
		String message = this.messageBody.getText();
		
//		Session session = SessionProviderFactory.getInstance().getSession(ICloudProvider.class, from, "yumix_h@icloud.com", "Dysnomi@0");
		Session session = sessionProvider.getSession();
		Mail.from(userSetting.getFromAddress()).to(toList).cc(ccList).bcc(bccList).subject(subject).message(message).send(session);

		quaoarRunner.select(WhichScene.MAILBOX);
	}
	
	@FXML
	public void onClickCancel(ActionEvent event) {
		quaoarRunner.select(WhichScene.MAILBOX);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fromAddr.setText(userSetting.getFromAddress());
	}
}
