public class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point point) {
        // сохранение одного знака после запятой (без математического округления)
        return (double) ((int) (Math.sqrt((point.x - this.x) * (point.x - this.x)
                + (point.y - this.y) * (point.y - this.y)) * 10)) / 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point point = (Point) obj;
        return x == point.x || y == point.y;

    }
    @Override
    public String toString() {
        return String.format("""
                Точка (%d, %d)
                """, getX(), getY());
    }
}
