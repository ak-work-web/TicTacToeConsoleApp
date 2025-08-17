package app;

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。

import core.Game;
import core.Referee;
import core.RuleEngine;
import io.ConsoleInput;
import io.ConsoleRenderer;
import model.Board;
import model.Marker;
import player.HumanPlayer;
import player.Player;

/**
 * メインクラス
 */
public class Main {
    public static void main(String[] args) {

        Board board = new Board(3);
        RuleEngine rules = new RuleEngine(3);
        Referee referee = new Referee();
        ConsoleRenderer out = new ConsoleRenderer();
        ConsoleInput in = new ConsoleInput();

        Player player1 = new HumanPlayer(Marker.X);
        Player player2 = new HumanPlayer(Marker.O);

        new Game(board, player1, player2, referee, rules, out, in).run();


    }
}