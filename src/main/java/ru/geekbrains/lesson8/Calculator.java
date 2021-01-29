package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private final JTextField textField;
    private char operation;
    private double total;
    private boolean isFirstDigit;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 170, 300);
        setVisible(true);
        isFirstDigit = true;

        total = 0;

        JPanel jPanel = new JPanel();

        textField = new JTextField(12);
        textField.setEditable(false);

        jPanel.add(textField);

        JButton[] jbs = new JButton[10];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton(String.valueOf(i));
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(e);
                }
            });
            jPanel.add(jbs[i]);
        }
        JButton buttonC = new JButton("C");
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonMult = new JButton("*");
        JButton buttonDiv = new JButton("/");
        JButton buttonEquals = new JButton("=");
        JButton buttonDot = new JButton(".");

        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(" ");
            }
        });
        buttonDot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculating(e);
            }
        });
        buttonMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(e);
            }
        });

        jPanel.add(buttonC);
        jPanel.add(buttonPlus);
        jPanel.add(buttonMinus);

        jPanel.add(buttonMult);
        jPanel.add(buttonDiv);
        jPanel.add(buttonEquals);
        jPanel.add(buttonDot);
        add(jPanel);


        setVisible(true);
    }

    private void calculating(ActionEvent e) {
        String text = textField.getText();
        String digit = "";
        try {

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (text.charAt(i) == '+' && text.charAt(i + 1) == '+' ||
                        text.charAt(i) == '-' && text.charAt(i + 1) == '-' ||
                        text.charAt(i) == '*' && text.charAt(i + 1) == '*' ||
                        text.charAt(i) == '/' && text.charAt(i + 1) == '/' ||
                        text.charAt(i) == '.' && text.charAt(i + 1) == '.') {
                    textField.setText("");
                } else {

                    if (c == '-' || c == '+' || c == '*' || c == '/') {
                        double currentValue = Double.parseDouble(digit);

                        if (isFirstDigit) {
                            total += currentValue;
                            isFirstDigit = false;
                        } else {
                            if (operation == '-') {
                                total -= currentValue;
                            } else if (operation == '+') {
                                total += currentValue;
                            } else if (operation == '*') {
                                total = total * currentValue;
                            } else if (operation == '/') {
                                total /= currentValue;
                            }


                        }


                        digit = "";
                        operation = c;
                        continue;
                    }
                }


                digit += c;
            }
        }
        catch(StringIndexOutOfBoundsException exception) {
            textField.setText("Введите корректно");
        }
        catch(NumberFormatException  exception) {
            textField.setText("Введите корректно");
        }


            double currentValue = Double.parseDouble(digit);
            if (operation == '-') {
                total -= currentValue;
            } else if (operation == '+') {
                total += currentValue;
            } else if (operation == '*') {
                total *= currentValue;
            } else if (operation == '/') {
                total /= currentValue;
            }


            isFirstDigit = true;
            textField.setText(String.valueOf(total));
            total = 0;
        }


        public void action (ActionEvent event){
            textField.setText(textField.getText() + event.getActionCommand());
        }



}
