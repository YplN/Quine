import java.util.ArrayList;

public class line {
	
	ArrayList<Pair<Boolean, Integer>> oneline;
	
	public Boolean addvalue(Integer value)
	{
		int i=0;
		while(i<oneline.size() && !value.equals(oneline.get(i).second))
			i++;
		
		if(i<oneline.size())
		{
			oneline.get(i).first=true;
			return true;
		}
		else
			return false;
			
	}
	
	
	public Boolean removevalue(Integer value)
	{
		int i=0;
		while(i<oneline.size() && !value.equals(oneline.get(i).second))
			i++;
		
		if(i<oneline.size())
		{
			oneline.get(i).first=false;
			return true;
		}
		else
			return false;
			
	}
	
	public Boolean checkline()
	{
		for(int i=0; i<oneline.size();i++)
		{
			if(oneline.get(i).first.equals(false))
				return false;
		}
		return true;
	}
	
	public line(ArrayList<Integer> values)
	{
		oneline= new ArrayList<Pair<Boolean, Integer>>();
		for(int i=0; i<values.size(); i++)
		{
			oneline.add(new Pair<Boolean, Integer>(false, values.get(i)));
		}
	}
	
	public void print()
	{
		String s=new String();
		for(int i=0; i<oneline.size();i++)
			s+=oneline.get(i).second+"("+oneline.get(i).first.toString()+") ";
		System.out.println(s);
	}
	
	public void printremaining()
	{
		String s=new String();
		for(int i=0; i<oneline.size();i++)
			if(!oneline.get(i).first)
				s+=oneline.get(i).second+" ";
		System.out.println(s);
	}
	
	public ArrayList<Integer> remaining()
	{
		ArrayList<Integer> s = new ArrayList<>();
		for(int i=0; i<oneline.size();i++)
			if(!oneline.get(i).first)
				s.add(oneline.get(i).second);
		return s;
	}
	
}
