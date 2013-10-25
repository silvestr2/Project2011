import java.util.Vector;
import java.util.Hashtable;

/**
 * Class in which the hashtable is managed. 
 */
public class BookIndex {

	Hashtable<String,IndexedWord> hw=new Hashtable<String,IndexedWord>();
	Vector<String> sentences=new Vector<String>();
	StringBuilder currentSentence;

	/**
	 * Constructor for the class that takes no parameters
	 */
	public BookIndex(){
		currentSentence=new StringBuilder();
		sentences.add("\n");
	}

	/**
	 * Method that is responsible for mapping the hashtable. It assigns
	 * values to the keys, defines what is the end of a sentence, splits a 
	 * sentence into words, when it comes to a space and adds additional 
	 * information to the values in hashtables.
	 * @param nextLine where a word ends
	 * @param number line number
	 */
	public void lineAdding(String nextLine, int number) {
		String[] tokens=nextLine.split(" ");

		for(int i=0;i<tokens.length;i++){

			String token=tokens[i];
			if(token.length()>1){
				currentSentence.append(" "+token);
				char endChar=token.charAt(token.length()-1);
				if(endChar=='.' || endChar==';' || endChar=='?' || endChar=='!'){
					sentences.add(currentSentence.toString());
					currentSentence=new StringBuilder();
				}
			}

			token=this.filterToken(tokens[i]);

			if(token!=null){
				IndexedWord word=hw.get(token);

				if(word==null){
					word=new IndexedWord(token);
					hw.put(token,word);
				}
				word.addline(number);
				word.addSentence(sentences.size());
			}
		}

	}

	/**
	 * Method that filters the words in a provided text
	 * to get rid of the punctuation. It checkes if the character
	 * are letters or digits or if there is a " ' " in the word, which
	 * can also be a part of the word 
	 * @param token the word being filtered
	 * @return  returns a filtered word
	 */
	public static String filterToken(String token){
		StringBuilder filtered=new StringBuilder("");
		token=token.toLowerCase();

		for(int i=0;i<token.length();i++){
			if(Character.isLetterOrDigit(token.charAt(i)))
				filtered.append(token.charAt(i));
			else if(i>=1 && token.charAt(i)=='\'')
				filtered.append(token.charAt(i));
		}
		if(filtered.length()==0) return null;
		if(!Character.isLetterOrDigit(filtered.charAt(0))) return null;

		return filtered.toString();
	}
}
