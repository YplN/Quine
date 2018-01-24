import java.util.ArrayList;

public class card {
	Integer id;
	ArrayList<line> lines;
	
	public Boolean addvalue(Integer value)
	{

		for(int i =0; i<lines.size(); i++)
		{
			if(lines.get(i).addvalue(value))
				return true;
		}
		return false;
	}
	
	public Boolean removevalue(Integer value)
	{

		for(int i =0; i<lines.size(); i++)
		{
			if(lines.get(i).removevalue(value))
				return true;
		}
		return false;
	}
	
	public Pair<Integer, line> checkline()
	{
		for(int i=0; i<lines.size();i++)
		{
			if(lines.get(i).checkline())
				return new Pair<Integer, line>(id,lines.get(i));
		}
		return new Pair<Integer, line>(-1,null);
	}
	
	
	public Integer checkcard()
	{
		
		for(int i=0; i<lines.size(); i++)
		{
			if(!lines.get(i).checkline())
				return -1;
		}
		return id;
	}
	public card(Integer i, ArrayList<ArrayList <Integer>> c)
	{
		line l;
		id=i;
		lines=new ArrayList<line>();
		for(ArrayList<Integer> a : c)
		{	
			l= new line(a);
			//l.print();
			lines.add(l);
		}
	}
	
	public void print()
	{
		System.out.println(id+" :");
		for(line l : lines)
		{	
			l.print();
		}
	}
	
	public void printremaining()
	{
		System.out.println(id+" :");
		for(line l : lines)
		{	
			l.printremaining();
		}
	}
	
	public ArrayList<Integer> remaining()
	{
		ArrayList<Integer> s = new ArrayList<>();
		
		for(int i = 0; i<lines.size(); i++)
		{
			s.addAll(lines.get(i).remaining());
		}
		return s;
	}
}
