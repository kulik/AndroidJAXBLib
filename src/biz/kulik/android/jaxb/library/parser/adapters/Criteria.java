package biz.kulik.android.jaxb.library.parser.adapters;

public final class Criteria {

    private Package mPackaze;
    private Class mClazz;
    private Class<?> mReturnType;

    public Criteria() {
    }

    public Criteria(Package packaze, Class clazz, Class<?> returnType) {
        mPackaze = packaze;
        mClazz = clazz;
        mReturnType = returnType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Criteria criteria = (Criteria) o;

        if (mClazz != null && !criteria.mClazz.equals(mClazz)) return false;
        if (mReturnType == null || criteria.mReturnType == null || !mReturnType.equals(criteria.mReturnType)) return false;
        if (mPackaze == null || criteria.mPackaze == null || !mPackaze.equals(criteria.mPackaze)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mPackaze != null ? mPackaze.hashCode() : 0;
        result = (mClazz != null) ? (31 * result +  mClazz.hashCode()) : result;
        result = 31 * result + (mReturnType != null ? mReturnType.hashCode() : 0);
        return result;
    }

    public Criteria set(Package p, Class<?> clazz, Class<?> returnType) {
        mPackaze = p;
        mClazz = clazz;
        mReturnType = returnType;
        return this;
    }

}