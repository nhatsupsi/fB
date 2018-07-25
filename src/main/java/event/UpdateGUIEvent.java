package event;

import state.State;

public class UpdateGUIEvent {
    private State state;
    public UpdateGUIEvent(State state){
        this.state= state;
    }

    public State getState() {
        return state;
    }
}
