import java.util.Random;

public class Die {
    private static final Random Generator = new Random();                   //returnerar ett slumpmässigt heltal mellan 0 och (maxValue-1).
    private int value= 0;                                                  //nuvarandevärde
    private int sides;                                                     //antalsidor
    private static int staticInt;



    //konstructor
    public Die(int sides){
        this.sides =sides;
        roll();
    }


    public void roll() {
        value = Generator .nextInt(sides - 1+1)+1;               //random.nextInt(max-min+1)+min


    }

    public int getSides (int sides) {

        return this.sides;
    }

    public int getValue() {
        return value;
    }


}
