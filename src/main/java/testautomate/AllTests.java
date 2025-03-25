package testautomate;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({GET.class, POST.class, UPDATE.class, DELETE.class, NEGATIVE.class})
public class AllTests {

}
