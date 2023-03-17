package fr.esgi.crowdfunding.model;

public abstract class State {
    Campagne campagne;

    public abstract String onNext();
    public abstract String onPrevious();
}
