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


}
