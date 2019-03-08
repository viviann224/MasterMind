//Computer.java vtn000 && NNC94

//////////////////////////////////////////////////////////////////////////////
//Works on the code. sets values for it, makes it, clears the code, print,
//and gets the code.
//////////////////////////////////////////////////////////////////////////////

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
 * Lines of Code: 78
 */

import java.util.Random;
public class Computer
{
    private char[] Code;
    private Random randomCode = new Random();
    private char[] Code1 = new char[6];
    private String result="";
    
    public Computer()
    {                                //////////////////////////////////////////////////
        Code1[0] = 'B';                //initialize a value to each index with a char.
        Code1[1] = 'G';                /////////////////////////////////////////////////
        Code1[2] = 'O';
        Code1[3] = 'P';
        Code1[4] = 'R';
        Code1[5] = 'Y';
        
        Code = new char[4];
    }
    
    public  String createCode()            /////////////////////////////////////////////////
    {        for(int x=0; x<4; x++)        //Randomize the indices to generate random colors!
    {                                ///////////////////////////////////////////////
        int y=randomCode.nextInt(6);
        Code[x] = Code1[y];
        result+=Code[x];
    }
        return result;
    }
    
    public String clearCode()
    {                                    ////////////////////////////////////////////////////
        for(int x=0; x<4;x++)            //clears the code to recreate another secret code.
            result="";                    ///////////////////////////////////////////////////
        return result;
    }
    
    public void printCode()
    {                                                    ////////////////////////////////////////
        System.out.print("\nYour Code is: " +result);    //this method prints out the secret code
    }                                                    ////////////////////////////////////////
    
    public String getCode()                    //////////////////////////////////////
    {    String test = new String(Code);        //this method gets the secret code.
        return test;                            ////////////////////////////////////
    }
}
