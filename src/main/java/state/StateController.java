package state;

import model.FileBrowser;
import view.GUI;

public class StateController {
    private State state;
    FileBrowser fileBrowser;
    //private GUI gui;

    public StateController(FileBrowser fileBrowser/*, GUI gui*/){
        this.fileBrowser=fileBrowser;
        //this.gui=gui;
        nextState(null);
    }

    public void nextState(DataPacket dataPacket){
        if (state != null) {
            while(state.checkIfEndState(dataPacket)) {
                state = state.getNextState(dataPacket);
                // make sure that state is update before notify()
                state.updateGUI();
            }
        }
        else{
            this.state=State.instance(fileBrowser);
            state.updateGUI();
        }
    }
    public void previousState(){
        if (state != null) {
            state = state.getPreviousState();
            state.updateGUI();
        }
        else{
            this.state=State.instance(fileBrowser);
            state.updateGUI();
        }
    }
    public State getState(){
        return state;
    }
}
