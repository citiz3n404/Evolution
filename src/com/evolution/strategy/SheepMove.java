package com.evolution.strategy;

import com.evolution.model.Animal;
import com.evolution.model.Model;
import com.evolution.model.Square;
import com.evolution.model.Wolf;
import java.util.ArrayList;

/**
 *
 * @author Anthony
 */
public class SheepMove implements BehaviorMove {

    Model m;

    public SheepMove(Model mParam) {
        m = mParam;
    }

    @Override
    public void move(Animal animal) {
        ArrayList<Square> list1 = new ArrayList<>(); // Cas possibles
        ArrayList<Square> list2 = new ArrayList<>(); // Liste sans les hors zone
        ArrayList<Square> list3 = new ArrayList<>(); // Liste sans animaux
        ArrayList<Square> list4 = new ArrayList<>(); // Liste d'animaux

        int x = animal.getPosX();
        int y = animal.getPosY();
        int tempx;
        int tempy;
        int tempSize;

        //ON liste les 9 list1
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                list1.add(new Square(i, j));

            }
        }
        // L2 contient les cases sans les cas impossibles (hors zone)
        for (int z = 0; z < 9; z++) {
            if (!(list1.get(z).getX() < 0 || list1.get(z).getX() >= m.getSizeX())) {
                if (!(list1.get(z).getY() < 0 || list1.get(z).getY() >= m.getSizeY())) {
                    list2.add(list1.get(z));

                }
            }
        }

        //L3 contient toutes les cases sans animaux
        for (int w = 0; w < list2.size(); w++) {
            tempx = list2.get(w).getX();
            tempy = list2.get(w).getY();

            if ((m.world[tempx][tempy].getNumberOfAnimals() == 0)) {
                list3.add(list2.get(w));
            } else {
                list4.add(list2.get(w));
            }
        }

        // On ajoute 3 de danger à toutes les cases qui ont de l'herbe et qui n'ont pas d'animaux
        for (int i = 0; i < list3.size(); i++) {
            tempx = list3.get(i).getX();
            tempy = list3.get(i).getY();

            if (m.world[tempx][tempy].getGrass()) {
                list3.get(i).setDanger(list3.get(i).getDanger() - 3);
            }
        }

        for (int j = 0; j < list4.size(); j++) {

            for (int z = 0; z < m.getListAnimals().size(); z++) {
                if (list4.get(j).getX() == m.getListAnimals().get(z).getPosX() && list4.get(j).getY() == m.getListAnimals().get(z).getPosY()) {
                    if (m.getListAnimals().get(z) instanceof Wolf) {

                        tempx = m.getListAnimals().get(z).getPosX();
                        tempy = m.getListAnimals().get(z).getPosY();

                        ArrayList<Square> list5 = new ArrayList<>(); // list des possibles pour le loup

                        for (int r = tempx - 1; r <= tempx + 1; r++) {
                            for (int w = tempy - 1; w <= tempy + 1; w++) {
                                list5.add(new Square(r, w));
                            }
                        }

                        //On compare la liste des cases adjacentes au loup avec la liste des cases vides.
                        for (int f = 0; f < list3.size(); f++) {
                            tempx = list3.get(f).getX();
                            tempy = list3.get(f).getY();

                            for (int g = 0; g < list5.size(); g++) {
                                if (list5.get(g).getX() == tempx && list5.get(g).getY() == tempy) {
                                    list3.get(f).setDanger(list3.get(f).getDanger() + 5);
                                }
                            }
                        }

                    } else { // Si c'est un mouton
                        tempx = m.getListAnimals().get(z).getPosX();
                        tempy = m.getListAnimals().get(z).getPosY();

                        ArrayList<Square> list5 = new ArrayList<>(); // list des possibles pour le loup

                        for (int r = tempx - 1; r <= tempx + 1; r++) {
                            for (int w = tempy - 1; w <= tempy + 1; w++) {
                                list5.add(new Square(r, w));
                            }
                        }

                        //On compare la liste des cases adjacentes au loup avec la liste des cases vides.
                        for (int f = 0; f < list3.size(); f++) {
                            tempx = list3.get(f).getX();
                            tempy = list3.get(f).getY();

                            for (int g = 0; g < list5.size(); g++) {
                                if (list5.get(g).getX() == tempx && list5.get(g).getY() == tempy) {
                                    list3.get(f).setDanger(list3.get(f).getDanger() - 2);
                                }
                            }
                        }
                    }

                }
            }

        }

        // La liste 3 est notée en fonction des animaux il ne reste plus qu'a choisir celle avec le plus petit danger.
        Square tempSq = new Square(0,0);

        for (int p = 0; p < list3.size(); p++) {

            if (tempSq.getDanger() > list3.get(p).getDanger()) {
                tempSq = list3.get(p);
            }

        }

        if(!list3.isEmpty()){
            // Ne reste plus qu'a se déplacer sur tempSq
            m.world[x][y].setNumberOfAnimals(m.world[x][y].getNumberOfAnimals() - 1);
            animal.setPosX(tempSq.getX());
            animal.setPosY(tempSq.getY());
            System.out.println("Mouton va en :"+tempSq.getX()+" "+tempSq.getY());
            m.world[tempSq.getX()][tempSq.getY()].setNumberOfAnimals(m.world[tempSq.getX()][tempSq.getY()].getNumberOfAnimals() + 1);
        }
        else{
            System.out.println("Mouton reste sur place");
        }
    }

}
