package view;

import controller.AppController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class FileTypeScene extends view.Scene {
    public FileTypeScene() {
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        if(startScene!=null){
            update();
            primaryStage.setScene(startScene);
            primaryStage.show();
        }else {
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

        HBox folderChooser = new HBox(1);
        folderChooser.setPadding(new Insets(15, 12, 15, 12));
        folderChooser.setSpacing(100);
        folderChooser.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: black;"
                + "-fx-font-weight: bold;");
        folderChooser.setAlignment(Pos.CENTER);


        Label labelSelectedDirectory = new Label(AppController.instance().getFileBrowser().getPath());
        labelSelectedDirectory.setId("labelSelectedDirectory");

        folderChooser.getChildren().addAll(labelSelectedDirectory);


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
        });


        Button previousPageButton = new Button();
        previousPageButton.setText("PREVIOUS");
        previousPageButton.setStyle("-fx-border-color: black;-fx-font-weight: bold;");
        previousPageButton.setPrefSize(150, 50);
        previousPageButton.setOnAction(clicked -> {
            try {
                AppController.instance().previousState();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Region middleSpring = new Region();
        pageController.getChildren().addAll(previousPageButton, middleSpring, nextPageButton);
        pageController.setHgrow(middleSpring, Priority.ALWAYS);
        /*****************************************************************************/


        Region bottomSpring = new Region();
        settings.getChildren().addAll(folderChooser, bottomSpring, pageController);
        settings.setVgrow(bottomSpring, Priority.ALWAYS);


        Scene startScene = new Scene(settings);
        return startScene;
    }

    @Override
    protected void update() {
        Label labelSelectedDirectory=(Label)(startScene.lookup("#labelSelectedDirectory"));
        labelSelectedDirectory.setText(AppController.instance().getFileBrowser().getPath());
    }
}
