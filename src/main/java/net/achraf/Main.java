package net.achraf;

import net.achraf.config.BeanFactory;
import net.achraf.metier.IMetier;
import net.achraf.metier.MetierImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        // Utiliser le framework d'injection pour créer le bean MetierImpl
        IMetier metier = BeanFactory.createBean(MetierImpl.class);
        metier.calcul();  // Affiche "Calcul started", "Data from DAO implementation", "Calcul finished"
    }
}
