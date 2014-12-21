package com.evolution.model;

import com.evolution.observer.Observable;
import com.evolution.observer.Observer;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
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

    //STATUT DES BOUTONS
    public boolean buttonStart;
    public boolean buttonValidate;
    public boolean validWorld = false;

    private ArrayList<Animal> animal = new ArrayList<>();
    private ArrayList<Square> square = new ArrayList<>();

    private ArrayList<Observer> observer = new ArrayList<>();

    //**************************************************************************
    // CONSTRUCTOR
    //**************************************************************************
    public Model() {
        sizeX = 0;
        sizeY = 0;
        nbSquare = 0;
        nbWolfs = 0;
        nbSheeps = 0;
        nbGrass = 0;
        nbMinerals = 0;
        buttonStart = false;
    }

    //**************************************************************************
    // METHODS
    //**************************************************************************
    public void initUniverse() {
        System.out.println("initUniverse()");
        world = new Square[sizeX][sizeY];

        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                world[x][y] = new Square(x, y);
            }
        }
    }

    public void initSquarePossibilities() {
        square.clear();
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                square.add(new Square(x, y)); // CASES POSSIBLES
            }
        }
    }

    /**
     * Fonction qui ajoute des animaux en tirant aléatoirement dans la liste des
     * cases possibles restantes.
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

            if (i < nbWolfs) {
                animal.add(new Wolf(sq.getX(), sq.getY(), this));
                world[sq.getX()][sq.getY()].setHasAnimal(true);

            } else {
                animal.add(new Sheep(sq.getX(), sq.getY(), this));
                world[sq.getX()][sq.getY()].setHasAnimal(true);

            }
            square.remove(rand);

        }

    }

    public void afficheListeAnimals() {
        for (int i = 0; i < animal.size(); i++) {
            if (animal.get(i) instanceof Sheep) {
                System.out.println(i + " SHEEP COORD : X=" + animal.get(i).getPosX() + " Y=" + animal.get(i).getPosY());

            } else {
                System.out.println(i + " WOLF  COORD : X=" + animal.get(i).getPosX() + " Y=" + animal.get(i).getPosY());
            }

        }
    }

    public void moveAnimals() {
        
        for (int i = 0; i < animal.size(); i++) {
            animal.get(i).behaviorMove.move(animal.get(i));
        }

        notifyObserver();
    }

    public void sleep() {
        

        /*   try {
        Thread.sleep(1000);
        } catch (InterruptedException ie) {
        }*/
    }

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

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getNbWolfs() {
        return nbWolfs;
    }

    public int getNbSheeps() {
        return nbSheeps;
    }

    public int getNbGrass() {
        return nbGrass;
    }

    public int getNbMinerals() {
        return nbMinerals;
    }

    public int getNbSquare() {
        return nbSquare;
    }

    public int getNbAnimals() {
        return nbAnimals;
    }

    public Animal getAnimal(int i) {
        return animal.get(i);
    }
    
    public ArrayList<Animal> getListAnimals(){
        return animal;
    }

    public int getSizeAnimal() {
        return animal.size();
    }

    public void setSizeX(int x) {
        this.sizeX = x;
        notifyObserver();
    }

    public void setSizeY(int y) {
        this.sizeY = y;
        notifyObserver();
    }

    public void setNbWolfs(int w) {
        this.nbWolfs = w;
        notifyObserver();
    }

    public void setNbSheep(int s) {
        this.nbSheeps = s;
        notifyObserver();
    }

    public void setNbGrass(int g) {
        this.nbGrass = g;
        notifyObserver();
    }

    public void setNbMinerals(int m) {
        this.nbMinerals = m;
        notifyObserver();
    }

    public void setNbSquare(int s) {
        this.nbSquare = s;
    }

    public void setNbElements(int e) {
        this.nbElements = e;
    }

    public void setNbAnimals(int a) {
        this.nbAnimals = a;
    }

    @Override
    public void registerObserver(Observer o) {
        observer.add(o);
        System.out.println("Added observer");
    }

    @Override
    public void deleteObserver(Observer o) {
        observer.remove(o);
    }

    @Override
    public void notifyObserver() {

        for (Observer observer1 : observer) {
            observer1.update();
        }
    }

}
