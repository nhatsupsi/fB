package state;

import event.UpdateGUIEvent;
import model.FileBrowser;
import view.Scene;

import java.util.Observable;

public abstract class State extends Observable {
    public enum AppState{FIRST, SECOND, THIRD, FOURTH}
    protected FileBrowser fileBrowser;
    protected AppState state;
    protected State previousState=null;
    protected State nextState=null;
    protected Scene scene;

    State(FileBrowser fileBrowser, State previousState){
        this.fileBrowser=fileBrowser;
        this.previousState=previousState;
    }

    protected abstract State getNextState(DataPacket dataPacket);
    protected State getPreviousState(){
        return this.previousState;
    }
    public AppState getState() {
        return this.state;
    }

    public Scene getScene(){
        return this.scene;
    }

    abstract protected boolean checkIfEndState(DataPacket dataPacket);
    protected void updateGUI(){
        setChanged();
        notifyObservers(new UpdateGUIEvent(this));
    }

    protected static State instance(FileBrowser fileBrowser){
        return new FirstState(fileBrowser);
    }
}
