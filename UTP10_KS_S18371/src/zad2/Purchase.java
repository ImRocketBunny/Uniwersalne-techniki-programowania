/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad2;
import java.beans.*;

public class Purchase {
    VetoableChangeSupport veto = new  VetoableChangeSupport(this);
    PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
    String komputer;
    String promocja;
    double v;
    public Purchase(String komputer, String promocja, double v) {
        this.komputer=komputer;
        this.promocja=promocja;
        this.v=v;
    }

    public synchronized void setData(String w_promocji) throws PropertyVetoException{
        String old;
        old=promocja;
        veto.fireVetoableChange("promocja",w_promocji,old);
        promocja=w_promocji;
    }

    public void setPrice(double v2) throws PropertyVetoException{
        Double staraCena;
        staraCena=v;
        veto.fireVetoableChange("v", staraCena, v2);
        v=v2;
        propertyChange.firePropertyChange("v", staraCena, v2);
    }
    public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
        veto.addVetoableChangeListener(l);
    }


    public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChange.addPropertyChangeListener(l);
    }

    @Override
    public String toString() {
        return "Purchase [prod=" + komputer + ", data=" + promocja + ", price=" + v + "]";
    }
}
