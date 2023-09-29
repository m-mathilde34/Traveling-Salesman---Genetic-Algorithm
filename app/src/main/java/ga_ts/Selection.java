package ga_ts;

import java.util.ArrayList;

public class Selection {

    public int k;
    public ArrayList<Route> pool;
    public Route fittestIndividual;


    public Selection(){
        this.k = 40;
        pool = createTournamentPool();
        fittestIndividual = getFittestIndividual();
    }

    public ArrayList<Route> createTournamentPool(){
        return pool;
    }

    public Route getFittestIndividual(){
        return fittestIndividual;
    }

}
