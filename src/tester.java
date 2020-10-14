
public class tester {
  public static void main(String[] args){
    CircularGenome banana = new CircularGenome("banana");
    System.out.println(banana.toString());
    System.out.println(banana.search("ana"));
    System.out.println(banana.search("nab"));
    System.out.println(banana.search("bananabanana"));
    System.out.println(banana.search("bananas"));
  }
}
