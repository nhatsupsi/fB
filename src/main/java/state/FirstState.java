package state;

import controller.AppController;
import controller.GUIMediator;
import model.FileBrowser;
import view.MainScene;

public class FirstState extends State {
    protected FirstState(FileBrowser fileBrowser, State previousState){
        super(fileBrowser, previousState);
        this.state= AppState.FIRST;
        this.addObserver(GUIMediator.instance());
        this.scene=new MainScene();
    }

    protected FirstState(FileBrowser fileBrowser){
        this(fileBrowser, null);
    }

    @Override
    public State getNextState(DataPacket dataPacket) {
        if(dataPacket.getPath()!=null){
            this.fileBrowser.setPath(dataPacket.getPath());
            if(this.nextState==null){
                this.nextState = new SecondState(this.fileBrowser, this);
            }
            return this.nextState;
        }
        else
            return this;
    }

    @Override
    protected State getPreviousState() {
        throw new NullPointerException();
    }


    @Override
    public boolean checkIfEndState(DataPacket dataPacket) {
        return (dataPacket.getPath()!=null);
    }
}
