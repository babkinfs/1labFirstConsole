import java.util.List;

public class MyPolygon {
    private int[] polygonX;
    private int[] polygonY;

    public MyPolygon(List<Integer> polygonX, List<Integer> polygonY){
        this.polygonX = polygonX.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        this.polygonY = polygonY.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
//    public void setPolygonX(int[] polygonX) {
//        this.polygonX = polygonX;
//    }
//
//    public void setPolygonY(int[] polygonY) {
//        this.polygonY = polygonY;
//    }

    public int[] getPolygonX() {
        return polygonX;
    }

    public int[] getPolygonY() {
        return polygonY;
    }
    public int getCount(){
        return polygonX.length;
    }
}
