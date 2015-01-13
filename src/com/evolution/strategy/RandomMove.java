package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;
import com.evolution.model.Square;
import java.util.ArrayList;

/**
 * Class Random move, the animal go on an empty square randomly or stay
 * where is he. / Pattern Strategy
 * @author Anthony
 */
public class RandomMove implements BehaviorMove {

    Model m;

    /**
     * Constructor of the RandomMove
     * @param mParam Model
     */
    public RandomMove(Model mParam) {
        m = mParam;
    }

    /**
     * Method of move
     * @param animal Animal
     */
    @Override
    public void move(Animal animal) {
        ArrayList<Square> list1 = new ArrayList<>();
        ArrayList<Square> list2 = new ArrayList<>();
        ArrayList<Square> list3 = new ArrayList<>();
        
        int x                   = animal.getPosX();
        int y                   = animal.getPosY();
        int tempx;
        int tempy;
        int tempSize;

        //ON liste les 9 list1
        
        //System.out.println("\n Les positions possibles");
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                list1.add(new Square(i, j));
                //System.out.println("x="+i+" j="+j);
            }
        }

        // ON SUPPRIME LES CAS IMPOSSIBLES
        for (int z = 0; z < 9; z++) {
            if (!(list1.get(z).getX() < 0 || list1.get(z).getX() >= m.getSizeX())) {
                if (!(list1.get(z).getY() < 0 || list1.get(z).getY() >= m.getSizeY())) {
                    list2.add(list1.get(z));

                }
            }
            
        }
        
        
        /*System.out.println("\n -------- ELAGAGE");
        for(int l =0; l < list2.size(); l++){
        System.out.println("x="+list2.get(l).getX()+" j="+list2.get(l).getY());
        }
        System.out.println("On a supprimé les cases qui débordent");
        */
        
       
        
        //On supprime les list1 avec animaux Même celle où il se trouve
        for (int w = 0; w < list2.size(); w++) {
            tempx = list2.get(w).getX();
            tempy = list2.get(w).getY();
            
            if ((m.world[tempx][tempy].getNumberOfAnimals() == 0)) {
                list3.add(list2.get(w));
            }
        }
        
        /*  System.out.println("\n -------- ELAGAGE 2");
        for(int l =0; l < list3.size(); l++){
        System.out.println("x="+list3.get(l).getX()+" j="+list3.get(l).getY());
        }
        System.out.println("On a supprimé les cases qui contiennent des animaux");*/
        // On choisi un case libre au hasard
        
        if (!list3.isEmpty()) {
            int rand = Model.randInt(0, list3.size() - 1);

            m.world[x][y].setNumberOfAnimals(m.world[x][y].getNumberOfAnimals()-1);
            animal.setPosX(list3.get(rand).getX());
            animal.setPosY(list3.get(rand).getY());
            m.world[animal.getPosX()][animal.getPosY()].setNumberOfAnimals(m.world[animal.getPosX()][animal.getPosY()].getNumberOfAnimals()+1);
            System.out.println("Mouton va en :"+animal.getPosX()+" "+animal.getPosY());

        } else {
            System.out.println("Mouton reste sur place");
        }

    }

}
