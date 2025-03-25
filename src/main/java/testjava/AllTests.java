package testjava;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ GET.class, Post.class })
public class AllTests {

}
