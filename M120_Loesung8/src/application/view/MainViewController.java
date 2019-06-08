package application.view;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import application.TableColumnHelper;
import application.model.Customer;
import application.model.Status;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.*;

public class MainViewController {
	
	@FXML
	private TableView<Customer>  tblCustomer;
	
	@FXML
	private TableColumn<Customer, String> myfirstname, mylastname;
	
	@FXML
	private TableColumn<Customer, Status> status;
	
	@FXML
	private TableColumn<Customer, Boolean> newsletter;
	
	@FXML
	private Label lblFirstname, lblName, lblStatus, lblNewsletter, lblStreet, lblZipCity, lblEmail, lblCustomerSince;
	
	private ObservableList<Customer> kundenListe = FXCollections.observableArrayList();

	//Zum speichern der Referenz aufs Primärfenster
	private Stage primaryStage;
	
	public void setStage(Stage s) {
		this.primaryStage = s;
	}
	
	@FXML
	public void initialize() {
		tblCustomer.setEditable(true);
		
		TableColumnHelper.addConfigs(myfirstname).setCellValueFactory(value -> value.getValue().getFirstname());
		TableColumnHelper.addConfigs(mylastname).setCellValueFactory(value -> value.getValue().getName());
		TableColumnHelper.addBooleanConfigs(newsletter);
		TableColumnHelper.addSelectionConfigs(status).setCellValueFactory(value -> value.getValue().getStatus());
		
		tblCustomer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    Customer selection = oldSelection;
			if (newSelection != null) {
		    	selection = newSelection;
		    }
	    	reload(selection);		    
		});
		
		setData();
		
	}
	
	public void reload(Customer selection) {
		lblFirstname.setText(selection.getFirstname().getValue());
    	lblName.setText(selection.getName().getValue());
    	lblStreet.setText(selection.getStreet().getValue());
    	lblEmail.setText(selection.getEmail().getValue());
    	lblZipCity.setText(selection.getZipCity().getValue());
    	lblCustomerSince.setText(selection.getCustomerSince().getValue().format(DateTimeFormatter.ISO_LOCAL_DATE));
    	lblStatus.setText(selection.getStatus().getValue().name());
    	lblNewsletter.setText(selection.getNewsletter().getValue().booleanValue()+"");
	}
	
	public void addCustomer() {
		for(Customer c : kundenListe) {
			System.out.println(c.getFirstname().getValue());
		}
	}
	
	public void setData() {
		Customer c = new Customer("Buchs", "Enrico", Status.Premium);
		c.getStreet().setValue("Buchenweg");
		c.getZipCity().setValue("2552 Orpund");
		c.getEmail().setValue("buchs@email.ch");
		c.getNewsletter().setValue(true);
		c.getCustomerSince().setValue(LocalDate.now());
		kundenListe.add(c);
		c = new Customer("Muster", "Max", Status.Standard);
		c.getStreet().setValue("Buchsweg");
		c.getZipCity().setValue("2500 Biel");
		c.getCustomerSince().setValue(LocalDate.now());
		kundenListe.add(c);
		tblCustomer.setItems(kundenListe);
	}
	
	
	/**
	 * Zeigt die EditView zum Bearbeiten eines Kunden an
	 */
	@FXML
	private void showEditView(ActionEvent event) {
		try {
			if(tblCustomer.getSelectionModel().getSelectedItem() != null) {
			//Die EditView laden
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EditView.fxml"));
				Parent editView = loader.load();
				
				// Eine neue Stage für die EditView erstellen
				Stage editStage = new Stage();
				editStage.setTitle("Kunde bearbeiten");
				editStage.initModality(Modality.WINDOW_MODAL);
				editStage.initOwner(this.primaryStage);	
				
				//Laden des Controller
				EditViewController editController = loader.getController();
				//Übergabe des erstellten Fensters
				editController.setStage(editStage);
				Customer customer = tblCustomer.getSelectionModel().getSelectedItem();
				editController.setCustomer(customer);
				
				//Eine neue Scene mit der editView erstellen, der editStage übergeben und anzeigen
				editStage.setScene( new Scene(editView));
				editStage.showAndWait();
				reload(customer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void addCustomer(ActionEvent event) {
		try {
			//Die EditView laden
				FXMLLoader loader = new FXMLLoader(this.getClass().getResource("EditView.fxml"));
				Parent editView = loader.load();
				
				// Eine neue Stage für die EditView erstellen
				Stage editStage = new Stage();
				editStage.setTitle("Kunde bearbeiten");
				editStage.initModality(Modality.WINDOW_MODAL);
				editStage.initOwner(this.primaryStage);	
				
				//Laden des Controller
				EditViewController editController = loader.getController();
				//Übergabe des erstellten Fensters
				editController.setStage(editStage);
				Customer customer = new Customer();
				editController.setCustomer(customer);
				
				//Eine neue Scene mit der editView erstellen, der editStage übergeben und anzeigen
				editStage.setScene( new Scene(editView));
				editStage.showAndWait();
				kundenListe.add(customer);
				reload(customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void delete(ActionEvent event) {
		if(tblCustomer.getSelectionModel().getSelectedItem() != null) 
			kundenListe.remove(tblCustomer.getSelectionModel().getSelectedItem());
	}
}
