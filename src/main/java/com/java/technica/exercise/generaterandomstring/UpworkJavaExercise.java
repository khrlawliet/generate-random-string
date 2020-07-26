package com.java.technica.exercise.generaterandomstring;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UpworkJavaExercise {

	public List<String> generatedRandomStrings() {

		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 100;
		Random random = new Random();
		List<String> stringList = new LinkedList<String>();

		for (int x = 1; x < 230; x++) {
			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
			if (stringList.contains(generatedString)) {
				continue;
			}
			stringList.add(generatedString);
		}
		return stringList;

	}

	public void generateStringTextfile(List<String> stringList) {
		try {
			String fileData = stringList.stream().map(e -> e.toString()).collect(Collectors.joining("\n"));
			FileOutputStream fos = new FileOutputStream("generated-file");
			fos.write(fileData.getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void execute() {
		List<String> result = generatedRandomStrings();
		generateStringTextfile(result);
		System.out.println("Successfully generated!");

	}

	public void intArrays(int[] arr, int k) {
		int[] res = {};
		for (int i = 0; i < k / 2; i++) {
			int swap = arr[i];
			arr[i] = arr[k - i - 1];
			arr[k - i - 1] = swap;
			System.out.println(swap);
		}

	}
	
//	upworkJavaExercise.intArrays(new int[] { 2, 3, 4, 2, 12, 5 }, 6);
//	int[] array = { 45, 12, 3 };
//	int temp;
//	for (int i = 1; i < array.length; i++) {
//		for (int j = i; j > 0; j--) {
//			if (array[j] < array[j - 1]) {
//				temp = array[j];
//				System.out.println("t " + temp);
//				array[j] = array[j - 1];
//				array[j - 1] = temp;
//			}
//		}
//	}
//	for (int i = 0; i < array.length; i++) {
//		System.out.println(array[i]);
//	}
//}

}
