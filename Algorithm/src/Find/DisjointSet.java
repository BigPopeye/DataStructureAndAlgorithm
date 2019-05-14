package Find;

public interface DisjointSet {


    /** Connect two items into a set
     * Also known as union
     */
    public void connect(int x , int y);

    /** Check if two items is connected */
    public boolean isConnected(int x, int y);


}
