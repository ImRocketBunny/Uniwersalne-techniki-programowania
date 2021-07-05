/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad1;


import java.util.HashMap;

public class Calc {
    String[] kalkulacja;
    HashMap<String,Czynnosc> zbiorOperacji = new HashMap<>();
    public String doCalc(String arg) {
        zbiorOperacji.put("-", new Odejmowanie());
        zbiorOperacji.put("/", new Dzielenie());
        zbiorOperacji.put("+", new Dodawanie());
        zbiorOperacji.put("*", new Mnozenie());
        try {
            kalkulacja=arg.split("\\s+");
            double pierwsza = Double.parseDouble(kalkulacja[0]);
            double druga = Double.parseDouble(kalkulacja[2]);
            Czynnosc czynnosc = zbiorOperacji.get(kalkulacja[1]);
            return "" + czynnosc.oblicz(pierwsza, druga);

        }catch (Exception e){
           return "Invalid command to calc";

        }
    }
}
