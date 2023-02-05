package assign02;

import java.util.GregorianCalendar;

public class LibraryBook extends Book
{
	
	public String holder;
	public GregorianCalendar dueDate = new GregorianCalendar();	
	
	public LibraryBook(long isbn, String author, String title)
	{
		super(isbn, author, title);
		
	}
	public String getHolder()
	{
		return this.holder;
	}
	public GregorianCalendar getDueDate() 
	{
		if(this.getHolder() == null)
			return null;
		else
			return this.dueDate;
	}

	public void checkIn(Book book)
	{
		this.dueDate = null;
		this.holder = null;
	}
	
	public void checkOut(String holder, int day, int month, int year)
	{
		this.dueDate.set(year, month, day);
		this.holder = holder;
	}
	
}