package command;

import model.FileBrowser;

public class NextCommand implements Command {

    private FileBrowser fileBrowser;
    public NextCommand(FileBrowser fileBrowser){
        this.fileBrowser=fileBrowser;
    }
    @Override
    public void execute() {

    }
}
