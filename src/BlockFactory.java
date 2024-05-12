public class BlockFactory {
    public static Block getInstance(BlockType type, double x, double y){
        Block blockInstance = null;
        if (type == BlockType.DOGERS_BLUE_BLOCK) {

        } else if (type == BlockType.RED_BLOCK) {
            blockInstance = new RedBlock(x,y);
            blockInstance.init(x, y);
        }
        
        return blockInstance;
    }
}