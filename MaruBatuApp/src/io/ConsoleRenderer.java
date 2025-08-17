package io;

import model.Board;
import model.Marker;
import model.Position;

/**
 * コンソールへのデータレンダリングクラス
 */
public class ConsoleRenderer {
    /**
     * ボード情報をコンソールに表示する
     *
     * @param board 　ボード情報
     */
    public void render(Board board) {
        System.out.println();
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board.size(); col++) {
                Marker marker = board.get(Position.of(row, col));
                char ch;
                switch (marker) {
                    case X -> ch = 'X';
                    case O -> ch = 'O';
                    default -> ch = '.';
                }
                System.out.print(" " + ch + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * メッセージ表示
     *
     * @param msg 　表示メッセージ
     */
    public void showMessage(String msg) {
        System.out.println(msg);
    }

    /**
     * 結果表示
     *
     * @param winner 　結果表示側のマーカー
     */
    public void showResult(Marker winner) {
        if (winner == null) {
            System.out.println("Draw");
        } else {
            System.out.println("Winner:" + winner);
        }
    }
}
