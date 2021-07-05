package zad2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Ceny implements VetoableChangeListener {
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        if(evt.getPropertyName().equals("v")&&((Double)evt.getNewValue()<100.0)){
            throw new PropertyVetoException("Price change to: " + evt.getNewValue() + " not allowed", evt);
        }
    }
}
