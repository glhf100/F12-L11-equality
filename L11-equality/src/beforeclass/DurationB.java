package beforeclass;



public class DurationB {
    private final int mins;
    private final int secs;
    // rep invariant:
    //    mins >= 0, secs >= 0
    // abstraction function:
    //    represents a span of time of mins minutes and secs seconds

    /** Make a duration lasting for m minutes and s seconds. */
    public DurationB(int m, int s) {
        mins = m; secs = s;
    }
    
    /** @return length of this duration in seconds */
    public long getLength() {
        return mins*60 + secs;
    }
    
    // Right definition of equals()
    @Override // asserts that superclass has this method; compile-time error if not
    public boolean equals (Object _that) {
        if (!(_that instanceof DurationB)) return false; // also handles _that == null
        DurationB that = (DurationB) _that;
        return this.getLength() == that.getLength();
    }
    

    public static void main(String[] args) {
        DurationB d1 = new DurationB(1,2);
        DurationB d2 = new DurationB(1,2);
        System.out.println("d1.equals(d2) -> " + d1.equals(d2));
        
        Object o2 = d2;
        System.out.println("d1.equals(o2) -> " + d1.equals(o2));
        System.out.println("o2.equals(d1) -> " + o2.equals(d1));

        /*
        System.out.println("d1.hashCode() -> " + d1.hashCode());
        System.out.println("d2.hashCode() -> " + d2.hashCode());
        Set<DurationB> set = new HashSet<DurationB>();
        set.add(d1);
        System.out.println("set.contains(d2) -> " + set.contains(d2));
        */
    }
    
}
