
import java.util.Scanner;

public class Craps
	{
		static int balance = 100;
		static boolean gameContinue = true;
		static int die1 = (int)(Math.random()*6)+1;
		static int die2 = (int)(Math.random()*6)+1;
		static int sum = die1+die2;
		static int bet;
		public static void main(String[] args)
			{
				doIntro();
				doBet();
				while (gameContinue)
					{
				rollDice();
					}
				
			}
		public static void doIntro()
		{
			System.out.println("Hey there. What is your name?");
			Scanner input = new Scanner(System.in);
			String name = input.nextLine();
			System.out.println("Alright, " + name + ", let's play some Craps!");
			doBet();
			if (sum == 2 || sum == 12)
				{
					System.out.println("You rolled a " + die1 + " and a " + die2 + " for a total of " + sum);
					System.out.println("You lose, " + name + "!");
					balance = balance-bet;
					System.out.println("Your new balance is " + balance);
				}
			else if (sum == 7 || sum == 11)
				{
					System.out.println("You rolled a " + die1 + " and a " + die2 + " for a total of " + sum);
					System.out.println("You win, " + name + "!");
					balance = balance+bet;
					System.out.println("Your new balance is "+balance);
				}
			else 
				{
					System.out.println("You rolled a " + die1 + " and a " + die2 + ". Your point is " + sum + ", " + name);
					rollDice();
				}
		}
		public static void doBet()
		{
			System.out.println("You have" + balance + " to bet");
			System.out.println("How much of that " + balance + " would you like to bet?");
			Scanner input1 = new Scanner(System.in);
			bet = input1.nextInt();
			if (bet > balance || bet < 0)
				{
					System.out.println("That is not allowed. Please bet within your range");
					doBet();
				}
		}
		public static void rollDice()
		{
					try
						{
							Thread.sleep(750);
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
			System.out.println("Press Spacebar and Enter to roll the Dice");
			Scanner input1 = new Scanner(System.in);
			String roll = input1.nextLine();
			if (roll .equals(" "))
				{
							int die3 = (int)(Math.random()*6)+1;
							int die4 = (int)(Math.random()*6)+1;
							int sum2 = die3+die4;
							System.out.println("You rolled a " + die3 + " and a " + die4 + " for a total of " + sum2);
							if (sum2 == sum)
								{
									System.out.println("So you win!");
									balance = balance+bet;
									System.out.println("Your new balance is "+balance);
									if (balance == 0)
										{
											System.out.println("you lose");
											gameContinue = false;
										}
								}
							
							else if (sum2 == 7)
								{
									System.out.println("So you lose");
									balance = balance-bet;
									System.out.println("Your new balance is "+balance);
									gameContinue = false;
								}
							else 
								{
									rollDice();
								}
						}
			else if (roll != " ") 
				{
					System.out.println("That didn't work");
					rollDice();
				}
		}
		
	}
	
