public class BlockBuilder {
    final static int BLOCK_WIDTH = 50;
    
    public static Block buildRedBlock(Point p){
        
        Square [] squares = new Square[4];
        squares [0] = new Square(p, BLOCK_WIDTH);
        squares [1] = new Square(new Point(p.getX() + BLOCK_WIDTH,p.getY()) , BLOCK_WIDTH);//새로운 포인터 만들기
        squares [2] = new Square(new Point(p.getX(), p.getY() + BLOCK_WIDTH), BLOCK_WIDTH);
        squares [3] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY() + BLOCK_WIDTH), BLOCK_WIDTH);

        Block red = new Block(BlockType.RED_BLOCK, squares);
        return red;// 만들어서 리턴 이거 원레 Red Block이었는데 객체 만들어서 red로 리턴함
    }

    public static Block buildTealBlock(Point p){
        
        Square [] squares = new Square[4];
        squares [0] = new Square(p, BLOCK_WIDTH);
        squares [1] = new Square(new Point(p.getX(), p.getY() + BLOCK_WIDTH), BLOCK_WIDTH);;//새로운 포인터 만들기
        squares [2] = new Square(new Point(p.getX(), p.getY() + (2 * BLOCK_WIDTH)), BLOCK_WIDTH);
        squares [3] = new Square(new Point(p.getX(), p.getY() + (3 * BLOCK_WIDTH)), BLOCK_WIDTH);

        Block teal = new Block(BlockType.TEAL_BLOCK, squares);
        return teal;
    }

    public static Block buildBlueBlock(Point p){
        
        Square [] squares = new Square[4];
        squares [0] = new Square(p, BLOCK_WIDTH);
        squares [1] = new Square(new Point(p.getX(), p.getY() + BLOCK_WIDTH), BLOCK_WIDTH);;//새로운 포인터 만들기
        squares [2] = new Square(new Point(p.getX() + BLOCK_WIDTH, p.getY() + BLOCK_WIDTH), BLOCK_WIDTH);
        squares [3] = new Square(new Point(p.getX() + (2 * BLOCK_WIDTH), p.getY() + BLOCK_WIDTH), BLOCK_WIDTH);

        Block dogersBlue = new Block(BlockType.DOGERS_BLUE_BLOCK, squares);
        return dogersBlue;
    }

    public static Block buildBlock(BlockType type, Point upperLeft) {
        // 블록을 생성하여 반환하는 코드 작성
        Square[] squares = new Square[4];
        squares[0] = new Square(upperLeft, BLOCK_WIDTH);
        // 나머지 사각형 추가 구현
    
        Block block = new Block(type, squares);
        return block;
    }
    
}
