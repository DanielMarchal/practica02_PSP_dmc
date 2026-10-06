package vista;

import modelo.Cliente;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Aplicacion extends JFrame{
    
    ArrayList <Cliente> miLista = new ArrayList<>();
    private int posicion = 0;
    
    public Aplicacion(){
        miLista.add(new Cliente(1, "Daniel", 19, 5) );
        miLista.add(new Cliente(2, "Hugo", 21, 10) );
        miLista.add(new Cliente(3, "Pablo", 29, 3) );
        
        JLabel numeroLabel = new JLabel("Numero: ");
        JLabel nombreLabel = new JLabel("Nombre: ");
        JLabel edadLabel = new JLabel("Edad: ");
        JLabel puntosLabel = new JLabel("Puntos: ");
        
        JTextField numeroField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField puntosField = new JTextField();
        
        JButton siguienteBoton = new JButton("Siguiente");
        JButton anteriorBoton = new JButton("Anterior");
        
        mostrarCliente(numeroField, nombreField, edadField, puntosField);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2) );
        
        panel.add(numeroLabel);
        panel.add(numeroField);
        
        panel.add(nombreLabel);
        panel.add(nombreField);
        
        panel.add(edadLabel);
        panel.add(edadField);
        
        panel.add(puntosLabel);
        panel.add(puntosField);
        
        getContentPane().add(panel, BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout() );
        
        panelBotones.add(anteriorBoton);
        panelBotones.add(siguienteBoton);
        
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        siguienteBoton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                posicion++;
                mostrarCliente(numeroField, nombreField, edadField, puntosField);
            }
            
        });
        
        anteriorBoton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                posicion--;
                mostrarCliente(numeroField, nombreField, edadField, puntosField);
            }
        
        });
    
    }
    
    public void mostrarCliente(JTextField numeroField, JTextField nombreField, JTextField edadField, JTextField puntosField) {

        Cliente cliente = miLista.get(posicion);

        numeroField.setText("" + cliente.getNumero() );
        nombreField.setText(cliente.getNombre() );
        edadField.setText("" + cliente.getEdad() );
        puntosField.setText("" + cliente.getPuntos() );
    }
    
    
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(new Runnable() {
        
            public void run(){
                Aplicacion miAplicacion = new Aplicacion();
                miAplicacion.pack();
                miAplicacion.setVisible(true);
            }        
        });
        
    }
    
}
 

