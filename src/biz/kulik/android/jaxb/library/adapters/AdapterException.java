package biz.kulik.android.jaxb.library.adapters;

/**
 * User: kulik
 * Date: 6/26/13
 * Time: 8:02 PM
 */
public class AdapterException extends Exception {

    private Exception mAdapterException;

    public AdapterException(Exception e) {
        mAdapterException = e;
    }

    public Exception getAdapterException() {
        return mAdapterException;
    }
}
