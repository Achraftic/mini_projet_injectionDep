package net.achraf.metier;

import net.achraf.dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;


    public MetierImpl() {
    }


    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public void calcul() {
        System.out.println("Business logic with DAO: " + dao.getData());
    }
}
