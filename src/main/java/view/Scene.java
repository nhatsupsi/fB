package view;

import javafx.application.Application;
import javafx.stage.Stage;
import state.DataPacket;

public abstract class Scene extends Application {
    protected final DataPacket dataPacket=new DataPacket();
    protected javafx.scene.Scene startScene;
    protected abstract javafx.scene.Scene createScene(Stage primaryStage);
    protected abstract void update();
}
