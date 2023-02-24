import java.util.Stack;

public class lab41 {
    public static void main(String[] args) {
        QReader in  = new QReader();
        QWriter out = new QWriter();
        Stack<Long>stack= new Stack<Long>();// ( -> -1,) -> -2
        String s;   long ans=0;
        s = in.next();
        char[] ch = s.toCharArray();
        for(int i=0 ; i<s.length() ; i++){
            if(ch[i]=='('){
                stack.push((long) -1);
            }else {
                if (stack.peek() == (long) -1) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push((long) 1);
                    } else if (stack.peek() > 0) {
                        ans = stack.peek();
                        stack.pop();
                        while(!stack.isEmpty() && stack.peek()>0){
                            ans+=stack.peek();
                            ans%=514329;
                            stack.pop();
                        }
                        stack.push((ans + 1)%514329);
                    } else stack.push((long) 1); continue;
                } else ans = stack.peek();
                stack.pop();
                while(stack.peek()>0){
                    ans+=stack.peek();
                    stack.pop();
                    ans %= 514329;
                }
                ans *= 2;
                ans %= 514329;

                stack.pop();
                stack.push(ans);
            }
        }
        ans=stack.pop()%514329;
        out.println(ans);
        out.close();
    }
}
