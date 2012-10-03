package beforeclass;


public class DurationC {
    private final int mins;
    private final int secs;
    // rep invariant:
    //    mins >= 0, secs >= 0
    // abstraction function:
    //    represents a span of time of mins minutes and secs seconds

    /** Make a duration lasting for m minutes and s seconds. */
    public DurationC(int m, int s) {
        mins = m; secs = s;
    }
    
    /** @return length of this duration in seconds */
    public long getLength() {
        return mins*60 + secs;
    }
    
    private static final int CLOCK_SKEW = 5; // seconds
    
    @Override // asserts that superclass has this method; compile-time error if not
    public boolean equals (Object _that) {
        if (!(_that instanceof DurationC)) return false; // also handles _that == null
        DurationC that = (DurationC) _that;
        return Math.abs(this.getLength() - that.getLength()) <= CLOCK_SKEW;
    }
    
    public static void main(String[] args) {
    }
    
}
