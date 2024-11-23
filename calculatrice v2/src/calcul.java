import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class calcul implements ActionListener {

    char operateur;
    JFrame fenetre;
    JPanel panel ;


    JButton addition , soustraction , division , supp , eff , negatif , multi , egal , point;

    JButton[] bouton = new JButton[10];
    JButton[] fonctionop = new JButton[9];
    JTextField text ;

    double num1 , num2, resultat ;



    calcul(){
        fenetre = new JFrame("Calculatrice ");
        fenetre.setSize(400,600);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLayout(null);



        addition = new JButton("+");
        fonctionop[0] = addition;

        soustraction = new JButton("-");
        fonctionop[1] = soustraction;

        division = new JButton("/");
        fonctionop[2] = division;

        supp = new JButton("SUPP");
        fonctionop[3] = supp;

        eff = new JButton("EFF");
        fonctionop[4] = eff;

        negatif = new JButton("(-)");
        fonctionop[5] = negatif;

        multi = new JButton("*");
        fonctionop[6] = multi;

        egal = new JButton("=");
        fonctionop[7] = egal;

        point = new JButton(".");
        fonctionop[8] = point;

        for (int i = 0;i<9;i++){
            fonctionop[i].addActionListener(this);
        }




        for(int i = 0;i<10;i++){
            bouton[i] = new JButton(String.valueOf(i));
            bouton[i].addActionListener(this);
        }

        text = new JTextField();
        text.setBounds(50,50,300,40);
        text.setEditable(false);



        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(bouton[1]);
        panel.add(bouton[2]);
        panel.add(bouton[3]);
        panel.add(addition);
        panel.add(bouton[4]);
        panel.add(bouton[5]);
        panel.add(bouton[6]);
        panel.add(soustraction);
        panel.add(bouton[7]);
        panel.add(bouton[8]);
        panel.add(bouton[9]);
        panel.add(multi);
        panel.add(point);
        panel.add(bouton[0]);
        panel.add(egal);
        panel.add(division);



        negatif.setBounds(50,430,100,50);
        eff.setBounds(250,430,100,50);
        supp.setBounds(150,430,100,50);



        fenetre.add(panel);
        fenetre.add(negatif);
        fenetre.add(supp);
        fenetre.add(eff);
        fenetre.add(text);

        fenetre.setVisible(true);





    }

    public void actionPerformed(ActionEvent e){
        for(int i = 0 ;i<10 ; i++){
            if(e.getSource() == bouton[i]){
                   text.setText(text.getText().concat(String.valueOf(i)));
            }
    }
        if (e.getSource() == eff){
            text.setText("");
        }
        if (e.getSource() == supp){
            String tab = text.getText();
            text.setText("");
            for (int i = 0 ;i< tab.length()-1 ;i++){
                    text.setText(text.getText()+ tab.charAt(i));
            }
        }

        if(e.getSource() == addition){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operateur = '+';
        }
        if(e.getSource() == soustraction){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operateur = '-';
        }
        if(e.getSource() == multi){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operateur = '*';
        }
        if(e.getSource() == division){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operateur = '/';
        }
        if(e.getSource() == egal){
            num2 = Double.parseDouble(text.getText());
            text.setText("");
            switch (operateur){
                case '+':
                    resultat = num1 + num2;
                    break;
                case '*':
                    resultat = num1 * num2;
                    break;
                case '/':
                    resultat = num1 / num2;

                case '-':
                    resultat = num1 - num2;
                    break;
            }
            text.setText(String.valueOf(resultat));
        }
        if(e.getSource() == point){
            text.setText(text.getText() +".");
        }

        if (e.getSource() == negatif){
            Double achanger = Double.parseDouble(text.getText())*-1;

            text.setText(String.valueOf(achanger));
        }








}
}
