package com.utfpr.fpoo.ticTacToe.model.score;

public interface ScoreModel extends ReadOnlyScoreModel  {

    void incScoreX();
    void incScoreO();
    void reset();
    
}
