package beforeclass;

// ImList, ImListVisitor, Empty, and Cons are nested inside one class
// for ease of presentation in lecture.  A real program would 
// put them in separate files. Also, specs omitted to save space -- 
// see the lecture notes for specs.
public class Im {
    // datatype definition:
    //    ImList = Empty + Cons(e:E, rest:ImList)
    
    // ImList represents an immutable sequence of elements of type E
    public static interface ImList<E> {
        public <R> R accept(ImListVisitor<E,R> visitor);
    }

    // ImListVisitor represents a function ImList<E> -> R
    public static interface ImListVisitor<E,R> {
        public R on(Empty<E> nil);
        public R on(Cons<E> list);
    }
    
    // Empty represents the empty list
    public static class Empty<E> implements ImList<E> {
        public Empty() { }
        public <R> R accept(ImListVisitor<E,R> visitor) { return visitor.on(this); }
    }

    // Cons represents an element followed by the rest of the list
    public static class Cons<E> implements ImList<E> {
        public final E first;
        public final ImList<E> rest;
        public Cons(E first, ImList<E> rest) { this.first = first; this.rest = rest; }
        public <R> R accept(ImListVisitor<E,R> visitor) { return visitor.on(this); }
    }   

    // size: return the number of elements in a list
    public static <E> int size(ImList<E> list) {
        return list.accept(new ImListVisitor<E,Integer>() {
            public Integer on(Empty<E> nil) { return 0; }
            public Integer on(Cons<E> list) { return 1 + size(list.rest); }
        });        
    }

    public static void main(String[] args) {
        ImList<Integer> nil = new Empty<Integer>();
        ImList<Integer> x = new Cons<Integer>(5, nil);
        int n = size(x);
        System.out.println(n);
    }
}
