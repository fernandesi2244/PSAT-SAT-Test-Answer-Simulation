import java.util.ArrayList;

/**
 * This program attempts to compare scores on a 131 question test that is meant
 * to simulate the Reading, Writing, and Math multiple choice sections of the PSAT. The first option is to pick a letter
 * of the day and choose that for all questions. Otherwise, you can guess a random letter.
 * (This assumes you don't know the answer to any of the questions, which I hope is not the case)
 * 
 * Keep in mind that this program has many limitations.
 * For example, the SAT answer distribution is not necessarily uniform.
 * In addition, even if it were, Math.random() would fail to replicate those 
 * conditions due to its pseudorandom nature.
 */
public class SAT_AnswerChoiceSelectionTest {

	/**
	 * Run the test
	 * @param args
	 */
	public static void main(String[] args) {
		//Fill up answer key with random values (0 representing answer choice A and so on)
		ArrayList<Integer> answerKey = new ArrayList<>();
		for(int i = 0;i<131;i++) {
			answerKey.add((int)(Math.random()*4));
		}
		
		//Randomly pick answer of the day. (Option 1)
		int answerOfTheDay = (int)(Math.random()*4);
		
		//ArrayList filled with a second set of random values. (Option 2)
		ArrayList<Integer> option2Answers = new ArrayList<>();
		for(int i = 0;i<131;i++) {
			option2Answers.add((int)(Math.random()*4));
		}
		
		//Store scores for use in multiple trials
		ArrayList<Integer> option1ScoreList = new ArrayList<>();
		ArrayList<Integer> option2ScoreList = new ArrayList<>();
		int option1Score, option2Score;
		
		//Complete several trials for reliability
		for(int x = 0;x<1000000;x++) {
			option1Score = 0;
			option2Score = 0;
		
		for(int current: answerKey)
			if(current == answerOfTheDay)
				option1Score++;
		
		for(int i = 0;i<answerKey.size();i++) {
			if(answerKey.get(i)==option2Answers.get(i))
				option2Score++;
		}
		
		option1ScoreList.add(option1Score);
		option2ScoreList.add(option2Score);
		}
		
		int option1Average = 0, option2Average = 0;
		
		//Find average score of each score list.
		for(int a: option1ScoreList) {
			option1Average+=a;
		}
		
		option1Average/=option1ScoreList.size();
		
		for(int a: option2ScoreList) {
			option2Average+=a;
		}
		
		option2Average/=option2ScoreList.size();
		
		System.out.println("The results have come in...\nIf you choose the same letter every time, your score will likely be "+option1Average+".\nIf you guess randomly, your score is a "+option2Average+".");

	}

}
