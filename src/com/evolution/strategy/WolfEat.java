package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;
import com.evolution.model.Sheep;

/**
 * Class WolfEat / Pattern Strategy
 * @author Anthony
 */
public class WolfEat implements BehaviorEat {

    Model m;

    /**
     * Constructor of the WolfEat behavior
     * @param mParam Model
     */
    public WolfEat(Model mParam) {
        m = mParam;
    }

    /**
     * Method eat
     * @param animal Animal
     */
    @Override
    public void eat(Animal animal) {
        int x, y;

        x = animal.getPosX();
        y = animal.getPosY();

        if (m.world[x][y].getNumberOfAnimals() == 2) {
            System.out.println("Loup mange Mouton en : " + x + " " + y);
            for (int i = 0; i < m.getListAnimals().size(); i++) {
                if (m.getListAnimals().get(i) instanceof Sheep && m.getListAnimals().get(i).getPosX()==x && m.getListAnimals().get(i).getPosY()==y) {
                    m.world[m.getListAnimals().get(i).getPosX()][m.getListAnimals().get(i).getPosY()].setNumberOfAnimals(m.world[m.getListAnimals().get(i).getPosX()][m.getListAnimals().get(i).getPosY()].getNumberOfAnimals() -1);
                    m.removeAnimal(m.getListAnimals().get(i));
                    m.setNbSheep(m.getNbSheeps() - 1);
                    
                    animal.resetHunger();
                }
            }
        }
    }

}
