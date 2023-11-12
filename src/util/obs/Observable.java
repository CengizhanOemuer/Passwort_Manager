package util.obs;

public interface Observable {
    // Methods:
    public void addObserver(Observer obs);
    public void removeObserver(Observer obs);
    public void notifyObserver();
}
