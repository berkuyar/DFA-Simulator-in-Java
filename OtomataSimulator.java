package OtomataSimulator;

import java.util.*;

public class OtomataSimulator {
    static class DFA {
        int[][] transitionTable;
        int startState;
        Set<Integer> acceptStates;

        DFA(int[][] transitionTable, int startState, Set<Integer> acceptStates) {
            this.transitionTable = transitionTable;
            this.startState = startState;
            this.acceptStates = acceptStates;
        }

        boolean simulate(String input) {
            int currentState = startState;
            System.out.println("Başlangıç Durumu: q" + currentState);

            for (char symbol : input.toCharArray()) {
                int inputIndex = symbol == 'a' ? 0 : 1;
                if (inputIndex < 0 || inputIndex >= transitionTable[currentState].length) {
                    System.out.println("Geçersiz sembol: " + symbol);
                    return false;
                }
                currentState = transitionTable[currentState][inputIndex];
                System.out.println("Okunan Harf: " + symbol + "     , DFA'daki Şu Anki Durum: q" + currentState);
            }

            if (acceptStates.contains(currentState)) {
                System.out.println("Dizge kabul durumuna ulaştı!");
                return true;
            } else {
                System.out.println("Dizge kabul durumuna ulaşamadı!");
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

   
        int[][] transitionTable = {
                {2, 1},  // q0
                {4, 3},  // q1
                {5, 4},  // q2
                {6, 3},  // q3
                {7, 6},  // q4
                {5, 7},  // q5
                {8, 6},  // q6
                {7, 8},  // q7
                {8, 8}   // q8 
        };

        int startState = 0;  
        Set<Integer> acceptStates = new HashSet<>(Collections.singletonList(8));  

        DFA dfa = new DFA(transitionTable, startState, acceptStates);

       
        System.out.println("Sadece 'a' ve 'b' harflerini içeren bir dizgi girin:");
        String input = scanner.nextLine();

        
        dfa.simulate(input);
        scanner.close(); 
    }
}

