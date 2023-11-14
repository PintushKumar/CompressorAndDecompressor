 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.CompressionAlgorithm;
import comp_decomp.DecompressionAlgorithm;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author pintu
 */
public class AppFrame   implements ActionListener {
    
    JFrame frame;
   
    JButton compressButton;
    JButton decompressButton;
    AppFrame() {
        frame = new JFrame();
        frame.setTitle("File Compressor/Decompressor");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        compressButton = new JButton("Select File to Compress");
        decompressButton = new JButton(" Select File to Decompress");
        
        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(compressButton);
        panel.add(decompressButton);

        panel.setBorder(new EmptyBorder(80, 0, 0, 0));

        frame.add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    CompressionAlgorithm.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null , ee.toString());
                }
            }
        }
        if(e.getSource()== decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    DecompressionAlgorithm.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null , ee.toString());
                }
            }
        }
    }

}
