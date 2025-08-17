package io;

import java.util.Scanner;

/**
 * コンソールでの入力用クラス
 */
public class ConsoleInput {

    //スキャナー
    private final Scanner scanner = new Scanner(System.in);

    /**
     * 入力されたテキスト行を読み込む
     * @return string 文字列
     */
    public String readLine(){
        return scanner.nextLine();
    }
}
