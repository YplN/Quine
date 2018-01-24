import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class check {

	private static Scanner sc;

	private static ArrayList<card> readFile(String filename)
	{

		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filename));

			String line;
			line = reader.readLine();
			int num_card = Integer.parseInt(line);
			String[] values;
			String[] lines;

			String[] info;
			ArrayList<Integer> oneline;
			ArrayList<ArrayList<Integer>> onecard;
			ArrayList<card> cards= new ArrayList<card>();
			card c;
			int v;

			for(int i=0; i<num_card; i++)
			{	
				onecard = new ArrayList<ArrayList<Integer>>();
				line=reader.readLine();
				info=line.split("-");
				lines = info[1].split(";");

				for(String l : lines)
				{
					oneline = new ArrayList<Integer>();
					values = l.split(" ");
					for(String val : values)
					{
						v = Integer.parseInt(val);
						oneline.add(v);
					}
					onecard.add(oneline);
				}
				c=new card(Integer.parseInt(info[0]),onecard);
				cards.add(c);
			}

			reader.close();
			return cards;



		}
		catch (Exception e)
		{
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}

	public static Integer checker(Pair<Integer, ArrayList<Pair<Boolean, Integer>>> Cards, int value)
	{
		return value;
	}

	public static ArrayList<Pair<Boolean, Integer>> createline(ArrayList<Integer> values)
	{
		ArrayList<Pair<Boolean, Integer>> card = new ArrayList<Pair<Boolean, Integer>>();
		for(int i=0; i<values.size(); i++)
		{
			card.add(new Pair<Boolean, Integer>(false, values.get(i)));
		}
		return card;
	}

	public static ArrayList<Pair<Boolean, Integer>> createcard(ArrayList<Integer> values)
	{
		ArrayList<Pair<Boolean, Integer>> card = new ArrayList<Pair<Boolean, Integer>>();
		for(int i=0; i<values.size(); i++)
		{
			card.add(new Pair<Boolean, Integer>(false, values.get(i)));
		}
		return card;
	}

	public static void cartonplein(ArrayList<card> cards)
	{
		String val=new String();
		Integer input;
		do
		{
			sc = new Scanner(System.in);
			System.out.println("Veuillez saisir un nombre :");
			input=sc.nextInt();
			val+=input.toString()+" ";
			card cID=cards.get(0);
			int minsize=cards.get(0).remaining().size();
			for(card c:cards)
			{
				c.addvalue(input);

				if(minsize>c.remaining().size())
				{
					minsize=c.remaining().size();
					cID=c;
				}
				if(c.checkcard()!=-1)
				{
					System.out.println("QUINE SUR LA CARTE :"+c.id);
					c.print();
					System.out.println("Valeurs tirees:"+val+"\n");
					val=new String();
				}
			}
		
			if(minsize!=0)
			{
				System.out.println("Carte la plus proche : "+cID.id);
				cID.printremaining();
				
			}
			
		}
		while(input!=-1); 
	}
	
	
	public static void quineligne(ArrayList<card> cards)
	{
		String val=new String();
		Integer input;
		do
		{
			sc = new Scanner(System.in);
			System.out.println("Veuillez saisir un nombre :");
			input=sc.nextInt();
			val+=input.toString()+" ";
			card cID=cards.get(0);
			line lID=cards.get(0).lines.get(0);
			int minsize=cards.get(0).lines.get(0).remaining().size();
			
			for(card c:cards)
			{
				if(input>0)
					c.addvalue(input);
				else if(input<0)
					c.removevalue(-input);

				for(line l : c.lines)
				{

					if(minsize>l.remaining().size())
					{
						minsize=l.remaining().size();
						lID=l;
						cID=c;
					}
				}
				
				if(c.checkline().first!=-1)
				{
					System.out.println("QUINE SUR LA CARTE :"+c.checkline().first);
					c.checkline().second.print();
					System.out.println("Valeurs tirees:"+val+"\n");
					val=new String();
				}
				
			}
			
			if(minsize!=0)
			{
				System.out.println("Ligne la plus proche dans la carte n°"+cID.id);
				lID.printremaining();
				
			}
			
		}
		while(input!=0); 
	}
	
	
	
	
	public static void main(String args[]) {

		ArrayList<card> cards= readFile("test2.txt");
		for(card c: cards)
			c.print();

		//cartonplein(cards);
		quineligne(cards);

		System.out.println("Merci d'avoir joué.");
	}
}
