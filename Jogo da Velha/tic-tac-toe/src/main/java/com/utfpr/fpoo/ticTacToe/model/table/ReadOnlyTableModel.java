package com.utfpr.fpoo.ticTacToe.model.table;

import com.utfpr.fpoo.ticTacToe.model.Mark;

public interface ReadOnlyTableModel {

        Mark getMark(int lin, int col);
    
}