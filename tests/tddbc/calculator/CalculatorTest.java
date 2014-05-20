package tddbc.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void 入力が空なら0() {
        assertThat(calculator.add(""), is(0));
    }

    @Test
    public void 入力が1なら1() {
        assertThat(calculator.add("1"), is(1));
    }

    @Test
    public void 入力が1と2なら3() {
        assertThat(calculator.add("1,2"), is(3));
    }

    @Test
    public void 入力が1と2と3なら6() {
        assertThat(calculator.add("1,2,3"), is(6));
    }

    @Test
    public void 改行を区切りに使う() {
        assertThat(calculator.add("1\n2,3"), is(6));
    }

    @Test
    public void 区切り文字を抽出する() {
        String numbers = "//;\n1;2";
        String[] expected = {"1", "2"};
        assertThat(calculator.definedDelimiter(numbers).split("1;2"), is(expected));
    }

    @Test
    public void セミコロンを区切りに使う() {
        assertThat(calculator.add("//;\n1;2"), is(3));
    }

    @Test(expected = NegativesNotAllowedException.class)
    public void マイナスの数字は受け付けない() {
        calculator.add("-1,2");
    }
}