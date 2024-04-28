import java.util.Random;
import java.util.Scanner;

public class App {
    

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        char input = ' '; 

        Block[] blocks = new Block[BlockType.values().length]; // 모든 블록을 저장할 배열 생성
        for (int i = 0; i < BlockType.values().length; i++) {
            // 랜덤한 시작 위치 생성
            int startX = rand.nextInt(501); // X 좌표는 0부터 500까지
            int startY = rand.nextInt(101); // Y 좌표는 0부터 100까지

            // 시작 위치로 블록 생성
            Point startPoint = new Point(startX, startY);
            blocks[i] = BlockBuilder.buildBlock(BlockType.values()[i], startPoint); // 생성된 블록을 배열에 저장
        }

        do {
            // 사용자로부터 BlockType 선택
            System.out.println("Enter block type (RED_BLOCK, TEAL_BLOCK, DOGERS_BLUE_BLOCK): ");
            String blockTypeStr = scanner.nextLine();
            BlockType blockType = BlockType.valueOf(blockTypeStr);

            // 사용자로부터 시작 위치 입력 받음
            System.out.println("Enter starting position (X Y): ");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            // 사용자로부터 이동량 입력 받음
            System.out.println("Enter translation amount (dx dy): ");
            int dx = scanner.nextInt();
            int dy = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거

            // 입력 받은 블록 타입에 해당하는 블록을 찾아서 이동
            Block block = null;
            for (Block b : blocks) {
                if (b.getType() == blockType) {
                    block = b;
                    break;
                }
            }

            // 블록을 찾지 못한 경우 메시지 출력 후 반복문 재실행
            if (block == null) {
                System.out.println("Block type not found. Please try again.");
                continue;
            }

            // 입력 받은 이동량으로 블록 이동
            block.translate(dx, dy);
            //System.out.println("Upper left coordinate of the block: " + block.getSquares()[0].getUpperLeft());

            // 이동 후의 좌표 출력
            System.out.println("Block moved: " + block);

            // 사용자에게 계속할 지 묻기
            System.out.println("Press 'q' to quit, or press Enter to continue.");
            input = scanner.nextLine().charAt(0); // 첫 번째 문자만 가져옴
        } while (input != 'q');

        // 프로그램 종료
        scanner.close();
    }
}


