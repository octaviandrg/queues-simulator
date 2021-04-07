package ro.tuc.tp.tema2.GUI;

import ro.tuc.tp.tema2.Logic.SimulationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {

    public int timeLimit;
    public int maxProcessingTime ;
    public int minProcessingTime;
    public int maxArrivalTime;
    public int minArrivalTime;
    public int numberOfQueues;
    public int numberOfClients;
    public volatile boolean start = false;

    public JPanel contentPane;


    JFrame frame = new JFrame("Queue Simulation");
    public JTextField textSimulationTime;
    public JTextField textNumberClients;
    public JTextField textNumberQueues;
    public JTextField textMinArrivalTime;
    public JTextField textMinProcessingTime;
    public JTextField textMaxArrivalTime;
    public JTextField textCurrentTime;
    public JTextField textMaxProcessingTime;
    public JButton btnStart;
    public JEditorPane textOutput;
    public Document doc;
    public JScrollPane scrollPane;


    public boolean isStart(){
        return start;
    }


    public SimulationFrame(){
        this.buildFrame();
    }

    public void buildFrame(){

        btnStart = new JButton("START");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SimulationManager.timeLimit = Integer.parseInt(textSimulationTime.getText());
                SimulationManager.numberOfQueues = Integer.parseInt(textNumberQueues.getText());
                SimulationManager.numberOfClients = Integer.parseInt(textNumberClients.getText());
                SimulationManager.minArrivalTime = Integer.parseInt(textMinArrivalTime.getText());
                SimulationManager.maxArrivalTime = Integer.parseInt(textMaxArrivalTime.getText());
                SimulationManager.minProcessingTime = Integer.parseInt(textMinProcessingTime.getText());
                SimulationManager.maxProcessingTime = Integer.parseInt(textMaxProcessingTime.getText());
                start = true;

            }
        });

        frame.setBackground(Color.DARK_GRAY);
        frame.setTitle("Queue Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 590, 815);
        contentPane = new JPanel();
        contentPane.setBackground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);

        JLabel lblSimulationTime = new JLabel("Simulation time:");

        JLabel lblNumberOfClients = new JLabel("Number of clients:");

        JLabel lblSimulationTime_1_1 = new JLabel("Number of queues:");

        JLabel lblSimulationTime_1_1_1 = new JLabel("Min / Max arrival time:");

        JLabel lblSimulationTime_1_1_1_1 = new JLabel("Min / Max processing time:");


        textSimulationTime = new JTextField();
        textSimulationTime.setBackground(Color.LIGHT_GRAY);
        textSimulationTime.setHorizontalAlignment(SwingConstants.CENTER);
        textSimulationTime.setColumns(10);

        textNumberClients = new JTextField();
        textNumberClients.setBackground(Color.LIGHT_GRAY);
        textNumberClients.setHorizontalAlignment(SwingConstants.CENTER);
        textNumberClients.setColumns(10);

        textNumberQueues = new JTextField();
        textNumberQueues.setBackground(Color.LIGHT_GRAY);
        textNumberQueues.setHorizontalAlignment(SwingConstants.CENTER);
        textNumberQueues.setColumns(10);

        textMinArrivalTime = new JTextField();
        textMinArrivalTime.setBackground(Color.LIGHT_GRAY);
        textMinArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
        textMinArrivalTime.setColumns(10);

        textMinProcessingTime = new JTextField();
        textMinProcessingTime.setBackground(Color.LIGHT_GRAY);
        textMinProcessingTime.setHorizontalAlignment(SwingConstants.CENTER);
        textMinProcessingTime.setColumns(10);

        textMaxArrivalTime = new JTextField();
        textMaxArrivalTime.setBackground(Color.LIGHT_GRAY);
        textMaxArrivalTime.setHorizontalAlignment(SwingConstants.CENTER);
        textMaxArrivalTime.setColumns(10);



        btnStart.setBackground(Color.WHITE);

        JLabel lblCurrentTime = new JLabel("Current time");

        textCurrentTime = new JTextField();
        textCurrentTime.setEditable(false);
        textCurrentTime.setBackground(Color.LIGHT_GRAY);
        textCurrentTime.setColumns(10);

         textOutput = new JEditorPane();
        JScrollPane scrollPane = new JScrollPane(textOutput);
        //scrollPane.setPreferredSize(new Dimension(400, 100));
        frame.add(scrollPane);

       doc = textOutput.getDocument();

                textMaxProcessingTime = new JTextField();
        textMaxProcessingTime.setHorizontalAlignment(SwingConstants.CENTER);
        textMaxProcessingTime.setColumns(10);
        textMaxProcessingTime.setBackground(Color.LIGHT_GRAY);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(textOutput, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                                                .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(lblNumberOfClients, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textNumberClients, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(372, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblSimulationTime)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(textSimulationTime, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblSimulationTime_1_1_1_1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textMinProcessingTime, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(textMaxProcessingTime, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblSimulationTime_1_1_1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(textMinArrivalTime, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(textMaxArrivalTime, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(lblSimulationTime_1_1, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(textNumberQueues, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(btnStart)
                                                                .addGap(88))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(textCurrentTime, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblCurrentTime))
                                                                .addGap(51))))))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblSimulationTime)
                                        .addComponent(textSimulationTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnStart))
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblNumberOfClients)
                                                        .addComponent(textNumberClients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSimulationTime_1_1)
                                                        .addComponent(textNumberQueues, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSimulationTime_1_1_1)
                                                        .addComponent(textMinArrivalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textMaxArrivalTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lblSimulationTime_1_1_1_1)
                                                                .addComponent(textMinProcessingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(textMaxProcessingTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(43)
                                                .addComponent(lblCurrentTime)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textCurrentTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textOutput, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
        frame.setVisible(true);





}}
