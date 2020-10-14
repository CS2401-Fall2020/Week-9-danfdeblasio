
public class Nucleotide {
  // Class variables: (private char, public Nucleotide)
  private char base; 
  public Nucleotide next;
  
  // Constructor
  Nucleotide(char inBase){
    base = inBase;
  }
  
  // Getter
  public char getChar() {
    return base;
  }
  
  // recursive match
  //   given a string match the first char if possible, then recursively call on rest of list
  public boolean match(String inSequence) {
    
    // if not equal return false
    if(inSequence.charAt(0) == base) {
      
      // if this is the last thing to check, found the string
      if(inSequence.length() <= 1) return true;
      
      // if more string, trim off front then recursive call
      return next.match(inSequence.substring(1));
    }
    
    return false;
  }
}
