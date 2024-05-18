public class BlockFactory {
    public static Block getInstance(BlockType type, double x, double y){
        Block blockInstance = null;
        if (type == BlockType.RED_BLOCK) {
            blockInstance = new RedBlock(x,y);
            blockInstance.init(x, y);
        } else if (type == BlockType.DOGERS_BLUE_BLOCK) {
            blockInstance = new DogersBlueBlock(x,y);
            blockInstance.init(x, y);
        } else if (type == BlockType.TEAL_BLOCK) {
            blockInstance = new TealBlock(x,y);
            blockInstance.init(x, y);
        } else if (type == BlockType.ORANGE_BLOCK) {
            blockInstance = new OrangeBlock(x,y);
            blockInstance.init(x, y);
        } else if (type == BlockType.PURPLE_BLOCK) {
            blockInstance = new PurpleBlock(x,y);
            blockInstance.init(x, y);
        } else if (type == BlockType.YELLOW_BLOCK) {
            blockInstance = new YellowBlock(x,y);
            blockInstance.init(x, y);
        } else {
            blockInstance = new GreenBlock(x, y);
            blockInstance.init(x,y);
        }
        
        return blockInstance;
    }
}