package view;

import controller.AppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainScene extends view.Scene {
    public MainScene() {
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        if(startScene!=null){
            update();
            primaryStage.setScene(startScene);
            primaryStage.show();
        }else{
            startScene=createScene(primaryStage);
            primaryStage.setScene(startScene);
            primaryStage.show();
        }
    }

    @Override
    protected Scene createScene(Stage primaryStage) {
        VBox settings = new VBox(3);
        settings.setPadding(new Insets(10, 10, 10, 10));
        settings.setAlignment(Pos.TOP_CENTER);

        /*****************************************************************************/
        /**************************** File chooser ***********************************/
        /*****************************************************************************/

        HBox folderChooser = new HBox(2);
        folderChooser.setPadding(new Insets(15, 12, 15, 12));
        folderChooser.setSpacing(100);
        folderChooser.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: black");
        folderChooser.setAlignment(Pos.CENTER);


        Label labelSelectedDirectory = new Label("");
        Button btnOpenDirectoryChooser = new Button();
        btnOpenDirectoryChooser.setText("Open DirectoryChooser");
        btnOpenDirectoryChooser.setPrefSize(200, 50);
        btnOpenDirectoryChooser.setOnAction(clicked -> {
            try {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                File selectedDirectory = directoryChooser.showDialog(primaryStage);
                if (selectedDirectory == null) {
                    labelSelectedDirectory.setText("No Directory selected");
                    dataPacket.setPath(null);
                } else {
                    labelSelectedDirectory.setText(selectedDirectory.getAbsolutePath());
                    dataPacket.setPath(selectedDirectory.getAbsolutePath());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
            /*
            btnOpenDirectoryChooser.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    DirectoryChooser directoryChooser = new DirectoryChooser();

                    File selectedDirectory = directoryChooser.showDialog(primaryStage);
                    if(selectedDirectory == null){
                        labelSelectedDirectory.setText("No Directory selected");
                        System.out.println("No Directory selected");
                    }else{
                        labelSelectedDirectory.setText(selectedDirectory.getAbsolutePath());
                        System.out.println(selectedDirectory.getAbsolutePath());
                    }
                }
            });
            */
        folderChooser.getChildren().addAll(labelSelectedDirectory, btnOpenDirectoryChooser);

        /*****************************************************************************/
        /**************************** Page changer ***********************************/
        /*****************************************************************************/


        HBox pageController = new HBox(2);
        Button nextPageButton = new Button();
        nextPageButton.setText("NEXT");
        nextPageButton.setStyle("-fx-border-color: black;-fx-font-weight: bold;");
        nextPageButton.setPrefSize(150, 50);
        nextPageButton.setOnAction(clicked -> {
            try {
                AppController.instance().nextState(dataPacket);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //new StartGameCommand(guiMediator.getGame(), Integer.parseInt(comboBox.getValue()), ((RadioButton)(group.getSelectedToggle())).getText()).execute();
        });

        Region rightSpring = new Region();
        pageController.getChildren().addAll(rightSpring, nextPageButton);
        pageController.setHgrow(rightSpring, Priority.ALWAYS);


        Region bottomSpring = new Region();
        settings.getChildren().addAll(folderChooser, bottomSpring, pageController);
        settings.setVgrow(bottomSpring, Priority.ALWAYS);


        Scene startScene = new Scene(settings);
        /*
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setTitle("File Browser");
        primaryStage.setMaximized(true);
        primaryStage.setMinHeight(bounds.getHeight() / 1.2);
        primaryStage.setMinWidth(bounds.getWidth() / 2);
        */

        //this.startScene=startScene;
        //primaryStage.setScene(startScene);
        //primaryStage.show();
        return startScene;
    }

    @Override
    protected void update() {

    }
}
