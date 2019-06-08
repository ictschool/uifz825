package application.view;

import application.model.Customer;
import application.model.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.*;

public class EditViewController {

	@FXML
	private TextField txtVorname, txtNachname, txtStrasse, txtPlz, txtOrt, txtEmail;
	@FXML
	private DatePicker datKundeSeit;
	@FXML
	private CheckBox chkNewsletter;
	@FXML
	private ChoiceBox<Status> cbKundeArt;

	private Customer customer;

	// Zum speichern der Referenz auf das Fenster
	private Stage stage;

	public void setStage(Stage s) {
		this.stage = s;
		ObservableList<Status> list = FXCollections.observableArrayList();
		for (Status st : Status.values()) {
			list.add(st);
		}
		cbKundeArt.setItems(list);
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		txtVorname.setText(customer.getFirstname().getValue());
		txtNachname.setText(customer.getName().getValue());
		txtStrasse.setText(customer.getStreet().getValue());
		try {
			txtPlz.setText(customer.getZipCity().getValue().split(" ")[0]);
			txtOrt.setText(customer.getZipCity().getValue().split(" ")[1]);
		} catch (Exception e) {

		}
		txtEmail.setText(customer.getEmail().getValue());
		datKundeSeit.setValue(customer.getCustomerSince().getValue());
		chkNewsletter.setSelected(customer.getNewsletter().getValue());
		cbKundeArt.setValue(customer.getStatus().getValue());
	}

	/**
	 * Schliesst das Fenster
	 */
	@FXML
	private void saveButtonPressed(ActionEvent event) {
		customer.getFirstname().setValue(txtVorname.getText());
		customer.getName().setValue(txtNachname.getText());
		customer.getCustomerSince().setValue(datKundeSeit.getValue());
		customer.getNewsletter().setValue(chkNewsletter.isSelected());
		customer.getStatus().setValue(cbKundeArt.getValue());
		customer.getEmail().setValue(txtEmail.getText());
		customer.getStreet().setValue(txtStrasse.getText());
		customer.getZipCity().setValue(txtPlz.getText() + " " + txtOrt.getText());

		this.stage.close();
	}

	/**
	 * Schliesst das Fenster
	 */
	@FXML
	private void cancelButtonPressed(ActionEvent event) {
		this.stage.close();
	}
}
