import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.NumberFormat;


class MyFrame extends JFrame implements ActionListener{

    JLabel roll = new JLabel();
    JButton btn1=new JButton("Height in cm");
    JButton btsug= new JButton("Suggestions");

    Border border;
    JButton btn2=new JButton("Weight in pound");
    JButton btbmi=new JButton("BMI");
    Font fn1=new Font("Arial",Font.BOLD,22);
    JLabel label=new JLabel();
    JLabel lebHeight = new JLabel();
    JLabel outSug = new JLabel();
    JTextField txt1=new JTextField();
    JTextField tweight= new JTextField();

    JLabel output= new JLabel();
    JLabel outPound= new JLabel();
    JLabel outBmi = new JLabel();
    JLabel leb2 = new JLabel();
    JLabel Title = new JLabel();
    Container c;

    MyFrame(){

        c=this.getContentPane();
        c.setLayout(null);
        btn1.setBounds(20,150,140,30);
        btn2.setBounds(320,150,140,30);
        btbmi.setBounds(195,260, 100, 30);
        btsug.setBounds(185,350, 120,30);

        label.setBounds(20,70,140,30);
        label.setOpaque(true);
        label.setText("  Input height in Inch");


        label.setBackground(new Color(220, 220, 240));
        lebHeight.setText("  Input weight in KG");
        lebHeight.setBounds(320,70,140,30);
        lebHeight.setOpaque(true);
        lebHeight.setBackground(new Color(220,220,240));
        Title.setText("                       WEIGHT MECHINE");
        Title.setBackground(Color.red);
        Title.setOpaque(true);
        Title.setBounds(0, 0, 500,50);
        Title. setFont(fn1);
        Title.setBorder(border);

        txt1.setBounds(20,100,140,30);
        tweight.setBounds(320,100,140,30);


        output.setBounds(20, 180, 140, 30);
        output.setOpaque(true);
        output.setBackground(Color.white);

        outPound.setBounds(320, 180, 140, 30);
        outPound.setOpaque(true);
        outPound.setBackground(Color.white);

        outBmi.setBounds(140,290, 200, 30);
        outBmi.setOpaque(true);
        outBmi.setBackground(Color.lightGray);

        outSug.setBounds(20,380,440,40);
        outSug.setOpaque(true);
        outSug.setBackground(Color.lightGray);

        roll.setText("Prepared by Md. Rashedul Islam. Roll: 2003023");
        roll.setBounds(0, 440, 500,20);
        roll.setHorizontalAlignment(JLabel.CENTER);
        roll.setOpaque(true);


        c.add(outPound);
        c.add(btn1);
        c.add(btn2);
        c.add(label);
        c.add(txt1);
        c.add(lebHeight);
        c.add(output);
        c.add(Title);
        c.add(tweight);
        c.add(btbmi);
        c.add(outBmi);
        c.add(btsug);
        c.add(outSug);
        c.add(roll);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btbmi.addActionListener(this);
        btsug.addActionListener(this);

    }
    int i=0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btn2) {
          //  i=1;

           // label.setText(String.valueOf(i));
           // output.setText("0");
            btn2.setBackground(Color.green);
            btn1.setBackground(null);}

            if(e.getSource()==btn1) {
                double inch  = Double.parseDouble(txt1.getText());
                double cm = 2.54*inch;

                output.setText(" "+cm+" cm");
                btn1.setBackground(new Color(255, 100, 100));
                btn2.setBackground(new Color(220, 220, 240));
                btbmi.setBackground(new Color(220, 220, 240));
                btsug.setBackground(new Color(220, 220, 240));


        }
        if(e.getSource()==btn2) {
            double kg= Double.parseDouble(tweight.getText());
            double pound= 2.2*kg;


            NumberFormat nf=  NumberFormat.getNumberInstance();
            outPound.setText(" "+nf.format(pound)+" Pound");
            btn2.setBackground(new Color(255, 100, 100));
            btn1.setBackground(new Color(220, 220, 240));
            btbmi.setBackground(new Color(220, 220, 240));
            btsug.setBackground(new Color(220, 220, 240));
        }
        if(e.getSource()==btbmi)
        {
            btn2.setBackground(new Color(220, 220, 240));
            btn1.setBackground(new Color(220, 220, 240));
            btsug.setBackground(new Color(220, 220, 240));
            btbmi.setBackground(new Color(255, 100, 100));
           double kg= Double.parseDouble(tweight.getText());
           double inch  = Double.parseDouble(txt1.getText());
           double m = 0.0254*inch;
           double bmi= kg/(m*m);
          // String s= String.valueOf(bmi);
          NumberFormat nf=  NumberFormat.getNumberInstance();

            outBmi.setText("            Your BMI is:  "+nf.format(bmi));

        }
        if(e.getSource()==btsug){
            double kg= Double.parseDouble(tweight.getText());
            double inch  = Double.parseDouble(txt1.getText());
            double m = 0.0254*inch;
            double bmi= kg/(m*m);
            btn2.setBackground(new Color(220, 220, 240));
            btn1.setBackground(new Color(220, 220, 240));
            btbmi.setBackground(new Color(220, 220, 240));
            btsug.setBackground(new Color(255, 100, 100));

            if(bmi<=18.5)
            {

                outSug.setText("  You have insufficient weight."+
                        " So You need to put on some weight.");
            }
            if(bmi>18.5 && bmi<=24.9)
            {
                outSug.setText("  Congrats! You have a healthy weight for your height. Keep maintain it.");
            }
            if(bmi>24.9 && bmi<=29.9){
                outSug.setText("  You are slightly overweight. Try to lose weight for health reason");
            }
            if(bmi>29.9 && bmi<=50)
            {
                outSug.setText("  You have obesity. Your health may be at risk if you do not lose weight");
            }
            if(bmi>50)
            {
                outSug.setText("  You have morbid obesity. Talk with a doctor or dietitian for advice.");
            }



        }

    }
}


 class First{

    public static void main(String[] args) {
        MyFrame frame=new MyFrame();
        frame.setTitle("1203 project");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(000,000,060));


    }

}