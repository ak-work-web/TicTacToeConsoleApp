package core;

import model.Board;
import model.Marker;
import model.Position;

/**
 * ゲームルールクラス
 */
public class RuleEngine {

    private final int winLength;

    public RuleEngine(int winLength){
        this.winLength = winLength;
    }

    public boolean isWin(Board board, Marker marker){
        int n = board.size();
        //行・列
        for (int i = 0; i < n; i++){
            if (lineWin(board, marker, i,0,0,1))return true;
            if (lineWin(board, marker, 0,i,1,0))return true;
        }

        //斜め
        if (lineWin(board, marker,  0,  0,  1,  1)) return true;
        if (lineWin(board, marker,  0,  n - 1,  1,  -1)) return true;
        return  false;
    }

    private boolean lineWin(Board board, Marker marker, int row, int col, int dr, int dc){
        for (int k =0; k < winLength; k++){
            int rr = row + dr * k, cc = col + dc * k;
            if (rr < 0 || cc < 0 || rr >=  board.size() || cc >= board.size()) return false;
            if ( board.get(Position.of(rr, cc)) != marker) return false;
        }
        return true;
    }

    /**
     * 引き分け判定
     * ボード情報に空の状態がなく、バツもマルも勝利条件を満たしていない場合、引き分けと判定する。
     *
     * @param board ボード情報
     * @return boolean　引き分けの場合　true、　それ以外の場合はfalseを返す。
     */

    public boolean isDrow(Board board){
        return board.emptyPositions().isEmpty() && !isWin(board, Marker.X) && !isWin(board, Marker.O);
    }


}
