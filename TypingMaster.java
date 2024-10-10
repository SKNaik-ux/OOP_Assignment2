/*
AUTHOR: SAISH NAIK
VERSION: 1.0
 */


import java.util.Scanner;

public class TypingMaster {
    public static void main(String[] args) {
        int options;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to the TYPE MASTER!\n");
        System.out.println("1.] PLAY GAME \n0.] QUIT GAME");
        System.out.println("Enter your choice: ");
        options = sc.nextInt();

        //runner block
        if (options==1){
            gameRun();
        } else if (options==0) {
            System.exit(0);
        }
    }


    public static void gameRun(){
        // Sample sentences
        String[] dummysentences = {
                "I seriously doubt she actually believes you.",
                "I feel like blowing something up.",
                "It’s time to watch TV.",
                "My father doesn’t speak good English.",
                "What toy do you wish you had?"
        };

        // Selecting a random sentence from above sentences
        int sentenceIndex = (int) (Math.random() * dummysentences.length);
        String sentenceToType = dummysentences[sentenceIndex];


        System.out.println("Type FASSSTTT and ACCURATELY...!!");
        System.out.println("\n" + sentenceToType + "\n");

        // start time
        long TypestartTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        // end time
        long TypeendTime = System.currentTimeMillis();

        // Calculates the time taken in seconds
        double timeTaken = (TypeendTime - TypestartTime) / 1000.0;

        // Calculates typing speed (WPM)- score
        int wordCount = sentenceToType.split(" ").length;
        double typeScore = (wordCount / timeTaken) * 60;

        // Calculate accuracy
        int correctChars = 0;
        for (int i = 0; i < Math.min(sentenceToType.length(), userInput.length()); i++) {
            if (sentenceToType.charAt(i) == userInput.charAt(i)) {
                correctChars++;
            }
        }
        double accuracy = ((double) correctChars / sentenceToType.length()) * 100;

        // Display results
        System.out.println("\nTime taken: " + timeTaken + " seconds");
        System.out.printf("Your Score: %.2f words per minute (WPM)\n", typeScore);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);


//        if (accuracy>=80){
//            System.out.println("Your Accuracy is Excellent...Keep it up!!!");
//        } else if (accuracy>=60) {
//            System.out.println("Your Accuracy is Good...Keep trying to Make it at least 90%!!");
//        } else if (accuracy<60) {
//            System.out.println("Your Accuracy is Weak...Keep trying to Make it at least 80%!!");
//        }

        // Retry game
        int retry;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n2.] RETRY \n0.] EXIT ");
        retry = sc.nextInt();

        if(retry==2){
            gameRun();
        } else if (retry==0) {
            System.exit(0);
        }
        scanner.close();
    }

}
