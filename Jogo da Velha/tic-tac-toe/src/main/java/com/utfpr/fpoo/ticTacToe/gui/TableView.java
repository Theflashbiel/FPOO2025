package com.utfpr.fpoo.ticTacToe.gui;

import javax.management.RuntimeErrorException;
import javax.swing.ImageIcon;

import com.utfpr.fpoo.ticTacToe.component.AbstractComponent;
import com.utfpr.fpoo.ticTacToe.component.button.ImageButton;
import com.utfpr.fpoo.ticTacToe.model.Mark;
import com.utfpr.fpoo.ticTacToe.model.table.ReadOnlyTableModel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class TableView extends AbstractComponent {

    private ImageIcon icon = null;
    private ImageIcon iconX, iconO;
    private ImageButton[][] table = new ImageButton[3][3];
    private ReadOnlyTableModel tableModel;

    public TableView() {
        super();
        super.dimension = new Dimension(100,100);
        fillTable();
    }
    
    public TableView(ImageIcon icon) {
        this();
        this.icon = icon;
    }

    public TableView(int x, int y, int width, int height, ImageIcon icon) {
        super(x, y, width, height);
        this.icon = icon;
        fillTable();
    }

    public void setIconX (ImageIcon icon){
        this.iconX = icon;
    }

    public void setIconO (ImageIcon icon){
        this.iconO = icon;
    }

    public ImageIcon iconOf(Mark mark){
        return ((mark == Mark.O)? iconO :
                ((mark ==Mark.X)? iconX : null));
    }

    public void setTableModel(ReadOnlyTableModel tableModel){
        this.tableModel = tableModel;
    }
    private void fillTable(){

        int cellWidth = (width()-20)/3;
        int cellHeigh = (height()-20)/3;
        

        for (int lin = 0; lin<table.length; lin++){
            for (int col = 0 ; col<table[lin].length; col++){

                int x = 5 + (lin*(cellHeigh + 5));
                int y = 5 + (col*(cellWidth + 5));

                table[lin][col] = new ImageButton(x, y, cellWidth, cellHeigh, null); 
            }
        }
    }

    private void paintChildren(Graphics g){

        if(tableModel == null)
            throw new RuntimeException("Error: TableModel is null at TableView!");
        
        for (int lin = 0; lin<table.length; lin++){
            for (int col = 0 ; col<table[lin].length; col++){
                Mark mark = tableModel.getMark(lin, col);
                table[lin][col].setImage(iconOf(mark));
                table[lin][col].paint(g);
            }
        }

    }
    @Override
    public void paint(Graphics g) {

        if (icon == null)
            return;
        int xLeft = position.x;
        int yTop = position.y;
        int width = dimension.width;
        int height = dimension.height;

        g.drawImage(icon.getImage(), xLeft, yTop, width, height, null);
    }

}
