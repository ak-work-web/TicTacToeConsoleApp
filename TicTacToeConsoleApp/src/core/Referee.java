package core;

import model.Board;
import model.Move;
import model.Position;

/**
 * 審判クラス
 */
public class Referee {

    /**
     * マーク変更が可能か判定
     *
     * @param board　ボード情報
     * @param move　変更情報
     * @return 変更可能の場合は true, それ以外はfalse
     */
    public boolean isLegal(Board board, Move move){
        Position position = move.getPosition();
        return position.row >= 0 && position.col >= 0 &&
                position.row < board.size() && position.col < board.size() &&
                board.isEmpty(position);

    }
}
