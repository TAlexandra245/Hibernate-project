package com.fortech.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StringUtilTest {

    private StringUtil word = new StringUtil();
    private StringUtil mockWord = Mockito.mock(StringUtil.class);

    @Test

    public void testString() {
        String newVariables = word.concat("cuvant", " Hello");
        Assertions.assertEquals("cuvant Hello", newVariables);
    }

    @Test
    public void mockTestString() {

        Mockito.when(mockWord.concat("aa", "bb")).thenReturn("aabb");
        String newResult = mockWord.concat("aa", "bb");
        Assertions.assertEquals("aabb", newResult);
        String newResult1 = mockWord.concat("cc", "dd");
        Assertions.assertEquals("ccdd", newResult1);
    }
}
