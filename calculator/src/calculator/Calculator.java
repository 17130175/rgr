package calculator;
//��������� ���������� ��� ������ � ���������� ������, �������, ��� �������� ������������ ����
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

//������� �����, ����������� ��������� ActionListener
//��������� ����� ��� ��������� ������� ������� �� ������
public class Calculator implements ActionListener{
    JFrame frame = new JFrame("������� ���������� �������� � ������"); //������� ����
    JPanel panelLeft = new JPanel(); //������ � �������
    JPanel panelRight = new JPanel(); //������ � ���������� ������
    JPanel panelBottom = new JPanel(); //������ � ��������
    public JTextField[] fields = new JTextField[2];//������ ��������� �����

    //�����������
    public Calculator() {
        //������������� �������� ���������� ��� ������ � �������
        //������ ������������ �� ���������
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        //������������  ������ 250 �� 300 ��������
        panelLeft.setPreferredSize(new Dimension(250, 300));

        //������������� �������� ���������� ��� ������ � ���������� ������
        //������ ������������ �� ���������
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        //�������������  ������ 130 �� 300 ��������
        panelRight.setPreferredSize(new Dimension(230,300));

        //�������� ����� ����� ����� addLabel
        addLabel(panelLeft, "�����:", Color.BLACK);
        addLabel(panelLeft, "���������� �������� � ������:", Color.BLACK);
        //��������� ��������� ���� ����� ���� � ���������� �� � ������
        for(int i = 0; i < fields.length; i++){
            if(fields.length >= 0){
                //���������� ������ �� ������ � ������ ��� ���������� ������ � ��������� �����
                fields[i] = addTextField(panelRight);}

        }


        //��������� ������ ������� � ������
        JButton calc = addButton(panelBottom, "������");
        //��������� ��������� �� ������� �������
        calc.addActionListener(this);
        JButton reset = addButton(panelBottom, "�����");
        //��������� ��������� �� ������� �������
        reset.addActionListener(this);


        //������ ������� ����� �������
        frame.setVisible(true);
        //������������� �������� ��� ������� �� ������� - ���������� ����������
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //������������� ��������� ��������� ������������ ������ ������ (�� ������)
        frame.setLocationRelativeTo(null);
        //������������� ������ �������� ����(400 �� 450)
        frame.setSize(450,200);
        //��������� ����� � ����������� � ������ � ����� ���� ����
        JLabel top = new JLabel("������ ���� �������� ������������ ��� ����������");
        //������������� ������������ ������ � ����� �� ������
        top.setHorizontalAlignment(JLabel.CENTER);

        //��������� ������ �� ������� ����
        frame.add(top, BorderLayout.NORTH);
        frame.add(panelLeft, BorderLayout.WEST);
        frame.add(panelRight, BorderLayout.EAST);
        frame.add(panelBottom, BorderLayout.SOUTH);
        frame.setResizable(false); //��������� ��������� �������� �������� ����

    }


    //����� ���������� ��������� �����
    public void addLabel(JComponent container, String name, Color color){
        //������� �������� ����� � ������ name
        JLabel label = new JLabel(name);
        //������������� ����������� ���������� ������
        label.setMaximumSize(new Dimension(200,20));
        //������������� ����� ������
        label.setForeground(color);
        //������������� ������������ �� ������� ����
        label.setHorizontalAlignment(JLabel.RIGHT);
        //��������� �����
        label.setBorder(new EtchedBorder());
        //��������� ��������� ����� � ������
        container.add(label);
    }

    //����� ���������� ��������� �����
    public JTextField addTextField(JComponent container){
        //������� ��������� ����
        JTextField field = new JTextField();
        //������������� ��� ����������� ���������� ������
        field.setMaximumSize(new Dimension(350,20));
        //��������� ��������� ���� �� ������
        container.add(field);
        //���������� ������ �� ��������� ����
        return field;
    }

    //����� ���������� ������
    public JButton addButton(JComponent container, String name){
        //������� ������
        JButton button = new JButton(name);
        //������������� ����������� ���������� ������
        button.setMaximumSize(new Dimension(100,20));
        //����������� �� ����������� �� ������
        button.setHorizontalAlignment(JButton.CENTER);
        //��������� ������ �� ������
        container.add(button);
        //���������� ������ �� ������
        return button;
    }


    //����� ��������
    public void calculate() throws Exception {
    	String getText = fields[0].getText();
        String valueOf = String.valueOf(getText.length());
        fields[1].setText(valueOf);
    }
           

    //����� ��������� ������� ������� �� ������
    @Override
    public void actionPerformed(ActionEvent e) {
        //������ ��� ������, �� ������� ������
        if (e.getActionCommand().equals("������")) {
            try {
                //��������� ������
                calculate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "��������� ������������ �����");
            }
        }else{
            //������� ��� ����
            for(int i=0; i<fields.length; i++){
                fields[i].setText("");
            }
        }
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Calculator();
            }
        });
    }

}
