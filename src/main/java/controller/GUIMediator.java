package controller;

import event.UpdateGUIEvent;
import state.State;
import view.GUI;

import java.util.Observable;
import java.util.Observer;

public class GUIMediator implements Observer {
    private static GUIMediator myGUIMediator = null;
    private GUI gui;


    private GUIMediator(GUI gui){
        this.gui=gui;
    }
    static public synchronized GUIMediator instance(GUI gui) {
        if (myGUIMediator == null) {
            myGUIMediator = new GUIMediator(gui);
            return myGUIMediator;
        } else {
            myGUIMediator.gui=gui;
            return myGUIMediator;
        }
    }
    static public synchronized GUIMediator instance() {
        if(myGUIMediator == null)
            throw new ExceptionInInitializerError("First instance: plz insert GUI");
        return myGUIMediator;
    }
    
    //Observer
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof UpdateGUIEvent) {
            try {
                State state = ((UpdateGUIEvent) arg).getState();
                gui.setScene(state.getScene());
            }catch (Exception e){}
        }
    }
}
