package lab11;
import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject{
    private String channelName;
    private List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }


    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for(Observer observer : observers){
            observer.update(message);
        }
    }

    public void uploadVideo(String title) {
        System.out.println("{"+ channelName + "} uploaded a new video: " + title);
        notifyObservers(title);
    }
}