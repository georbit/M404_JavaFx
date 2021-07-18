package ch.bbw._project_mvn_openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;

public class PrimaryController {

    @FXML
    private TextField nachname;
    @FXML
    private TextField vorname;
    @FXML
    private TextField email;
    @FXML
    private ChoiceBox<String> musikgenre;
    @FXML
    private ChoiceBox<String> kuenstler;
    @FXML
    private ChoiceBox<String> medium;
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

    // Customer List
    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    private final ObservableList<String> genreList = FXCollections.observableArrayList("Pop", "Rock", "Klassik");
    private final ObservableList<String> kuenstlerList = FXCollections.observableArrayList("21 Pilots", "Linkin Park", "Schubert");
    private final ObservableList<String> mediumList = FXCollections.observableArrayList("CD", "Schallplatte", "Kassette");

    private int actualCustomer;

    private ObservableList<Customer> getCustomerList() {

        ObservableList<Customer> customers = FXCollections.observableArrayList();

        Music music = new Music("Pop", "Linkin Park", "Kassette");

        for (int i = 0; i < 10; i++) {
            customers.add(new Customer("Johnny" + i, "Hendrix" + i, "jh@bbw.ch", music));
        }
        return customers;
    }

    /**
     * initialisierungsmethode von FXML
     */
    @FXML
    private void initialize() {
        this.actualCustomer = 0;
        this.customerList = getCustomerList();
        nachname.setText(customerList.get(actualCustomer).getFirstname());
        vorname.setText(customerList.get(actualCustomer).getLastname());
        email.setText(customerList.get(actualCustomer).getEmail());
        musikgenre.setItems(genreList);
        kuenstler.setItems(kuenstlerList);
        medium.setItems(mediumList);
        kundenliste.setItems(customerList);
    }

    @FXML
    private void onButtonReset() {
        setDataOfCustomers();
    }

    @FXML
    public void onButtonSave() {

        Customer customer = customerList.get(actualCustomer);

        if (!validateMail()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ungültige Email Adresse");
            alert.setHeaderText("Ungültige Email Adresse");
            alert.setContentText("Ihre/n Email Adresse ist nicht gültig. Bitte geben Sie eine gültige Adresse ein!");

            alert.showAndWait();

        } else {
            if (customer.getEmail().equals(email.getText()) && customer.getLastname().equals(nachname.getText())) {

                Music music = new Music();

                music.setGenre(musikgenre.getValue().toString());
                music.setKuenstler(kuenstler.getValue().toString());
                music.setMedium(medium.getValue().toString());

                customerList.get(actualCustomer).setFirstname(vorname.getText());
                customerList.get(actualCustomer).setLastname(nachname.getText());
                customerList.get(actualCustomer).setEmail(email.getText());
                customerList.get(actualCustomer).setMusic(music);

            } else {

                Music music = new Music();
                music.setGenre(musikgenre.getValue().toString());
                music.setKuenstler(kuenstler.getValue().toString());
                music.setMedium(medium.getValue().toString());

                customerList.add(new Customer(vorname.getText(), nachname.getText(), email.getText(), music));
            }
        }

        for (Customer customer1 : customerList) {
            System.out.println(customer1.ToStringDebug());
        }
    }

    @FXML
    public void onButtonForward() {
        actualCustomer++;
        if (actualCustomer > customerList.size() - 1) {
            actualCustomer = 0;
        }
        setDataOfCustomers();
    }

    @FXML
    public void onButtonFastForward() {
        actualCustomer = (customerList.size() - 1);
        setDataOfCustomers();
    }

    @FXML
    public void onButtonBack() {
        actualCustomer--;
        if (actualCustomer < 0) {
            actualCustomer = customerList.size() - 1;
        }
        setDataOfCustomers();
    }

    @FXML
    public void onButtonFastBack() {
        actualCustomer--;
        if (actualCustomer < customerList.size() - 1) {
            actualCustomer = 0;
        }
        setDataOfCustomers();
    }

    @FXML
    public void onMouseSelection() {
        actualCustomer = kundenliste.getSelectionModel().getSelectedIndex();
        setDataOfCustomers();
    }

    public boolean validateMail() {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.getText().matches(regex);
    }

    public void setDataOfCustomers() {
        vorname.setText(customerList.get(actualCustomer).getFirstname());
        nachname.setText(customerList.get(actualCustomer).getLastname());
        email.setText(customerList.get(actualCustomer).getEmail());
        musikgenre.setItems(genreList);
        musikgenre.setValue(customerList.get(actualCustomer).getMusic().getGenre());
        kuenstler.setItems(kuenstlerList);
        kuenstler.setValue(customerList.get(actualCustomer).getMusic().getKuenstler());
        medium.setItems(mediumList);
        medium.setValue(customerList.get(actualCustomer).getMusic().getMedium());
    }

}
