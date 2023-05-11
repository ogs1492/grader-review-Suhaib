import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

import javax.xml.crypto.dsig.spec.XPathType.Filter;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testFilter(){
    StringChecker checker = new IsMoon();
    List<String> input = Arrays.asList("moon", "mon", "MOON", "mOOn", "mmoon");
    List<String> expected = Arrays.asList("moon", "MOON", "mOOn");
    assertEquals("Should report strings equal to \'moon\' ignoring case.", expected, ListExamples.filter(input, checker));
  }

  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
}
