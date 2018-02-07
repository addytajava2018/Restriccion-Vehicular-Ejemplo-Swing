package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ventana extends JFrame {
    private JLabel etiqueta;
    private JLabel etiquetaSal;
    private JTextField campo;
    private JButton boton;

    public Ventana() {
        super("Restriccion Vehicular");
        etiqueta = new JLabel("Introducir numero de la placa");
        etiquetaSal = new JLabel("");
        campo = new JTextField(10);
        boton = new JButton("Verificar");

        FlowLayout f = new FlowLayout();
        setLayout(f);
        add(etiqueta);
        add(campo);
        add(boton);
        add(etiquetaSal);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificar();

            }
        });
    }

    private void verificar() {
        String placa = campo.getText();
        int numpla = getParteNumerica(placa);
        System.out.println(numpla);
        Calendar c1 = Calendar.getInstance();
        int dia = c1.get(Calendar.DAY_OF_WEEK);
        System.out.println(dia);

        if (dia == 1 || dia == 7) {
            etiquetaSal.setText("Se levanta la restriccion");
        }
        switch (dia) {
            case 2:
                if (numpla == 0 || numpla == 1)
                    etiquetaSal.setText("No circula");
                else etiquetaSal.setText("Circula normalmente");
                break;
            case 3:
                if (numpla == 2 || numpla == 3)
                    etiquetaSal.setText("No circula");
                else etiquetaSal.setText("Circula normalmente");

                break;
            case 4:
                if (numpla == 5 || numpla == 4)
                    etiquetaSal.setText("No circula");
                else etiquetaSal.setText("Circula normalmente");

                break;
            case 5:
                if (numpla == 6 || numpla == 7)
                    etiquetaSal.setText("No circula");
                else etiquetaSal.setText("Circula normalmente");
                break;
            case 6:
                if (numpla == 8 || numpla == 9)
                    etiquetaSal.setText("No circula");
                else etiquetaSal.setText("Circula normalmente");
                break;
            default:
                etiquetaSal.setText("Circula normalmente");
                break;

        }
        setVisible(true);

    }


    private int getParteNumerica(String placa) {
        int res = 0;

        for (int i = 0; i < placa.length(); i++) {
            char c = placa.charAt(i);
            if (c >= '0' && c <= '9') {
                //res = res * 10 + Character.getNumericValue(c);
                res = (int) Integer.parseInt(String.valueOf(c));
            }
        }
        return res;
    }
}
