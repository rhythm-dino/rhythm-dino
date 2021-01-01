package dino.extension;

import java.util.Objects;

public class position{
    private int x,y;
    public position(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        position position = (position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public position addX(int px) {
        this.x+=px;
        return this;
    }
    public position addY(int px) {
        this.y+=px;
        return this;
    }
}
