import java.util.Random;
public class RandomUtils{
    public static BlockType randomBlockType(){
        int randBlockNum = new Random().nextInt(4) + 4;
        switch (randBlockNum) {
            /* case 1:
                return BlockType.RED_BLOCK;
            case 2:
                return BlockType.TEAL_BLOCK;
            case 3:
                return BlockType.DOGERS_BLUE_BLOCK;*/
            case 4:
                return BlockType.YELLOW_BLOCK;
            case 5:
                return BlockType.ORANGE_BLOCK;
            case 6:
                return BlockType.PURPLE_BLOCK;
            case 7:
                return BlockType.GREEN_BLOCK;
            default:
                return null;
        }
    }

    public static int randomInt(int min, int max){
        int randInt = new Random().nextInt(max - min) + min;
        return randInt;
    }
    
    public static double randomDouble(double min, double max){
        double randDouble = new Random().nextDouble(max - min) + min;
        return randDouble;
    }
}