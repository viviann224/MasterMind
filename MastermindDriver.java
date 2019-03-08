/*  Student information for assignment
 *
 *  On <our|my> honor, <Nguyen Chau> and <Vivian Nguyen>,
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
 *  programming hours #2:  11
 *
 * Lines of Code:
 */

public class MastermindDriver {
    
    public static void main(String[] args){
        
        Game g = new Game(true);
        g.runGames();
        g = new Game(false);
        g.runGames();
    }
    
}

