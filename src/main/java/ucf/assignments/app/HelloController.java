/*
 * UCF COP3330 Fall 2021 Assignment 4 Solution
 * Copyright 2021 Kelli Howard
 */

package ucf.assignments.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button addTask;
    @FXML
    private TextField taskName;
    @FXML
    private TextField taskDescription;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ListView taskList;
    @FXML
    private TabPane tabPane;

    ObservableList<TodoItem> list = FXCollections.observableArrayList();
    ObservableList<TodoItem> listNotDone = FXCollections.observableArrayList();
    ObservableList<TodoItem> listDone = FXCollections.observableArrayList();

    @FXML
    public void onCreateTODOList() {
        // Here I'm going to create a new tab for a new list
        // Create new tableview object
        Tab tab = new Tab();
        tab.setText("Untitled Todo List");
        tabPane.getTabs().add(tab);
    }

    @FXML
    protected void onAddItem() {
        // Get the name of the specific list being indexed
        // Create an item object
        // add the item to the list specified

        list.add(new TodoItem(taskName.getText(), taskDescription.getText(),
                datePicker.getValue()));
        System.out.println(taskDescription.getText());
        taskList.setItems(list);
        taskDescription.setText("");
    }

    @FXML
    protected void onDeleteItem() {
        // Get the name of the specific list being indexed
        // loop through the items in the list until the specified item is found
        // delete the item specified
        list.remove(taskList.getSelectionModel().getSelectedItem());
        taskList.refresh();
    }

    @FXML
    protected void onClearCompleted() {
        taskList.getItems().clear();
    }

    @FXML
    protected void onMarkAsComplete() {
        TodoItem task = list.get(taskList.getSelectionModel().getSelectedIndex());
        String oldTaskName = "COMPLETED   |   " + task.getName();
        String oldTaskDescrip = task.getDescrip();
        list.remove(taskList.getSelectionModel().getSelectedItem());

        TodoItem newTask = new TodoItem(oldTaskName, oldTaskDescrip,
                datePicker.getValue());
        list.add(newTask);

        taskList.setItems(list);
        taskList.refresh();

    }

    @FXML
    protected void onDisplayAll() {
        taskList.setItems(list);
        taskList.refresh();
    }

    @FXML
    protected void onDisplayIncomplete() {
        listNotDone.clear();

        for (TodoItem item: list) {
            if(! item.getName().contains("COMPLETED")) {
                listNotDone.add(item);
            }
        }

        taskList.setItems(listNotDone);
        taskList.refresh();
    }

    @FXML
    protected void onDisplayComplete() {
        listDone.clear();

        for (TodoItem item: list) {
            if(item.getName().contains("COMPLETED")) {
                listDone.add(item);
                System.out.println("complete " + item);
            }
        }

        taskList.refresh();
        taskList.setItems(listDone);
        taskList.refresh();
    }
}