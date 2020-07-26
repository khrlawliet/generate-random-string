package com.java.technica.exercise.generaterandomstring;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UpworkJavaExerciseTest {

	@InjectMocks
	UpworkJavaExercise javaExercise;

	@Test
	public void checkNumberOfString() {
		assertEquals(230 - 1, javaExercise.generatedRandomStrings().size());
	}

	@Test
	public void checkIfHasDuplicateString() {
		List<String> generatedListItems = javaExercise.generatedRandomStrings();
		List<String> normalList = javaExercise.generatedRandomStrings();
		List<String> duplicateList = new ArrayList<String>();
		for (String item : generatedListItems) {
			if (normalList.contains(item)) {
				duplicateList.add(item);
			}
		}
		assertEquals(duplicateList.size() > 0, false);
	}



}
