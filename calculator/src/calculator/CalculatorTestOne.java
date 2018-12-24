package calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculatorTestOne {

    @Test
    public void testCalculator(){
        try{
            Calculator lc = new Calculator();
            lc.fields[0].setText("read?one"); //текст
            lc.calculate();
            Assert.assertTrue("8".equals(lc.fields[1].getText())); //подсчет количества символов в тексте
        }
        catch(Exception e){
            Assert.fail("Проверьте правильность входных значений");
        }

    }
}
