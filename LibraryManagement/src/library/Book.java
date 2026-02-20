package library;

public class Book {
private int id;
private String title;
private String author;
private double price;

public Book(String title,String author,double price)
{
	this.title=title;
	this.author=author;
	this.price=price;
}

public int getid()
{
	return id;
}
public void setid(int id)
{
	this.id=id;
}

public String gettitle()
{
	return title;
}
public void settitle(String title)
{
	this.title=title;
}

public String getauthor()
{
	return author;
}
public void setauthor(String author)
{
	this.author=author;
}

public double getprice()
{
	return price;
}
public void setprice(double price)
{
	this.price=price;
}
}
