//Game.java vtn000 && NNC94

/////////////////////////////////////////////////////////////////////////////
//checks the game && starts, stops && runs the game. it also keep track of
//the white and black pegs.
/////////////////////////////////////////////////////////////////////////////

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
 * Lines of Code: 158
 */

import java.util.Scanner;
import java.lang.StringBuffer;

public class Game {
    
    private Player p;
    private Computer c;
    private Board b;
    private boolean showCode;
    private int Black ;
    private int White;
    private boolean done=true;
    
    public Game(boolean easy)
    {
        showCode = easy;
        p = new Player();
        c = new Computer();
        b = new Board();
        Black=0;
        White=0;
    }
    
    public void checkGuess()                            ////////////////////////////////////////////////////////////////
    {                                                //this is a check message  to check each
        for(int x=0; x<12 && done; x++)                    //char of the guess && code location
        {                                                //&& compares them to see if there is
            if(showCode)                                    //a black peg or white peg counter that needs to be updated.
                c.printCode();                            ////////////////////////////////////////////////////////////////
            
            p.inputGuess(); // call method player to have the user to input guess
            b.printBoard();
            
            White=0;            //resets the the white counter.
            Black=0;            //resets the black counter.
            
            StringBuffer guess = new StringBuffer (p.g());
            StringBuffer Code = new StringBuffer (c.getCode());
            b.changeBoard(guess);
            b.addRow(guess);
            for(int i = 0; i < guess.length(); i++)
            {                                                    ///////////////////////////////////////////////////////////////////
                String first= ""+guess.charAt(i);                //temp string that contain the characters for the ith index.
                int firstCode = Code.indexOf(first);             //search one char of the guess to see if it matches with the code.
                //if true go to if statements.
                if(firstCode != -1)                                //if indexOf returns -1 then it means there are no matches.
                {                                                /////////////////////////////////////////////////////////////////////
                    if(Code.charAt(i)==guess.charAt(i))
                    {                                                    ///////////////////////////////////////////////////////////////////////
                        Black+=1;                                        //so if the loc of the guess and code is right update the black counter
                        Code.setCharAt(i,'0');                            //this is the StringBuffer method that goes back to the 0 index.
                    }                                                    //////////////////////////////////////////////////////////////////////
                    else if(Code.charAt(firstCode)==guess.charAt(firstCode))
                    {
                        Black+=1;                                            //it moves the pointer to the next index so you do not check twice.
                        Code.setCharAt(firstCode,'0');
                    }
                    else if(firstCode!=i)                                    //checks if the location of the firstCode does not equal the current i.
                    {
                        White+=1;                                            //if the code is right, but the index location is wrong than update the white counter.
                        Code.setCharAt(firstCode,'0');
                    }
                }
                
            }
            
            if(Black==4)            //if black is 4 then we are done with the game.
                done=false;
            
            System.out.println(" \n Black Peg: "+ Black);
            //Black=0;                                     //resets Black.
            System.out.println(" White Peg: "+ White);
            //White=0;                                //resets White.
            System.out.println(" Number of Tries: "+(x+1));
        }
        
        if(Black==4)
        {    System.out.println("\nYour answer Matches the correct answer " + c.getCode());
            System.out.println("\nYou solved the puzzle! Good job.");
            System.out.print("Enter Y for another game or N to quit: ");
            Scanner s = new Scanner( System.in);
            String retry = s.nextLine();                                    //asks user if they want to replay the game or not. by typing y or Y. no N or n for no.
            if(retry.equals("y") || retry.equals("Y")|| retry.equals("YES")|| retry.equals("yes") || retry.equals("Yes"))
                runNewGame();
            
            else if(retry.equals("N")|| retry.equals("n"))
            {
                done=false;
            }
            else
            {
                System.out.println(" invalid charater. Please type in Y or N.");    ////////////////////////////////////////////////////////////////////////////////////////
                retry = s.nextLine();                                                //if they mistyped then they are going to be reprompt to answer with another choice.
            }                                                                        ////////////////////////////////////////////////////////////////////////////////////////
        }
        else
        {    System.out.println("\nYour answer DID NOT Match the correct answer " + c.getCode());        ///////////////////////////////////////////////////////////////////////                                                                                                //you end the game by not answering the right ans in less than 12 turns.
            System.out.println("You did not solve the puzzle. Too bad.");                                //you lost, now you are reprompted to play again or not,
            System.out.print("Enter Y for another game or N to quit: ");                                //////////////////////////////////////////////////////////
            Scanner s = new Scanner( System.in);
            String retry = s.nextLine();
            if(retry.equals("y") || retry.equals("Y"))
                runNewGame();
            
            else if(retry.equals("N")|| retry.equals("n"))
                done=false;
            else
            {
                System.out.println("Please type in Y or N.");
                retry = s.nextLine();
            }
        }
    }
    
    public void runNewGame()
    {                                        /////////////////////////////////////////////////////////////
        Game g = new Game(showCode);                //runs the new game depending on the constructor it will
        g.runGames();                            //show the secret code or not.
    }                                        ////////////////////////////////////////////////////////////////
    public void runGames()
    {
        c.clearCode();            ////////////////////////////////////////////////////////////
        c.createCode();            //to run the game you have to make sure if the code
        checkGuess();            //is clear && then create the code && then check the game.
        ////////////////////////////////////////////////////////////
    }
}
