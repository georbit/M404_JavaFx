package ch.bbw._project_mvn_openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
	@FXML
	private ListView<Customer> kundenliste;


	/**
	 * Fields
	 *
	 */
	// Customer List
	private ObservableList<Customer> customerList = FXCollections.observableArrayList();

	private int actualCustomer;


	private ObservableList<Customer> getCustomerList() {

		ObservableList<Customer> customers = FXCollections.observableArrayList();

		for (int i = 0; i < 10; i++) {
			customers.add(new Customer("Johnny" + i, "Hendrix" + i, "jh@bbw.ch"));
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
		this.customerList = getCustomerList();
		nachname.setText(customerList.get(actualCustomer).getFirstname());
		vorname.setText(customerList.get(actualCustomer).getLastname());
		email.setText(customerList.get(actualCustomer).getEmail());

		musikgenre.setItems(FXCollections.observableArrayList("Pop","Rock","Klassik"));
		kuenstler.setItems(FXCollections.observableArrayList("21 Pilots","Linkin Park","Schubert"));
		medium.setItems(FXCollections.observableArrayList("CD","Schallplatte","Kassette"));

		kundenliste.setItems(customerList);

	}

	@FXML
	public void onButtonSave() {
		System.out.println("button klicked");
		Music music = new Music();
		music.setGenre(musikgenre.getValue().toString());
		music.setKuenstler(kuenstler.getValue().toString());
		music.setMedium(medium.getValue().toString());
		System.out.println("Name: " + vorname.getText());

		customerList.add(new Customer(vorname.getText(),nachname.getText(),email.getText(),music));

		for(Customer customer1 : customerList) {
			System.out.println(customer1.ToStringDebug());
		}
	}

	@FXML
	public void onButtonForward() {
		actualCustomer++;
		// roundrobin
		if (actualCustomer > customerList.size() - 1) {
			actualCustomer = 0;
		}

		vorname.setText(customerList.get(actualCustomer).getFirstname());
		nachname.setText(customerList.get(actualCustomer).getLastname());
		email.setText(customerList.get(actualCustomer).getEmail());
		musikgenre.setValue(customerList.get(actualCustomer).getMusic().getGenre());

	}

	@FXML
	public void onButtonFastForward() {
		actualCustomer = (customerList.size() - 1);
		// Liste
//		txtName.setText(customers.get(actualCustomer).getFirstname());
		// Array
		vorname.setText(customerList.get(actualCustomer).getFirstname());

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
