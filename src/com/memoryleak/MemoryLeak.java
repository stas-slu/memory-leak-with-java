package com.memoryleak;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * First, let's defined memory-leak in Java context -it's a situation where some objects are not used by the application any more,
 * but Garbage Collector (GC)  fails to recognize them as unused and free them.
 *
 * To demonstrate it, let's construct a Java program which will create a collection of objects in class scope and periodically
 * add new objects to the collections without dropping the reference to the instance of the class that holds the collection.
 *
 * Now, because Java has a GC, any object that's not referenced by your application is should be automatically deallocated but we had
 * prevented this by keeping on adding values to the list and never clear it.
 *
 * Eventually this will throw OutOfMemoryError exception.
 *
 */
class MemoryLeak {

    private List<Integer> leakingList = new ArrayList<>();

    private void startLeaking() {
        while(true) {
            leakingList.add(42);

        }
    }

    public static void main(String[] args) {
        MemoryLeak ml = new MemoryLeak();
        while (true) {
            ml.startLeaking();
        }
    }
}
