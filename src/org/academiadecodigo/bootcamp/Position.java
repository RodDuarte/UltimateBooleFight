package org.academiadecodigo.bootcamp;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }

    public void moveUp() {
        if (row <= 8 && row > 5) {
        this.row --;
        }
    }

    public void moveDown() {
        if (row >= 5 && row < 8) {
        this.row++;
        }
    }

    public void moveLeft() {
        if (col <= 19 && col >= 0) {
            this.col--;
        }
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Position getPosition() {
        return this;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public String toString() {
        return "Position{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}

