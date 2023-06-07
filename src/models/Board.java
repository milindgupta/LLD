package models;

import java.util.ArrayList;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        for(int i = 0; in < size; ++i) {
            this.board.add(new ArrayList<>());
            for(int j =0; j<size;++j) {
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }



    public void setSize(int size) {
        this.size = size;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }



    public int getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }



}
