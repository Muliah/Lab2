import java.util.ArrayList;

public class Player {
    //instansvariabler
    public String name;
    public int score;
    ArrayList<Die> dice;

    //constructor
    Player(String name, int i){
        this.name = name;
        this.dice = new ArrayList<>() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getScore () {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void rollDice() {                                     // den skall slumpa fram ett nummer på tärningen
        for (Die d:dice) {
            d.roll();
        }
    }

    /* int sizeOfList = dice.size();
        for (int i = 0; i < sizeOfList; i++) {
            Dice d = dice.get(i);
            d.roll();*/



    public int getDieValue() {
        int sum = 0;
        for (Die d:dice) {                                      //Skall summera och returnera värdet på spelarens alla tärningar
            sum += d.getValue();
        }
        return sum;
    }



   public void increaseScore(){                                        // Skall öka spelarens poäng med ett
       score ++;
   }


    public void addDie(Die d){
                                                                // Skapar en ny tärning med sidor sides och lägger till den till spelaren
        dice.add(d);

    }

}
