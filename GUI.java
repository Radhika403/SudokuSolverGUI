import javax.swing.*;
// import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import Solver.java;
// import java.util.*;

public class GUI extends Solver implements ActionListener{

    

    public GUI() {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(800, 600));

        JPanel panel = new JPanel();

        JTextField[] fields = new JTextField[81];
        for (int x=0 ; x<81 ; x++){
            fields[x] = new JTextField();
        }


        JButton b1 = new JButton("Solve");
        JButton b2 = new JButton("Clear grid");
        JButton b3 = new JButton(" Exit");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(10, 3)); //imported awt module for this
        for (int x=0 ; x<81 ; x++) {
           panel.add(fields[x]);
        }
        panel.add(b1);panel.add(b2);panel.add(b3);


        

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sudoku Solver");
        frame.pack();
        frame.setVisible(true);

        // b1.addActionListener(this);
        // public void actionPerformed(ActionEvent e) {
        //     if(e.getSource() == b1){
        //         GUIToSudoku(fields);
        //     }
        // }
    
    }

    void GUIToSudoku(JTextField[] fields){
        SudokuClass inputPuzzle = new SudokuClass();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                String val = fields[2 * i + j].getText();
                if (val.equals("")){
                    inputPuzzle.sudoku[i][j] = 0;
                }else{
                    inputPuzzle.sudoku[i][j] = Integer.parseInt(fields[2 * i + j].getText());
                }
            }
        }
        
        inputPuzzle.show();

        solve(inputPuzzle, 0, 0);
        // inputPuzzle.show();
        // SudokuToGUI(inputPuzzle);
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     if(e.getSource() == b1){
    //         GUIToSudoku(fields);
    //     }
    // }


}


