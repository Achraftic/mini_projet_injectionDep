package net.achraf;

import net.achraf.config.BeanFactory;
import net.achraf.metier.IMetier;
import net.achraf.metier.MetierImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        IMetier metier = BeanFactory.createBean(MetierImpl.class);
        metier.calcul();
    }
}
