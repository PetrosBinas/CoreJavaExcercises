package objects_and_classes;


import java.util.ArrayList;
import java.util.Scanner;

public class DuelGame {

    static void main() {

        Scanner sc = new Scanner(System.in);

        ArrayList<Character> gladiatorLst =  new ArrayList<>();

        gladiatorLst.add(new Character("Warrior", 120, 25, 15));
        gladiatorLst.add(new Character("Knight", 140, 20, 20));
        gladiatorLst.add(new Character("Barbarian", 110, 35, 8));
        gladiatorLst.add(new Character("Assassin", 80, 40, 5));
        gladiatorLst.add(new Character("Necromancer", 85, 32, 7));

        characterChoice(gladiatorLst);

    }

    static void characterChoice(ArrayList<Character> gladiatorLst) {

        int index = 1;
        gladiatorLst.forEach(gladiator -> {
            System.out.printf("%s, Health: %d, Damage: %d, Defence: %d\n", gladiator.getName(), gladiator.getHealth(), gladiator.getAttackPower(), gladiator.getDefence());
        });
    }

    static void getGladiatorChoice(Scanner sc) {

        
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
