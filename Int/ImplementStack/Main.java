public class Main {
    public static void main(String[] args) throws Exception {
        // CustomStack st=new CustomStack(5);
        DynamicCustomStack st=new DynamicCustomStack(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(10);
        System.out.println(st.peek());
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
    }
}
