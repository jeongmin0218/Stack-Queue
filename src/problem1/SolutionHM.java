package problem1;
import java.util.Scanner;
import java.util.Stack;
public class SolutionHM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder finalString = new StringBuilder();

        int num = sc.nextInt(); //  - 수열의 갯수를 받음
        int start = 0; // 첫 스택은 비어있음 = 0

        Stack<Integer> stackBox = new Stack<>();

        while (num --> 0){
            // 새로 알게된 사실 ! (var--(증감 연산자)); var > 0) 를 합치면, var --> 0으로 줄여 쓸 수 있다고 함 !!
            int input = sc.nextInt(); // 숫자 입력받아옴
            if (start < input) { // 받아온 숫자가 지금 스택의 크기보다 크다면
                for (int i = start + 1; i <= input; i++) { // 숫자의 크기까지 스택의 크기를 늘려줘야함 push !
                    stackBox.push(i); // input이 4일시 1,2,3,4 번 ++++ 하게됨 (4가 젤 위에 있게 됨)
                    finalString.append("+\n"); // 문자열을 저장하는 fianlString에 + 저장 (4번만큼 push했기에 '+'도 4번 출력
                }
                start = input;  // 늘려진 스택의 크기를 저장해야함 (4)
            }

            if(stackBox.peek() != input){  // 스택에 마지막 과 입력값된 값이 다르면 만들 수 없
                // peek(): 가장 나중에 추가된 데이터를 리턴해야함
                finalString.delete(0,finalString.length()).append("NO");
                // .delete(int start, int end)
                // .append(): 문자열을 추가
                break;
            }
            stackBox.pop();
            finalString.append("-\n");
        }
        System.out.println(finalString);
    }
}

