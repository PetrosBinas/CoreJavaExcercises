package objects_and_classes;


import java.util.ArrayList;
import java.util.Scanner;

public class DuelGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Character> gladiatorLst =  new ArrayList<>();

        gladiatorLst.add(new Character("Warrior", 120, 25, 15));
        gladiatorLst.add(new Character("Knight", 140, 20, 20));
        gladiatorLst.add(new Character("Barbarian", 110, 35, 8));
        gladiatorLst.add(new Character("Assassin", 80, 40, 5));
        gladiatorLst.add(new Character("Necromancer", 85, 32, 7));

        characterChoice(gladiatorLst);
        ArrayList<Character> gladiatorsToBattle = getGladiatorChoice(sc, gladiatorLst);
        duelLogic(gladiatorsToBattle.get(0), gladiatorsToBattle.get(1));

    }

    static void duelLogic(Character gladiator1, Character gladiator2) {

        while (true) {

            //gladiator1 attacks gladiator2
            int damage2 = gladiator1.getAttackPower() - gladiator2.getDefence();
            int healthg2 = gladiator2.getHealth() - damage2;
            gladiator2.setHealth(healthg2);
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gladiator2.getHealth() < 0) {
                System.out.printf("%s Won, %s Died", gladiator1.getName(), gladiator2.getName());
                break;
            }
            else {
                System.out.printf("%s got %d Damage and has now %d Health!\n", gladiator2.getName(), damage2, gladiator2.getHealth());
            }

            //gladiator2 attacks gladiator1
            int damage1 = gladiator2.getAttackPower() - gladiator1.getDefence();
            int healthg1 = gladiator1.getHealth() - damage1;
            gladiator1.setHealth(healthg1);
            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gladiator1.getHealth() < 0) {
                System.out.printf("%s Won, %s Died", gladiator2.getName(), gladiator1.getName());
                break;
            }
            else {
                System.out.printf("%s got %d Damage and has now %d Health!\n", gladiator1.getName(), damage1, gladiator1.getHealth());
            }

        }
    }

    static void characterChoice(ArrayList<Character> gladiatorLst) {

        int index = 1;
        gladiatorLst.forEach(gladiator -> {
            System.out.printf("%s, Health: %d, Damage: %d, Defence: %d\n", gladiator.getName(), gladiator.getHealth(), gladiator.getAttackPower(), gladiator.getDefence());
        });
    }

    static ArrayList<Character> getGladiatorChoice(Scanner sc, ArrayList<Character> gladiatorLst) {

        Character gladiator1;
        Character gladiator2;
        ArrayList<Character> gladiatorsToBattle = new ArrayList<Character>();
        String name;

        while (true) {
            System.out.println("Type the First Gladiator of Your Choice:");
            try {
                name = sc.next();
                gladiator1 = gladiatorExists(name, gladiatorLst);
                if (gladiator1 == null) {
                    throw new Exception();
                }
                gladiatorsToBattle.add(gladiator1);
                break;
            }
            catch (Exception e) {
                System.out.println("Gladiator name not valid!");
            }
        }

        while (true) {
            System.out.println("Type the Second Gladiator of Your Choice:");
            try {
                name = sc.next();
                gladiator2 = gladiatorExists(name, gladiatorLst);
                if (gladiator2 == null) {
                    throw new Exception();
                }
                gladiatorsToBattle.add(gladiator2);
                break;
            }
            catch (Exception e) {
                System.out.println("Gladiator name not valid!");
            }
        }
        return gladiatorsToBattle;
    }

    static Character gladiatorExists(String glName, ArrayList<Character> gladiatorLst) {

        for (Character gladiator : gladiatorLst) {
            if (gladiator.getName().equalsIgnoreCase(glName.toLowerCase())) {
                return gladiator;
            }
        }
        return null;
    }
}

class Character {

    private String name;
    private int health;
    private int attackPower;
    private int defence;

    //constructor
    public Character(String n, int h, int a, int d) {

        this.name = n;
        this.health = h;
        this.attackPower = a;
        this.defence = d;
    }

    //getters
    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getAttackPower() { return this.attackPower; }
    public int getDefence() { return this.defence; }

    //setters
    public void setName(String n) { this.name = n; }
    public void setHealth(int h) { this.health = h; }
    public void setAttackPower(int a) { this.attackPower = a; }
    public void setDefence(int d) { this.defence = d; }

}
