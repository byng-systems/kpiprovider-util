/**
 * Counter.java
 * Created 18-Dec-2015 13:04:01
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.util;



/**
 * Counter
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface Counter<N extends Number> {
    
    public void clear();
    
    public void increment(N value);
    
    public N getTotal();
    
    
    
    public class IntegerImpl implements Counter<Integer> {

        private int total = 0;

        @Override
        public void clear() {
            this.total = 0;
        }

        @Override
        public synchronized void increment(Integer value) {
            this.total += value;
        }

        @Override
        public Integer getTotal() {
            return this.total;
        }

    }
    
}
