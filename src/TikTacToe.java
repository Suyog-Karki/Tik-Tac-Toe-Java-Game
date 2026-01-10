import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TikTacToe {
    int boardWidth = 600;
    int boardHeight = 650;
    JFrame frame = new JFrame("Tik Tak Toe");
    JLabel tLabel = new JLabel();
    JPanel tPanel = new JPanel();
    JPanel bPanel = new JPanel();
    JButton[][] board = new JButton[3][3];
    String PlayerX = "X";
    String PlayerO = "O";
    String CurrentPlayer = PlayerX;
    boolean GameOver = false;
    int turns=0;

    public TikTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        tLabel.setBackground(Color.darkGray);
        tLabel.setForeground(Color.white);
        tLabel.setFont(new Font("Arial", Font.BOLD, 60));
        tLabel.setHorizontalAlignment(JLabel.CENTER);
        tLabel.setText("TIK TAK TOE");
        tLabel.setOpaque(true);
        tPanel.setLayout(new BorderLayout());
        tPanel.add(tLabel);
        frame.add(tPanel, BorderLayout.NORTH);

        bPanel.setLayout(new GridLayout(3, 3));
        bPanel.setBackground(Color.darkGray);
        frame.add(bPanel);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tile = new JButton();



                board[i][j] = tile;
                bPanel.add(tile);
                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.red);
                tile.setFocusable(false);

                tile.setFont(new Font("arial", Font.BOLD, 125));


                tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (GameOver) {
                            return;

                        }
                        JButton tile = (JButton) e.getSource();
                        if (tile.getText().isEmpty()) {
                            tile.setText(CurrentPlayer);
                            turns++;
                            checkWinner();
                            if (!GameOver) {

                                if (CurrentPlayer.equals(PlayerX)) {
                                    CurrentPlayer = PlayerO;
                                } else {
                                    CurrentPlayer = PlayerX;
                                }
                                tLabel.setText("It is " + CurrentPlayer + "'s turn.");
                            }
                        }


                    }
                });


            }
        }


    }

    void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText().isEmpty()) continue;
            if (board[i][0].getText() == board[i][1].getText() &&
                    board[i][1].getText() == board[i][2].getText()) {
                for (int k = 0; k < 3; k++) {
                    setWinner(board[i][k]);

                }
                GameOver = true;
                return;

            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j].getText().isEmpty()) continue;
            if (board[0][j].getText() == board[1][j].getText() &&
                    board[1][j].getText() == board[2][j].getText()) {
                for (int k = 0; k < 3; k++) {
                    setWinner(board[k][j]);

                }
                GameOver = true;
                return;

            }
        }
        if (board[0][0].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][2].getText()) &&
                !board[0][0].getText().isEmpty()) {

            for (int k = 0; k < 3; k++) {
                setWinner(board[k][k]);
            }
            GameOver = true;
            return;
        }
        if (board[0][2].getText().equals(board[1][1].getText()) &&
                board[1][1].getText().equals(board[2][0].getText()) &&
                !board[0][2].getText().isEmpty()) {


                setWinner(board[0][2]);
                setWinner(board[1][1]);
                setWinner(board[2][0]);
                GameOver = true;
                return;
        }
        else if(turns==9){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    setTie(board[i][j]);
                }}
                }

        }





    void setWinner(JButton tile){
        tile.setBackground(Color.black);
        tile.setForeground(Color.green);
        tLabel.setText(CurrentPlayer +" is the winner!!");


    }
    void setTie(JButton tile) {
        tile.setBackground(Color.orange);
        tile.setForeground(Color.gray);
        tLabel.setText("Tie!!!");
        tile.setOpaque(true);
        tile.setContentAreaFilled(true);

    }
}

