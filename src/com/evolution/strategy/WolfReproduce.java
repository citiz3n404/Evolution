package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;
import com.evolution.model.Square;
import com.evolution.model.Wolf;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Anthony
 */
public class WolfReproduce implements BehaviorReproduce {

    Model m;

    public WolfReproduce(Model mParam) {
        m = mParam;
    }

    @Override
    public void reproduce(Animal animal) {
        // Pour le moment on se contente d'ajouter un bébé

        //Si il s'agit d'une louve
        if (!animal.getSex() && animal instanceof Wolf && animal.getReproductivity()==0) {
            ArrayList<Square> list1 = new ArrayList<>();
            ArrayList<Square> list2 = new ArrayList<>();

            int x = animal.getPosX();
            int y = animal.getPosY();

            Square tempSq = new Square(0, 0);
            boolean hasEmptySq = false;

            //On liste les 9 cases possibles du conjoint.
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    list1.add(new Square(i, j));
                }
            }

            //SUPPRIMER LES CAS IMPOSSIBLES !!!!
            for (int z = 0; z < 9; z++) {
                if (!(list1.get(z).getX() < 0 || list1.get(z).getX() >= m.getSizeX())) {
                    if (!(list1.get(z).getY() < 0 || list1.get(z).getY() >= m.getSizeY())) {
                        list2.add(list1.get(z));

                    }
                }
            }

            for (int i = 0; i < list2.size(); i++) {
                //Dans la liste des cases si il y en a une vide on la garde pour ajouter le bébé
                if (!hasEmptySq) {
                    
                    if (m.world[list2.get(i).getX()][list2.get(i).getY()].getNumberOfAnimals()==0) {
                        tempSq.setX(list2.get(i).getX());
                        tempSq.setY(list2.get(i).getY());
                        hasEmptySq = true;
                        break ;
                    }
                }
            }

            //Si il n'y en a pas alors on ne fais rien
            if (hasEmptySq) {
                end : for (int n = 0; n < list2.size(); n++) {
                    //AJOUTER UN FOR QUI PARCOURS LA LISTE DES ANIMAUX ET QUI TEST
                    for (int j = 0; j < m.getListAnimals().size(); j++) {

                        //On cherche l'animal correspondant aux coord
                        if (m.getAnimal(j).getPosX() == list2.get(n).getX() && m.getAnimal(j).getPosY() == list2.get(n).getY()) {
                            
                            if (m.getAnimal(j).getSex() && m.getAnimal(j) instanceof Wolf && m.getAnimal(j).getReproductivity() == 0) {
                                System.out.println("Nouveau bébé loup en : "+tempSq.getX()+" "+ tempSq.getY());
                                Wolf wolf = new Wolf(tempSq.getX(), tempSq.getY(), m);
                                wolf.resetReproductivity();
                                m.getListAnimals().add(wolf);
                                
                                m.world[tempSq.getX()][tempSq.getY()].setNumberOfAnimals(1);
                                
                                m.setNbWolfs(m.getNbWolfs()+1);
                                m.notifyObserver();
                                animal.resetReproductivity();
                                break end;
                            }
                        }

                    }
                }
            }

        }

    }
}
