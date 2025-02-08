import java.util.Arrays;
import java.util.Scanner;

public class Main {
    // My first thought is to make 2 functions, one that gets the grid size and
    // one that gets the size of the movable object. Time will tell if this works!

    // Update  was trying to find the size of the object, realized I don't need to :3
    static Scanner input = new Scanner(System.in);// Length,Height
    static char[][] testGrid = {{' ',' ',' '},  // Row 1
                                {'#',' ',' '},  // Row 2
                                {' ','#',' '}}; // Row 3
    // Realizing I need a lot of variables
    // Realizing I didn't need a lot of variables


    static void moveUp(char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == ('#')){
                    if (i != 0){
                        array[i][j] = ' ';
                        array[i-1][j] = '#';
                    } else {
                        System.out.println("Cannot Move Down");
                        return;
                    }
                }
            }
        }
    }



    static void moveDown(char[][] array){
        // So I've encountered an issue at this point where the moveUp function goes from top to bottom which
        // works BUT if I try to use the same code for move down it'll overwrite some of the values
        // Example :
        // Input :
        // [ , X,  ,  ]
        // [X, X,  ,  ]
        // [ ,  ,  ,  ]
        //
        // moveDown();
        // Output :
        // [ ,  ,  ,  ]
        // [ ,  ,  ,  ]
        // [X, X,  ,  ]
        //
        // Fix : Go from bottom to top
        // Also realized I'm going to have to iterate differently for each one
        for (int i = array.length - 1; i >= 0; i--) {
            // It is at this moment I realize I have to do a flipped grid of pain and suffering
            for (int j = 0; j < array[i].length; j++) {

                if(array[i][j] == ('#')){
                    if (i != array.length - 1){
                        array[i][j] = ' ';
                        array[i+1][j] = '#';
                    } else {
                        System.out.println("Cannot Move Down");
                        return;
                    }
                }
            }
        }
    }



    // Trying to move left is proving...difficult
    static void moveLeft(char[][] array){

        char[][] original = new char[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, original[i], 0, array[i].length);
        }

        for (int i = 0; i < array.length; i++) {
            // It is at this moment I realize I have to do a flipped grid of pain and suffering
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == ('#')){
                    if (j != 0){
                        array[i][j] = ' ';
                        array[i][j-1] = '#';
                    } else {
                        System.out.println("Cannot Move Left");
                        for (int t = 0; t < array.length; t++) {
                            System.arraycopy(original[t], 0, array[t], 0, original[t].length);
                        }
                        return;
                    }
                }
            }
        }
    }


    static void moveRight(char[][] array){

        char[][] original = new char[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(array[i], 0, original[i], 0, array[i].length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array[i].length - 1; j >= 0; j--) {
                if(array[i][j] == ('#')){
                    if (j != array[i].length - 1){
                        array[i][j] = ' ';
                        array[i][j+1] = '#';
                    } else {
                        System.out.println("Cannot Move Right");
                        for (int t = 0; t < array.length; t++) {
                            System.arraycopy(original[t], 0, array[t], 0, original[t].length);
                        }
                        return;
                    }
                }
            }
        }
    }



    // The only thing that didn't break! The main smh
    public static void main(String[] args) {
        while(true){

            System.out.println("Which way do you want to move? (Up, Down, Left, Right). To exit the program just say 'Exit'\nCurrent Grid : ");

            for (char[] strings : testGrid) {
                System.out.println(Arrays.toString(strings));
            }

            String userInput = input.nextLine();
            if (userInput.equalsIgnoreCase("up")) {
                moveUp(testGrid);
            } else if (userInput.equalsIgnoreCase("down")) {
                moveDown(testGrid);
            } else if (userInput.equalsIgnoreCase("left")) {
                moveLeft(testGrid);
            } else if (userInput.equalsIgnoreCase("right")) {
                moveRight(testGrid);
            } else if (userInput.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("That wasn't an option ;w;");
            }
        }
    }
}