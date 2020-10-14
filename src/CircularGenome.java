
public class CircularGenome {
  // two Nucleotide pointers for head and tail
  Nucleotide head;
  Nucleotide tail;
  
  // constructor populates the head and tail pointer with Nucleotides
  // should use charAt and toUpperCase
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
  
  // output a linearized version of the circular genome, use the pointers to know when youve made one rotation
  // no need to change case here, will always output in all caps
  public String toString() {
    Nucleotide current = head;
    String rtn = "";

    // note this could also be done with a do-while rather than a while true 
    // this other method is shown in match
    while(true) {
      rtn += current.getChar();
      if(current == tail) break;
      else current = current.next;
    }
    
    return rtn;
  }
  
  /* checks each position as a possible start location either returns:
   *    "'<all caps search>' found at position(s) #, #...." 
   *         or 
   *   "'<all caps search>' not found"
   * 
   *    should use toUpperCase and match but no need for charAt in this method
   */
  public String search(String inSequence) {
    String allCapsSequence = inSequence.toUpperCase();
    String foundString = "";
    Nucleotide current = head;
    int pos = 1;
    
    // note that without a do while you could have a while(true) then an if(current == tail) break; as above
    do {
      
      // if it matches at this position
      if(current.match(allCapsSequence)) {
        
        // if this is the first position thats matched populate the foundString
        if(foundString.length()==0) {
          foundString = "'" + allCapsSequence +"' found at position(s) " + String.valueOf(pos);
          
        // otherwise just append the new position
        }else {
          foundString += ", " + String.valueOf(pos);
        }
      }
      
      // increments the pointer and the counter
      current = current.next;
      pos++;
      
    // this loop only makes one pass, the match can go beyond the current position though
    } while(current!=head);
    
    if(foundString.length()==0) {
      return "'" + allCapsSequence +"' not found";
    }else {
      return foundString;
    }
  }
}
