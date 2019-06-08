package application.model;

import java.time.LocalDate;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {

	private SimpleStringProperty name = new SimpleStringProperty();
	private SimpleStringProperty firstname = new SimpleStringProperty();
	private SimpleStringProperty street = new SimpleStringProperty();
	private SimpleStringProperty zipCity = new SimpleStringProperty();
	private SimpleStringProperty email = new SimpleStringProperty();

	private SimpleObjectProperty<LocalDate> customerSince = new SimpleObjectProperty<LocalDate>();
	
	private SimpleBooleanProperty newsletter = new SimpleBooleanProperty();
	private SimpleObjectProperty<Status> status = new SimpleObjectProperty<Status>();
	
	public Customer() {
		
	}
	
	public Customer(String name, String firstname, Status status) {
		this.name.setValue(name);
		this.firstname.setValue(firstname);
		this.status.setValue(status);
	}
	
	public SimpleStringProperty getEmail() {
		return email;
	}
	
	public SimpleStringProperty getZipCity() {
		return zipCity;
	}

	public SimpleStringProperty getStreet() {
		return street;
	}
	
	public SimpleStringProperty getName() {
		return name;
	}
	public SimpleStringProperty getFirstname() {
		return firstname;
	}

	public SimpleBooleanProperty getNewsletter() {
		return newsletter;
	}

	public SimpleObjectProperty<Status> getStatus() {
		return status;
	}

	public SimpleObjectProperty<LocalDate> getCustomerSince() {
		return customerSince;
	}
	
}
