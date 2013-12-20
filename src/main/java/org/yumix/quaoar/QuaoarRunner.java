package org.yumix.quaoar;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.yumix.quaoar.qualifier.MailReaderRootPane;
import org.yumix.quaoar.qualifier.MailWriterRootPane;
import org.yumix.quaoar.qualifier.MailboxRootPane;
import org.yumix.quaoar.qualifier.PrimaryStage;

@Singleton
public class QuaoarRunner {
	
	@Inject
	@MailboxRootPane
	private AnchorPane mailboxRootPane;
	
	@Inject
	@MailReaderRootPane
	private AnchorPane mailReaderRootPane;
	
	@Inject
	@MailWriterRootPane
	private AnchorPane mailWriterRootPane;
	
	@Inject
	@PrimaryStage
	private Stage stage;
	
	public void start() throws IOException {
		Scene scene = new Scene(mailboxRootPane, 320, 480);
		stage.setScene(scene);
		stage.show();
	}
	
	public void select(WhichScene whichScene) {
		switch (whichScene) {
		case MAILBOX:
			System.out.println(mailboxRootPane);
			stage.getScene().setRoot(mailboxRootPane);
			break;
		case MAIL_READER:
			System.out.println(mailReaderRootPane);
			stage.getScene().setRoot(mailReaderRootPane);
			break;
		case MAIL_WRITER:
			System.out.println(mailWriterRootPane);
			stage.getScene().setRoot(mailWriterRootPane);
			break;
		default:
			break;
		}
	}
}
