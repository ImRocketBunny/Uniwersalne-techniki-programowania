/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad2;


import java.beans.PropertyVetoException;

public class Main {
  public static void main(String[] args) {

    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);

    ZmianaDanych zd = new ZmianaDanych();
    Ceny ceny= new Ceny();

    purch.addVetoableChangeListener(ceny);
    purch.addPropertyChangeListener(zd);

    // --- tu należy dodać odpowiedni kod

    // ----------------------------------

    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);

      purch.setPrice(500.00);

    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);

  }
}
