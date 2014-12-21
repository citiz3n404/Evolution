package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;
import com.evolution.model.Square;
import java.util.ArrayList;

/**
 *
 * @author Anthony
 */
public class RandomM implements BehaviorMove {

    Model m;

    public RandomM(Model mParam) {
        m = mParam;
    }

    @Override
    public void move(Animal animal) {
        ArrayList<Square> squares = new ArrayList<>();
        
        int x = animal.getPosX();
        int y = animal.getPosY();
        int tempx;
        int tempy;
        int tempSize;

        //ON liste les 9 cases
        System.out.println("\n --------");
        System.out.println("\n Les positions possibles");
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                squares.add(new Square(i, j));
                System.out.println("x="+i+" j="+j);
            }
        }

        // ON SUPPRIME LES CAS IMPOSSIBLES
        for (int z = 0; z < squares.size(); z++) {
            if (squares.get(z).getX() < 0 || squares.get(z).getX() > m.getSizeX()-1) {
                if (squares.get(z).getY() < 0 || squares.get(z).getY() > m.getSizeY()-1) {
                    squares.remove(squares.get(z));
                }
            }
            
        }
        
        
        System.out.println("\n -------- ELAGAGE");
        for(int l =0; l < squares.size(); l++){
            System.out.println("x="+squares.get(l).getX()+" j="+squares.get(l).getY());
        }
        
        System.out.println("On a supprimé les cases qui débordent");
        
        //On supprime les cases avec animaux Même celle où il se trouve
        for (int w = 0; w < squares.size(); w++) {
            tempx = squares.get(w).getX();
            tempy = squares.get(w).getY();
            
            if (m.world[tempx][tempy].getHasAnimal()) {
                squares.remove(squares.get(w));
            }
        }
        
         System.out.println("\n -------- ELAGAGE 2");
        for(int l =0; l < squares.size(); l++){
            System.out.println("x="+squares.get(l).getX()+" j="+squares.get(l).getY());
        }
        System.out.println("On a supprimé les cases qui contiennent des animaux");
        // On choisi un case libre au hasard
        if (!squares.isEmpty()) {
            int rand = Model.randInt(0, squares.size() - 1);

            m.world[x][y].setHasAnimal(false);
            animal.setPosX(squares.get(rand).getX());
            animal.setPosY(squares.get(rand).getY());
            
            m.world[animal.getPosX()][animal.getPosY()].setHasAnimal(true);
            System.out.println("On a choisi la case :"+animal.getPosX()+" "+animal.getPosY());

        } else {
            //Sinon on ne fait rien et on reste sur place
        }

    }

}
