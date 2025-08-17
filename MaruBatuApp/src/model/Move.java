package model;

public class Move {
    private Position position;
    private Marker marker;

    /**
     * コンストラクタ
     *
     * @param position 位置情報
     * @return marker　セル状態
     */

    public Move(Position position, Marker marker){
        this.position = position;
        this.marker = marker;
    }

    /**
     * 位置情報の取得
     *
     * @return position 位置情報
     */
    public Position getPosition(){
        return position;
    }

    /**
     * 背r状態取得
     *
     * @return Marker　セル状態
     */
    public Marker getMarker(){
        return marker;
    }

}
