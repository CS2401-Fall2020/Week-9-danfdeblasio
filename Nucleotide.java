
public class Nucleotide {
  private char base; 
  public Nucleotide next;
  
  Nucleotide(char inBase){
    base = inBase;
  }
  
  public char getChar() {
    return base;
  }
  
  public boolean match(String inSequence) {
    if(inSequence.charAt(0) == base) {
      if(inSequence.length() <= 1) return true;
      return next.match(inSequence.substring(1));
    }
    return false;
  }
}
