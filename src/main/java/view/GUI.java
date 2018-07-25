package view;

import controller.AppController;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.FileBrowser;

public class GUI extends Application{
    private Stage primaryStage;
    private AppController appController;
    private FileBrowser fileBrowser;
    private Scene scene;
    boolean started=false;

    public GUI(){
        this.fileBrowser = new FileBrowser();
        this.appController = AppController.instance();
        this.appController.setup(fileBrowser, this);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        if(!started) {
            this.primaryStage = primaryStage;
            initStage(this.primaryStage);
            this.scene.start(primaryStage);
        }
        started=true;
    }

    public void setScene(Scene scene) throws Exception {
        this.scene = scene;
        this.scene.start(primaryStage);
    }
    private void initStage(Stage primaryStage){
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setTitle("File Browser");
        primaryStage.setMaximized(true);
        primaryStage.setMinHeight(bounds.getHeight() / 1.2);
        primaryStage.setMinWidth(bounds.getWidth() / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
