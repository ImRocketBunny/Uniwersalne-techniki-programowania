package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ZmianaDanych implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Change value of: " + evt.getPropertyName() + " from: " + evt.getOldValue() + " to: " + evt.getNewValue());
    }
}
