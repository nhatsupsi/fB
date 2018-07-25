package controller;

import model.FileBrowser;
import state.DataPacket;
import state.StateController;
import view.GUI;

public class AppController {
    private static AppController myAppController = null;
    private FileBrowser fileBrowser;
    private StateController stateController;
    private  AppController(){}
    static public synchronized AppController instance() {
        if (myAppController == null) {
            myAppController = new AppController();
            return myAppController;
        } else {
            return myAppController;
        }
    }
    public void setup(FileBrowser fileBrowser, GUI gui) {
        GUIMediator.instance(gui);
        this.fileBrowser = fileBrowser;
        this.stateController = new StateController(fileBrowser);
    }

    public void nextState(DataPacket dataPacket){
        stateController.nextState(dataPacket);
    }
    public void previousState(){
        stateController.previousState();
    }

    public FileBrowser getFileBrowser() {
        return fileBrowser;
    }
}
