package biz.kulik.android.jaxb.library.parser.adapters;

public final class Criteria {

        private Package packaze;
        private Class clazz;

        public Criteria(Package packaze, Class clazz) {
            this.packaze = packaze;
            this.clazz = clazz;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Criteria criteria = (Criteria) o;

            if (clazz != null ? !clazz.equals(criteria.clazz) : criteria.clazz != null) return false;
            if (packaze != null ? !packaze.equals(criteria.packaze) : criteria.packaze != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = packaze != null ? packaze.hashCode() : 0;
            result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
            return result;
        }

        private Criteria(Class clazz, Package packaze) {
            this.clazz = clazz;
            this.packaze = packaze;
        }
    }