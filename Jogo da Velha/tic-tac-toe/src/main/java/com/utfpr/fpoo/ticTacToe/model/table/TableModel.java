package com.utfpr.fpoo.ticTacToe.model.table;

import com.utfpr.fpoo.ticTacToe.model.Mark;

public interface TableModel extends ReadOnlyTableModel {

    void setMark(int lin, int col, Mark mark);
    void reset();
} 
