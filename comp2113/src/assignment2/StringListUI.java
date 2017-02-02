/*
 * Author:		  Chris Kasza
 * Student #:	  100133723
 * Course:		  COMP 2113 N1
 * Assignment #:  01
 * Version:		 1.0
 * File:			 StringListUI.java
 *
 * A user interface for EditorStringList
 */

package assignment2;
 
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.control.Alert.*;
import javafx.stage.*;

public class StringListUI extends Application {
	protected EditorStringList stringlist = new EditorStringList();
	protected boolean bRevOrder = false;
	protected Label lblSourceWarn = new Label("*Required");
	protected Label lblDestWarn = new Label("*Required");
	protected TextField tfSource = new TextField();
	protected TextField tfDest = new TextField();
	protected TextArea taList = new TextArea();
		
	public static void main(String[] args) {
		Application.launch(args);
	}

	// draw UI
	@Override
	public void start(Stage stage) {
		Button btnInsertAfter = new Button("Insert After");
		Button btnInsertBefore = new Button("Insert Before");
		Button btnInsertFront = new Button("Insert Front");
		Button btnRemove = new Button("Remove");
		Button btnRevOrder = new Button("<->");
		Label lblSource = new Label("Source String");
		Label lblDest = new Label("Destination String");
		Label lblListLabel = new Label("List of Strings:");

		stage.setTitle("String List Editor");
		lblSourceWarn.setTextFill(Color.RED);
		lblSourceWarn.setVisible(false);
		lblDestWarn.setTextFill(Color.RED);
		lblDestWarn.setVisible(false);
		taList.setEditable(false);
		taList.setWrapText(true);
		
		btnInsertAfter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(hasBothReqs()) {
					if(stringlist.exists(tfDest.getText())) {
						if(!stringlist.exists(tfSource.getText())) {
							if(bRevOrder) {
								stringlist.insertBefore(tfSource.getText(), tfDest.getText());
							} else {
								stringlist.insertAfter(tfSource.getText(), tfDest.getText());
							}
							resetWarns();
							updateList();
							
						} else {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Warning");
							alert.setHeaderText(null);
							alert.setContentText("Source element already exists.  Enter a valid source.");
							alert.showAndWait();								
						}						
					} else {					
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("Destination element does not exist.  Enter a valid destination.");
						alert.showAndWait();	
					}
				}
			}
		});
		
		btnInsertBefore.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(hasBothReqs()) {
					if(stringlist.exists(tfDest.getText())) {
						if(!stringlist.exists(tfSource.getText())) {
							if(bRevOrder) {
								stringlist.insertAfter(tfSource.getText(), tfDest.getText());							
							} else {
								stringlist.insertBefore(tfSource.getText(), tfDest.getText());							
							}
							resetWarns();
							updateList();	
						} else {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Warning");
							alert.setHeaderText(null);
							alert.setContentText("Source element already exists.  Enter a valid source.");
							alert.showAndWait();								
						}
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning");
						alert.setHeaderText(null);
						alert.setContentText("Destination element does not exist.  Enter a valid destination.");
						alert.showAndWait();	
					}
				}
			}
		});

		btnInsertFront.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(tfSource.getText() == null || tfSource.getText().trim().isEmpty()) {
					lblSourceWarn.setVisible(true);
				} else if(stringlist.exists(tfSource.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Source element already exists.  Enter a valid source.");
					alert.showAndWait();	
				} else {
					if(bRevOrder) {
						stringlist.insertEnd(tfSource.getText());
					} else {
						stringlist.insertFront(tfSource.getText());
					}				
					resetWarns();
					updateList();
				}
			}
		});
		
		btnRemove.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(tfSource.getText() == null || tfSource.getText().trim().isEmpty()) {
					lblSourceWarn.setVisible(true);
				} else if(!stringlist.exists(tfSource.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning");
					alert.setHeaderText(null);
					alert.setContentText("Element does not exist.");
					alert.showAndWait();					
				} else {
					stringlist.remove(tfSource.getText());
					resetWarns();
					updateList();
				}
			}
		});

		btnRevOrder.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				if(bRevOrder) {
					bRevOrder = false;
				} else {
					bRevOrder = true;
				}
				updateList();
			}
		});
				
		HBox left1Pane = new HBox(2);
		left1Pane.setPadding(new Insets(10));
		left1Pane.getChildren().addAll(lblSource, lblSourceWarn);

		HBox left3Pane = new HBox(2);
		left3Pane.setPadding(new Insets(10));
		left3Pane.getChildren().addAll(lblDest, lblDestWarn);

		VBox leftPane = new VBox(4);
		leftPane.setPadding(new Insets(10));
		leftPane.getChildren().addAll(left1Pane, tfSource, left3Pane, tfDest);

		VBox rightPane = new VBox(4);
		rightPane.setPadding(new Insets(10));
		rightPane.getChildren().addAll(btnInsertBefore, btnInsertAfter, btnInsertFront, btnRemove);
		
		HBox topPane = new HBox(2);
		topPane.setPadding(new Insets(10));
		topPane.getChildren().addAll(leftPane, rightPane);

		VBox bottomLeftPane = new VBox(2);
		bottomLeftPane.setPadding(new Insets(10));
		bottomLeftPane.getChildren().addAll(lblListLabel, btnRevOrder);
		
		HBox bottomPane = new HBox(2);
		bottomPane.setPadding(new Insets(10));
		bottomPane.getChildren().addAll(bottomLeftPane, taList);
		
		//FlowPane rootPane = new FlowPane(Orientation.VERTICAL, 10, 10);
		VBox rootPane = new VBox(2);
		rootPane.setPadding(new Insets(10));
		rootPane.getChildren().addAll(topPane, bottomPane);
		
		// create a scene
		Scene scene = new Scene(rootPane, 640, 400);
		
		// set the scene on the stage
		stage.setScene(scene);
		
		// show the stage and its scene
		stage.show();
	}
	
	public boolean hasBothReqs() {
		// check if the tfSource and tfDest fields are populated
		boolean bCont = true;
		if(tfDest.getText() == null || tfDest.getText().trim().isEmpty()) {
			lblDestWarn.setVisible(true);
			bCont = false;
		}
		
		if(tfSource.getText() == null || tfSource.getText().trim().isEmpty()) {
			lblSourceWarn.setVisible(true);
			bCont = false;
		}
		
		return bCont;
	}

	public void resetWarns() {
		lblDestWarn.setVisible(false);
		lblSourceWarn.setVisible(false);		
	}

	public void updateList() {
		if(bRevOrder) {
			taList.setText(stringlist.revPrint(stringlist.getLastElement()));
		} else {
			taList.setText(stringlist.print(stringlist.getFirstElement()));
		}
	}
}