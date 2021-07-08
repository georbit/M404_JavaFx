package ch.bbw._project_mvn_openjfx;

import java.io.IOException;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController {

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtVorname;
	@FXML
	private TextField txtEmail;

	/**
	 * Fields
	 *
	 */
	// Customer Array
	private Customer[] customerArray = new Customer[10];

	// oder Liste
//	private ObservableList<Customer> customers = FXCollections.observableArrayList();

	private int actualCustomer;

	/**
	 * some customers
	 * 
	 * mit Liste
	 * 
	 * @return
	 */
//	private ObservableList<Customer> getCustomers() {
//		ObservableList<Customer> customers = FXCollections.observableArrayList(
//				new Customer("Giovanni", "Cucuzza", "gc@bbw.ch"), new Customer("Jimmi", "Hendrix", "jh@bbw.ch"),
//				new Customer("Johnny", "Django", "jd@bbw.ch"));
//		return customers;
//
//	}

	// Beispiel mit Arrays
	private Customer[] getCustomerArray() {

		Customer[] customers = new Customer[10];
		for (int i = 0; i < 10; i++) {
			customers[i] = new Customer("Johnny" + i, "Hendrix" + i, "jh@bbw.ch");
		}
		return customers;

	}

	/**
	 * initialisierungsmethode von FXML
	 */
	@FXML
	private void initialize() {
		// set datas

		this.actualCustomer = 0;
		// mit Arrays
		this.customerArray = getCustomerArray();
		txtName.setText(customerArray[actualCustomer].getFirstname());

		// mit Liste
//		this.customers = getCustomers();
//		txtName.setText(customers.get(actualCustomer).getFirstname());

	}

	@FXML
	public void onButtonSave() {
		System.out.println("button klicked");
		System.out.println("Name: " + txtName.getText());
		// Liste
//		System.out.println(customers.get(actualCustomer));
		// Arrays
		System.out.println(customerArray[actualCustomer]);

	}

	@FXML
	public void onButtonForward() {
		actualCustomer++;
		// roundrobin
		if (actualCustomer > customerArray.length - 1) {
			actualCustomer = 0;
		}
		// Liste
//		txtName.setText(customers.get(actualCustomer).getFirstname());
		// Arrays
		txtName.setText(customerArray[actualCustomer].getFirstname());
		txtVorname.setText(customerArray[actualCustomer].getLastname());
		txtEmail.setText(customerArray[actualCustomer].getEmail());

	}

	@FXML
	public void onButtonFastForward() {
		actualCustomer = (customerArray.length - 1);
		// Liste
//		txtName.setText(customers.get(actualCustomer).getFirstname());
		// Array
		txtName.setText(customerArray[actualCustomer].getFirstname());

	}

	@FXML
	public void onButtonBack() {
		System.out.println("button klicked");

	}

	@FXML
	public void onButtonFastBack() {
		System.out.println("button klicked");

	}

}
