public class Main {

    public static void main(String[] args){

        if(args.length!=2){
            System.out.println("Usage: wight number_of_iterations\n");
            System.exit(0);
        }

        int wight = Integer.parseInt(args[0]);
        long N = Long.parseLong(args[1]);
        System.out.println("Parameters:\n\twight = "+wight+"\n\titerations: = "+N);
        long P = N;

        long goods=0;
        long two_goods=0;

        Cube cube = new Cube(wight);

        while (N>0){

            cube.shuffle();

            int[] res = cube.getResult();


            for (int i =0;i<6;i++){
                if(res[i]!=0){
                    goods++;
                    for (int j = i+1;j<6;j++){
                        if(res[j]==res[i]){
                            goods--;
                            two_goods++;
                        }
                    }
                }
            }

            N--;
        }
        long sum = goods+two_goods;
        double one_chance = (double)goods/(double)P;
        double two_chance = (double)two_goods/(double)P;
        double sum_chance = (double)sum/(double)P;

        System.out.println("One side: "+goods);
        System.out.println("One side chance: "+String.format("%.10f", one_chance));
        System.out.println("Two sides: "+two_goods);
        System.out.println("Two sides chance: "+String.format("%.10f", two_chance));
        System.out.println("Sum: "+sum);
        System.out.println("Sum chance: "+String.format("%.10f", sum_chance));


    }

}
