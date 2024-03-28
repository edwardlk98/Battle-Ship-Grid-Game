import java.util.ArrayList;

public class StartupBust{
        private GameHelper helper = new GameHelper();
        private ArrayList<Startup> startups = new ArrayList<Startup>();
        private int numofGuesses = 0;

        public void setupGame(){
        Startup startup1 = new Startup();
        Startup startup2 = new Startup();
        Startup startup3 = new Startup();
        startup1.setName("Startup1");
        startup2.setName("Startup2");
        startup3.setName("Startup3");
        startups.add(startup1);
        startups.add(startup2);
        startups.add(startup3);
        System.out.println("Your goal is to sink three startups. ");
        System.out.println("Startup1, Starup2, Startup3");
        System.out.println("Try to sink them all in the fewest number of guesses");
            for (Startup startup: startups){
                ArrayList<String> newLocation = helper.placeStartup(3);
                startup.setLocationCells(newLocation);
            }

        }
        public void startPlaying(){
            while (!startups.isEmpty()) {
                String userGuess = helper.getUserInput("Enter a Guess");
                checkUserGuess(userGuess);
            }
            finishGame();
        }
        public void checkUserGuess(String userGuess){
            numofGuesses++;
            String result = "miss";
            for (Startup startupToTest : startups){
                result = startupToTest.checkYourself(userGuess);
                if(result.equals("hit")){
                    break;
                }
                if (result.equals("kill")){
                    startups.remove(startupToTest);
                    break;
                }
            }
            System.out.println(result);
        }
        public void finishGame(){
            System.out.println("All Startups aree dead! Your stock is now worthless");
            if (numofGuesses <= 18){
                System.out.println("It only took you " + numofGuesses + " guessses");
                System.out.println("You got out before your option sank");
            }
            else{
                System.out.println("Took you long enough. " + numofGuesses + " guesses");
                System.out.println("Fish are dancing with your options");
            }

        }
        public static void main(String[] args) {
            StartupBust game = new StartupBust();
            game.setupGame();
            game.startPlaying();
        }
    
}