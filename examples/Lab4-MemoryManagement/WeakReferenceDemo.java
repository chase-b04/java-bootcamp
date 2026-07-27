import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

    public static void main(String[] args) {
        System.out.println("===== Weak Reference Demonstration =====");

        System.out.println("--- Strong Reference ---");
        Person strongPerson = new Person("Strong User", 40);
        System.out.println("Before GC : " + strongPerson);
        MemoryMonitor.triggerGarbageCollection();
        System.out.println("After GC  : " + strongPerson);
        System.out.println("Object remains because a strong reference still exists.");

        System.out.println();
        System.out.println("--- Weak Reference ---");
        // TODO: create Person weakTarget; wrap in WeakReference<Person>
        System.out.println("Before removing strong reference : " + strongPerson);
        strongPerson = null;
        System.out.println("Strong reference removed.");
        Person weakTarget = new Person("Weak User", 22);
        WeakReference<Person> weakReference = new WeakReference<>(weakTarget);
        System.out.println("Before GC : " + weakReference.get());
        // TODO: null weakTarget; trigger GC; print WeakReference.get() result
        weakTarget = null;
        MemoryMonitor.triggerGarbageCollection();
        System.out.println("After GC via WeakReference.get() : " + weakReference.get());
        throw new UnsupportedOperationException("TODO");
    }
}