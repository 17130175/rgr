package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculatorTestTwo {

    @Test
    public void testCalculator(){
        try{
            Calculator lc = new Calculator();
            lc.fields[0].setText("read three"); //�����
            lc.calculate();
            Assert.assertTrue("10".equals(lc.fields[1].getText())); //������� ���������� �������� � ������
        }
        catch(Exception e){
            Assert.fail("��������� ������������ ������� ��������");
        }

    }
}