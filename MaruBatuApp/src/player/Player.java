package player;

import io.ConsoleInput;
import io.ConsoleRenderer;
import model.Board;
import model.Marker;
import model.Move;

import java.io.Console;

public interface Player {
    Marker marker();
    Move nextMove(Board board, ConsoleInput in, ConsoleRenderer out);
}
