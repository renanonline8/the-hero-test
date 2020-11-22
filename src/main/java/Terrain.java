public class Terrain {
    private int side_1;
    private int side_2;
    private final int MIN_AREA = 100;

    public Terrain(int side_1, int side_2) {
        this.side_1 = side_1;
        this.side_2 = side_2;
    }

    public boolean isSquare() {
        if (this.side_1 == this.side_2) {
            return true;
        }
        return false;
    }

    public int calculateArea() {
        return this.side_1 * this.side_2;
    }

    public boolean checkMinArea() {
        if (this.calculateArea() >= this.MIN_AREA) {
            return true;
        }
        return false;
    }

    public double getArableLand(int year) {
        if (year < 2000) {
            return this.calculateArea() * 0.8;
        }
        return this.calculateArea() * 0.2;
    }

    public boolean isLegal(int areaAlreadyArable, int year) {
        if (this.getArableLand(year) >= areaAlreadyArable) {
            return true;
        }
        return false;
    }
}
