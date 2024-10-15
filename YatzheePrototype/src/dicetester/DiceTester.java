package dicetester;

/**
 * @author 507606
 */
public class DiceTester 
{
    public static void main(String[] args) 
    {
       Die myDie = new Die(6);
   //    System.out.println("The number you rolled on a single six-sided die was: " + myDie.roll(rand));
       
       Dice myDice = new Dice(5,6);
       
       System.out.println("The sum of five six-sided dice = "+ myDice.roll());
    }
    
}
