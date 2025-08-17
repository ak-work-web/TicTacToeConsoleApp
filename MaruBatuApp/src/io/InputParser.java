package io;

import model.Position;

import java.util.Optional;

/**
 * 入力値の変換クラス
 */
public class InputParser {

    /**
     * 位置情報への変換
     *
     * @param line　文字列データ
     * @param size　ボードサイズ
     * @return Optional<Position> オプショナル型の位置情報
     */
    public Optional<Position> parsePosition(String line, int size){
        try{
//文字列の間に１つ以上の空白文字があれば、そこで文字列を分割する。
            String[] parts = line.trim().split("\\s+");

            //分割後の文字列が２つ以上の場合はデータをからとして返す。
            if(parts.length != 2 ) return Optional.empty();

            //パーツから行と列の値を取得
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            //行と列の値の検証
            if(row < 0 || col < 0 || row >= size || col >= size) return Optional.empty();

            //結果をOptional型に詰めて返す。
            return Optional.of(Position.of(row, col));
        } catch (Exception e){
            return Optional.empty();
        }
    }
}
