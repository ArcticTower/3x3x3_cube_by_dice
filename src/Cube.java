public class Cube {

    private int wight;
    private Dice[][][] dices;

    public Cube(int n){

        wight = n;

        this.dices = new Dice[n][n][n];

//        for(Dice[][] block : dices) {
//            for (Dice[] line : block) {
//                for (Dice dice : line) {
//                    dice = new Dice();
//                }
//            }
//        }

        for (int i =0;i<n;i++){
            for (int j =0;j<n;j++){
                for (int k=0;k<n;k++){
                    dices[i][j][k] = new Dice();
                }
            }
        }
    }

    public void shuffle(){

        for (Dice[][] block: dices) {
            for (Dice[] line : block) {
                for (Dice dice : line) {
                    dice.shuffle();
                }
            }
        }
    }

    private int checkFront(){

        for (int i =0;i<wight;i++){
            for (int j=0;j<wight-1;j++){
                if(dices[i][j][0].getFront() != dices[i][j+1][0].getFront()){
                    return 0;
                }
            }
        }
        for (int i =0;i<wight-1;i++){
            if(dices[i][0][0].getFront()!=dices[i+1][0][0].getFront()){
                return 0;
            }
        }
        return dices[0][0][0].getFront();
    }

    private int checkBack(){

        int last = this.wight-1;

        for (int i=0;i<wight;i++){
            for (int j =0;j<wight-1;j++){
                if(dices[i][j][last].getBack()!=dices[i][j+1][last].getBack()){
                    return 0;
                }
            }
        }

        for (int i =0;i<wight-1;i++){
            if(dices[i][0][last].getBack()!=dices[i+1][0][last].getBack()){
                return 0;
            }
        }
        return dices[0][0][last].getBack();
    }

    private int checkUp(){

        for (int i =0;i<wight;i++){
            for (int j =0;j<wight-1;j++){
                if(dices[0][i][j].getUp()!=dices[0][i][j+1].getUp()){
                    return 0;
                }
            }
        }

        for (int i=0;i<wight-1;i++){
            if (dices[0][i][0].getUp()!=dices[0][i+1][0].getUp()){
                return 0;
            }
        }
        return dices[0][0][0].getUp();
    }

    private int checkDown(){

        int last = this.wight-1;

        for (int i =0;i<wight;i++){
            for (int j =0;j<wight-1;j++){
                if(dices[last][i][j].getDown()!=dices[last][i][j+1].getDown()){
                    return 0;
                }
            }
        }

        for (int i=0;i<wight-1;i++){
            if (dices[last][i][0].getDown()!=dices[last][i+1][0].getDown()){
                return 0;
            }
        }
        return dices[last][0][0].getDown();

    }

    private int checkLeft(){

        for(int i=0;i<wight;i++){
            for (int j=0;j<wight-1;j++){
                if(dices[i][0][j].getLeft()!=dices[i][0][j+1].getLeft()){
                    return 0;
                }
            }
        }

        for (int i=0;i<wight-1;i++){
            if(dices[i][0][0].getLeft()!=dices[i+1][0][0].getLeft()){
                return 0;
            }
        }
        return dices[0][0][0].getLeft();
    }

    private int checkRight(){

        int last = this.wight-1;

        for(int i=0;i<wight;i++){
            for (int j=0;j<wight-1;j++){
                if(dices[i][last][j].getRight()!=dices[i][last][j+1].getRight()){
                    return 0;
                }
            }
        }

        for (int i=0;i<wight-1;i++){
            if(dices[i][last][0].getRight()!=dices[i+1][last][0].getRight()){
                return 0;
            }
        }
        return dices[0][last][0].getRight();
    }

    public int[] getResult(){
        int[] res = new int[6];

        res[0] = checkFront();
        res[1] = checkUp();
        res[2] = checkBack();
        res[3] = checkDown();
        res[4] = checkLeft();
        res[5] = checkRight();

        return res;

    }

}
