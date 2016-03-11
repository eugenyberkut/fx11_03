package dbgui.controller;

import dbgui.model.AvtorService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
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

    EntityManagerFactory emf;
    EntityManager em;
    AvtorService as;

    public void doExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emf = Persistence.createEntityManagerFactory("NewPU");
        em = emf.createEntityManager();
        as = new AvtorService(em);
    }

    public void showAvtors(ActionEvent actionEvent) {
        as.findAll().stream().forEach(System.out::println);
    }


    public void addAvtor(ActionEvent actionEvent) {
        String comment = avtorCommentTextField.getText();
        String name = avtorNameTextField.getText();
        Avtor avtor = as.create(name, comment);
        avtorNameTextField.setText("");
        avtorCommentTextField.setText("");
    }
}
