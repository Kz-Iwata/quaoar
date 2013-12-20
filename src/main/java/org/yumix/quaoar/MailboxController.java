package org.yumix.quaoar;

import static org.yumix.quaoar.WhichScene.MAIL_WRITER;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import javax.inject.Inject;

public class MailboxController implements Initializable {
	
	@Inject
	private QuaoarRunner quaoarRunner;
	
	@FXML
	private ListView<TextFlow> receivedMailListView;
	
	private ObservableList<TextFlow> receivedMailList;
	
	@FXML
	private Button write;
	
	@FXML
	public void onClickWrite(ActionEvent event) {
		quaoarRunner.select(MAIL_WRITER);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		receivedMailList = FXCollections.observableArrayList();
		receivedMailList.add(new TextFlow(new Text("最初のメール")));
		receivedMailList.add(new TextFlow(new Text("2番目のメール")));
		receivedMailList.add(new TextFlow(new Text("最後のメール")));
		receivedMailListView.setItems(receivedMailList);
	}
}
