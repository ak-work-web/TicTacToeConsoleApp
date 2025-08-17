package player;

import io.ConsoleInput;
import io.ConsoleRenderer;
import io.InputParser;
import model.Board;
import model.Marker;
import model.Move;
import model.Position;

import java.util.Optional;

/**
 * プレイヤー（人）クラス
 */
public class HumanPlayer implements Player{

 //使用する記号（マルorバツ）
 private final Marker marker;

 //入力値変換クラスのインスタンス
 private final InputParser parser = new InputParser();


    /**
     * コンストラクタ
     *
     * @param marker プレイヤーの使用する記号（マルorバツ）
     */
 public HumanPlayer(Marker marker){
     this.marker = marker;

 }

 @Override
    public Marker marker(){
     return marker;
 }

 @Override
    public Move nextMove(Board board, ConsoleInput in, ConsoleRenderer out){
     while (true){
         out.showMessage("Player " + marker + ": enter row col (e.g. o 2):");
         Optional<Position> pos = parser.parsePosition(in.readLine(), board.size());

         if(pos.isPresent()) return new Move(pos.get(), marker);

         out. showMessage("Invalid input. Try again.");

     }
 }

}
