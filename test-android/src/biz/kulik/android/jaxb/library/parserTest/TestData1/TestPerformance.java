package biz.kulik.android.jaxb.library.parserTest.TestData1;

import android.test.AndroidTestCase;
import android.test.PerformanceTestCase;
//import com.kulik.logger.EasyLoggerFactory;
//import com.kulik.logger.MyLog;


/**
 * User: kulik
 * Date: 10/26/12
 * Time: 12:50 PM
 */
public class TestPerformance extends AndroidTestCase implements PerformanceTestCase{
//    private static final MyLog LOG = EasyLoggerFactory.getLogger(TestPerformance.class);

    @Override
    protected void tearDown() throws Exception {
//        LOG.d("tearDown()");
        super.tearDown();
    }

    @Override
    protected void setUp() throws Exception {
//        LOG.d("setUp()");
        super.setUp();
    }

    public void testPerfi() {
//        LOG.d("testPerfi()");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int startPerformance(Intermediates intermediates) {
//        LOG.d("startPerformance()");
        intermediates.setInternalIterations(100);
        return 0;
    }

    @Override
    public boolean isPerformanceOnly() {
//        LOG.d("isPerformanceOnly()");
        return true;
    }
}
