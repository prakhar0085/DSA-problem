// char array[] Approach
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 !=0){
            return false;
        }

        char temp[] = new char[s.length()];
        int index = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c=='(' || c == '{' || c == '['){
                temp[index++] = c;
            }
            else{
                if(index == 0){
                    return false;
                }

                char last = temp[index -1];
                if((c == ')' && last == '(') || (c == '}' && last == '{') || (c == ']' && last == '[')){
                    index--;
                }else{
                    return false;
                }
            }
        }
        return index == 0;
    }
}



Differentiate between char[] array approach and Stack approach:

What is Internal Synchronization Overhead in Stack?
🔹 First, understand: What is synchronization?
Synchronization is like putting a lock on a resource.
When multiple threads might access the same resource at the same time (in a multi-threaded program), Java places a lock on that object to prevent inconsistent behavior.
This ensures that only one thread can use the resource at a time.

🎯 Example:
Imagine a box (like a Stack) where you put values.
If two people try to put values into the box at the same time, things could go wrong.
So, Java automatically adds locks around push(), pop(), and other methods of the Stack to avoid issues.

❗ But when does it become a problem?
When your program is single-threaded (only one thread is running), Java still puts locks on Stack methods — even though no other thread exists.

Example:
stack.push('a');  // Java adds a lock
stack.pop();      // Java releases the lock
Even though you are the only one using the Stack, Java still assumes "maybe another thread might use it" and performs lock/unlock steps.

👉 Internal Synchronization Overhead
🔹 What's the problem with that?
Each method call includes extra steps:
Acquiring a lock
Releasing the lock

This causes small but unnecessary costs in terms of CPU time and memory usage.
That’s what we call synchronization overhead.

✅ Final Suggestion
For single-threaded programs (like coding interviews or simple apps):
👉 Use char[] or ArrayDeque — they are faster.

For multi-threaded applications:
👉 Use Stack or ConcurrentLinkedDeque — they are thread-safe.

🧵 What is a Single-threaded Program?
A single-threaded program performs one task at a time using just one thread (usually the main thread).
Most simple Java programs are single-threaded by default.

🚫 The Problem with Stack in Single-threaded Programs:
Java’s Stack class is synchronized (thread-safe).
That means every function like push() and pop() uses locking and unlocking internally.
In a single-threaded program, this locking is completely unnecessary and causes a performance slowdown.

Example:
You call stack.push('a').

Java checks:
"Could another thread also be using this stack?"
It doesn’t know, so it adds a lock, does the push, then removes the lock.

But if your program has only one thread, then this locking is pointless — it just wastes CPU time.

✅ So what's the solution?
For single-threaded programs, synchronization is unnecessary overhead.
If you don’t need thread safety, then avoid using synchronized structures like Java’s Stack.

⚡ Better alternatives (for single-threaded code):
1. ArrayDeque — the modern, fast replacement for Stack
Deque<Character> stack = new ArrayDeque<>();
stack.push('a');       // push
char c = stack.pop();  // pop
No synchronization (no locking overhead)

Supports push(), pop(), peek()

Faster than Stack in single-threaded programs

Dynamically sized (no need to define max size)

2. Manual char[] array stack (if you know the max size)
char[] stack = new char[maxSize];
int index = 0;
// push
stack[index++] = 'a';
// pop
char c = stack[--index];
❌ Why not use Stack?
Every method in Stack locks and unlocks — even if only one thread is using it.

This causes extra CPU usage and slower performance.

Stack stores Character objects (not primitive char), which increases memory usage and puts more load on the garbage collector.

✅ Bottom Line:
Use Case	Best Option
Single-threaded code	✅ ArrayDeque or char[]
Multi-threaded code	✅ Stack or ConcurrentLinkedDeque


//Alternative solution (ArrayDeque<Character>)
// import java.util.ArrayDeque;
// import java.util.Deque;

// class Solution {
//     public boolean isValid(String s) {
//         // Early exit for odd length
//         if (s.length() % 2 != 0) return false;

//         Deque<Character> stack = new ArrayDeque<>();

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);

//             // Push opening brackets
//             if (c == '(' || c == '{' || c == '[') {
//                 stack.push(c);
//             } 
//             // For closing brackets
//             else {
//                 if (stack.isEmpty()) return false;

//                 char last = stack.peek();
//                 if ((c == ')' && last == '(') ||
//                     (c == '}' && last == '{') ||
//                     (c == ']' && last == '[')) {
//                     stack.pop(); // matched pair, pop it
//                 } else {
//                     return false; // mismatch
//                 }
//             }
//         }

//         return stack.isEmpty(); // all matched if stack empty
//     }
// }

// Why use ArrayDeque here?
// No synchronization overhead (faster than Stack)
// Provides fast push, pop, and peek methods
// Cleaner and modern approach for stack behavior
