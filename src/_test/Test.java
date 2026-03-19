package _test;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	static class View {
		
		Input input = new Input();
		Output output = new Output();
		
		static class Input {
			int input() {
				try (var sc = new Scanner(System.in)) {
					return sc.nextInt();
				}
			}
		}
		
		static class Output {
			void output(int output) {
				System.out.println(output);
			}
		}
		
	}
	
	static class Controller {
		
		Logic logic = new Logic();
		Loop loop = new Loop();
		
		void launch() {
			loop.loop(logic);
		}
		
		static class Logic {
			
			View view = new View();
			Model model = new Model();
			
			void logic() {
				
			}
		}
		
		static class Loop {
			void loop(Logic logic) {
				while(true)
					logic.logic();
			}
		}
		
		public static void main(String[] args) {
			new Controller().launch();
		}
		
	}
	
	static class Model {
		
		World world = new World();
		
		static class World {
			ArrayList<Value> world = new ArrayList<>();
			World() {
				world.add(new Value(2));
				world.add(new Value(3));
			}
		}
		
		static class Value {
			int n;
			Value(int n) {
				this.n = n;
			}
		}
		
	}
	
}
