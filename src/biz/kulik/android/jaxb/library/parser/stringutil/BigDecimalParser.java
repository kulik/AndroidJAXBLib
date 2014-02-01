package biz.kulik.android.jaxb.library.parser.stringutil;

import java.math.BigDecimal;

/**
 * User: kulik
 * Date: 1/21/13
 * Time: 2:49 PM
 */
public class BigDecimalParser extends PrimitiveJavaWrapperParser<BigDecimal> {


    @Override
    public BigDecimal valueOf(String value) {
        BigDecimal bd = null;
        bd = new BigDecimal(value.replaceAll(",", ""));
        return bd;
    }
}
