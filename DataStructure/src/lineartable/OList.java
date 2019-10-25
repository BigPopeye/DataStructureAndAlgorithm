package lineartable;

public interface OList {
    void addFirst(int x);

    int getFirst();

    void addLast(int x);

    int getLast();

    int removeLast();

    int size();
}
