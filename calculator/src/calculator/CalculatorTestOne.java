package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculatorTestOne {

    @Test
    public void testCalculator(){
        try{
            Calculator lc = new Calculator();
            lc.fields[0].setText("read?one"); //�����
            lc.calculate();
            Assert.assertTrue("8".equals(lc.fields[1].getText())); //������� ���������� �������� � ������
        }
        catch(Exception e){
            Assert.fail("��������� ������������ ������� ��������");
        }

    }
}
