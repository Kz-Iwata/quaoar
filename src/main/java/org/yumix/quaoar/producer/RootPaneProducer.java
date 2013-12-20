package org.yumix.quaoar.producer;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.yumix.quaoar.qualifier.MailReaderRootPane;
import org.yumix.quaoar.qualifier.MailWriterRootPane;
import org.yumix.quaoar.qualifier.MailboxRootPane;

@Dependent
public class RootPaneProducer {

	@Inject
	private FXMLLoader loader;
	
	private static final String MAILBOX_ROOT_URI = "/org/yumix/quaoar/Mailbox.fxml";
	
	private static final String MAIL_READER_ROOT_URI = "/org/yumix/quaoar/MailReader.fxml";
	
	private static final String MAIL_WRITER_ROOT_URI = "/org/yumix/quaoar/MailWriter.fxml";
	
	@Produces
	@MailboxRootPane
	public AnchorPane getMailboxRootPane() throws IOException {
		return getRootPane(MAILBOX_ROOT_URI);
	}
	
	@Produces
	@MailReaderRootPane
	public AnchorPane getMailReaderRootPane() throws IOException {
		return getRootPane(MAIL_READER_ROOT_URI);
	}
	
	@Produces
	@MailWriterRootPane
	public AnchorPane getMailWriterRootPane() throws IOException {
		return getRootPane(MAIL_WRITER_ROOT_URI);
	}
	
	private AnchorPane getRootPane(String name) throws IOException {
		try (InputStream fxml = getClass().getResourceAsStream(name)) {
			return loader.load(fxml);
		}
	}
}
