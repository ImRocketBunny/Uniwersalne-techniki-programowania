package zad1;

import javax.swing.*;

public class Country {
    private String nameCountry;
    private String capital;
    private int population;
    private Icon flag;


    public Country(String nameCountry, String capital, int population, Icon flag) {
        this.nameCountry=nameCountry;
        this.capital=capital;
        this.population=population;
        this.flag=flag;
    }

    public String getName() {
        return nameCountry;
    }

    public Integer getPop() {
        return population;
    }
    public String getCap() {
        return capital;
    }

    public Icon getFlag() {
        return flag;
    }


    public void setPop(Integer population){
        this.population=population;
    }
    public String toString(){
        return getName()+" "+getCap()+" "+getPop();
    }
}
