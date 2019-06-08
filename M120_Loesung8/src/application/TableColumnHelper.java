package application;

import application.model.Customer;
import application.model.Status;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

public class TableColumnHelper {

	public static TableColumn<Customer,String> addConfigs(TableColumn<Customer,String> column){
		column.setCellFactory(TextFieldTableCell.forTableColumn());
		column.setSortable(true);
		column.setEditable(true);
		return column;
	}
	
	public static TableColumn<Customer,Status> addSelectionConfigs(TableColumn<Customer,Status> column){
		ObservableList<Status> items = FXCollections.observableArrayList();
		for(Status s : Status.values()) {
			items.add(s);
		}
		column.setCellFactory(ChoiceBoxTableCell.forTableColumn(items));
		column.setSortable(true);
		column.setEditable(true);
		return column;
	}
	
	
	public static TableColumn<Customer,Boolean> addBooleanConfigs(TableColumn<Customer,Boolean> column){
		column.setCellFactory(new Callback<TableColumn<Customer,Boolean>, TableCell<Customer,Boolean>>() {
			
			@Override
			public TableCell<Customer, Boolean> call(TableColumn<Customer, Boolean> param) {
				CheckBoxTableCell<Customer, Boolean> cell = new CheckBoxTableCell<>();
				return cell;
			}
			
		});
		
		
		column.setCellValueFactory(value -> value.getValue().getNewsletter());
		column.setEditable(true);
		return column;
	}
	
}
