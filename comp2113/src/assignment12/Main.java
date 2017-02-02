package assignment12;
	
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Author:        Chris Kasza
 * Student #:     100133723
 * Course:        COMP 2113 N1
 * Assignment #:  12
 * Version:       1.0
 * File:          Main.java
 *
 * A user interface for a dictionary ADT driver.
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TextField tfItem = new TextField();
			Button btnAdd = new Button("Add");
			Button btnDelete = new Button("Delete");
			Button btnFind = new Button("Find");
			Button btnLoad = new Button("Load");
			Button btnSave = new Button("Save");
			Button btnQuit = new Button("Quit");
			Label lblComps = new Label();
			Label lblFindSorted = new Label();
			Label lblFindUnsorted = new Label();
			SortedDictionary sortedList = new SortedDictionary();
			UnsortedDictionary unsortedList = new UnsortedDictionary();
			ObservableList<String> listSorted = FXCollections.observableArrayList();
			ObservableList<String> listUnsorted = FXCollections.observableArrayList();
			ListView<String> viewSorted = new ListView<String>(listSorted);
			ListView<String> viewUnsorted = new ListView<String>(listUnsorted);
			
			btnAdd.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					String temp = tfItem.getText();
					lblFindSorted.setText("");
					lblFindUnsorted.setText("");
					lblComps.setText("");
					if(temp != null) {
						sortedList.add(temp);
						unsortedList.add(temp);
						listSorted.clear();
						listUnsorted.clear();
						listSorted.addAll(sortedList.getList());
						listUnsorted.addAll(unsortedList.getList());
						lblComps.setText("Number of comparisons for last operation are sorted(" + sortedList.getComps().toString() + ") and unsorted(" + unsortedList.getComps().toString() + ")");
						tfItem.setText("");
					}
				}
			});
			
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					String temp = tfItem.getText();
					lblFindSorted.setText("");
					lblFindUnsorted.setText("");
					lblComps.setText("");
					if(temp != null) {						
						sortedList.delete(temp);
						unsortedList.delete(temp);
						listSorted.clear();
						listUnsorted.clear();
						listSorted.addAll(sortedList.getList());
						listUnsorted.addAll(unsortedList.getList());
						lblComps.setText("Number of comparisons for last operation are sorted(" + sortedList.getComps().toString() + ") and unsorted(" + unsortedList.getComps().toString() + ")");						
						tfItem.setText("");
					}
				}
			});
			
			btnFind.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					int index;
					String temp = tfItem.getText();
					lblFindSorted.setText("");
					lblFindUnsorted.setText("");
					lblComps.setText("");
					if(temp != null) {						
						index = sortedList.find(temp);
						viewSorted.requestFocus();
						viewSorted.scrollTo(index);
						viewSorted.getSelectionModel().select(index);
						if(index == -1)
							lblFindSorted.setText("\"" + temp + "\" was not found in the sorted list.");
						else
							lblFindSorted.setText("\"" + temp + "\" was not found at position " + (index + 1) + " in the sorted list.");
						
						index = unsortedList.find(temp);
						viewUnsorted.requestFocus();
						viewUnsorted.scrollTo(index);
						viewUnsorted.getSelectionModel().select(index);
						if(index == -1)
							lblFindUnsorted.setText("\"" + temp + "\" was not found in the unsorted list.");
						else
							lblFindUnsorted.setText("\"" + temp + "\" was found at position " + (index + 1) + " in the unsorted list.");
						
						lblComps.setText("Number of comparisons for last operation are sorted(" + sortedList.getComps().toString() + ") and unsorted(" + unsortedList.getComps().toString() + ")");						
						tfItem.setText("");
					}
				}
			});
			
			btnLoad.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					String line;
					lblFindSorted.setText("");
					lblFindUnsorted.setText("");
					lblComps.setText("");
					sortedList.emptyList();
					unsortedList.emptyList();
					Scanner file;
					try {
						file = new Scanner(new File("fname"));
						if(file.hasNext()) {
							line = file.nextLine().trim();
							System.out.println(line);
							if(!line.equals("Sorted")) {
								// file doesn't have expected structure
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Warning");
								alert.setHeaderText(null);
								alert.setContentText("File cannot be loaded due to incorrect structure.");
								alert.showAndWait();
								file.close();
								return;
							}
							while(file.hasNext()) {
								line = file.nextLine().trim();
								if(line.equals("")){
									break;
								}
								sortedList.add(line);								
							}
						}
						if(file.hasNext()) {
							line = file.nextLine().trim();
							if(!line.equals("Unsorted")) {
								// file doesn't have expected structure
								sortedList.emptyList();
								file.close();
								Alert alert = new Alert(AlertType.WARNING);
								alert.setTitle("Warning");
								alert.setHeaderText(null);
								alert.setContentText("File cannot be loaded due to incorrect structure.");
								alert.showAndWait();
								return;
							}
							while(file.hasNext()) {
								line = file.nextLine().trim();
								if(line.equals("")){
									break;
								}
								unsortedList.add(line);								
							}
						}
						
						listSorted.clear();
						listUnsorted.clear();
						listSorted.addAll(sortedList.getList());
						listUnsorted.addAll(unsortedList.getList());
						file.close();
					} catch (IOException e) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("There was an issue accessing the file:\n" + e.getMessage());
						alert.showAndWait();
						e.printStackTrace();
					}
				}
			});
			
			btnSave.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {	
					lblFindSorted.setText("");
					lblFindUnsorted.setText("");
					lblComps.setText("");
					try {
						FileWriter file = new FileWriter("fname");
						file.write("Sorted\n");
						for(String line : sortedList.getList()) {
							file.write(line + "\n");
						}
						file.write("\nUnsorted\n");
						for(String line : unsortedList.getList()) {
							file.write(line + "\n");
						}
						lblComps.setText("Lists saved to fname.");
						file.close();
					} catch (IOException e) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("There was an issue accessing the file for saving:\n" + e.getMessage());
						alert.showAndWait();
						e.printStackTrace();
					}
				}
			});
			
			btnQuit.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ae) {
					primaryStage.close();
				}
			});

			HBox hbox0 = new HBox(7);
			hbox0.setPadding(new Insets(10));
			hbox0.getChildren().addAll(btnLoad, btnSave, btnQuit, tfItem, btnAdd, btnDelete, btnFind);
			
			VBox vbox1 = new VBox(2);
			vbox1.setPadding(new Insets(10));
			vbox1.getChildren().addAll(lblFindSorted, lblFindUnsorted, lblComps);
			
			HBox hbox2 = new HBox(3);
			hbox2.setPadding(new Insets(10));
			hbox2.getChildren().addAll(viewSorted, viewUnsorted);
			
			VBox all = new VBox(12);
			all.setPadding(new Insets(10));
			all.getChildren().addAll(hbox0, vbox1, hbox2);
			
			Scene scene = new Scene(all, 640, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
