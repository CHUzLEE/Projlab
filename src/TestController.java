import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class TestController {
	//az adott tesz során létrejövő objektumok, név alapján indexelve
	private static HashMap<String, Object> objectMap = new HashMap<String, Object>();
	//objektumok nevei, object alapján indexelve
	private static HashMap<Object, String> nameMap = new HashMap<Object, String>();
	//bemeneti nyelv metódusai
	private static HashMap<String, Method> methods = new HashMap<String, Method>();

	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		init();
		
		String input;
		
		Scanner inputScanner = new Scanner(System.in);
		
		//menü kiírása
		do {
			System.out.println("\nExit: 0\n"
					 + "Test0: 1\n"
					 + "Test1: 2\n"
					 + "Test2: 3\n"
					 + "Test3: 4\n"
					 + "Test4: 5\n"
					 + "Test5: 6\n"
					 + "Test6: 7\n"
					 + "Test7: 8\n"
					 + "Test8: 9\n"
					 + "Test9: 10\n"
					 + "Test10: 11\n"
					 + "Test11: 12\n"
					 + "Test12: 13\n"
					 + "Test13: 14\n"
					 + "Test14: 15\n"
					 + "Test15: 16\n"
					 + "Test18: 19\n"
					 + "Test19: 20\n"
					 + "Test20: 21\n"
					 + "Test21: 22\n"
					 + "Test24: 25\n"
					 + "Test25: 26\n"
					 + "Test26: 27\n"
					 + "Test27: 28\n"
					 + "Test28: 29\n"
					 + "Test29: 30\n"
					 + "Test30: 31\n"
					 + "Test31: 32\n"
					 + "Test32: 33\n"
					 + "Test33: 34\n"
					 + "Test34: 35\n"
					 + "Test35: 36\n"
					 + "Test36: 37\n"
					 + "Test37: 38\n"
					 + "Test38: 39\n"
					 + "Test39: 40\n"
					 + "Test40: 41\n"
					 + "Test41: 42\n"
					 + "Test42: 43\n"
					 + "ManualTest: 49");
			
			input = inputScanner.next();
			
			int option = Integer.parseInt(input);
			
			//menüválasztó
			switch(option) {
			case 1: Test("0");
					break;
			case 2: Test("1");
					break;
			case 3: Test("2");
					break;
			case 4: Test("3");
					break;
			case 5: Test("4");
					break;
			case 6: Test("5");
					break;
			case 7: Test("6");
				break;
			case 8: Test("7");
				break;
			case 9: Test("8");
				break;
			case 10: Test("9");
				break;
			case 11: Test("10");
				break;
			case 12: Test("11");
				break;
			case 13: Test("12");
				break;
			case 14: Test("13");
				break;
			case 15: Test("14");
				break;
			case 16: Test("15");
				break;
			case 19: Test("18");
				break;
			case 20: Test("19");
				break;
			case 21: Test("20");
			break;
			case 22: Test("21");
			break;
			case 25: Test("24");
			break;
			case 26: Test("25");
			break;
			case 27: Test("26");
			break;
			case 28: Test("27");
			break;
			case 29: Test("28");
			break;
			case 30: Test("29");
			break;
			case 31: Test("30");
				break;
			case 32: Test("31");
			break;
			case 33: Test("32");
			break;
			case 34: Test("33");
				break;
			case 35: Test("34");
				break;
			case 36: Test("35");
				break;
			case 37: Test("36");
				break;
			case 38: Test("37");
					break;	
			case 39: Test("38");
					break;
			case 40: Test("39");
					break;
			case 41: Test("40");
					break;
			case 42: Test("41");
					break;
			case 43: Test("42");
					break;
			case 44: Test("43");
					break;
			case 49: ManualTest();
			break;
			}
					
		}while(!input.equals("0"));
		
		inputScanner.close();
	
	
	}
	
	//feltölti a methods map-et, stringként beolvasott parancsok végrehajtásához kell
	private static void init() throws NoSuchMethodException, SecurityException {
		methods.put("CreatePlumber", TestController.class.getMethod("CreatePlumber", String.class));
		methods.put("CreateSaboteur", TestController.class.getMethod("CreateSaboteur", String.class));
		methods.put("CreatePump", TestController.class.getMethod("CreatePump", String.class));
		methods.put("CreateCistern", TestController.class.getMethod("CreateCistern", String.class));
		methods.put("CreateSource", TestController.class.getMethod("CreateSource", String.class));
		methods.put("CreatePipe", TestController.class.getMethod("CreatePipe", String.class));
		methods.put("Move", TestController.class.getMethod("Move", String.class));
		methods.put("AddPipe", TestController.class.getMethod("AddPipe", String.class));
		methods.put("PutDownPipeEnd", TestController.class.getMethod("PutDownPipeEnd", String.class));
		methods.put("PickUpPipeEnd", TestController.class.getMethod("PickUpPipeEnd", String.class));
		methods.put("ChangePumpOutput", TestController.class.getMethod("ChangePumpOutput", String.class));
		methods.put("ChangePumpOutputByPlayer", TestController.class.getMethod("ChangePumpOutputByPlayer", String.class));
		methods.put("ChangePumpInput", TestController.class.getMethod("ChangePumpInput", String.class));
		methods.put("ChangePumpInputByPlayer", TestController.class.getMethod("ChangePumpInputByPlayer", String.class));
		methods.put("AddFreePipe", TestController.class.getMethod("AddFreePipe", String.class));
		methods.put("PickUpFreePipe", TestController.class.getMethod("PickUpFreePipe", String.class));
		methods.put("SourceWaterFlow", TestController.class.getMethod("SourceWaterFlow", String.class));
		methods.put("PickUpPump", TestController.class.getMethod("PickUpPump", String.class));
		methods.put("PutDownPump", TestController.class.getMethod("PutDownPump", String.class));
		methods.put("CisternWaterFlow", TestController.class.getMethod("CisternWaterFlow", String.class));
		methods.put("Sabotage", TestController.class.getMethod("Sabotage", String.class));

		methods.put("FixGameElement", TestController.class.getMethod("FixGameElement", String.class));
		methods.put("PumpWaterFlow", TestController.class.getMethod("PumpWaterFlow", String.class));

	}
	
	//fájlból beolvasott tesztek futtatása
	private static void Test(String testNumber) throws IllegalAccessException, InvocationTargetException {
		Scanner inputScanner;
		String result = new String();
		try {
			inputScanner = new Scanner(new FileInputStream("test_sources/test"+ testNumber +"_in.txt"));
			
			while(inputScanner.hasNextLine()) {
				String line = inputScanner.nextLine();
				line = line.replaceAll(" ", "");
				int i = line.indexOf("(");
				String command = line.substring(0, i);
				String params = line.substring(i + 1, line.length() - 1);
				//System.out.println("debug:" + command);
				String commandOut = (String) methods.get(command).invoke(null, params);
				//System.out.println("debug:" + commandOut);
				if(commandOut != null) {
					System.out.println(commandOut);
					result += commandOut;
				}
			}
			inputScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner outputScanner;
		String predictedResult = new String();
		try {
			outputScanner = new Scanner(new FileInputStream("test_sources/test"+ testNumber +"_out.txt"));
			while(outputScanner.hasNextLine()) {
				predictedResult += outputScanner.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		predictedResult = predictedResult.replaceAll(" ", "");
		result = result.replaceAll(" ", "");
		result = result.replaceAll("\n", "");
		
		//System.out.println(result);
		//System.out.println(predictedResult);
		if(result.compareTo(predictedResult) == 0) {
			System.out.println("Sikeres teszt");
		}
		else {
			System.out.println("Sikertelen teszt");
		}
		
	}
	
	private static void ManualTest() throws IllegalAccessException, InvocationTargetException {
		Scanner inputScanner;
		String result = new String();
			inputScanner = new Scanner(System.in);
			
			while(inputScanner.hasNextLine()) {
				String line = inputScanner.nextLine();
				line = line.replaceAll(" ", "");
				int i = line.indexOf("(");
				String command = line.substring(0, i);
				String params = line.substring(i + 1, line.length() - 1);
				String commandOut = (String) methods.get(command).invoke(null, params);
				if(commandOut != null) {
					System.out.println(commandOut);
					result += commandOut;
				}
			}
			inputScanner.close();
			System.exit(0);
	}
	
	/**
	 * Létrehoz egy új szerelőt.
	 * @param hasPump Van-e a szerelőnél pumpa?
	 * @param id A szerelő azonosítója.
	 * @param carriedPump A szerelő által hordozott pumpa, null ha a szerelőnél nincs pumpa.
	 * @param onMoveable A szerelő tartózkodási helye.
	 * @param carriedPipe A szerelőnél lévő cső, null ha a szerelőnél nincs cső.
	 * @return A megadott paraméterekkel létrehozott Plumber példány.
	 */
	public static String CreatePlumber(String params) {
		String[] args = params.split(",");
		
		String name = args[0];
		boolean hasPump;
		if(args[1].equals("false")) {
			hasPump = false;
		}
		else {
			hasPump = true;
		}
		
		int id = Integer.parseInt(args[2]);
		
		Pump carriedPump;
		if(args[3].equals(null)) {
			carriedPump = null;
		}
		else {
			carriedPump = (Pump)objectMap.get(args[3]);
		}
		
		Moveable onMoveable;
		if(args[4].equals(null)) {
			onMoveable = null;
		}
		else {
			onMoveable = (Moveable)objectMap.get(args[4]);
		}
		Pipe carriedPipe;
		if(args[5].equals(null)) {
			carriedPipe = null;
		}
		else {
			carriedPipe = (Pipe)objectMap.get(args[5]);
		}
		
		/*System.out.println(id);
		System.out.println(onMoveable.toString());
		System.out.println(carriedPipe.toString());
		System.out.println(hasPump);
		System.out.println(carriedPump);*/
		
		Plumber plumber = new Plumber(id, onMoveable, carriedPipe, hasPump, carriedPump);
		objectMap.put(name, plumber);
		nameMap.put(plumber, name);
		
		return "CreatePlumber: " + nameMap.get(plumber) + "\n"
			+  "Adatai: hasPump: "+ plumber.IsHasPump() +",ID: "+ plumber.getId() +", carriedPump:"+ nameMap.get(plumber.GetCarriedPump())+", location: "+ nameMap.get(plumber.getOnMoveable()) +", carriedPipes: "+ nameMap.get(plumber.getCarriedPipe()) +"\n";
	}
	
	/**
	 * Létrehoz egy új szabotőrt.
	 * @param id A szabotőr azonosítója.
	 * @param onMoveable A szabotőr tartózkodási helye.
	 * @param carriedPipe A szerelőnél lévő cső, null ha a szerelőnél nincs cső.
	 * @return A megadott paraméterekkel létrehozott Saboteur példány.
	 */
	public static String CreateSaboteur(String params) {
		String[] args = params.split(",");
		String name = args[0];
		int id = Integer.parseInt(args[1]);
		Moveable onMoveable;
		if(args[2].equals(null)) {
			onMoveable = null;
		}
		else {
			onMoveable = (Moveable)objectMap.get(args[2]);
		}
		Pipe carriedPipe;
		if(args[3].equals(null)) {
			carriedPipe = null;
		}
		else {
			carriedPipe = (Pipe)objectMap.get(args[3]);
		}
		
		Saboteur saboteur = new Saboteur(id, onMoveable, carriedPipe);
		objectMap.put(name, saboteur);
		nameMap.put(saboteur, name);
		
		return "CreateSaboteur: " + nameMap.get(saboteur) + "\n"
		+  "Adatai: ID: " + saboteur.getId() +", location: "+ nameMap.get(saboteur.getOnMoveable()) +", carriedPipes: "+ nameMap.get(saboteur.getCarriedPipe()) +"\n";
	}
	
	/**
	 * Létrehoz egy új pumpát.
	 * @param output A pumpa kimenete.
	 * @param input A pumpa bemenete.
	 * @param storedWater A pumpában tárolt víz mennyisége.
	 * @param maxStorage A maximális vízmennyiség, amit a pumpa tárolni tud.
	 * @param working Működik a pumpa?
	 * @param pipes A pumpához csatlakoztatott csövek.
	 * @param maxPipes A pumpához csatlakoztatható csövek maximális száma.
	 * @return A megadott paraméterekkel létrehozozz Pump példány. 
	 */
	public static String CreatePump(String params) {
		String[] args = params.split(",");
		String name = args[0];
		
		Pipe output;
		if(args[1].equals(null)) {
			output = null;
		}
		else {
			output = (Pipe)objectMap.get(args[1]);
		}
		
		Pipe input;
		if(args[2].equals(null)) {
			input = null;
		}
		else {
			input = (Pipe)objectMap.get(args[2]);
		}
		
		int storedWater = Integer.parseInt(args[3]);
		
		int maxStorage = Integer.parseInt(args[4]);
		
		boolean working;
		if(args[5].equals("false")) {
			working = false;
		}
		else {
			working = true;
		}
		
		ArrayList<Pipe> pipes = null;
		
		int maxPipes = Integer.parseInt(args[7]);
		
		Pump pump = new Pump(output, input, storedWater, maxStorage, working, pipes, maxPipes);
		objectMap.put(name, pump);
		nameMap.put(pump, name);
		
		String pipeNames = null;
		ArrayList<Pipe> pipeList = ((Pump)objectMap.get(name)).getPipes();
		if(!pipeList.isEmpty()) {
			for(Pipe i : pipeList) {
				pipeNames +=  nameMap.get(i);
				pipeNames += ", "; 
			}
			pipeNames.substring(0, pipeNames.length() - 2);
		}
		
		return "CreatePump: " + nameMap.get(pump) + "\n"
			 + "Adatai: output:" + pump.getOutputId() + ", input: " + pump.getInputId() + ", storedWater: " + pump.getStoredWater() + ", maxStorage: " + pump.getMaxStorage() + ", working: " + pump.isWorking()+ ", pipes: " + pipeNames + ", maxPipes: " +pump.getMaxPipes() + "\n"; 
	}
	
	/**
	 * Létrehoz egy új csövet
	 * @param waterLevel A cső vízszintje.
	 * @param working Lyukas-e a cső?
	 * @param capacity A cső kapacitása.
	 * @param occupied Áll-e valaki a csövön?
	 * @param sabotageable Mennyi idő múlva lesz a cső újra szabotálható
	 * @param sticky Mennyi ideig ragadós a cső
	 * @param slippery Mennyi ideig csúszós a cső
	 * @param endpoints A cső két végpontja
	 * @return A megadott paraméterekkel létrehozott Pipe példány.
	 */
	public static String CreatePipe(String params) {
		String[] args = params.split(",");
		
		String name = args[0];
		
		int waterLevel = Integer.parseInt(args[1]);
		
		boolean working;
		if(args[2].equals("false")) {
			working = false;
		}
		else {
			working = true;
		}
		
		int capacity = Integer.parseInt(args[3]);
		
		boolean occupied;
		if(args[4].equals("false")) {
			occupied = false;
		}
		else {
			
			occupied = true;
		}
		
		int sabotageable = Integer.parseInt(args[5]);
		
		int sticky = Integer.parseInt(args[6]);
		
		int slippery = Integer.parseInt(args[7]);
		
		ArrayList<Element> endPoints = new ArrayList<Element>();
		endPoints.add((Element)objectMap.get(args[8]));
		endPoints.add((Element)objectMap.get(args[9]));
		
		Pipe pipe = new Pipe(waterLevel, working, capacity, occupied, sabotageable, sticky, slippery, endPoints);
		objectMap.put(name, pipe);
		nameMap.put(pipe, name);
		
		String endpoint1 = nameMap.get(pipe.getEndPoints().get(0));
		String endpoint2 = nameMap.get(pipe.getEndPoints().get(1));
		
		return "CreatePipe: " + nameMap.get(pipe) + "\n"
			 + "Adatai: waterLevel: "+ pipe.getWaterLevel() +", working: " + pipe.isWorking() + ", capacity: " + pipe.GetCapacity() + ", occupied: " + pipe.GetOccupied() + ", sabotageable: " + pipe.getSabotageable() + ", sticky: " + pipe.getSticky() + ", slippery: " + pipe.getSlippery() + ", endpoints: " + nameMap.get(pipe.getEndPoints().get(0)) + ", " + nameMap.get(pipe.getEndPoints().get(1)) + "\n";
	}
	
	/**
	 * Létrehoz egy új ciszternát.
	 * @param numberOfFreePipes A ciszternához csatlakozó szabad végű csövek száma.
	 * @param createdPipes A ciszternán keletkezett szabad végű csövek.
	 * @param pipes A ciszternához csatlakozó csövek.
	 * @param maxPipes A ciszternához csatlakoztatható csövek maximális száma.
	 * @return A megadaott paraméterkkel létrehozott Cistern példány.
	 */
	public static String CreateCistern(String params) {
		String[] args = params.split(",");
		String name = args[0];
		
		
		int numberOfFreePipes = Integer.parseInt(args[1]);
		
		ArrayList<Pipe> createdPipes = new ArrayList<Pipe>();
		int i = 0;
		while(i < numberOfFreePipes) {
			createdPipes.add((Pipe)objectMap.get(args[i + 2]));
			i++;
		}
		i = i+3;
		
		ArrayList<Pipe> pipes = null;
		i++;
		int maxPipes = Integer.parseInt(args[i]);
		
		
		Cistern cistern = new Cistern(numberOfFreePipes, createdPipes, pipes, maxPipes);
		objectMap.put(name, cistern);
		nameMap.put(cistern, name);
		
		String pipeNames = null;
		ArrayList<Pipe> pipeList = cistern.getPipes();
		if(!pipeList.isEmpty()) {
			for(Pipe p : pipeList) {
				pipeNames +=  nameMap.get(p);
				pipeNames += ", "; 
			}
			pipeNames.substring(0, pipeNames.length() - 2);
		}
		
		String createdPipeNames = null;
		ArrayList<Pipe> createdPipeList = cistern.getCreatedPipes();
		if(!createdPipeList.isEmpty()) {
			for(Pipe p : createdPipeList) {
				createdPipeNames +=  nameMap.get(p);
				createdPipeNames += ", "; 
			}
			createdPipeNames.substring(0, createdPipeNames.length() - 2);
		}
		
		return "CreateCistern: " + nameMap.get(cistern) + "\n"
			 + "Adatai: numberOfFreePipes:" + cistern.getNumberOfFreePipes() + ", createdPipes: " + createdPipeNames +", pipes: "+ pipeNames +", maxPipes: " + cistern.getMaxPipes() + "\n";
	}
	
	/**
	 * Létrehoz egy új forrást.
	 * @param pipes A forráshoz csatlakozó csövek.
	 * @param maxPipes A forráshoz hozzácsatolható csövek maximális száma.
	 * @return A megadott paraméterekkel létrehozott Source objektum.
	 */
	public static String CreateSource(String params) {
		String[] args = params.split(",");
		
		String name = args[0];
		
		ArrayList<Pipe> pipes = null;
		
		int maxPipes = Integer.parseInt(args[2]);
		
		Source source = new Source(pipes, maxPipes);
		objectMap.put(name, source);
		nameMap.put(source, name);
		
		String pipeNames = null;
		ArrayList<Pipe> pipeList = source.getPipes();
		if(!pipeList.isEmpty()) {
			for(Pipe p : pipeList) {
				pipeNames +=  nameMap.get(p);
				pipeNames += ", "; 
			}
			pipeNames.substring(0, pipeNames.length() - 2);
		}
		
		return "CreateSource: " + nameMap.get(source) + "\n"
			+  "Adatai: pipes: " + pipeNames +", maxPipes: " + source.getMaxPipes() + "\n";
	}
	
	/**
	 * Kiírja a megadott dolog tulajdonságait
	 * @param name Annak a példánynak a neve, amelynek az adatait ki akarjuk iratni.
	 * @param map HashMap amelyben a megadott névhez tartozó objektum található.
	 */
	public static void Info(String name, HashMap<String, Object> map) {
		System.out.println(map.get(name).toString());
	}
	
	/**
	 * Pumpa felvétele a kézbe
	 * @param plumber Ki veszi fel a pumpát?
	 * @param cistern Honnan veszi fel a pumpát?
	 */
	public static String PickUpPump(String params) {
		String[] args = params.split(",");
		Plumber plumber = (Plumber)objectMap.get(args[0]);
		Cistern cistern = (Cistern)objectMap.get(args[1]);
		try {
			plumber.GetPump(cistern);
		} catch (PumpAlreadyPickedupException e) {
			return args[0] + " sikertelenul vett fel pumpat" + args[1]+ "-bol.";
		}
		if(!plumber.GetCarriedPump().equals(null)) {
			return args[0] + " sikeresen vett fel pumpat" + args[1]+ "-bol.\n";
		}
		return args[0] + " sikeresen vett le pumpát" + args[1]+ "-ból\n";
	}
	
	/**
	 * Pumpa lerakása a csőre
	 * @param plumber Ki rakja le a pumpát?
	 * @param pipe Hova rakja le a pumpát?
	 */
	public static String PutDownPump(String params) {
		String[] args = params.split(",");
		
		Plumber plumber = (Plumber)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		try {
			plumber.PlacePump(pipe);
		} catch (NoPumpPickedupException e) {
			e.printOutMessage();
			return args[0] + " sikertelenul tett le pumpat "+ nameMap.get(pipe) + "-ra.\n";
		}
		catch(PipePiercedPlacePumpException f)
		{
			f.printOutMessage();
			return args[0] + " sikertelenul tett le pumpat "+ nameMap.get(pipe) + "-ra.\n";
		}


		return args[0] + " sikeresen tett le pumpat "+ args[1] + "-ra.\n";

	}
	
	/**
	 * Javítható elem javítása
	 * @param plumber Ki akar javítani?
	 * @param element Mit akar javítani?
	 */
	public static String FixGameElement(String params) {
		String[] args = params.split(",");
		
		Plumber plumber = (Plumber)objectMap.get(args[0]);
		Fixable element = (Fixable)objectMap.get(args[1]);
		
		
		boolean working = element.isWorking();
		
		plumber.Fix(element);
		
		if(!working && element.isWorking()) {
			return "FixGameElement: " + args[0] + " sikeresen javitotta " + args[1]+ "-t\n";
		}
		return "FixGameElement: " +args[0] + " sikertelenul javitotta " + args[1]+ "-t\n";
		
	}
	
	/**
	 * Cső csúszóssá tétele
	 * @param saboteur Ki teszi csúszóssá?
	 * @param pipe Melyik csövet?
	 */
	public static String MakeSlippery(String params) {
		String[] args = params.split(",");
		
		Saboteur saboteur = (Saboteur)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		
		int slippery = pipe.getSlippery();
		
		saboteur.MakeSlippery(pipe);
		
		if(slippery == 0 && pipe.getSlippery() > 0) {
			return args[0] + " sikeresen csúszóssá tette " + args[1] + "csövet\n";
		}
		return args[0] + " sikertelenul csúszóssá tette " + args[1] + "csövet\n";
	}
	
	/**
	 * Cső ragadóssá tétele.
	 * @param player A játékos, aki ragadóssá teszi a csövet.
	 * @param pipe A cső, amelyet ragadóssá tesz a játékos.
	 */
	public static String MakeSticky(String params) {
		String[] args = params.split(",");
		
		Player player = (Player)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		
		int sticky = pipe.getSticky();
		
		try {
			player.MakeSticky(pipe);
		} catch (PipeStickyException e) {
			e.printOutMessage();
		}
		if(sticky == 0 && pipe.getSticky() > 0) {
			return args[0] + "sikeresen ragadóssá tette " + args[1] + "csövet\n";
		}
		return args[0] + "sikertelenul ragadóssá tette " + args[1] + "csövet\n";
	}
	
	/**
	 * Cső elrontása
	 * @param saboteur
	 * @param pipe
	 */
	public static String Sabotage(String params) {
		String[] args = params.split(",");
		
		Saboteur saboteur = (Saboteur)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		
		boolean working = pipe.isWorking();
		
		try {
			saboteur.Sabotage(pipe);
		} catch (PipeSabotageableException e) {
			e.printOutMessage();
		}
		if(working && !pipe.isWorking()) {
			return "Sabotage: " + args[0] + " sikeresen kilyukasztotta " + args[1] + "-t\n";
		}
		return "Sabotage: " + args[0] + " sikertelenul kilyukasztotta " + args[1] + "-t\n";
	}
	
	/**
	 * Csővég felvétele a kézbe
	 * @param player A játékos, aki a csövet lecsatolja
	 * @param pipe A cső amit lecsatolunk
	 * @param element Innen csatoljuk le a csövet
	 */
	public static String PickUpPipeEnd(String params) {
		String[] args = params.split(",");
		
		Pipe pipe = (Pipe)objectMap.get(args[0]);
		Element element = (Element)objectMap.get(args[1]);
		Player player = (Player)objectMap.get(args[2]);
		
		
		try {
			Pump pump = (Pump)element;
			if(pump.getInputId().equals(pipe) || pump.getOutputId().equals(pipe))
			{
				
			}
			else
			{
				player.DetachPipe(pipe, element);
			}
		}
		catch(ClassCastException e)
		{
			player.DetachPipe(pipe, element);
		}
		catch(NullPointerException e)
		{
			player.DetachPipe(pipe, element);
		}
		
		
		if(pipe.isDetached()) {
			return args[2] + " sikeresen felvette " + args[0] + " cso veget " + args[1] + "jatekelemrol.\n";
		}
		return args[2] + " sikertelenul felvette " + args[0] + " cso veget " + args[1] + "jatekelemrol.\n";
		
	}
	
	/**
	 * Cső vég lerakása és csatlakoztatása az elemhez
	 * @param player A játékos, aki a csövet fel csatlakoztatja
	 * @param element Ide csatlakoztatja a játékos a nála lévő csövet
	 */
	public static String PutDownPipeEnd(String params) {
		String[] args = params.split(",");
		
		Player player = (Player)objectMap.get(args[0]);
		Element element = (Element)objectMap.get(args[1]);
		String pipename = nameMap.get(player.getCarriedPipe());
		
		try {
			player.AttachPipe(element);
		} catch (NoPickedupPipeException e) {
			e.printOutMessage();
			return args[0] + " sikertelenul tette le " + pipename + " csoveget " + args[1] +" jatekelemre.\n";
		}
		return args[0] + " sikeresen tett le " + pipename + " csoveget  " + args[1] +" jatekelemre.\n";
	}
	
	/**
	 * Pumpa bemenetének változtatása
	 * @param pump Melyik pumpának a bemenetét akarjuk megváltoztatni?
	 * @param pipe Melyik cső lesz a bemenete a pumpának?
	 */
	public static String ChangePumpInput(String params) {
		String[] args = params.split(",");
		
		Pump pump = (Pump)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		try {
			pump.SetInputId(pipe);
		} catch (PumpInputException e) {
			
		}
		return args[0] + " bemeneti csove " + args[1] + " csore valtozott.\n";

	}
	
	/**
	 * Pumpa bemenetének változtatása
	 * @param pump Melyik pumpának a bemenetét akarjuk megváltoztatni?
	 * @param pipe Melyik cső lesz a bemenete a pumpának?
	 * @param player Ki változtatja meg?
	 */
	public static String ChangePumpInputByPlayer(String params) {
		String[] args = params.split(",");
		
		Pump pump = (Pump)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		Player player = (Player)objectMap.get(args[2]);
		
		try {
			pump.SetInputId(pipe);
		} catch (PumpInputException e) {
			return args[2] + " sikertelenül megváltoztatta " + args[0] + " bemeneti csővét " + args[1] + " csőre.\n";
		}
		return args[2] + " sikeresen megvaltoztatta " + args[0] + " bemeneti csovet " + args[1] + " csore.\n";
	}
	
	
	/**
	 * Pumpa bemenetének változtatása
	 * @param pump Melyik pumpának a kimenetét akarjuk megváltoztatni?
	 * @param pipe Melyik cső lesz a kimenete a pumpának?
	 * @param player Ki változtatja meg?
	 */
	public static String ChangePumpOutputByPlayer(String params) {
		String[] args = params.split(",");
		
		Pump pump = (Pump)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		Player player = (Player)objectMap.get(args[2]);
		
		try {
			pump.SetOutputId(pipe);
		} catch (PumpOutputException e) {
			return args[2] + " sikertelenül megváltoztatta " + args[0] + " kimeneti csővét " + args[1] + "csőre.\n";
		}
		return args[2] + " sikeresen megvaltoztatta " + args[0] + " kimeneti csovet " + args[1] + "csore.\n";
	}
	
	/**
	 * Pumpa bemenetének változtatása
	 * @param pump Melyik pumpának a kimenetét akarjuk megváltoztatni?
	 * @param pipe Melyik cső lesz a kimenete a pumpának?
	 */
	public static String ChangePumpOutput(String params) {
		String[] args = params.split(",");
		
		Pump pump = (Pump)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		
		try {
			pump.SetOutputId(pipe);
		} catch (PumpOutputException e) {
			return args[0] + " sikertelenül megváltoztatta " + args[1] + " kimeneti csővét " + args[1] + "csőre.\n";
		}
		return args[0] + " kimeneti csove " + args[1] + " csore valtozott.\n";
	}
	
	/**
	 * Játékos mozgatása
	 * @param player A játékos aki mozog.
	 * @param moveable Ide lép a játékos
	 */
	public static String Move(String params) {
		String[] args = params.split(",");
		Player player = (Player)objectMap.get(args[0]);
		Moveable moveable = (Moveable)objectMap.get(args[1]);
		player.Move(moveable);
		
		if(player.getOnMoveable().equals(moveable)) {
			return "Move: " + args[0] + " sikeresen ment a " +  args[1]+ " elemre.\n";
		}
		return "Move: " + args[0] + " sikertelenul ment a " +  args[1]+ "elemre.\n";
	}
	
	/**
	 * Cső csatlakoztatása pumpához
	 * @param pump Ehhez a pumpához csatlakoztatjuk a csövet
	 * @param pipe Ezt a csövet csatoljuk a pumpához
	 */
	public static String AddPipe(String params) {
		String[] args = params.split(",");
		Element pump = (Element)objectMap.get(args[0]);
		Pipe pipe = (Pipe)objectMap.get(args[1]);
		try {
			pump.Addpipe(pipe);
		} catch (PipePlaceException e) {
			e.printOutMessage();
		}
		return null;
	}
	
	/**
	 * Aktív elemen folyat át vizet
	 * @param element Ezen folyat keresztül vizet.
	 */
	public static String SourceWaterFlow(String params) {
		String[] args = params.split(",");
		
		Source source = (Source)objectMap.get(args[0]);
		
		
		
		ArrayList<Pipe> pipes = source.getPipes();
		
		String out = new String(args[0] + "waterflow: vizszint pumpalas elott:\n");
		
		for(Pipe i : pipes) {
			out += (String)nameMap.get(i) + ": " +  i.getWaterLevel() + "\n";
		}
		
		source.WaterFlow();
		
		out += "vizszint pumpalas utan: \n";
		
		for(Pipe i : pipes) {
			out += (String)nameMap.get(i) + ": " +  i.getWaterLevel() + "\n";
		}
		
		return out;
	}
	
	public static String CisternWaterFlow(String params) {
		String[] args = params.split(",");
		
		Cistern source = (Cistern)objectMap.get(args[0]);
		
		
		
		ArrayList<Pipe> pipes = source.getPipes();
		
		String out = new String(args[0] + "waterflow: vizszint pumpalas elott:\n");
		
		for(Pipe i : pipes) {
			out += (String)nameMap.get(i) + ": " +  i.getWaterLevel() + "\n";
		}
		
		source.WaterFlow();
		
		out += "vizszint pumpalas utan: \n";
		
		for(Pipe i : pipes) {
			out += (String)nameMap.get(i) + ": " +  i.getWaterLevel() + "\n";
		}
		
		return out;
	}
	
	public static String PumpWaterFlow(String params) {
		String[] args = params.split(",");
		
		Pump pump = (Pump)objectMap.get(args[0]);
		
		
		
		Pipe input = pump.getInputId();
		Pipe output = pump.getOutputId();
		
		String out = new String(args[0] + "waterflow: vizszint pumpalas elott:\n");
		
		out += args[0] + ": " + pump.getStoredWater()+ "\n";
		out += (String)nameMap.get(input) + ": " + input.getWaterLevel()+ "\n";
		out += (String)nameMap.get(output) + ": " + output.getWaterLevel()+ "\n";
		
		pump.WaterFlow();
		
		out += "vizszint pumpalas utan: \n";
		
		out += args[0] + ": " + pump.getStoredWater()+ "\n";
		out += (String)nameMap.get(input) + ": " + input.getWaterLevel()+ "\n";
		out += (String)nameMap.get(output) + ": " + output.getWaterLevel()+ "\n";
		
		return out;
	}
	
	/**
	 * Szabad  végű cső hozzáadása ciszternához
	 * @param name A létrejövő cső neve
	 * @param cistern Itt jön létre.
	 */
	public static String AddFreePipe(String params) {
		String[] args = params.split(";");
		Cistern cistern = (Cistern)objectMap.get(args[0]);
		try {
			cistern.CreateNewPipe();
			return "Uj cso letrehozva a " + nameMap.get(cistern) + " altal.\n";
		}
		catch(PipeSetEndpointException e)
		{
			e.printOutMessage();
			return "Nem sikerult uj cso letrehozasa " + nameMap.get(cistern) + " altal.\n";
 		}
		
		
	}
	
	/**
	 * Szabad  végű cső felvétele ciszternáról
	 * @param player Ki veszi fel a csövet
	 * @param cistern Honnan veszi fel a csövet
	 */
	public static String PickUpFreePipe(String params) {
		String[] args = params.split(",");
		
		
		Player player = (Player)objectMap.get(args[0]);
		
		Cistern cistern = (Cistern)objectMap.get(args[1]);
		
		try {
			player.AddCarriedPipe(cistern.GetFreePipe());
			return nameMap.get(cistern) + " ciszternarol szabad cso sikeresen felveve " + nameMap.get(player) + " altal.\n";
			
		} catch (NoFreePipeCisternException e) {
			e.printOutMessage();
			return nameMap.get(cistern) + " ciszternarol szabad cso sikertelenul felveve " + nameMap.get(player) + " altal.\n";
		}
		catch (PipeAlreadyPickedupException f)
		{
			f.printOutMessage();
			return nameMap.get(cistern) + " ciszternarol szabad cso sikertelenul felveve " + nameMap.get(player) + " altal.\n";
		}
	}
	
	
}
