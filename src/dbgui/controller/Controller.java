package dbgui.controller;

import dbgui.model.AvtorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tables.Avtor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField avtorNameTextField;
    public TextField avtorCommentTextField;

    @FXML
    TableView<Avtor> tableAvtors;
    @FXML
    TableColumn<Avtor,String> avtorNameColumn;
    @FXML
    TableColumn<Avtor,String> avtorCommentColumn;

    private AvtorService as;

    public void doExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPU");
        EntityManager em = emf.createEntityManager();
        as = new AvtorService(em);

        avtorNameColumn.setCellValueFactory(new PropertyValueFactory<Avtor,String>("name"));
        avtorCommentColumn.setCellValueFactory(new PropertyValueFactory<Avtor,String>("comment"));

    }

    public void showAvtors(ActionEvent actionEvent) {
        showAvtors();
    }

    private void showAvtors() {
        List<Avtor> avtors = as.findAll();
        avtors.stream().forEach(System.out::println);
        ObservableList<Avtor> ol = FXCollections.observableList(avtors);
        tableAvtors.setItems(ol);
    }


    public void addAvtor(ActionEvent actionEvent) {
        String comment = avtorCommentTextField.getText();
        String name = avtorNameTextField.getText();
        Avtor avtor = as.create(name, comment);
        avtorNameTextField.setText("");
        avtorCommentTextField.setText("");
        showAvtors();
    }
}
