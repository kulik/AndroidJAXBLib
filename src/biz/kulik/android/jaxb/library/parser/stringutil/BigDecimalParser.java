package biz.kulik.android.jaxb.library.parser.stringutil;

import java.math.BigDecimal;

/**
 * User: kulik
 * Date: 1/21/13
 * Time: 2:49 PM
 */
public class BigDecimalParser implements SimpleTypeParser<BigDecimal> {


        @Override
        public BigDecimal valueOf(String value) {
            BigDecimal bd = null;
            try {
                bd = new BigDecimal(value.replaceAll(",", ""));
            } catch (NumberFormatException e) {
            }
            return bd;
        }
}
