import java.util.ArrayList;
import java.util.Random;


public class Dice {

    private int up;
    private int down;
    private int left;
    private int right;
    private int front;
    private int back;

    private final ArrayList<Integer> nums = new ArrayList<>();

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

        pullNums();
    }

    private void pullNums(){
        nums.clear();
        for(int i =1;i<=6;i++){
            nums.add(i);
        }
    }

    private void reset(){
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
        reset();
        Random random = new Random();
        int front = random.nextInt(6)+1;

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
                break;
            case 6:
                rotateDown();
                rotateDown();
                break;
                
        }

        ArrayList<Integer> local_nums = new ArrayList<>(nums);

        local_nums.remove((Integer) this.front);
        local_nums.remove((Integer) this.back);



        int up = local_nums.get(random.nextInt(4));

        while (this.up!=up){
            rotateRed();
        }


    }

}
