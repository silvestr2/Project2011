import java.util.Vector;

/**
 * Class storing vectors of line and sentence numbers.
 */
public class IndexedWord {
	String bookword;
	Vector<Integer> lines=new Vector<Integer>();
	Vector<Integer> sentences=new Vector<Integer>();

	/**
	 * Constructor for class IndexedWord
	 * @param bookword a word
	 */
	public IndexedWord(String bookword){
		this.bookword=bookword;
	}

	/**
	 * Method that adds line number to the Vector of lines
	 * @param n number of line
	 */
	public void addline(int n){
		lines.add(n);
	}

	/**
	 * Method that adds line number to the Vector of sentences
	 * @param n number of sentences
	 */
	public void addSentence(int n){

		if(sentences.size()>=1)
			if(sentences.get(sentences.size()-1)!=n)
				sentences.add(n);

		if(sentences.size()==0)
			sentences.add(n);
	}

	/**
	 * Method that returns information about a word, its line and
	 * sentence numbers and context
	 * @param sentences vector of sentences
	 * @return  returns information on a word
	 */
	public StringBuilder getText(Vector<String> sentences){
		StringBuilder sb=new StringBuilder();
		sb.append(bookword);
		sb.append("\nline number:");
		sb.append(lines.toString());
		sb.append("\nsentence number:");
		sb.append(this.sentences.toString());
		sb.append("\n");
		for(int i=0;i<this.sentences.size();i++){
			sb.append(sentences.get(this.sentences.get(i)));
			sb.append("\n");
		}
		return sb;
	}

}
