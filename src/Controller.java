import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Controller {
    //static HashMap<Object, String> map = new HashMap<>();	//itt tároljuk a teszthez létrehozott objektumokat és a nevüket, teszt végén clear()-t kell hívni
	static HashMap<String, Object> map = new HashMap<String, Object>();
	static int tabCounter = 0; 	//hány tab legyen egy függvény infoinak kiíratása előtt, függvényhívás előtt növelni, függvényből való visszatérés előtt csökkenteni kell, test végén le kell nullázni
    static ArrayList<FunctionCall> functionTree = new ArrayList<FunctionCall>();	//ide kerülnek a teszt során hívott függvények információi, teszt végén clear()-t kell hívni
    static boolean initPhase = true;	//igaz, ha még inicializaljuk a tesztet, inicialiálás után hamisra kell állítani
	static int plumberPoints = 0;
	static int saboteurPoints = 0;

	public static void println(String str) {
		System.out.println(str);
	}

	public static void print(String str) {
		System.out.print(str);
	}

    private static void clear() {
    	map.clear();
        functionTree.clear();
        tabCounter = 0;
    }
    
    private static void initStart() {
    	initPhase = true;
    }
    
    private static void initEnd() {
    	initPhase = false;
    }
    
    /*private static void MoveToPipeTest() {
        // initialization
    	initStart();

        Plumber plumber = new Plumber();
        Saboteur saboteur = new Saboteur();
        Pipe destination1 = new Pipe();
        Pipe destination2 = new Pipe();
        Moveable onMoveable = new Pump();

        map.put(plumber, "plumber");
        map.put(saboteur, "saboteur");
        map.put(destination1, "destination1");
        map.put(destination2, "destination2");
        map.put(onMoveable, "onMoveable");

        plumber.SetOnMoveable(onMoveable);
        saboteur.SetOnMoveable(onMoveable);

        initEnd();


        // start test
        FunctionCall functionMove1 = new FunctionCall("test_controller", tabCounter);
        functionTree.add(functionMove1);
        tabCounter++;

        plumber.Move(destination1);

        FunctionCall functionMove2 = new FunctionCall("test_controller", tabCounter);
        functionTree.add(functionMove2);
        tabCounter++;

        saboteur.Move(destination2);

        //printing
        for(FunctionCall func : functionTree)
            func.print();

        // clearing
        clear();
    }
    
    private static void MoveActiveToElementTest() {
        // initialization
    	initStart();
    	
    	Plumber plumber = new Plumber();
        Saboteur saboteur = new Saboteur();
        Pump destination = new Pump();
        Pipe onMoveable1 = new Pipe();
        Pipe onMoveable2 = new Pipe();

        map.put(plumber, "plumber");
        map.put(saboteur, "saboteur");
        map.put(destination, "destination");
        map.put(onMoveable1, "onMoveable1");
        map.put(onMoveable2, "onMoveable2");
        
        plumber.SetOnMoveable(onMoveable1);
        saboteur.SetOnMoveable(onMoveable2);
        onMoveable1.SetOccupied(true);
        onMoveable2.SetOccupied(true);
        
        initEnd();

        
        //start test
        FunctionCall functionMove1 = new FunctionCall("test_controller", tabCounter);
        functionTree.add(functionMove1);
        tabCounter++;
        
        plumber.Move(destination);
        
        
        FunctionCall functionMove2 = new FunctionCall("test_controller", tabCounter);
        functionTree.add(functionMove2);
        tabCounter++;
        
        saboteur.Move(destination);
        
        
        //printing
        for(FunctionCall func : functionTree) {
        	func.print();
        }
        
        // clearing
        clear();
    }

    private static void PickupPumpTest() {
        // initializing
        initStart();

        Plumber plumber = new Plumber();
        Cistern cistern = new Cistern();

        map.put(plumber, "plumber");
        map.put(cistern, "cistern");

        initEnd();


        // start test
        FunctionCall functionGetPump = new FunctionCall("test_controller", tabCounter);
        functionTree.add(functionGetPump);
        tabCounter++;

        plumber.GetPump(cistern);

        //printing
        for(FunctionCall func : functionTree)
            func.print();

        // clearing
        clear();
    }

    private static void PlacePumpTest() {
        // initializing
        initStart();

        Plumber plumber = new Plumber();
        Pipe oldPipe = new Pipe();
        Pump oldEndPoint = new Pump();
        Pump otherEndPoint = new Pump();
        Pump carriedPump = new Pump();

		oldPipe.AddEndPoint(otherEndPoint);
		oldPipe.AddEndPoint(oldEndPoint);

        plumber.AddCarriedPump(carriedPump);

        map.put(plumber, "plumber");
        map.put(oldPipe, "oldPipe");
        map.put(oldEndPoint, "oldEndPoint");
        map.put(carriedPump, "carriedPump");

        initEnd();

        // start test
        FunctionCall functionPlacePump = new FunctionCall("test_controller", tabCounter);
        functionTree.add(functionPlacePump);
        tabCounter++;

        plumber.PlacePump(oldPipe);

        //printing
        for(FunctionCall func : functionTree)
            func.print();

        // clearing
        clear();
    }
    
    public static void SabotagePipeTest() {
    	//initializing
    	initStart();
    	
    	Saboteur saboteur = new Saboteur();
    	Pipe pipe = new Pipe();
    	
    	map.put(saboteur, "saboteur");
    	map.put(pipe, "pipe");
    	
    	initEnd();
    	
    	//start test
    	FunctionCall functionSabotage = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionSabotage);
    	tabCounter++;
    	
    	saboteur.Sabotage(pipe);
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	// clearing
    	clear();
    }
    
    public static void SetInputTest() {
    	initStart();
    	
    	Player player = new Plumber();
    	Pipe input = new Pipe();
    	Pipe oldInput = new Pipe();
    	Pump pump = new Pump();
    	
    	map.put(player, "player");
    	map.put(input, "input");
    	map.put(oldInput, "oldInput");
    	map.put(pump, "pump");
    	
    	pump.SetInputId(oldInput);
    	player.SetOnMoveable(pump);
    	
    	initEnd();
    	
    	FunctionCall functionSetInput = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionSetInput);
    	tabCounter++;
    	
    	player.ChangePumpInput(pump, input);
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	// clearing
    	clear();
    	
    }
    
    public static void SetOutputTest() {
    	initStart();
    	
    	Player player = new Plumber();
    	Pipe output = new Pipe();
    	Pipe oldOutput = new Pipe();
    	Pump pump = new Pump();
    	
    	map.put(player, "player");
    	map.put(output, "output");
    	map.put(oldOutput, "oldOutput");
    	map.put(pump, "pump");
    	
    	pump.SetOutputId(oldOutput);
    	player.SetOnMoveable(pump);
    	
    	initEnd();
    	
    	FunctionCall functionSetOutput = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionSetOutput);
    	tabCounter++;
    	
    	player.ChangePumpOutput(pump, output);
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	// clearing
    	clear();
    }
    
    public static void FixPumpTest() {
    	initStart();
    	
    	Plumber plumber = new Plumber();
    	Pump pump = new Pump();
    	
    	map.put(plumber, "plumber");
    	map.put(pump, "pump");
    	
    	pump.Disable();
    	
    	initEnd();
    	
    	FunctionCall functionFixPump = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionFixPump);
    	tabCounter++;
    	
    	plumber.Fix(pump);
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	// clearing
    	clear();
    	
    	
    }
    public static void FixPipeTest() {
    	//initializing
    	initStart();
    	
    	Plumber plumber= new Plumber();
    	Pipe pipe = new Pipe();
    	
    	map.put(plumber, "plumber");
    	map.put(pipe, "pipe");
    	
    	pipe.Disable();
    	
    	initEnd();
    	
    	//start test
    	FunctionCall functionFix = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionFix);
    	tabCounter++;
    	
    	plumber.Fix(pipe);
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	// clearing
    	clear();
    }
    
    public static void BrokePumpTest() {
    	//initializing
    	initPhase = true;
    	Pump pump = new Pump();
    	
    	map.put(pump, "pump");
    	
    	initPhase = false;
    	
    	//start test
    	FunctionCall functionRandomDisable = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionRandomDisable);
    	tabCounter++;
    	
    	pump.RandomDisable();
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	// clearing
    	clear();
    }
    public static void PumpWaterFlowTest() {
    	initStart();
		Pump pump = new Pump();
		Pipe output = new Pipe();
		Pipe input = new Pipe();
		pump.SetOutputId(output);
		pump.SetInputId(input);
		map.put(pump, "pump");
		map.put(output, "output");
		map.put(Desert.GetDesert(), "desert");
		map.put(input, "input");
		initEnd();
		
		FunctionCall functionWaterFlow = new FunctionCall("test_controller", tabCounter);
		functionTree.add(functionWaterFlow);
		tabCounter++;
		pump.WaterFlow();
		
		
		for(FunctionCall func : functionTree) {
        	func.print();
        }
		clear();
    	
    }
    public static void  CreateFreePipeTest() {
    	initStart();
    	Cistern cistern = new Cistern();
    	map.put(cistern, "cistern");
    	initEnd();
    	
    	FunctionCall functionCreateNewPipe= new FunctionCall("test_controller", tabCounter);
		functionTree.add(functionCreateNewPipe);
		tabCounter++;

		cistern.CreateNewPipe();
    	
    	for(FunctionCall func : functionTree)
        	func.print();

    	clear();
    }

    
   //todo: egyiknel vmiert nullt ad vissza
    public static void CisternWaterflowTest() {
    	//initphase
    	initStart();
     	
    	Cistern cistern = new Cistern();
    	Pipe pipe = new Pipe();
    	
    	map.put(cistern, "cistern");
    	map.put(pipe, "pipe");
    	
    	cistern.Addpipe(pipe);
    	pipe.setwaterLevel(5);
    	
    	initEnd();
    	
    	//start test
    	FunctionCall functionCisternWaterFlow = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionCisternWaterFlow);
    	tabCounter++;
    	
    	cistern.WaterFlow();
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	//clear
    	clear();
    	
    }
  

    public static void AttachPipeTest() {
    	//initphase
    	initStart();
    	
     	
    	Plumber plumber = new Plumber();
    	Pump onMoveable = new Pump();
    	Pipe carriedPipe = new Pipe();
    	
    	
    	
    	map.put(plumber, "plumber");
    	map.put(onMoveable, "onMoveable");
    	map.put(carriedPipe, "carriedPipe");
    	
    	
    	initEnd();
    	
    	//start test
    	FunctionCall functionRandomDisable = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionRandomDisable);
    	tabCounter++;
    	
    	plumber.AttachPipe(carriedPipe, onMoveable);
    	
    	
    	 
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	//clear
    	clear();
    	
    }

    //todo: ua mint CisternWaterflowTest
    public static void DetachPipeTest() {
    	//initphase
    	initStart();
    	
     	
    	Plumber plumber = new Plumber();
    	Pump onMoveable = new Pump();
    	Pipe pipe = new Pipe();
    	
    	
    	
    	map.put(plumber, "plumber");
    	map.put(onMoveable, "onMoveable");
    	map.put(pipe, "pipe");
    	
    	
    	initEnd();
    	
    	//start test
    	FunctionCall functionRandomDisable = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionRandomDisable);
    	tabCounter++;
    	
    	plumber.DetachPipe(pipe, onMoveable);
    	
    	
    	 
    	
    	//printing
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	//clear
    	clear();
    }
    
    public static void SourceWaterFlowTest() {
    	initStart();
    	
     	
    	Source source = new Source();
    	Pipe pipe = new Pipe();
    	source.Addpipe(pipe);
    	
    	map.put(source, "source");
    	map.put(pipe, "pipe");
    	
    	initEnd();
    	
    	FunctionCall functionWaterFlow = new FunctionCall("test_controller", tabCounter);
    	functionTree.add(functionWaterFlow);
    	tabCounter++;
    	
    	source.WaterFlow();
    		
    	
    	for(FunctionCall func : functionTree) {
        	func.print();
        }
    	
    	clear();
    }
	
    public static void TestDrawBefore(String testName)
    {
    	String line = new String(new char[testName.length()+4]).replace('\0', '*');
    	String lineWithName = "| " + testName + " |";
    	System.out.println("\t" +  line); 
    	System.out.println("\t" +lineWithName);
    	System.out.println("\t" + line);
    }
    
    
    public static void TestDrawAfter(String testName)
    {
    	String line = new String(new char[testName.length()+4]).replace('\0', '*');
    	System.out.println("\t" + line);
    	
    }
    public static void main(String[] args) {
    	System.out.println("""
                0. Exit
                1. Sabotage Pipe
                2. Fix Pipe
                3. Broke Pump
                4. Fix Pump
                5. Set Input
                6. Set Output
                7. Cistern Waterflow
                8. Attach Pipe
                9. Detach Pipe
                10. Source Waterflow
                11. Move to Active Element
                12. Move to Pipe
                13. Pick up Pump
                14. Place Pump
                15. Pump Waterflow
                16. Create Free Pipe""");

        boolean run = true;
        while (run) {
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();

            switch (command) {
                case 0:
                    run = false;
                    break;
                case 1:
                	TestDrawBefore("Sabotage Pipe");
                    SabotagePipeTest();
                    TestDrawAfter("Sabotage Pipe");
                    break;
                case 2:
                	TestDrawBefore("Fix Pipe");
                    FixPipeTest();
                    TestDrawAfter("Fix Pipe");
                    break;
                case 3:
                	TestDrawBefore("Broke Pump");
                    BrokePumpTest();
                    TestDrawAfter("Broke Pump");
                    break;
                case 4:
                	TestDrawBefore("Fix Pump");
                	FixPumpTest();
                	TestDrawAfter("Fix Pump");
                	break;
                case 5:
                	TestDrawBefore("Set Input");
                	SetInputTest();
                	TestDrawAfter("Set Input");
                	break;
                case 6:
                	TestDrawBefore("Set Output");
                	SetOutputTest();
                	TestDrawAfter("Set Output");
                	break;
                case 7:
                	TestDrawBefore("Cistern waterflow");
                	CisternWaterflowTest();
                	TestDrawAfter("Cistern waterflow");
                	break;
                case 8:
                	TestDrawBefore("Attach Pipe");
                	AttachPipeTest();
                	TestDrawAfter("Attach Pipe");
                	break;
                case 9:
                	TestDrawBefore("Detach Pipe");
                	DetachPipeTest();
                	TestDrawAfter("Detach Pipe");
                	break;
                case 10:
                	TestDrawBefore("Source Waterflow");
                	SourceWaterFlowTest();
                	TestDrawAfter("Source Waterflow");
                	break;
                case 11:
                	TestDrawBefore("Move to Active Element");
                	MoveActiveToElementTest();
                	TestDrawAfter("Move to Active Element");
                    break;
                case 12:
                	TestDrawBefore("Move to Pipe");
                	MoveToPipeTest();
                	TestDrawAfter("Move to Pipe");
                    break;
                case 13:
                	TestDrawBefore("Pick up Pump");
                    PickupPumpTest();
                    TestDrawAfter("Pick up Pump");
                    break;
                case 14:
                    TestDrawBefore("Place Pump");
                    PlacePumpTest();
                    TestDrawAfter("Place Pump");
                    break;
                case 15:
                	TestDrawBefore("Pump Waterflow");
                	PumpWaterFlowTest();
                	TestDrawAfter("Pump Waterflow");
                	break;     
                case 16:
                	TestDrawBefore("Create Free Pipe");
                	CreateFreePipeTest();
                	TestDrawAfter("Create Free Pipe");
                	break;     
                default:
                    System.out.println("No test with given number.");
                    break;
            }
        }
    }*/
}
