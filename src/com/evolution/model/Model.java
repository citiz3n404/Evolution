package com.evolution.model;

import com.evolution.observer.Observable;
import com.evolution.observer.Observer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Model of the MVC
 *
 * @author Anthony
 */
public class Model implements Observable, CONSTANTS {
    //**************************************************************************
    // VARIABLES
    //**************************************************************************

    public Square[][] world;

    private int sizeX; // Lines of the grid
    private int sizeY; // Columns of the grid

    //VARIABLES DE VERIFS
    private int nbSquare;
    private int nbAnimals;
    private int nbElements;

    private int nbWolfs;
    private int nbSheeps;
    private int nbGrass;
    private int nbMinerals;
    private int nbLaps;

    public boolean validWorld = false;
    public boolean[] validBtn;

    private ArrayList<Animal> animal = new ArrayList<>();
    private ArrayList<Square> square = new ArrayList<>();
    private ArrayList<AnimalBis> animalCopy = new ArrayList<>();

    private ArrayList<Observer> observer = new ArrayList<>();

    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    /**
     * Constructor of the model
     */
    public Model() {
        sizeX = 0;
        sizeY = 0;
        nbSquare = 0;
        nbWolfs = 0;
        nbSheeps = 0;
        nbGrass = 0;
        nbMinerals = 0;
        /**
         * 0-init / 1-play /2-save /3-reset /4-quit
         */
        validBtn = new boolean[5];
        setBtn(1, true);
        setBtn(2, true);
        setBtn(3, true);

    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    /**
     * Reset all parameters of the model
     */
    public void resetModel() {
        animal.clear();
        square.clear();

        sizeX = 0;
        sizeY = 0;
        nbSquare = 0;
        nbWolfs = 0;
        nbSheeps = 0;
        nbGrass = 0;
        nbMinerals = 0;
        nbLaps = 0;

        nbAnimals = 0;
        nbSquare = 0;
        nbElements = 0;

        validWorld = false;

        notifyObserver();
    }

    /**
     * Save parmeters of the model into the path
     *
     * @param path String wich contains the path
     */
    public void saveModel(String path) {
        ObjectOutputStream output;

        try {
            output = new ObjectOutputStream(new FileOutputStream(path));
            output.writeInt(123456789);
            output.writeInt(sizeX);
            output.writeInt(sizeY);
            output.writeInt(nbSquare);
            output.writeInt(nbWolfs);
            output.writeInt(nbSheeps);
            output.writeInt(nbGrass);
            output.writeInt(nbMinerals);
            output.writeInt(nbLaps);
            output.writeInt(animal.size());

            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    output.writeObject(world[i][j]);
                }
            }

            for (int z = 0; z < animal.size(); z++) {
                animalCopy.add(new AnimalBis());
                animalCopy.get(z).alive = animal.get(z).alive;
                animalCopy.get(z).hunger = animal.get(z).hunger;
                animalCopy.get(z).lifeTime = animal.get(z).lifeTime;
                animalCopy.get(z).posX = animal.get(z).posX;
                animalCopy.get(z).posY = animal.get(z).posY;
                animalCopy.get(z).reproductivity = animal.get(z).reproductivity;
                animalCopy.get(z).sex = animal.get(z).sex;

                if (animal.get(z) instanceof Wolf) {
                    animalCopy.get(z).animal = 1;
                } else {
                    animalCopy.get(z).animal = 2;
                }
            }

            output.writeObject(animalCopy);

            System.out.println("SAVE SUCCEED !");

        } catch (IOException ex) {
            System.out.println("SAVE FAILED !");
        }
    }

    /**
     * Method that load parameters in a file into the model
     *
     * @param path String that contains the path of the file to load
     */
    public void loadModel(String path) {
        ObjectInputStream input;

        try {
            input = new ObjectInputStream(new FileInputStream(path));

            int tempInt;
            tempInt = input.readInt();

            if (tempInt == 123456789) {
                resetModel();
                validWorld = true;
                
                sizeX = input.readInt();
                sizeY = input.readInt();
                nbSquare = input.readInt();
                nbWolfs = input.readInt();
                nbSheeps = input.readInt();
                nbGrass = input.readInt();
                nbMinerals = input.readInt();
                nbLaps = input.readInt();
                int listSize = input.readInt();

                nbAnimals = nbWolfs + nbSheeps;
                nbElements = nbGrass + nbMinerals;
                nbSquare = sizeX + sizeY;

                world = new Square[sizeX][sizeY];

                for (int i = 0; i < sizeX; i++) {
                    for (int j = 0; j < sizeY; j++) {
                        try {
                            world[i][j] = (Square) input.readObject();
                        } catch (ClassNotFoundException ex) {
                            System.out.println("ERREUR LORS DE LA LECTURE DES CASES DU WORLD");
                        }
                    }
                }

                ArrayList<AnimalBis> animalBis;
                try {
                    animalBis = (ArrayList<AnimalBis>) input.readObject();
                    for (int z = 0; z < listSize; z++) {
                        if (animalBis.get(z).animal == 1) {
                            animal.add(new Wolf(animalBis.get(z).posX, animalBis.get(z).posY, this));
                        } else {
                            animal.add(new Sheep(animalBis.get(z).posX, animalBis.get(z).posY, this));
                        }
                        animal.get(z).alive = animalBis.get(z).alive;
                        animal.get(z).hunger = animalBis.get(z).hunger;
                        animal.get(z).lifeTime = animalBis.get(z).lifeTime;
                        animal.get(z).reproductivity = animalBis.get(z).reproductivity;
                        animal.get(z).sex = animalBis.get(z).sex;
                    }
                    System.out.println("MODEL LOADING SUCCEED !");

                    setBtn(1, false);
                    setBtn(2, false);
                    setBtn(3, false);

                    validWorld = true;

                } catch (ClassNotFoundException ex) {
                    System.out.println("LOADING FAILED !");
                }

            } else {
                System.out.println("ERREUR DE FICHIER");
            }

        } catch (IOException ex) {
            System.out.println("WORLD LOADING FAILED !");
        }

    }

    /**
     * Create the table of Square with the good coordinates
     */
    public void initUniverse() {
        System.out.println("initUniverse()");
        world = new Square[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                world[x][y] = new Square(x, y);
            }
        }
    }

    /**
     * Create an arrayList with all the squares in the created world, this
     * method is mainly used for le placement of animals doing a random without
     * "remise"
     */
    public void initSquarePossibilities() {
        square.clear();
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                square.add(new Square(x, y)); // CASES POSSIBLES
            }
        }
    }

    /**
     * Methods that create animals using square list created by
     * initSquarePossibilities, it use a random number to select the square of
     * each animal and then remove de square in the list to don't allow animal
     * to be on another one
     */
    public void initAnimals() {
        int rand;
        Square sq;
        int cmpt = 0;

        initSquarePossibilities();
        // On tire sans remise dans la liste.
        for (int i = 0; i < nbAnimals; i++) {

            rand = randInt(0, square.size() - 1);
            sq = square.get(rand);

            if (i < nbSheeps) {
                animal.add(new Sheep(sq.getX(), sq.getY(), this));
                world[sq.getX()][sq.getY()].setNumberOfAnimals(1);

            } else {
                animal.add(new Wolf(sq.getX(), sq.getY(), this));
                world[sq.getX()][sq.getY()].setNumberOfAnimals(1);
            }
            square.remove(rand);

        }

    }

    /**
     * This methods was only for debugging, it print to the console the number
     * of animal per square
     *
     * @deprecated
     */
    public void afficheNbAnimals() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print(world[j][i].getNumberOfAnimals() + " ");
            }
            System.out.println();
        }
    }

    /**
     * This method do a move, a birthday, a meal and baby if it's possible on
     * all the list of animals
     */
    public void moveAnimals() {

        for (int i = 0; i < animal.size(); i++) {

            animal.get(i).birthday();

            if (animal.get(i).alive) {
                animal.get(i).makeABaby();
                animal.get(i).makeAMove();
                animal.get(i).haveAMeal();
            }
        }

        notifyObserver();
    }

    /**
     * Method unused becauseof a problem
     */
    public void playSimulation() {
        // do{

        /* setNbLaps(getNbLaps() +1);
         moveAnimals();
         growGrass();
         removeDeads();*/
        //notifyObserver();
        //}while(!animal.isEmpty());
    }

    /**
     * Method that play de turn moving animals,growing grass and removing deads
     */
    public void playATurn() {

        System.out.println("\n*****************\n* Tour : " + (nbLaps+1) + "\n*****************");
        setNbLaps(getNbLaps() + 1);

        moveAnimals();
        growGrass();
        removeDeads();
        //afficheNbAnimals();

        if (animal.isEmpty() && nbMinerals == 0) {
            setBtn(1, true);
            System.out.println("UNIVERS MORT");
        }

        notifyObserver();

    }

    /**
     * Method that grow grass on square that there is minerals
     */
    public void growGrass() {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (world[x][y].getMinerals()) {
                    world[x][y].addGrass();
                    nbGrass++;
                    nbMinerals--;
                }
            }
        }
    }

    /**
     * Remove dead animals from the arraylist of animals
     */
    public void removeDeads() {
        for (int i = 0; i < animal.size(); i++) {
            if (!animal.get(i).alive) {

                if (!world[animal.get(i).getPosX()][animal.get(i).getPosY()].getGrass()) {
                    nbMinerals++;
                }

                world[animal.get(i).getPosX()][animal.get(i).getPosY()].addMinerals();

                if (animal.get(i) instanceof Wolf) {
                    System.out.println("Loup mort");
                    nbWolfs--;

                    notifyObserver();
                } else if (animal.get(i) instanceof Sheep) {
                    System.out.println("Mouton mort");
                    nbSheeps--;

                    notifyObserver();
                }
                world[animal.get(i).getPosX()][animal.get(i).getPosY()].setNumberOfAnimals(world[animal.get(i).getPosX()][animal.get(i).getPosY()].getNumberOfAnimals() - 1);

                animal.remove(animal.get(i));

            }
        }
    }

    /**
     * @deprecated
     *
     */
    public void sleep() {


        /*   try {
         Thread.sleep(1000);
         } catch (InterruptedException ie) {
         }*/
    }

    /**
     * Place grass and minerals on the world
     */
    public void initElements() {
        int rand;
        Square sq;

        initSquarePossibilities();
        // On tire une case sans remise dans la liste.
        for (int i = 0; i < nbGrass + nbMinerals; i++) {

            rand = randInt(0, square.size() - 1);
            sq = square.get(rand);

            if (i < nbGrass) {
                world[sq.getX()][sq.getY()].addGrass();
            } else {
                world[sq.getX()][sq.getY()].addMinerals();
            }
            square.remove(rand);

        }

    }

    /**
     * FONCTION QUE J'AI TROUVE SUR INTERNET Returns a psuedo-random number
     * between min and max, inclusive. The difference between min and max can be
     * at most <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimim value
     * @param max Maximim value. Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * Return the sizeY means the number of lines
     *
     * @return int sizeX
     */
    public int getSizeX() {
        return sizeX;
    }

    /**
     * Return the sizeY means the number of columns
     *
     * @return int sizeY
     */
    public int getSizeY() {
        return sizeY;
    }

    /**
     * Return the number of Wolfs in the universe
     *
     * @return int nbWolfs
     */
    public int getNbWolfs() {
        return nbWolfs;
    }

    /**
     * Return the number of Sheeps in the universe
     *
     * @return int nbSheeps
     */
    public int getNbSheeps() {
        return nbSheeps;
    }

    /**
     * Return the number of grass in the universe
     *
     * @return int nbGrass
     */
    public int getNbGrass() {
        return nbGrass;
    }

    /**
     * Return the number of minerals in the universe
     *
     * @return int nbMinerals
     */
    public int getNbMinerals() {
        return nbMinerals;
    }

    /**
     * Return the number of square in the universe
     *
     * @return int nbSqure
     */
    public int getNbSquare() {
        return nbSquare;
    }

    /**
     * Return the number of animals on the universe
     *
     * @return int nbAnimals
     */
    public int getNbAnimals() {
        return nbAnimals;
    }

    /**
     * Return the animal in the place int i on the arrayList
     *
     * @param i int
     * @return Animal
     */
    public Animal getAnimal(int i) {
        return animal.get(i);
    }

    /**
     * Return the arrayList of animals
     *
     * @return ArrayList of Animal
     */
    public ArrayList<Animal> getListAnimals() {
        return animal;
    }

    /**
     * Return the size of the ArrayList of Animals
     *
     * @return int size of the ArratList of animals
     */
    public int getSizeAnimal() {
        return animal.size();
    }

    /**
     * Return the current number of corresponding lap
     *
     * @return int nbLaps
     */
    public int getNbLaps() {
        return nbLaps;
    }

    /**
     * Set the n button of the Arrray on enabled or not using a boolean
     *
     * @param n int Place of the boolean corresponding to the button
     * @param bool boolean used to set the button
     */
    public void setBtn(int n, boolean bool) {
        validBtn[n] = bool;
        notifyObserver();
    }

    /**
     * Set the sizeX and notify observers
     *
     * @param x int
     */
    public void setSizeX(int x) {
        this.sizeX = x;
        notifyObserver();
    }

    /**
     * Set the sizeY and notify observers
     *
     * @param y int
     */
    public void setSizeY(int y) {
        this.sizeY = y;
        notifyObserver();
    }

    /**
     * Set the number of wolfs and notify observers
     *
     * @param w int
     */
    public void setNbWolfs(int w) {
        this.nbWolfs = w;
        notifyObserver();
    }

    /**
     * Set the number of sheeps and notify observers
     *
     * @param s int
     */
    public void setNbSheep(int s) {
        this.nbSheeps = s;
        notifyObserver();
    }

    /**
     * Set the number of grass and notify observers
     *
     * @param g int
     */
    public void setNbGrass(int g) {
        this.nbGrass = g;
        notifyObserver();
    }

    /**
     * Set the number of minerals and notify observers
     *
     * @param m int
     */
    public void setNbMinerals(int m) {
        this.nbMinerals = m;
        notifyObserver();
    }

    /**
     * Set the number of laps and notify observers
     *
     * @param l int
     */
    public void setNbLaps(int l) {
        this.nbLaps = l;
        notifyObserver();
    }

    /**
     * Set the number of squares and notify observers
     *
     * @param s int
     */
    public void setNbSquare(int s) {
        this.nbSquare = s;
    }

    /**
     * Set the number of Elements means grass + minerals and notify observers
     *
     * @param e int
     */
    public void setNbElements(int e) {
        this.nbElements = e;
    }

    /**
     * Set the number of animals
     *
     * @param a int
     */
    public void setNbAnimals(int a) {
        this.nbAnimals = a;
    }

    /**
     * Remove an animal from the ArrayList of animals
     *
     * @param a Animal
     */
    public void removeAnimal(Animal a) {
        animal.remove(a);
    }

    /**
     * Pattern Observer add and observer to the ArrayList
     *
     * @param o Observer
     */
    @Override
    public void registerObserver(Observer o) {
        observer.add(o);
        System.out.println("Added observer");
    }

    /**
     * Pattern Observer remove and Observer from the ArrayList
     *
     * @param o Observer
     */
    @Override
    public void deleteObserver(Observer o) {
        observer.remove(o);
    }

    /**
     * Pattern Observer, notify all observers to do a update()
     */
    @Override
    public void notifyObserver() {

        for (Observer observer1 : observer) {
            observer1.update();
        }
    }

}
