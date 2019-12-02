
/**
 * Write a description of class TestST01 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestST01
{
    public static void main(String[] args){
        STArray<Integer,String> st = new STArray(10);
        st.put(1,"H");
        st.put(2,"o");
        st.put(3,"l");
        st.put(4,"a");
        st.put(1,"C");
        st.put(2,"h");
        
        st.printf();
    }
}
