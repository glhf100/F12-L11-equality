package beforeclass;


public class DurationA {
    private final int mins;
    private final int secs;
    // rep invariant:
    //    mins >= 0, secs >= 0
    // abstraction function:
    //    represents a span of time of mins minutes and secs seconds

    /** Make a duration lasting for m minutes and s seconds. */
    public DurationA(int m, int s) {
        mins = m; secs = s;
    }
    /** @return length of this duration in seconds */
    public long getLength() {
        return mins*60 + secs;
    }
    
    public boolean equals(Object that) {
        return this == that;
    }
    // WRONG definition of equals()
    public boolean equals(DurationA that) {
        return this.getLength() == that.getLength();        
    }
    
    public static void main(String[] args) {
        DurationA d1 = new DurationA(1,2);
        DurationA d2 = new DurationA(1,2);
        System.out.println("d1.equals(d2) -> " + d1.equals(d2));
        
        Object o2 = d2;
        System.out.println("d1.equals(o2) -> " + d1.equals(o2));
    }
    
}
