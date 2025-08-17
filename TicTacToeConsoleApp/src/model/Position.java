package model;

import java.util.Objects;

/**
位置情報クラス
 */
public class Position {
    public final int row, col;

 /**
 *コンストラクタ
 *
 * @param row
 * @param col
  */

    private Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    /**
     *  行位置と列位置からPositionクラスを生成する
     *
     * @param row 行位置
     * @param col 列位置
     * @return Position 位置情報
     */
    public static Position of(int row, int col){
        return new Position(row, col);
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Position)) return false;
        Position position = (Position) obj;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
