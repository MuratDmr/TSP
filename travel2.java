import java.util.*;

public class travel2 {

	public static void main(String[] args) {

		// Random variable = new Random();

		System.out.println(" Traveling Salesman Problem");

		System.out.println();

		Random variable = new Random(); // create an object Random with the name
										// variable

		int[][] cities = new int[10][10]; // a 2 dimensional array

		for (int i = 0; i < cities.length; i++) { // loop from 0 to
													// cities.lenght end (inner)

			for (int j = 0; j < cities[i].length; j++) {// loop from 0 to
														// cities.lenght end
														// (outer)

				if (i == j) { // compare i with J

					cities[i][j] = 0; // set the position [i][j] = 0

				} else {

					cities[i][j] = variable.nextInt(10) + 10; // give the
																// position
																// [i][j] a
																// Random Number

					cities[j][i] = cities[i][j]; // reflect the pos: [i][j] to
													// [j][i]

				

				}

			}

		}

		for (int i = 0; i < cities.length; i++) {

			for (int j = 0; j < cities[i].length; j++) {

				System.out.print(cities[i][j] + " || ");   // output from the
															// array cities
				

			}

			System.out.println();
		

		}
		int[] travel = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // array travel[10]
		System.out.println();
		System.out.println("The length of the round trip is:");
		System.out.println(distance(travel, cities));
		System.out.println();
		for (int k = 0; k < 100000; k++) {

			int i = (int) (Math.random() * 9.0); // take random index position from travel array
			int j = (int) (Math.random() * 9.0);

			int travel1 = distance(travel, cities); // save the distance in the
													// variable travel
			swap(travel, i, j);
			int travel2 = distance(travel, cities);
			if (travel2 < travel1) {
				travel1 = travel2;

				for (int x = 0; x <= travel.length - 1; x++)
					System.out.print(travel[x] + " ");
				System.out.println(travel2);
			} else
				swap(travel, j, i);
		
		}

	}

	public static int distance(int travel[], int cities[][]) { // function with
																// paramater

		int calcdistance = 0;

		for (int z = 0; z < travel.length - 1; z++) { // loop from 0 to
														// travel.length end

			calcdistance += cities[travel[z]][travel[z + 1]]; // calculate the
																// distance from
																// cities
																// pos:travel[z}travel[z+1]

		}

		return calcdistance;

	}

	public static void swap(int travel[], int i, int j) {

		int swap = travel[i]; //
		travel[i] = travel[j];
		travel[j] = swap;

	}

}
