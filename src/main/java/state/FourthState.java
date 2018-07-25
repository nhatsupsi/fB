package state;

import model.FileBrowser;

public class FourthState extends State {
    protected FourthState(FileBrowser fileBrowser, State previewState) {
        super(fileBrowser, previewState);
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
