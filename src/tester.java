
public class tester {
  public static void main(String[] args){
    
    /*
     * Example from README (see text for description)
     *
     */
    CircularGenome banana = new CircularGenome("banana");
    
    System.out.println(banana.toString());
    assert(banana.toString().equals("BANANA"));
    
    System.out.println(banana.search("ana"));
    assert(banana.search("ana").equals("'ANA' found at position(s) 2, 4"));
    
    System.out.println(banana.search("nab"));
    assert(banana.search("nab").equals("'NAB' found at position(s) 5"));
    
    System.out.println(banana.search("bananabanana"));
    assert(banana.search("bananabanana").equals("'BANANABANANA' found at position(s) 1"));
    
    System.out.println(banana.search("bananas"));
    assert(banana.search("bananas").equals("'BANANAS' not found"));
    
    /*
     * Insert your test cases here
     */
    
    System.out.println("All assert tests passed");
  }
}
