package core;

import io.ConsoleInput;
import io.ConsoleRenderer;
import model.Board;
import model.Move;
import player.Player;

/**
 * ゲームクラス
 */
public class Game {

    private final Board board;
    private final Player[] players;
    private int turnIndex = 0;
    private final Referee referee;
    private final RuleEngine rules;
    private final ConsoleRenderer out;
    private final ConsoleInput in;

    /**
     * コンストラクタ
     *
     * @param board   　ボード情報
     * @param player1 　プレイヤー１の情報
     * @param player2 　プレイヤー１の情報
     * @param referee 　審判クラスインスタンス
     * @param rules   　ゲームルール
     * @param out     　コンソール出力用
     * @param in      　コンソールでの入力用
     */
    public Game(
            Board board,
            Player player1,
            Player player2,
            Referee referee,
            RuleEngine rules,
            ConsoleRenderer out,
            ConsoleInput in

    ) {
        this.board = board;
        this.players = new Player[]{player1, player2};
        this.referee = referee;
        this.rules = rules;
        this.out = out;
        this.in = in;

    }

    public void run() {
//タイトルとボードサイズを表示
        out.showMessage("Tic-Tac-Toe" + board.size() + "X" + board.size());

        //ボード情報を表示
        out.render(board);

        while (true) {
            //現在のプレイヤー情報を取得
            Player currentPlayer = players[turnIndex];
            //マス目の選択
            Move move = currentPlayer.nextMove(board, in, out);


            if (!referee.isLegal(board, move)) {
                out.showMessage("Illegal move. Try agein.");
                continue;
            }
            //データ更新
            board.place(move);
            //ボード情報の表示
            out.render(board);

            //勝敗判定
            if (rules.isWin(board,currentPlayer.marker())){
                out.showResult(currentPlayer.marker());
                break;
            }

            //引き分け判定
            if (rules.isDrow(board)){
                out.showResult(null);
                break;
            }

            //ターン変更
            turnIndex = 1 - turnIndex;
        }

    }
}

