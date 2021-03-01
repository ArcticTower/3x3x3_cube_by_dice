import java.util.Random;


public class Dice {

    private int up;
    private int down;
    private int left;
    private int right;
    private int front;
    private int back;

    int getUp(){
        return up;
    }

    int getDown(){
        return down;
    }

    int getLeft(){
        return left;
    }

    int getRight(){
        return right;
    }

    int getFront(){
        return front;
    }

    int getBack(){
        return back;
    }

    public Dice(){

        front = 1;
        back = 6;

        up = 5;
        down = 2;

        left = 4;
        right = 3;
    }

    private void rotateRight(){

        int buf = right;
        right = front;
        front = left;
        left = back;
        back = buf;

    }

    private void rotateDown(){

        int buf = down;
        down = front;
        front = up;
        up = back;
        back = buf;

    }
    
    private void rotateUp(){

        int buf = up;
        up = front;
        front = down;
        down = back;
        back = buf;

    }

    private void rotateLeft(){

        int buf = left;
        left = front;
        front = right;
        right = back;
        back = buf;

    }

    private void rotateRed(){

        int buf = right;
        right = up;
        up = left;
        left = down;
        down = buf;

    }

    public void shuffle(){

        Random random = new Random();
        int front = random.nextInt(6)+1;
        int red = random.nextInt(4);
        switch (front){
            case 1:
                break;
            case 2:
                rotateUp();
                break;
            case 3:
                rotateLeft();
                break;
            case 4:
                rotateRight();
                break;
            case 5:
                rotateDown();
            case 6:
                rotateDown();
                rotateDown();
                break;
                
        }

        for (int i =0;i<red;i++){
            rotateRed();
        }

//        int r = random.nextInt(4);
//        int d = random.nextInt(4);
//        int r2 = random.nextInt(4);
//
//        for(int i =0;i<r;i++){
//
//            rotateRight();
//
//        }
//
//        for(int i =0;i<d;i++){
//
//            rotateDown();
//
//        }
//
//        for(int i =0;i<r2;i++){
//
//            rotateRight();
//
//        }

    }

}
