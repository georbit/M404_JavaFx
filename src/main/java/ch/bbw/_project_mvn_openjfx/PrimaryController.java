package ch.bbw._project_mvn_openjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class PrimaryController {

	@FXML
	private TextField nachname;
	@FXML
	private TextField vorname;
	@FXML
	private TextField email;
	@FXML
	private ChoiceBox musikgenre;
	@FXML
	private ChoiceBox kuenstler;
	@FXML
	private ChoiceBox medium;
	@FXML
	private Button verwerfen;
	@FXML
	private Button speichern;
	@FXML
	private Button tostart;
	@FXML
	private Button back;
	@FXML
	private Button forward;
	@FXML
	private Button toend;

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
		nachname.setText(customerArray[actualCustomer].getFirstname());

		// mit Liste
//		this.customers = getCustomers();
//		txtName.setText(customers.get(actualCustomer).getFirstname());

	}

	@FXML
	public void onButtonSave() {
		System.out.println("button klicked");
		System.out.println("Name: " + vorname.getText());
		customerArray[customerArray.length+1] = new Customer(vorname.getText(),nachname.getText(),email.getText());
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
		vorname.setText(customerArray[actualCustomer].getFirstname());
		nachname.setText(customerArray[actualCustomer].getLastname());
		email.setText(customerArray[actualCustomer].getEmail());

	}

	@FXML
	public void onButtonFastForward() {
		actualCustomer = (customerArray.length - 1);
		// Liste
//		txtName.setText(customers.get(actualCustomer).getFirstname());
		// Array
		vorname.setText(customerArray[actualCustomer].getFirstname());

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
