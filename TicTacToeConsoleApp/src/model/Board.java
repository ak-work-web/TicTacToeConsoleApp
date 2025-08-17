package model;

import java.util.ArrayList;
import java.util.List;

/**
 * マルバツボードクラス
 */
public class Board {
    //列または行数
    private final int size;

    //各セル情報
    private final Marker[][] cells;

    /**
     * 列数を受け取り、そのサイズに合ったボード情報を初期化する。
     *
     * @param size 列数
     */

    public Board(int size) {
        this.size = size;
        this.cells = new Marker[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                cells[r][c] = Marker.EMPTY;
            }
        }
    }

    /**
     * サイズ取得
     *
     * @return size サイズ
     */
    public int size() {
        return size;
    }


    /**
     * 位置情報からセルの状態を取得
     *
     * @param p 位置情報
     * @return Marker セルの情報
     */
    public Marker get(Position p) {
        return cells[p.row][p.col];
    }


    /**
     * 位置情報からそのセルが空状態か判定する
     *
     * @param position 位置情報
     * @return 空状態ならture、それ以外はfalse
     */
    public boolean isEmpty(Position position) {
        return get(position) == Marker.EMPTY;
    }

    /**
     * ボードの状態を変更する
     * 変更が成功した場合ture、失敗した場合はfalseを返す。
     *
     * @param move 　変更情報
     * @return 変更結果　成功した場合はture、それ以外はfalse
     */

    public boolean place(Move move) {
        Position p = move.getPosition();
        if (!isEmpty(p)) return false;
        cells[p.row][p.col] = move.getMarker();
        return true;
    }

    /**
     * 空状態のセルの位置情報をリスト形式で返す
     *
     * @return 空状態の位置情報のリスト
     */

    public List<Position> emptyPositions() {
        List<Position> list = new ArrayList<>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (cells[r][c] == Marker.EMPTY) list.add(Position.of(r, c));
            }
        }
        return list;
    }


}
