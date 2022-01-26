public class PictureBook extends Book {
	private String illustrator;
	
	public PictureBook(String t, String a, String i) {
		title = t;
		author = a;
		illustrator = i;
	}

	public void printBookInfo() {
		System.out.print(title + ", written by " + author + " and illustrated by " + illustrator);
	}
}