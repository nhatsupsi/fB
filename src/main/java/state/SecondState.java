package state;

import controller.AppController;
import controller.GUIMediator;
import model.FileBrowser;
import view.FileTypeScene;

public class SecondState extends State {
    protected SecondState(FileBrowser fileBrowser, State previewState) {
        super(fileBrowser, previewState);
        this.state= AppState.SECOND;
        this.addObserver(GUIMediator.instance());
        this.scene=new FileTypeScene();
    }

    @Override
    public State getNextState(DataPacket dataPacket) {
        return null;
    }

    @Override
    public boolean checkIfEndState(DataPacket dataPacket) {
        return false;
    }
}
