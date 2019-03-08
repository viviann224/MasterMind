//Player.java vtn000 && NNC94

//////////////////////////////////////////////////////////////////////////////
//This is the code to check if the user used 4 chars in their guess && if it is
//one of the choices listed. it also has a method which returns the user's guess.
///////////////////////////////////////////////////////////////////////////////

/*  Student information for assignment
 *
 *  On <our> honor, <Nguyen Chau> and <Vivian Nguyen>,
 *  this programming assignment is <our> own work.
 *
 *  Student #1:
 *  Name #1:Nguyen Chau
 *  EID #1:NNC94
 *  email address #1:chaungocnguyen30@yahoo.com
 *  TA name #1:Joseph
 *  Unique course ID #1:56380
 *  programming hours #1: 11
 *
 *  Student #2:
 *  Name #2: Vivian Nguyen
 *  EID #2: vtn000
 *  email address #2: truecolormix@mail.utexas.edu
 *  TA name #2: Joseph
 *  Unique course ID #2: 56400
 *  programming hours #2:  16
 *
 * Lines of Code:99
 */

import java.util.Scanner;

public class Player {
    
    private String guess;
    private Computer c = new Computer();
    public Player(){};
    
    /*
     * inputGuess uses the user output to check precondions if the letters are B,G, O, P, R, Y
     * if they are then the user can use their guess to check against the secret code.
     * if it is not B,G,O,P,R,Y then the output shall be entered as an invalid input
     */
    
    void inputGuess(){
        
        
        boolean goodlength = false;
        boolean rightchars = false;
        
        while (!(goodlength && rightchars))
        {
            Scanner input = new Scanner( System.in);
            System.out.print("\nPlease choose four letters out of BGOPRY: ");
            
            guess = input.nextLine();         // the user's input
            guess=guess.toUpperCase();          //makes guess not case sensitive.
            
            assert (guess.length()<=4)  :  "inputGuess: MAX LENGTH can only be 4 chars or less.";
            
            //check input
            if (guess.length() == 4)            /////////////////////////////////////////////
            {                                    //a check method checks if the chars that the
                goodlength = true;            //user gives is a valid choice. if not
                rightchars = true;            //an error prompting message shows up.
                int i;                        ////////////////////////////////////////////
                for(i=0; i <  guess.length (); i++)
                {
                    char check = guess.charAt(i); // go to each character within the string
                    
                    switch (check)
                    {
                        case 'B':
                            break;
                        case 'G':
                            break;
                        case 'O':
                            break;
                        case 'P':
                            break;
                        case 'R':
                            break;
                        case 'Y':
                            break;
                        default:
                            rightchars = false;   // found a character not within the range,
                            System.out.println("invalid input," + "Please enter four letters out of BGOPRY: ");
                    }
                }
            }
        }
    }                                    ////////////////////////////
                                        //returns the user's guess.
    public String g()                   ////////////////////////////
    {
        return guess;
    }
}
