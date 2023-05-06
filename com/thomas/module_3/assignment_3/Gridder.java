package com.thomas.module_3.assignment_3;

import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;
import flanagan.io.*;
import java.awt.Image;
import java.util.Arrays;

@SuppressWarnings("all")
public class Gridder extends javax.swing.JFrame
        implements MouseListener, MouseMotionListener,
        ActionListener {

    protected final int gridCount=100;  //how many squares wide our drawing area is
    protected int[][] grid = new int[gridCount][gridCount]; //create the matrix
    private final int squareSize=5; //the size length of individual squares in pixels
    private final int gridSize=gridCount*squareSize;  //size of entire draw grid in pixels
    private final int offSet=50;  //how far from top/left edge do we draw the grid
    private int penColor = 1; //keeps track of current drawing color
    private Color[] colors; //our array of colors
    private Image ib;  //we do all drawing onto this image, it acts as an image buffer
    private Graphics ibg;  //will be set to our image buffer's graphic object
    private String filename;

    private Timer timmy;
    private boolean active=false;
    private int stepDelay = 500;
    private Color borderColor=new Color(20,20,20);


    //constructor for our GridderFrame
    public Gridder() {
        initComponents();
        addMouseListener(this);  //registers this frame to receive mouse clicks
        addMouseMotionListener(this); //register this frame to receive mouse motions
        setUpImageBuffer();
        takeCareOfResizing();
        setUpColors();
        clearGrid();
        draw();
    }


    //set our image (buffer) to a new image of the correct size
    public void setUpImageBuffer(){
        ib=this.createImage(gridSize+1,gridSize+1);
        ibg=ib.getGraphics();
    }


    //experimental code that redraws the grid after user resizes the window
    //works some of the time... still in progress
    public void takeCareOfResizing(){
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                draw();
            }
            public void componentMoved(ComponentEvent e) {
                draw();
            }
        });
    }

    public void setUpColors(){
        colors=new Color[2];
        colors[0]=Color.darkGray;  colors[1]=Color.white;

    }


    //fills the grid with 1's (represents white!)
    public void clearGrid(){
        for(int c=0; c<gridCount; c++)
            for(int r=0; r<gridCount; r++)
                grid[c][r]=0;

        draw();
    }


    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) {  }


    //will use the mouse x and y coordinates and figure out which square in the
    //draw area was clicked and pass this information to the clickGrid method
    public void mouseClicked(MouseEvent e) {
        int x = e.getX(); int y = e.getY();
        int row = (y-offSet)/squareSize;
        int col = (x-offSet)/squareSize;
        System.out.println("Click: " + col + ", " + row);
        //if inside our grid, call clickGrid passing it the col and row
        if ( (row>=0) && (row<gridCount) && (col>=0) && (col<gridCount) )
            clickGrid(col, row);
    }


    //will use the mouse x and y coordinates and figure out which square in the
    //draw area dragging is occurring and pass this information to the clickGrid method
    public void mouseDragged(MouseEvent e) {
        int x = e.getX(); int y = e.getY();
        int row = (y-offSet )/squareSize;
        int col = (x-offSet )/squareSize;
        System.out.println("Drag:  " + col + ", " + row);
        //if inside our grid, call dragGrid passint it the col and row
        if ( (row>=0) && (row<gridCount) && (col>=0) && (col<gridCount) )
            dragGrid(col, row);
    }

    public void mouseMoved(MouseEvent e) {
        //System.out.println("Moving at " + e.getX() + "," +  e.getY() );
    }

    //set a square in the grid to the color value as long as the values are valid
    public void colorSquare(int col, int row, int colorValue){
        grid[col][row] = colorValue;
        draw();
    }


    //any mouse click is forwarded to this method with the col and row of the
    //square clicked provided as parameters.  Comes from public void mouseClicked.
    public void clickGrid( int col, int row ){
        colorSquare(col, row, penColor);
    }


    //any mouse drag is forwarded to this method with the col and row of the
    //square dragged over provided as parameters.  Comes from public void mouseDragged.
    public void dragGrid( int col, int row) {
        colorSquare(col, row, penColor);
    }


    //draws the image based on the values stored in the grid.
    //we will draw on the image buffer's graphics object and then when we are
    //all done we will copy the image buffer onto the Frame's graphic object.
    public void draw(){

        //clear the area, draw white background
        ibg.clearRect(0, 0, gridSize,gridSize);
        ibg.setColor(Color.white);
        ibg.fillRect(0, 0, gridSize, gridSize);

        //draws individual squares (pass this method the frames graphics object
        drawSquares(ibg);

        //draws a black border around edge of grid
        ibg.setColor(Color.black);
        ibg.drawRect(0,0,gridSize,gridSize);

        //all done drawing your stuff onto the image buffer?
        //get the frame's graphics object and draw our image buffer onto the frame
        Graphics g = this.getGraphics();
        g.drawImage(ib,offSet,offSet,this);
    }


    //draws the individual colored squares that make the grid using the values
    //stored in the grid matrix.
    public void drawSquares(Graphics g){
        //draw each square (remember that squareSize is size of each square...
        g.setColor(Color.black);
        for(int r=0; r<gridCount; r++){
            for(int c=0; c<gridCount; c++) {
                g.setColor(colors[ grid[c][r] ] );
                g.fillRect(c*squareSize, r*squareSize, squareSize, squareSize);
                g.setColor(borderColor);
                g.drawRect(c*squareSize, r*squareSize, squareSize, squareSize);
            }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textInfo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        buttonOpen = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        buttonBlack = new javax.swing.JButton();
        buttonWhite = new javax.swing.JButton();
        jButtonStep = new javax.swing.JButton();
        jButtonCopy = new javax.swing.JButton();
        jButtonPaste = new javax.swing.JButton();
        jButtonRun = new javax.swing.JButton();
        jSliderDelay = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setMinimumSize(new java.awt.Dimension(950, 660));

        textInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textInfo.setText("give user info here...");

        buttonOpen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonOpen.setText("Open");
        buttonOpen.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSave.setText("Save");
        buttonSave.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        buttonClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonClear.setText("Clear");
        buttonClear.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonBlack.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        buttonBlack.setText("BLACK");
        buttonBlack.setMaximumSize(new java.awt.Dimension(50, 30));
        buttonBlack.setMinimumSize(new java.awt.Dimension(75, 0));
        buttonBlack.setPreferredSize(new java.awt.Dimension(50, 20));
        buttonBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBlackActionPerformed(evt);
            }
        });

        buttonWhite.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        buttonWhite.setText("WHITE");
        buttonWhite.setMaximumSize(new java.awt.Dimension(50, 30));
        buttonWhite.setMinimumSize(new java.awt.Dimension(75, 0));
        buttonWhite.setPreferredSize(new java.awt.Dimension(50, 20));
        buttonWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWhiteActionPerformed(evt);
            }
        });

        jButtonStep.setText("STEP");
        jButtonStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStepActionPerformed(evt);
            }
        });

        jButtonCopy.setText("Copy");

        jButtonPaste.setText("Paste");

        jButtonRun.setText("Run");
        jButtonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRunActionPerformed(evt);
            }
        });

        jSliderDelay.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jSliderDelay.setMajorTickSpacing(500);
        jSliderDelay.setMaximum(2000);
        jSliderDelay.setMinorTickSpacing(500);
        jSliderDelay.setPaintLabels(true);
        jSliderDelay.setPaintTicks(true);
        jSliderDelay.setSnapToTicks(true);
        jSliderDelay.setValue(500);
        jSliderDelay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderDelayStateChanged(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton7.setText("jButton7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton8.setText("jButton8");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("jButton9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("jButton10");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("jButton11");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("jButton12");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton10, jButton11, jButton12, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9});

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton12)
                                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("set delay");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSliderDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(buttonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttonRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttonBlack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jButtonStep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttonWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jButtonCopy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jButtonPaste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(buttonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButtonRun, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(28, 28, 28)
                                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addComponent(jLabel1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonBlack, buttonClear, buttonOpen, buttonRefresh, buttonSave, buttonWhite, jButtonCopy, jButtonPaste, jButtonRun, jButtonStep});

        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(buttonOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(buttonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(buttonRefresh)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonCopy)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonPaste)
                                                .addGap(20, 20, 20)
                                                .addComponent(buttonBlack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonWhite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(jButtonStep)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonRun)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSliderDelay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(184, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonBlack, buttonWhite});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonClear, buttonRefresh});

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    //saves the current picture data in CS format
    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        //String curDir = System.getProperty("user.dir");
        //System.out.println("Your directory is " + curDir);
        FileChooser FC = new FileChooser();
        FC.selectFile();
        filename=FC.getDirPath() +"/"+ FC.getFileName();
        System.out.println("Filename: " + filename);
        FC.close();

        FileOutput FO = new FileOutput(filename,"w");

        for(int r=0; r<gridCount; r++) {
            for(int c=0; c<gridCount; c++) {
                int num = grid[c][r];
                if (num<10)
                    FO.print("0"+num);
                else
                    FO.print(num);
            }
            FO.println(""); //go to new line
        }
        FO.close();

    }//GEN-LAST:event_buttonSaveActionPerformed

    //opens a CS format file and loads the image data into the grid
    private void buttonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
        FileChooser FC = new FileChooser();
        FC.selectFile();
        filename=FC.getDirPath() +"/"+ FC.getFileName();
        System.out.println(filename);
        FC.close();

        FileInput FI = new FileInput(filename);
        int num=FI.numberOfLines();
        if (num!=gridCount){
            System.out.println("Not enough lines in file!");
            return;
        }

        //read each row.  go through row two characters at a time and convert to number
        for(int r=0; r<gridCount; r++) {
            String line = FI.readLine();                         //read the next line
            for(int c=0; c<gridCount; c++){                 //or (int c=0; c<gridCount*2; c=c+2)
                String temp=line.substring(c*2, c*2+2);   //0,2,4,6,8,...
                int value=Integer.parseInt(temp);           //convert to int
                grid[c][r]=value;                                  //put in grid
            }
        }
        FI.close();

        //lets see what you just read!
        draw();

    }//GEN-LAST:event_buttonOpenActionPerformed

    //redraws the canvas when the picture disappears
    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        draw();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clearGrid();
    }//GEN-LAST:event_buttonClearActionPerformed


    private void buttonBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBlackActionPerformed
        penColor=0;
    }//GEN-LAST:event_buttonBlackActionPerformed

    private void buttonWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWhiteActionPerformed
        penColor=1;
    }//GEN-LAST:event_buttonWhiteActionPerformed

    public boolean isAlive(int c, int r) {
        //if cell is in grid and alive, return true
        //outside grid or not alive, return false
        return(true);
    }

    private void jButtonStepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStepActionPerformed
        step();
    }//GEN-LAST:event_jButtonStepActionPerformed

    public int countNeighbors(int c, int r){
        return(0);
    }

    public void step() {
        //empty now
        //sample code, take this out!   randomly pick a spot to turn white
        int col = (int)(Math.random()*gridCount);
        int row = (int)(Math.random()*gridCount);
        grid[col][row] = 1;


        //leave this in here or you won't see anything happen!
        draw();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //this event is called by the timer...
        //System.out.println("Calling Step...");
        //System.out.println(e.getSource());
        step();
    }

    private void jButtonRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        //create timer if it doesn't exist.  If it does exist, turn it on!
        System.out.println("Run/Pause Button Pressed");
        if (!active) {
            if (timmy==null) {
                timmy=new Timer(stepDelay,this);
                timmy.setInitialDelay(100);
                timmy.setDelay(stepDelay);
            }

            timmy.start();
            active=true;
            jButtonRun.setText("Pause...");
        }
        else { //turn timer off
            active=false;
            timmy.stop();
            jButtonRun.setText("Run...");
        }
    }//GEN-LAST:event_jButtonRunActionPerformed

    private void jSliderDelayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderDelayStateChanged
        stepDelay=jSliderDelay.getValue();
        if (stepDelay==0) {
            stepDelay=1;
        }
        if (timmy!=null)
            timmy.setDelay(stepDelay);
    }//GEN-LAST:event_jSliderDelayStateChanged

    /**
     Generates 100 random cells and sets their values to 1 in the grid.

     @param evt the ActionEvent that triggered this method
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Loop 100 times to generate 100 random cells
        for (int i = 0; i < 100; ++i) {
            // Generate a random column and row number
            int col = (int)(Math.random()*gridCount);
            int row = (int)(Math.random()*gridCount);
            // Set the value of the cell at the generated column and row number to 1
            grid[col][row] = 1;
        }
        // Draw the updated grid
        draw();
    }

    /**
     Fills a randomly selected column with 1s in the grid.

     @param evt the ActionEvent that triggered this method
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Generate a random column number
        int col = (int)(Math.random()*gridCount);
        // Set all cells in the generated column to 1
        Arrays.fill(grid[col], 1);
        // Draw the updated grid
        draw();
    }

    /**
     Fills the top half of the grid with 1s and the bottom half with 0s.

     @param evt the ActionEvent that triggered this method
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Loop through the rows in the top half of the grid
        for (int row = 0; row < gridCount/2; ++row) {
            // Loop through all columns and set the value of the current cell to 1
            for (int col = 0; col < gridCount; ++col) {
                grid[col][row] = 1;
            }
        }
        // Loop through the rows in the bottom half of the grid
        for (int row = gridCount/2; row < gridCount; ++row) {
            // Loop through all columns and set the value of the current cell to 0
            for (int col = 0; col < gridCount; ++col) {
                grid[col][row] = 0;
            }
        }
        // Draw the updated grid
        draw();
    }

    /**
     Counts the number of cells with value 1 in the grid and displays it in textInfo.

     @param evt the ActionEvent that triggered this method
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // Initialize a count variable to keep track of the number of cells with value 1
        int count = 0;
        // Loop through all cells in the grid and count the number of cells with value 1
        for (int[] i : grid) {
            for (int o : i) {
                if (o == 1) ++count;
            }
        }
        // Display the count in textInfo
        textInfo.setText( Integer.toString(count));
        // Draw the updated grid
        draw();
    }

    /**
     Sets the diagonals of the grid to 1s.

     @param evt the ActionEvent that triggered this method
     */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        // Clear the grid by setting all cells to 0
        clearGrid();
        // Loop through all positions on the diagonal and set the corresponding cells to 1
        for (int pos = 0; pos < gridCount; ++pos) {
            grid[pos][pos] = 1;
            grid[pos][gridCount - 1 - pos] = 1;
        }

        // draw the updated grid
        draw();
    }

    /**
     Inverts the values of all cells in the grid: 0 becomes 1, and 1 becomes 0.

     @param evt The ActionEvent that triggered this method.
     */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
        // Loop through all columns and rows of the grid.
        for (int col = 0; col < gridCount; ++col) {
            for (int row = 0; row < gridCount; ++row) {
                // If the current cell's value is 1, set it to 0; otherwise, set it to 1.
                if (grid[col][row] == 1) {
                    grid[col][row] = 0;
                } else if (grid[col][row] == 0) {
                    grid[col][row] = 1;
                }
            }
        }

        // Redraw the grid to reflect the changes.
        draw();
    }

    /**
     Updates the grid such that if a tile has exactly two neighbours with a value of 1,
     then that tile will have a value of one.
     This is similar to Conway's Game of Life, which I implemented for fun in button 12.

     @param evt the ActionEvent that triggered this method
     */
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        // create a copy of the grid to hold the new generation
        int[][] temp = grid.clone();
        for (int i = 0; i < gridCount; ++i) {
            temp[i] = grid[i].clone();
        }

        // loop through each cell in the grid
        for (int col = 0; col < gridCount; ++col) {
            for (int row = 0; row < gridCount; ++row) {
                // count the number of adjacent cells that are alive
                int adjacent = 0;
                if (col > 0 && row > 0 && grid[col-1][row-1] == 1) ++adjacent;
                if (col > 0 && grid[col-1][row] == 1) ++adjacent;
                if (col > 0 && row < gridCount - 1 && grid[col-1][row+1] == 1) ++adjacent;
                if (row < gridCount - 1 && grid[col][row+1] == 1) ++adjacent;
                if (col < gridCount - 1 && row < gridCount - 1 && grid[col+1][row+1] == 1) ++adjacent;
                if (col < gridCount - 1 && grid[col+1][row] == 1) ++adjacent;
                if (col < gridCount - 1 && row > 0 && grid[col+1][row-1] == 1) ++adjacent;
                if (row > 0 && grid[col][row-1] == 1) ++adjacent;

                if (adjacent == 2) {
                    temp[col][row] = 1;
                }
            }
        }

        // update the grid to the new generation and redraw it
        grid = temp;
        draw();
    }

    /**
     Moves the grid 1 column to the left

     @param evt the ActionEvent that triggered this method
     */
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        int[][] temp = grid.clone();

        // Copy each column in reverse order to temp
        for (int col = gridCount-1; col > 0; --col) {
            temp[col-1] = grid[col];
        }

        // Copy the first column to the last column in temp
        temp[gridCount-1] = grid[0];

        grid = temp;

        draw();
    }

    /**
     Rotates the current grid 90 degrees clockwise and redraws it.

     @param evt The ActionEvent that triggered this method.
     */
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        int[][] temp = new int[gridCount][gridCount];

        // Traverse the original grid and populate the new one with rotated values
        for (int col = 0; col < gridCount; ++col) {
            for (int row = 0; row < gridCount; ++row) {
                if (grid[row][gridCount - 1 - col] == 0) continue;

                temp[col][row] = grid[row][gridCount - 1 - col];
            }

        }

        // Update the current grid with the rotated one and redraw it
        grid = temp;
        draw();
    }

    // These next methods are just filled in for fun

    /**
     Rotates the current grid 90 degrees counter-clockwise and redraws it.
     This method was just filled in for fun

     @param evt The ActionEvent that triggered this method.
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        int[][] temp = new int[gridCount][gridCount];

        // Traverse the original grid and populate the new one with rotated values
        for (int col = 0; col < gridCount; ++col) {
            for (int row = 0; row < gridCount; ++row) {
                if (grid[col][row] == 0) continue;

                temp[row][gridCount - 1 - col] = grid[col][row];
            }

        }

        // Update the current grid with the rotated one and redraw it
        grid = temp;
        draw();
    }

    /**
     Randomly fills cells in the grid, and redraws it.
     This Method was just filled in for fun.

     @param evt The ActionEvent that triggered this method.
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        // Traverse the grid and randomly fills cell values
        for (int col = 0; col < gridCount; ++col) {
            for (int row = 0; row < gridCount; ++row) {
                grid[col][row] = (int) Math.round(Math.random());
            }
        }

        // Redraw the grid with the updated values
        draw();
    }

    /**
     Updates the grid based on the rules of Conway's Game of Life.
     For each cell in the grid, it counts the number of adjacent cells
     that are alive, and based on that count, it determines whether the
     cell should be alive or dead in the next generation.
     After all cells have been processed, it updates the grid to the
     next generation and redraws it on the screen.

     This method was just filled in for fun.

     @param evt the ActionEvent that triggered this method
     */
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        // create a copy of the grid to hold the new generation
        int[][] temp = grid.clone();
        for (int i = 0; i < gridCount; ++i) {
            temp[i] = grid[i].clone();
        }

        // loop through each cell in the grid
        for (int col = 0; col < gridCount; ++col) {
            for (int row = 0; row < gridCount; ++row) {
                // count the number of adjacent cells that are alive
                int adjacent = 0;
                if (col > 0 && row > 0 && grid[col-1][row-1] == 1) ++adjacent;
                if (col > 0 && grid[col-1][row] == 1) ++adjacent;
                if (col > 0 && row < gridCount - 1 && grid[col-1][row+1] == 1) ++adjacent;
                if (row < gridCount - 1 && grid[col][row+1] == 1) ++adjacent;
                if (col < gridCount - 1 && row < gridCount - 1 && grid[col+1][row+1] == 1) ++adjacent;
                if (col < gridCount - 1 && grid[col+1][row] == 1) ++adjacent;
                if (col < gridCount - 1 && row > 0 && grid[col+1][row-1] == 1) ++adjacent;
                if (row > 0 && grid[col][row-1] == 1) ++adjacent;

                // apply the rules of the game of life
                if (grid[col][row] == 1) {
                    // if the cell is alive and has 2 or 3 adjacent cells that are alive,
                    // it stays alive in the next generation
                    if (adjacent == 2 || adjacent == 3) {
                        temp[col][row] = 1;
                    } else {
                        // otherwise, it dies in the next generation
                        temp[col][row] = 0;
                    }
                } else {
                    // if the cell is dead and has exactly 3 adjacent cells that are alive,
                    // it comes to life in the next generation
                    if (adjacent == 3) {
                        temp[col][row] = 1;
                    } else {
                        // otherwise, it stays dead in the next generation
                        temp[col][row] = 0;
                    }
                }
            }
        }

        // update the grid to the new generation and redraw it
        grid = temp;
        draw();
    }



    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gridder().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBlack;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonOpen;
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonWhite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonCopy;
    private javax.swing.JButton jButtonPaste;
    private javax.swing.JButton jButtonRun;
    private javax.swing.JButton jButtonStep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderDelay;
    private javax.swing.JTextField textInfo;
    // End of variables declaration//GEN-END:variables

} //end of class