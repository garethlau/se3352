import java.util.ArrayList;

public abstract class Subject {


  // List of observers that need to be notified when changes occur
  ArrayList<Observer> observers;
  
  public Subject() {
    // Initialize the observers array to an empty array list
    this.observers = new ArrayList<Observer>();
  }

  // Define function that must be implemneted to add
  // observers to the observer list
  void attach(Observer observer) {
    // Add the observer to the list of observers
    this.observers.add(observer);
  }

  // Define detach function to remove an observer from this subject
  void detach(Observer observer) {
    // Remove the observer from the list of observers
    this.observers.remove(observer);
  }

  // Define abstract function that must be implemented to notify
  // all observers that changes have occured
  // Note that this method cannot be called notify() as notify is a Java 
  // Object method.
  void not() {
    this.observers.forEach(observer -> {
      // Call the update() function for the observer
      // to refresh its state
      observer.update();
    });
  };
}
