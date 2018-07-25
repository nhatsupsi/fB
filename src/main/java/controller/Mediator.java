package controller;

import model.FileBrowser;

public interface Mediator {
    void send(int turn);
    void addColleague(Colleague colleague);
}
