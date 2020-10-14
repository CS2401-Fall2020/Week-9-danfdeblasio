
public class CircularGenome {
  Nucleotide head;
  Nucleotide tail;
  
  CircularGenome(String inGenome){
    String allCapsGenome = inGenome.toUpperCase();
    head = new Nucleotide(allCapsGenome.charAt(0));
    tail = head;
    for(int i=1;i<allCapsGenome.length();i++) {
      tail.next = new Nucleotide(allCapsGenome.charAt(i));
      tail = tail.next;
    }
    tail.next = head;
  }
  
  public String toString() {
    Nucleotide current = head;
    String rtn = "";
    do{
      rtn += current.getChar();
      current = current.next;
    } while(current != head);
    
    return rtn;
  }
  
  public String search(String inSequence) {
    String allCapsSequence = inSequence.toUpperCase();
    String foundString = "";
    Nucleotide current = head;
    int pos = 1;
    do {
      if(current.match(allCapsSequence)) {
        if(foundString.length()==0) {
          foundString = "'" + allCapsSequence +"' found at position(s) " + String.valueOf(pos);
        }else {
          foundString += ", " + String.valueOf(pos);
        }
      }
      current = current.next;
      pos++;
    } while(current!=head);
    
    if(foundString.length()==0) {
      return "'" + allCapsSequence +"' not found";
    }else {
      return foundString;
    }
  }
}
