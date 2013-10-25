import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class that contains findWordInfo, loadBook and getBookContent
 * methods. It references to class BookIndex.
 */
public class General {
	BookIndex bookindex;

	/**
	 * Constructor of class General that takes no parameters
	 */
	public General(){
		
	}

	/**
	 * Method that searches if a given by user word is in
	 * the opened file.
	 * @param bookword value taken out of a hashtable
	 * @return either a message if the word is not in the file or a word with line and sentence numbers it's in and its context
	 */
	public String findWordInfo(String bookword){
		IndexedWord found=bookindex.hw.get(bookword);
		if(found!=null)
			return found.getText(bookindex.sentences).toString();
		else
			return "Word has not been found, type another";
	}
	
	/**
	 * Method that allows loading a file line by line
	 * @param path path of the file
	 */
	public void loadBook(String path){
		Scanner filein;
		try {
			filein=new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		this.bookindex=new BookIndex();
		int lineno=1;
		while(filein.hasNext()){
			String line=filein.nextLine();
			bookindex.lineAdding(line,lineno++);
		}
	}
	
	/**
	 * Method that prints the index, generated from the file
	 * that has been read in
	 * @return  index of words
	 */
	public String getBookContent(){
		IndexedWord[] index=bookindex.hw.values().toArray(new IndexedWord[bookindex.hw.size()]);
		Arrays.sort(index,new IndexedWord_Comperator());

		StringBuilder stringbuilder=new StringBuilder();
		for(int j=0;j<index.length;j++){
			stringbuilder.append("\n");
			stringbuilder.append(index[j].bookword+" "+index[j].lines.toString());
		}
		return stringbuilder.toString();

	}
	
	
	
}
