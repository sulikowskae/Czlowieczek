package sample;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    public TextField textfieldImie;
    public TextField textfieldNazwisko;
    public TextField textfieldPesel;
    public TextField textfieldWzrost;
    public TextField textfieldWiek;
    public TableView<Czlowieczek> table;


    public static class Czlowieczek {

        protected String imie;
        protected String nazwisko;
        protected String pesel;
        protected String wzrost;
        protected String wiek;

        public Czlowieczek(String imie, String nazwisko, String pesel, String wzrost, String wiek) {

            this.imie = imie;
            this.nazwisko = nazwisko;
            this.pesel = pesel;
            this.wzrost = wzrost;
            this.wiek = wiek;
        }

        public String getImie() {

            return imie;
        }

        public void setImie(String imie) {

            this.imie = imie;
        }

        public String getNazwisko() {

            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {

            this.nazwisko = nazwisko;
        }

        public String getPesel() {

            return pesel;
        }

        public void setPesel(String pesel) {

            this.pesel = pesel;
        }

        public String getWzrost() {

            return wzrost;
        }

        public void setWzrost(String wzrost) {

            this.wzrost = wzrost;
        }

        public String getWiek() {

            return wiek;
        }

        public void setWiek(String wiek) {

            this.wiek = wiek;
        }


    }


    public void handleClick(ActionEvent actionEvent) {


        table.getItems().add(new Czlowieczek(textfieldImie.getText(), textfieldNazwisko.getText(), textfieldPesel.getText(), textfieldWzrost.getText(), textfieldWiek.getText()));
        System.out.print(table.getItems());
    }

    public void initialize() {



        for (TableColumn<Czlowieczek, ?> column : table.getColumns()) {
            if ("columnImie".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textImie = (TableColumn<Czlowieczek, String>) column;
                textImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
            } else if ("columnNazwisko".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textNazwisko = (TableColumn<Czlowieczek, String>) column;
                textNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            } else if ("columnPesel".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textPesel = (TableColumn<Czlowieczek, String>) column;
                textPesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
            } else if ("columnWzrost".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textWzrost = (TableColumn<Czlowieczek, String>) column;
                textWzrost.setCellValueFactory(new PropertyValueFactory<>("wzrost"));
            } else if ("columnWiek".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textWiek = (TableColumn<Czlowieczek, String>) column;
                textWiek.setCellValueFactory(new PropertyValueFactory<>("wiek"));
            } else if ("columnUsun".equals(column.getId())) {
                TableColumn<Czlowieczek, Czlowieczek> usun = (TableColumn<Czlowieczek, Czlowieczek>) column;
                usun.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));

                usun.setCellFactory(param -> new TableCell<Czlowieczek, Czlowieczek>() {
                    private final Button deleteButton = new Button("Usuń");

                    @Override
                    protected void updateItem(Czlowieczek person, boolean empty) {
                        super.updateItem(person, empty);

                        if (person == null) {
                            setGraphic(null);
                            return;
                        }

                        setGraphic(deleteButton);
                        deleteButton.setOnAction(
                                event -> getTableView().getItems().remove(person));
                    }


                 });
    }

    }
    }
}