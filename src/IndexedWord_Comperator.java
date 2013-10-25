import java.util.Comparator;


/**
 * Class implementing Comparator<IndexedWord> interface. Used for
 * comparison
 */
public class IndexedWord_Comperator implements Comparator<IndexedWord>{

	/**
	 * Method comparing words
	 */
	@Override
	public int compare(IndexedWord o1, IndexedWord o2) {
		return o1.bookword.compareTo(o2.bookword);
	}

}
